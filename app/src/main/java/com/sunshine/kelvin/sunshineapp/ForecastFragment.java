package com.sunshine.kelvin.sunshineapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kelvin on 12/28/17.
 */

public class ForecastFragment extends Fragment {


    private ArrayAdapter<String> weatherArrayAdapter;
    public ForecastFragment(){
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh){
            FetchWeatherTask fetch = new FetchWeatherTask();
            fetch.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragement, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false
        );

        String SampleData [] = {
                "Kelvin", "Kofi", "His", "Friend", "Lotus"
        };

        List<String> weekForecast = new ArrayList<>(Arrays.asList(SampleData));
        weatherArrayAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_forecast,
                R.id.listview_forecast,
                weekForecast);

        ListView ListView = rootView.findViewById(R.id.listview_forecast);
        ListView.setAdapter(weatherArrayAdapter);

        return rootView;
    }
}