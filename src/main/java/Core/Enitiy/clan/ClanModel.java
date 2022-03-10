package Core.Enitiy.clan;

import Core.Enitiy.player.League;
import Core.Util;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClanModel
{
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("type")
	@Expose
	private String type;
	
	@SerializedName("description")
	@Expose
	private String description;
	
	@SerializedName("location")
	@Expose
	private Location location;
	
	@SerializedName("badgeUrls")
	@Expose
	private BadgeUrls badgeUrls;
	
	@SerializedName("clanLevel")
	@Expose
	private Integer clanLevel;
	
	@SerializedName("clanPoints")
	@Expose
	private Integer clanPoints;
	
	@SerializedName("clanVersusPoints")
	@Expose
	private Integer clanVersusPoints;
	
	@SerializedName("requiredTrophies")
	@Expose
	private Integer requiredTrophies;

	@SerializedName("requiredVersusTrophies")
	@Expose
	private Integer requiredVersusTrophies;

	@SerializedName("requiredTownhallLevel")
	@Expose
	private Integer requiredTownhallLevel;
	
	@SerializedName("warFrequency")
	@Expose
	private String warFrequency;
	
	@SerializedName("warWinStreak")
	@Expose
	private Integer warWinStreak;
	
	@SerializedName("warWins")
	@Expose
	private Integer warWins;

	@SerializedName("warLosses")
	@Expose
	private Integer warLosses;

	@SerializedName("warTies")
	@Expose
	private Integer warTies;
	
	@SerializedName("isWarLogPublic")
	@Expose
	private Boolean isWarLogPublic;
	
	@SerializedName("warLeague")
	@Expose
	private League warLeague;
	
	@SerializedName("members")
	@Expose
	private Integer members;
	
	@SerializedName("memberList")
	@Expose
	private List<ClanMember> memberList = null;
	
	@SerializedName("labels")
	@Expose
	private List<Label> labels = null;

	public String getTag()
	{
		return tag;
	}

	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public String getDescription()
	{
		return description;
	}
	
	public Location getLocation()
	{
		return location;
	}

	public BadgeUrls getBadgeUrls()
	{
		return badgeUrls;
	}

	public Integer getClanLevel()
	{
		return clanLevel;
	}

	public Integer getClanPoints()
	{
		return clanPoints;
	}

	public Integer getClanVersusPoints()
	{
		return clanVersusPoints;
	}

	public Integer getRequiredTrophies()
	{
		return requiredTrophies;
	}

	public Integer getRequiredVersusTrophies()
	{
		return requiredVersusTrophies;
	}

	public Integer getRequiredTownhallLevel()
	{
		return requiredTownhallLevel;
	}

	public String getWarFrequency()
	{
		return warFrequency;
	}

	public Integer getWarWinStreak()
	{
		return warWinStreak;
	}

	public Integer getWarWins()
	{
		return warWins;
	}

	public Integer getWarLosses()
	{
		return warLosses;
	}

	public Integer getWarTies()
	{
		return warTies;
	}

	public Boolean isWarLogPublic()
	{
		return isWarLogPublic;
	}
	
	public League getWarLeague()
	{
		return warLeague;
	}

	public Integer getMembers()
	{
		return members;
	}

	public List<ClanMember> getMemberList()
	{
		return memberList;
	}

	public List<Label> getLabels()
	{
		return labels;
	}

	public String getLink(){
		return "https://link.clashofclans.com/?action=OpenClanProfile&tag=" + Util.formatTag(getTag());
	}

	@Override
	public String toString() {
		return "ClanModel{" +
				"tag='" + tag + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", location=" + location +
				", clanLevel=" + clanLevel +
				", warWinStreak=" + warWinStreak +
				", warWins=" + warWins +
				", warLosses=" + warLosses +
				", warTies=" + warTies +
				", isWarLogPublic=" + isWarLogPublic +
				", warLeague=" + warLeague +
				", members=" + members +
				'}';
	}
}
