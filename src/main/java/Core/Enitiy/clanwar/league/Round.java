package Core.Enitiy.clanwar.league;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Round
{
	@SerializedName("warTags")
	@Expose
	private List<String> warTags = null;
	
	/**
	 * Returns the tag of each war occurring during this round.
	 * 
	 * @return a <code>List</code> of String
	 */
	public List<String> getWarTags()
	{
		return warTags;
	}
}
