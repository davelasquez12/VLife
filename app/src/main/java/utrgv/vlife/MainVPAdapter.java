package utrgv.vlife;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

/**
 * Created by David on 12/2/2016.
 */

public class MainVPAdapter extends FragmentStatePagerAdapter
{
	public static final int NUM_EVENT_FRAGS = 10;
	private EventsFragment[] mFragArr = new EventsFragment[NUM_EVENT_FRAGS];

	public MainVPAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int position)
	{
		return new EventsFragment();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		EventsFragment fragment = (EventsFragment) super.instantiateItem(container, position);
		fragment.setVPPageNumber(position);
		mFragArr[position] = fragment;
		return fragment;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		mFragArr[position] = null;
		super.destroyItem(container, position, object);
	}

	public EventsFragment getFragment(int position)
	{
		return mFragArr[position];
	}

	@Override
	public int getCount()
	{
		return NUM_EVENT_FRAGS;
	}
}
