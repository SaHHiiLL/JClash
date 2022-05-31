package Core.Enitiy.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifiedPlayer {

    @SerializedName("tag")
    @Expose
    private String tag;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("status")
    @Expose
    private String status;

    public String getTag() { return tag; }

    public String getToken() { return token; }

    public String getStatus() { return status; }
}
