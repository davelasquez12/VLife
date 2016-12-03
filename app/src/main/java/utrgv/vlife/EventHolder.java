package utrgv.vlife;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class EventHolder extends RecyclerView.ViewHolder
{
	private TextView mTitleTV, mHostingOrgTV, mTimeTV, mLocationTV, mNumLikesTV;
	private ImageButton mThumbsUpIB;

	public EventHolder(View itemView)
	{
		super(itemView);
		mTitleTV = (TextView) itemView.findViewById(R.id.event_title_textview);
		mHostingOrgTV = (TextView) itemView.findViewById(R.id.hosting_org_textview);
		mTimeTV = (TextView) itemView.findViewById(R.id.event_time_textview);
		mLocationTV = (TextView) itemView.findViewById(R.id.event_location_textview);
		mNumLikesTV = (TextView) itemView.findViewById(R.id.event_num_likes_textview);
		mThumbsUpIB = (ImageButton) itemView.findViewById(R.id.thumbs_up_image_button);
	}

	public void bindData(Event event)
	{
		mTitleTV.setText(event.getTitle());
		mHostingOrgTV.setText(event.getHostingOrg());
		mTimeTV.setText(event.getTime());
		mLocationTV.setText(event.getLocation());
		mNumLikesTV.setText(event.getNumLikes());
	}
}
