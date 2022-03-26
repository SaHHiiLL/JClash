package Core;

import Core.exception.*;
import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class Util {
    private static Logger log = Logger.getLogger(Util.class.getName());
    public final static String URL = "https://api.clashofclans.com/";
    public final static String API_VERSION = "v1";
    final static Gson gson = new Gson();

    public static <G> G deserialize(Response res, Class<G> obj)  {
        String json = null;
        try {
            json = res.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        G deserialized = gson.fromJson(json, obj);
        res.close();
        return deserialized;
    }

    public static <G> G deserialize(String res, Class<G> obj) throws IOException {
        return gson.fromJson(res, obj);
    }

    public static Response checkResponse(Response res) throws ClashAPIException {
        if (res.isSuccessful())
            return res;

        switch (res.code()) {
            case 400: {
                throw new BadRequestException();
            }
            case 403: {
                throw new AuthException();
            }
            case 404: {
                throw new NotFoundException();
            }
            case 429: {
                throw new RateLimitException();
            }
            case 503: {
                throw new MaintenanceException();
            }
            default: {
                throw new UnknownException();
            }
        }
    }

    public static String formatTag(String tag) {
        if (tag.startsWith("#")) {
            return tag.replace("#", "%23");
        } else
            return "%23" + tag;
    }
}
