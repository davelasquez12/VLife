package utrgv.vlife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment
{
	private List<Event> mEventList = new ArrayList<>();
	private RecyclerView mEventsRV;
	private int mVPPage;
	private EventsAdapter mEventsAdapter;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		mEventList.add(new Event("$1 Slice Pizza", "Hack and Make", "12:15 - 1:00 PM", "Engineering Bldg, entrance", "", "32", "#pizza, #fundraiser"));

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.events_recycler_view, container, false);
		mEventsRV = (RecyclerView) view.findViewById(R.id.events_recycyler_view);
		mEventsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
		mEventsRV.setHasFixedSize(true);
		setupRVAdapter();

		return view;
	}

	public void setVPPageNumber(int page)
	{
		mVPPage = page;
	}

	private void setupRVAdapter()
	{
		mEventsAdapter = new EventsAdapter();
		mEventsRV.setAdapter(mEventsAdapter);
	}

	private class EventsAdapter extends RecyclerView.Adapter<EventHolder>
	{
		@Override
		public EventHolder onCreateViewHolder(ViewGroup parent, int viewType)
		{
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			View view = inflater.inflate(R.layout.list_item_event, parent, false);

			return new EventHolder(view);
		}

		@Override
		public void onBindViewHolder(EventHolder holder, int position)
		{
			Event event = mEventList.get(position);
			holder.bindData(event);
		}

		@Override
		public int getItemCount()
		{
			return mEventList.size();
		}
	}
}
