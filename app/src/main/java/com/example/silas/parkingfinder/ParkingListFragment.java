package com.example.silas.parkingfinder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParkingListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParkingListFragment extends ListFragment {

    private List<Item> parkingList = new ArrayList<>();
    ListAdapter adapter;


    public ParkingListFragment() {
        // Required empty public constructor
    }


    public static ParkingListFragment newInstance() {
        ParkingListFragment fragment = new ParkingListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ListAdapter adapter = new ArrayAdapter<Item>(getActivity(), android.R.layout.simple_list_item_1, parkingList);

        adapter = new ItemAdapter(getActivity(),parkingList);
        setListAdapter(adapter);
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parking_list, container, false);
    }

    public void updateDatasource(List datasource){
        ArrayAdapter m = (ArrayAdapter) getListAdapter();
        m.clear();
        m.addAll(datasource);
        m.notifyDataSetChanged();

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Item itemClicked = (Item) adapter.getItem(position);
        DetailFragment detailFragment = DetailFragment.newInstance(itemClicked);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.parking_fragment_container, detailFragment, null).addToBackStack(null).commit();
    }
}
