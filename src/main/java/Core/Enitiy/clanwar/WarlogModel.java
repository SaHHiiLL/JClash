package Core.Enitiy.clanwar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarlogModel
{
	@SerializedName("items")
	@Expose
	private List<WarlogItem> items = null;

	public List<WarlogItem> getWars()
	{
		return items;
	}
}
