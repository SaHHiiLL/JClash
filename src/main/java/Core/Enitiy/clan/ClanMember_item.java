package Core.Enitiy.clan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClanMember_item {
    @SerializedName("items")
    @Expose
    private List<ClanMember> item;

    public List<ClanMember> getItem() {
        return item;
    }
}
