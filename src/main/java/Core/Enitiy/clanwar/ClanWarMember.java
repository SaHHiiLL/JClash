package Core.Enitiy.clanwar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClanWarMember
{
	@SerializedName("tag")
	@Expose
	private String tag;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("mapPosition")
	@Expose
	private Integer mapPosition;
	
	@SerializedName("townhallLevel")
	@Expose
	private Integer townhallLevel;
	
	@SerializedName("opponentAttacks")
	@Expose
	private Integer opponentAttacks;
	
	@SerializedName("bestOpponentAttack")
	@Expose
	private Attack bestOpponentAttack;
	
	@SerializedName("attacks")
	@Expose
	private List<Attack> attacks = null;
	
	/**
	 * Returns the tag of the clan member involved in this war.<br><br>
	 * The tag is a unique identifier each player has, in the form of #AAAA00.<br>
	 * It is displayed under the nickname on player's profile.
	 * 
	 * @return a <code>String</code>
	 */
	public String getTag()
	{
		return tag;
	}
	
	/**
	 * Returns the name of the clan member involved in this war.<br>
	 * The name is the identity behind which you appear when you write in chat.
	 * 
	 * @return a <code>String</code>
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the position at which the clan war member is in the map.
	 * 
	 * @return an integer
	 */
	public Integer getMapPosition()
	{
		return mapPosition;
	}
	
	/**
	 * Returns the current level of the clan war member's townhall.<br><br>
	 * Ranges from <code>1</code> to <code>13</code>.
	 * 
	 * @return an integer
	 */
	public Integer getTownhallLevel()
	{
		return townhallLevel;
	}
	
	/**
	 * Returns how many of his attacks the clan war member did.
	 * 
	 * @return an integer
	 */
	public Integer getOpponentAttacks()
	{
		return opponentAttacks;
	}
	
	/**
	 * Returns the best attack the clan war member did.
	 * 
	 * @return an <code>Attack</code> object
	 * @see Attack
	 */
	public Attack getBestOpponentAttack()
	{
		return bestOpponentAttack;
	}
	
	/**
	 * Returns the attacks the clan war member did.
	 * 
	 * @return a <code>List</code> of <code>Attack</code> objects
	 * @see Attack
	 */
	public List<Attack> getAttacks()
	{
		return attacks;
	}

	public String thIcon(){
		switch (townhallLevel) {
			case 1:
				return "https://cdn.discordapp.com/attachments/865619872967950347/872880465378418688/th1.png";
			case 2:
				return "https://media.discordapp.net/attachments/865619872967950347/872880702172049448/th2.png";
			case 3:
				return "https://media.discordapp.net/attachments/865619872967950347/872881142213271582/unnamed.png";
			case 4:
				return  "https://cdn.discordapp.com/attachments/865619872967950347/872881616572264528/unnamed.png";
			case 5:
				return  "https://media.discordapp.net/attachments/865619872967950347/872878770791542844/th5.png";
			case 6:
				return "https://media.discordapp.net/attachments/865619872967950347/865633092643454986/1_6.png";
			case 7:
				return "https://media.discordapp.net/attachments/865619872967950347/872877265665531944/th7.png";
			case 8:
				return "https://images-ext-2.discordapp.net/external/1GRtQCxcDskVPnDSWn_aRhICfCCjIh0rNK2Xl0BSTY4/https/minionbotclientstorage.blob.core.windows.net/townhalls/08.png";
			case 9:
				return "https://media.discordapp.net/attachments/865619872967950347/865619979504320532/758607429322801165.png";
			case 10:
				return "https://images-ext-1.discordapp.net/external/-xrZbwql2N8G8WmXgSGfymp-Nb_Pr0GopBEiTmFyzMk/https/minionbotclientstorage.blob.core.windows.net/townhalls/10.png";
			case 11:
				return  "https://media.discordapp.net/attachments/865619872967950347/865631736914378752/Town_Hall11.webp";
			case 12:
				return "https://media.discordapp.net/attachments/865619872967950347/872877604682747924/th12.png";
			case 13:
				return  "https://media.discordapp.net/attachments/865619872967950347/872878425587736586/th13.png?width=626&height=670";
			case 14:
				return  "https://images-ext-1.discordapp.net/external/VB8oGMkcgeoie_eXgh1np-82DSCxiRKLoPt2ETIx_BY/https/minionbotclientstorage.blob.core.windows.net/townhalls/14.png";
			default:
				return null;
		}
	}
}
