package Core.Enitiy.clanwar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WarInfo
{
	@SerializedName("clan")
	@Expose
	private ClanWarModel clan;
	
	@SerializedName("teamSize")
	@Expose
	private Integer teamSize;
	
	@SerializedName("opponent")
	@Expose
	private ClanWarModel opponent;
	
	@SerializedName("startTime")
	@Expose
	private String startTime;
	
	@SerializedName("state")
	@Expose
	private String state;
	
	@SerializedName("endTime")
	@Expose
	private String endTime;
	
	@SerializedName("preparationStartTime")
	@Expose
	private String preparationStartTime;
	
	/**
	 * Returns the current clan war information.
	 * 
	 * @return an <code>Opponent</code> object
	 * @see ClanWarModel
	 */
	public ClanWarModel getClan()
	{
		return clan;
	}
	
	/**
	 * Returns the number of clan members involved in this war.
	 * 
	 * @return an integer
	 */
	public Integer getTeamSize()
	{
		return teamSize;
	}
	
	/**
	 * Returns the enemy clan war information.
	 * 
	 * @return an <code>Opponent</code> object
	 * @see ClanWarModel
	 */
	public ClanWarModel getEnemy()
	{
		return opponent;
	}
	
	/**
	 * Returns the moment in UTC time when the attacks can start (a day after preparation time).<br><br>
	 * The moment is expressed in <code>ISO-8601</code> standard in the following form: <code>yyyyMMdd'T'HHmmss.SSS'Z'</code>
	 * 
	 * @return a <code>String</code>
	 */
	public String getStartTime()
	{
		return startTime;
	}
	
	/**
	 * Returns a <code>String</code> of the war state for this clan.
	 * 
	 * @return <code>inWar</code> if the clan is currently in attacking time<br>
	 * <code>preparation</code> if the clan is currently in preparation time<br>
	 * <code>warEnded</code> if the war has already occurred<br>
	 * <code>notInWar</code> if the clan is not involved in any war
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Returns the moment in UTC time when the attacks stop.<br><br>
	 * The moment is expressed in <code>ISO-8601</code> standard in the following form: <code>yyyyMMdd'T'HHmmss.SSS'Z'</code>
	 * 
	 * @return a <code>String</code>
	 */
	public String getEndTime()
	{
		return endTime;
	}
	
	/**
	 * Returns the moment in UTC time when the war starts (a day before attacks).<br><br>
	 * The moment is expressed in <code>ISO-8601</code> standard in the following form: <code>yyyyMMdd'T'HHmmss.SSS'Z'</code>
	 * 
	 * @return a <code>String</code>
	 */
	public String getPreparationStartTime()
	{
		return preparationStartTime;
	}

	public Date getPreparationStartTimeAsDate() throws ParseException {
		return new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSX").parse(preparationStartTime);
	}

	public Date getStartTimeAsDate() throws ParseException {
		return new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSX").parse(startTime);
	}

	public Date getEndTimeAsDate() throws ParseException{
		return new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSX").parse(endTime);
	}

	public String getStatus(){
		if (state.equals("warEnded")) {
			if (clan.getStars() > opponent.getStars()) {
				return "Winner: " + clan.getName();
			} else if (clan.getStars() < opponent.getStars()) {
				return "Winner: " + opponent.getName();
			} else {
				if (clan.getDestructionPercentage() > opponent.getDestructionPercentage()) {
					return "Winner: " + clan.getName();
				} else if (clan.getDestructionPercentage() < opponent.getDestructionPercentage()) {
					return "Winner: " + opponent.getName();
				} else {
					return "RESULT: DRAW";
				}
			}
		}
		return "war is still active";
	}
}
