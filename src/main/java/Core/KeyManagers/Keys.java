package Core.KeyManagers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Keys {
    @SerializedName("keys")
    @Expose
    private Key[] keys;

    public Key[] getKeys() {
        return keys;
    }

    public class Key{
        @SerializedName("key")
        @Expose
        private String key;

        @SerializedName("cidrRanges")
        @Expose
        private String[] ips;

        public String getKey() {
            return key;
        }

        public String[] getIps() {
            return ips;
        }

    }
}

