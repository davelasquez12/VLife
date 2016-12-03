package utrgv.vlife;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity
{
	private Toolbar mToolbar;
	private MainVPAdapter mMainVPAdapter;
	private ViewPager mViewPager;
	private int mCurrentVPPos = MainVPAdapter.NUM_EVENT_FRAGS/2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
		mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
		setSupportActionBar(mToolbar);
		setupViewPager();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main_toolbar_menu, menu);
		return true;
	}

	private void setupViewPager()
	{
		mMainVPAdapter = new MainVPAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mMainVPAdapter);
		mViewPager.setCurrentItem(mCurrentVPPos);

		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
			{

			}

			@Override
			public void onPageSelected(int position)
			{
				mCurrentVPPos = position;
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{

			}
		});

	}
}
