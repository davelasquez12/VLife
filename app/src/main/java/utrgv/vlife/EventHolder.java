package utrgv.vlife;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class EventHolder extends RecyclerView.ViewHolder
{
	private TextView mTitleTV, mHostingOrgTV, mTimeTV, mLocationTV, mNumLikesTV, mCategoryTags;
	private ImageView mThumbsUpIV;
	private LinearLayout mLikeButton;
	private TextView mLikeTV;

	public EventHolder(View itemView)
	{
		super(itemView);
		mTitleTV = (TextView) itemView.findViewById(R.id.event_title_textview);
		mHostingOrgTV = (TextView) itemView.findViewById(R.id.hosting_org_textview);
		mTimeTV = (TextView) itemView.findViewById(R.id.event_time_textview);
		mLocationTV = (TextView) itemView.findViewById(R.id.event_location_textview);
		mNumLikesTV = (TextView) itemView.findViewById(R.id.event_num_likes_textview);
		mThumbsUpIV = (ImageView) itemView.findViewById(R.id.thumbs_up_image_view);
		mCategoryTags = (TextView) itemView.findViewById(R.id.category_tags);
		mLikeButton = (LinearLayout) itemView.findViewById(R.id.event_like_button);
		//mLikeTV = (TextView) itemView.findViewById(R.id.like_text_view);
	}

	public void bindData(final Event event, final Context appContext)
	{
		mTitleTV.setText(event.getTitle());
		mHostingOrgTV.setText(event.getHostingOrg());
		mTimeTV.setText(event.getTime());
		mLocationTV.setText(event.getLocation());
		mNumLikesTV.setText(event.getNumLikes());
		mCategoryTags.setText(event.getTags());

		mLikeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				if(!event.isLiked())
				{
					Picasso.with(appContext).load(R.drawable.thumb_up_orange).into(mThumbsUpIV);
					/*mLikeTV.setText("Liked!");
					mLikeTV.setTextColor(ContextCompat.getColor(appContext, R.color.orange));*/
					int numLikes = Integer.parseInt(mNumLikesTV.getText().toString());
					mNumLikesTV.setText(String.valueOf(++numLikes));
					mNumLikesTV.setTextColor(ContextCompat.getColor(appContext, R.color.orange));
					event.setLikeStatus(true);
				}
				else
				{
					Picasso.with(appContext).load(R.drawable.thumb_up_gray).into(mThumbsUpIV);
					/*mLikeTV.setText("Like");
					mLikeTV.setTextColor(ContextCompat.getColor(appContext, android.R.color.darker_gray));*/
					int numLikes = Integer.parseInt(mNumLikesTV.getText().toString());
					mNumLikesTV.setText(String.valueOf(--numLikes));
					mNumLikesTV.setTextColor(ContextCompat.getColor(appContext, R.color.gray));
					event.setLikeStatus(false);
				}

			}
		});
	}
}
