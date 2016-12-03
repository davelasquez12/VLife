package utrgv.vlife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
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
	private LinearLayoutManager mLayoutManager;
	private int mVPPage;
	private EventsAdapter mEventsAdapter;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		mEventList.add(new Event("$1 Slice Pizza", "Association of Computer Machinery", "12:15 PM - 1:00 PM", "Engineering Bldg, entrance", "", "32", "#pizza #fundraiser #food"));
		mEventList.add(new Event("Stargazing Night", "Astronomy Club", "8:00 PM - 11:00 PM", "Track Field", "", "51", "#astronomy #social-event #free-food"));
		mEventList.add(new Event("Why Software Engineering Is Cool!", "Computer Science Dept.", "3:00 PM- 4:30 PM", "ENGR Bldg, auditorium", "", "112", "#speaker/presentation #free-food"));
		mEventList.add(new Event("Free Tacos!", "Chess Club", "12:15 PM - 1:00 PM", "Math Bldg, entrance", "", "245", "#free-food #tacos"));
		mEventList.add(new Event("League Tournament", "LoL Club", "12:00 PM - 2:00 AM", "Location is TBA", "", "47", "#gaming #league-of-legends #food"));
		mEventList.add(new Event("Movie Night (Star Wars: The Force Awakens)", "Theatre Club", " 7:30 PM - 10:00 PM", "ARHU Bldg, Rm 2.124", "", "25", "#movie #social-event"));
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.events_recycler_view, container, false);
		mEventsRV = (RecyclerView) view.findViewById(R.id.events_recycyler_view);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mEventsRV.setLayoutManager(mLayoutManager);
		mEventsRV.addItemDecoration(new DividerItemDecoration(mEventsRV.getContext(),mLayoutManager.getOrientation()));

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
			holder.bindData(event, getActivity().getApplicationContext());
		}

		@Override
		public int getItemCount()
		{
			return mEventList.size();
		}
	}
}
