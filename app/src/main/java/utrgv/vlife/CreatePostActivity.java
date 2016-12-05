package utrgv.vlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CreatePostActivity extends AppCompatActivity
{
	private Toolbar mToolbar;
	private Spinner mPostVisSpinner;
	private Button mContinueButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_post);

		mToolbar = (Toolbar) findViewById(R.id.create_post_toolbar);
		mPostVisSpinner =(Spinner) findViewById(R.id.spinner_post_visibility);
		mContinueButton = (Button) findViewById(R.id.create_post_continue_button);
		setSupportActionBar(mToolbar);

		assert getSupportActionBar() != null;
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		String[] postVisibilityOptions = {"Set Post Visibility", "Public", "Private (students/faculty only)"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, postVisibilityOptions);
		mPostVisSpinner.setAdapter(adapter);

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		mContinueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				Intent i = new Intent(CreatePostActivity.this, CreatePostPreviewActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();

		switch (id)
		{
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
