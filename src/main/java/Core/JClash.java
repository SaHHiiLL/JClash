package Core;

import Core.Enitiy.clan.ClanModel;
import Core.Enitiy.clanwar.WarInfo;
import Core.Enitiy.clanwar.WarlogModel;
import Core.Enitiy.clanwar.league.WarLeagueGroup;
import Core.Enitiy.player.Player;
import Core.KeyManagers.KeyHandler;
import Core.exception.AuthException;
import Core.exception.ClashAPIException;
import okhttp3.*;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JClash extends Util {
    private final OkHttpClient http;
    private static String TOKEN = "";
    private static Logger log = Logger.getLogger(JClash.class.getName());

    public JClash(String username, String password) throws ClashAPIException, IOException {
        if (TOKEN.equals("")){
            KeyHandler keyChecker = new KeyHandler();
            TOKEN = keyChecker.getValidKeys(username, password).get(0);
            if  (!TOKEN.equals("")){
                log.log(Level.INFO, "API token generated successfully" );
            }else{
                throw new UnexpectedException("Unexpected error uncounted while making keys for: " + username);
            }
        }
        http = new OkHttpClient();
    }
    public JClash () throws ClashAPIException {
        if (TOKEN.equals("")){
            throw new AuthException("No API token found! please initialize JClash with username and password as parameters");
        }
        http = new OkHttpClient();
    }

    private Request.Builder getBaseRequest(String suffix) {
        return new Request.Builder()
                .header("authorization", "Bearer " + TOKEN)
                .url(URL + API_VERSION + "/" + suffix);
    }

    private Response getRequest(String url) throws IOException, ClashAPIException {
        Response res = http.newCall(getBaseRequest(url).build()).execute();
        return checkResponse(res);
    }

    private Response postRequest(String url, RequestBody body) throws IOException, ClashAPIException {
        Response res = http.newCall(getBaseRequest(url).post(body).build()).execute();
        return checkResponse(res);
    }

    public Player getPlayer(String playerTag) throws IOException, ClashAPIException {
        Response res = getRequest("players/" + formatTag(playerTag));
        return deserialize(res, Player.class);
    }

    public ClanModel getClan(String clanTag) throws IOException, ClashAPIException {
        Response res = getRequest("clans/" + formatTag(clanTag));
        return deserialize(res, ClanModel.class);
    }

    public WarInfo getCurrentWar(String clanTag) throws IOException, ClashAPIException {
        Response res = getRequest("clans/" + formatTag(clanTag) + "/currentwar");
        return deserialize(res, WarInfo.class);
    }

    public WarlogModel getWarlog(String clanTag) throws IOException, ClashAPIException {
        Response res = getRequest("clans/" + formatTag(clanTag) + "/warlog");
        return deserialize(res, WarlogModel.class);
    }

    public WarLeagueGroup getCWLGroup(String clanTag) throws IOException, ClashAPIException {
        Response res = getRequest("clans/" + formatTag(clanTag) + "/currentwar/leaguegroup");
        return deserialize(res, WarLeagueGroup.class);
    }

    public WarInfo getCWLWar(String warTag) throws IOException, ClashAPIException {
        Response res = getRequest("clanwarleagues/wars/" + formatTag(warTag));
        return deserialize(res, WarInfo.class);
    }
}

