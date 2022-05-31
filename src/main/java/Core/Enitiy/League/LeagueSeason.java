package Core.Enitiy.League;

import Core.Enitiy.clan.BadgeUrls;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueSeason {

    @SerializedName("items")
    @Expose
    private List<LeagueSeasonItem> item;

    public List<LeagueSeasonItem> getItem() {
        return item;
    }

    public class LeagueSeasonItem {
        @SerializedName("tag")
        @Expose
        private String tag;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("expLevel")
        @Expose
        private Integer expLevel;

        @SerializedName("trophies")
        @Expose
        private Integer trophies;

        @SerializedName("attackWins")
        @Expose
        private Integer attackWins;

        @SerializedName("defenseWins")
        @Expose
        private Integer defenseWins;

        @SerializedName("rank")
        @Expose
        private Integer rank;

        @SerializedName("clan")
        @Expose
        private Clan_ clan;

        public String getTag() {
            return tag;
        }

        public String getName() {
            return name;
        }

        public Integer getExpLevel() {
            return expLevel;
        }

        public Integer getTrophies() {
            return trophies;
        }

        public Integer getAttackWins() {
            return attackWins;
        }

        public Integer getDefenseWins() {
            return defenseWins;
        }

        public Integer getRank() {
            return rank;
        }
    }
    public class Clan_ {
        @SerializedName("tag")
        @Expose
        private String tag;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("badgeUrls")
        @Expose
        private BadgeUrls badgeUrls;

        public String getTag() {
            return tag;
        }

        public String getName() {
            return name;
        }

        public BadgeUrls getBadgeUrls() {
            return badgeUrls;
        }
    }
}
