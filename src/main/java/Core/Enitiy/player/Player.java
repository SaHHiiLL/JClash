package Core.Enitiy.player;

import Core.Enitiy.League.League;
import Core.Enitiy.clan.ClanModel;
import Core.Enitiy.clan.Label;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Player {

    @SerializedName("clan")
    @Expose
    private ClanModel clan;

    @SerializedName("league")
    @Expose
    private League league;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("attackWins")
    @Expose
    private Integer attackWins;

    @SerializedName("defenseWins")
    @Expose
    private Integer defenseWins;

    @SerializedName("townHallLevel")
    @Expose
    private Integer townHallLevel;

    @SerializedName("townHallWeaponLevel")
    @Expose
    private Integer townHallWeaponLevel;

    @SerializedName("legendStatistics")
    @Expose
    private LegendStatistics legendStatistics;

    @SerializedName("troops")
    @Expose
    private List<Troop> troops = null;

    @SerializedName("heroes")
    @Expose
    private List<Troop> heroes = null;

    @SerializedName("spells")
    @Expose
    private List<Troop> spells = null;

    @SerializedName("labels")
    @Expose
    private List<Label> labels = null;

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

    @SerializedName("bestTrophies")
    @Expose
    private Integer bestTrophies;

    @SerializedName("donations")
    @Expose
    private Integer donations;

    @SerializedName("donationsReceived")
    @Expose
    private Integer donationsReceived;

    @SerializedName("builderHallLevel")
    @Expose
    private Integer builderHallLevel;

    @SerializedName("versusTrophies")
    @Expose
    private Integer versusTrophies;

    @SerializedName("bestVersusTrophies")
    @Expose
    private Integer bestVersusTrophies;

    @SerializedName("warStars")
    @Expose
    private Integer warStars;

    @SerializedName("achievements")
    @Expose
    private List<Achievement> achievements = null;

    @SerializedName("versusBattleWinCount")
    @Expose
    private Integer versusBattleWinCount;

    public ClanModel getClan() {
        return clan;
    }

    public League getLeague() {
        return league;
    }

    public String getRole() {
        return role;
    }

    public Integer getAttackWins() {
        return attackWins;
    }

    public Integer getDefenseWins() {
        return defenseWins;
    }

    public Integer getTownHallLevel() {
        return townHallLevel;
    }

    public Integer getTownHallWeaponLevel() {
        return townHallWeaponLevel;
    }

    public LegendStatistics getLegendStatistics() {
        return legendStatistics;
    }

    public List<Troop> getTroops() {
        return troops;
    }

    public List<Troop> getHeroes() {
        return heroes;
    }

    public List<Troop> getSpells() {
        return spells;
    }

    public List<Label> getLabels() {
        return labels;
    }

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

    public Integer getBestTrophies() {
        return bestTrophies;
    }

    public Integer getDonations() {
        return donations;
    }

    public Integer getDonationsReceived() {
        return donationsReceived;
    }

    public Integer getBuilderHallLevel() {
        return builderHallLevel;
    }

    public Integer getVersusTrophies() {
        return versusTrophies;
    }

    public Integer getBestVersusTrophies() {
        return bestVersusTrophies;
    }

    public Integer getWarStars() {
        return warStars;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public Integer getVersusBattleWinCount() {
        return versusBattleWinCount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "role='" + role + '\'' +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", expLevel=" + expLevel +
                ", bestTrophies=" + bestTrophies +
                ", warStars=" + warStars +
                '}';
    }
}
