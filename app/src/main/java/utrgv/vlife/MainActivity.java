package utrgv.vlife;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
	private Toolbar mToolbar;
	private MainVPAdapter mMainVPAdapter;
	private ViewPager mViewPager;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mNavDrawerLV;
	private LinearLayout mDateSelectButton;
	private int mCurrentVPPos = MainVPAdapter.NUM_EVENT_FRAGS/2;
	private String[] mSortCategories = {"Real Time", "Chronological", "Most Liked", "Least Liked"};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
		mNavDrawerLV = (ListView) findViewById(R.id.main_nav_drawer_list_view);
		mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
		mDateSelectButton = (LinearLayout) findViewById(R.id.select_date_from_calendar_button);
		setSupportActionBar(mToolbar);

		mDateSelectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				DatePickerFragment dialog = new DatePickerFragment();
				dialog.show(getSupportFragmentManager(), "date_select");
			}
		});

		setupNavDrawer();
		setupViewPager();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main_toolbar_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id)
		{
			case R.id.menu_item_create_post:
				Intent i = new Intent(this, CreatePostActivity.class);
				startActivity(i);
				return  true;

			case R.id.menu_item_sort_events:
				showSortDialog();
				return true;

			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setupNavDrawer()
	{
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.nav_drawer_opened, R.string.nav_drawer_closed)
		{
			@Override
			public void onDrawerOpened(View drawerView)
			{
				super.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView)
			{
				super.onDrawerClosed(drawerView);
			}
		};

		mDrawerLayout.addDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();

		String[] navOptions = {"My Organizations", "Favorites", "#free-food", "#food", "#speaker-presentation",
				"#social-event", "#fundraiser", "Settings"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, navOptions);
		mNavDrawerLV.setAdapter(adapter);
		mNavDrawerLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{

			}
		});
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

	private void showSortDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Sort Events By:");
		builder.setSingleChoiceItems(mSortCategories, 0, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i)
			{
				dialogInterface.dismiss();
			}
		});

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
