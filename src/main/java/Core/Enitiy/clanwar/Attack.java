package Core.Enitiy.clanwar;

import Core.Enitiy.player.Player;
import Core.JClash;
import Core.exception.ClashAPIException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

public class Attack
{
	@SerializedName("order")
	@Expose
	private Integer order;
	
	@SerializedName("attackerTag")
	@Expose
	private String attackerTag;
	
	@SerializedName("defenderTag")
	@Expose
	private String defenderTag;
	
	@SerializedName("stars")
	@Expose
	private Integer stars;
	
	@SerializedName("destructionPercentage")
	@Expose
	private Double destructionPercentage;

	@SerializedName("duration")
	@Expose
	private Integer duration;

	public Integer getOrder()
	{
		return order;
	}

	public String getAttackerTag()
	{
		return attackerTag;
	}

	public String getDefenderTag()
	{
		return defenderTag;
	}

	public Integer getStars()
	{
		return stars;
	}

	public Double getDestructionPercentage()
	{
		return destructionPercentage;
	}

	public Integer getDuration()
	{
		return duration;
	}

	public String getStarAsEmoji(){
		return "*".repeat(Math.max(0, getStars()));
	}
}
