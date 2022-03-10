package Core.KeyManagers;

import Core.Util;
import Core.exception.AuthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyChecker extends Util {
    private Keys mapKeys(String username, String password) throws AuthException, IOException {
        String keys = new KeyHandler().getKeys(username, password);
        return deserialize(keys, Keys.class);
    }

    private KeyModel mapKeys(String json) throws IOException {
        return deserialize(json, KeyModel.class);
    }

    public List<String> getValidKeys(String username, String password) throws AuthException, IOException {
        String ip = getIP();
        Keys keys = mapKeys(username, password);
        List<String> validKeys = new ArrayList<>();

        Arrays.stream(keys.getKeys()).forEach(keyObj -> {
            Arrays.stream(keyObj.getIps()).forEach(ips -> {
                if (ips.equalsIgnoreCase(ip))
                    validKeys.add(keyObj.getKey());
            });
        });

        if (validKeys.isEmpty()) {
            String createdKeys = new KeyHandler().createKeys(username, password, ip);
            validKeys.add(mapKeys(createdKeys).getKeys().getKey());
        }
        return validKeys;
    }

    private String getIP() throws IOException {
        java.net.URL url = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));
        return in.readLine();
    }
}
