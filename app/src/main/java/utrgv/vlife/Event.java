package utrgv.vlife;


public class Event
{
	private String mTitle, mHostingOrg, mTime, mLocation, mDescription, mNumLikes, mTags;

	public Event(String title, String hostingOrg, String time, String location,
				 String description, String numLikes, String tags)
	{
		mTitle = title;
		mHostingOrg = hostingOrg;
		mTime = time;
		mLocation = location;
		mDescription = description;
		mNumLikes = numLikes;
		mTags = tags;
	}

	public Event(){}

	public String getTitle()
	{
		return mTitle;
	}

	public void setTitle(String title)
	{
		mTitle = title;
	}

	public String getHostingOrg()
	{
		return mHostingOrg;
	}

	public void setHostingOrg(String hostingOrg)
	{
		mHostingOrg = hostingOrg;
	}

	public String getTime()
	{
		return mTime;
	}

	public void setTime(String time)
	{
		mTime = time;
	}

	public String getLocation()
	{
		return mLocation;
	}

	public void setLocation(String location)
	{
		mLocation = location;
	}

	public String getDescription()
	{
		return mDescription;
	}

	public void setDescription(String description)
	{
		mDescription = description;
	}

	public String getNumLikes()
	{
		return mNumLikes;
	}

	public void setNumLikes(String numLikes)
	{
		mNumLikes = numLikes;
	}

	public String getTags()
	{
		return mTags;
	}

	private void setTags(String tags)
	{
		mTags = tags;
	}
}
