package Core;

import Core.Enitiy.GoldPass.GoldPass;
import Core.Enitiy.League.League;
import Core.Enitiy.League.LeagueSeason;
import Core.Enitiy.clan.ClanMember_item;
import Core.Enitiy.clan.ClanModel;
import Core.Enitiy.clanwar.WarInfo;
import Core.Enitiy.clanwar.WarlogModel;
import Core.Enitiy.clanwar.league.WarLeagueGroup;
import Core.Enitiy.player.Player;
import Core.Enitiy.player.VerifiedPlayer;
import Core.KeyManagers.KeyHandler;
import Core.exception.ClashAPIException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class JClash extends Util {
    private final OkHttpClient http;
    private static MutexList<String> TOKEN_LIST = new MutexList<>();
    private static Logger log = LoggerFactory.getLogger(JClash.class);

    public JClash(String username, String password) throws ClashAPIException, IOException {
        if (getList().size() == 0) {
            getAndRegisterKeys(username, password);
            System.out.println("Loaded " + getList().size() + " tokens");
        }
        http = new OkHttpClient();
    }

    private void getAndRegisterKeys(String username, String password) throws IOException {
        KeyHandler keyHandler = new KeyHandler();
        setTokenList(keyHandler.getValidKeys(username, password));
        if (getList().size() != 0) {
            log.info("API token generated successfully for:" + username);
        } else {
            throw new UnexpectedException("Unexpected error uncounted while making keys for: " + username);
        }
    }

    public JClash(List<Credentials> credentials) throws IOException {
        if (getList().size() == 0) {
            for (Credentials x : credentials) {
                getAndRegisterKeys(x.getEmail(), x.getPassword());
            }
            System.out.println("Loaded " + getList().size() + " tokens");
        }
        http = new OkHttpClient();
    }

    public JClash() {
        if (getList().size() == 0) {
            throw new IllegalStateException("No API token found! please initialize JClash with username and password as parameters");
        }
        http = new OkHttpClient();
    }

//    public JClash(String token) {
//        http = new OkHttpClient();
//        if (TOKEN.equals("")) {
//            TOKEN = token;
//        }
//    }

    private Request.Builder getBaseRequest(String suffix) {
        String token = getList().cycle();
        return new Request.Builder()
                .header("authorization", "Bearer " + token) //TODO: Replace this with new mutex list
                .url(URL + API_VERSION + "/" + suffix);
    }

    public List<String> getListOfToken() {
        return new ArrayList<>(getList());
    }

    private Response getRequest(String url) throws IOException, ClashAPIException {
        Response res = http.newCall(getBaseRequest(url).get().build()).execute();
        return checkResponse(res);
    }

    private Response postRequest(String url, RequestBody body) throws IOException, ClashAPIException {
        Response res = http.newCall(getBaseRequest(url).post(body).build()).execute();
        return checkResponse(res);
    }

    public CompletableFuture<Player> getPlayer(String playerTag) throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("players/" + formatTag(playerTag));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, Player.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

//    public CompletableFuture<Player> getPlayer1(String tag) {
//
//    }

    public CompletableFuture<ClanModel> getClan(String clanTag) throws ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clans/" + formatTag(clanTag));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, ClanModel.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<WarInfo> getCurrentWar(String clanTag) throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clans/" + formatTag(clanTag) + "/currentwar");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, WarInfo.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<WarlogModel> getWarlog(String clanTag) throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clans/" + formatTag(clanTag) + "/warlog");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, WarlogModel.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<WarLeagueGroup> getCWLGroup(String clanTag) throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clans/" + formatTag(clanTag) + "/currentwar/leaguegroup");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, WarLeagueGroup.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<WarInfo> getCWLWar(String warTag) throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clanwarleagues/wars/" + formatTag(warTag));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, WarInfo.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<GoldPass> getGoldPass() throws IOException, ClashAPIException {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("goldpass/seasons/current");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, GoldPass.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<VerifiedPlayer> verifyPlayer(String tag, String token) {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                RequestBody body = new FormBody.Builder()
                        .add("token", token)
                        .build();
                res = postRequest("players/" + formatTag(tag) + "/verifytoken", body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, VerifiedPlayer.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<ClanMember_item> getClanMembers(String tag) {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("clans/" + formatTag(tag) + "/members");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, ClanMember_item.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    public CompletableFuture<League> getLeagues() {
        return CompletableFuture.supplyAsync(() -> {
            Response res = null;
            try {
                res = getRequest("leagues");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, League.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    /**
     * @param responseLimit - pass 0 < to get all
     * @return
     */
    public CompletableFuture<LeagueSeason> getLegendSeason(LocalDate seasonStartDate, Optional<Integer> responseLimit) {
        return CompletableFuture.supplyAsync(() -> {
            String seasonStartDateString = seasonStartDate.getYear() + "-" + seasonStartDate.getMonth().getValue();
            String url;
            if (responseLimit.isEmpty()) {
                url = "leagues/29000022/seasons/" + seasonStartDateString;
            } else {
                url = "leagues/29000022/seasons/" + seasonStartDateString + "?limit=" + responseLimit;
            }
            Response res = null;
            try {
                res = getRequest(url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return deserialize(res, LeagueSeason.class);
        }).exceptionally(throwable -> {
            if (throwable != null) {
                throw new ClashAPIException(throwable.getMessage(), throwable);
            }
            return null;
        });
    }

    private synchronized MutexList<String> getList() {
        return TOKEN_LIST;
    }

    private synchronized void setTokenList(List<String> list) {
        TOKEN_LIST = new MutexList<>(list);
    }
}

