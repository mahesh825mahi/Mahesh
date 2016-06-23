package com.zmax.allsamples.fragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.zmax.allsamples.R;
import com.zmax.allsamples.widgets.Listview.ActivityCustomListClick;
import com.zmax.allsamples.widgets.Listview.CustomListAdapter;
import com.zmax.allsamples.widgets.Listview.NewsItem;
import com.zmax.allsamples.widgets.Listview.OnCustomClickListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnCustomClickListener , SearchView.OnQueryTextListener
{
    Context ctx;
    ArrayList<NewsItem> results;
    ListView lv1;
    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_listview, container, false);

        ArrayList<NewsItem> image_details = getListData();
        lv1 = (ListView) rootView.findViewById(R.id.custom_list);
        lv1.setAdapter(new CustomListAdapter(ctx, image_details,this));
        lv1.setTextFilterEnabled(true);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                NewsItem newsData = (NewsItem) o;
                Toast.makeText(ctx, "Selected :--> "+position + " " + newsData, Toast.LENGTH_LONG).show();
            }

        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ctx =activity;


    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("HOME");
    }

    private ArrayList<NewsItem> getListData() {
        results = new ArrayList<NewsItem>();
        NewsItem newsData = new NewsItem();
        newsData.setHeadline("Dance of Democracy");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("Major Naxal attacks in the past");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("BCCI suspends Gurunath pending inquiry ");
        newsData.setReporterName("Rajiv Chandan");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
        newsData.setReporterName("Sudeep Nanda");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);


        newsData = new NewsItem();
        newsData.setHeadline("11111111111 ");
        newsData.setReporterName("Rajiv Chandan");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("L222222222222");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("3333333333333");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("4444444444444444444444444");
        newsData.setReporterName("Sudeep Nanda");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);


        newsData = new NewsItem();
        newsData.setHeadline("555555555555555555 ");
        newsData.setReporterName("Rajiv Chandan");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("666666666666666666666");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("7777777777777");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("888888888888888888");
        newsData.setReporterName("Sudeep Nanda");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);


        newsData = new NewsItem();
        newsData.setHeadline("11111111111 ");
        newsData.setReporterName("Rajiv Chandan");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("L222222222222");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("3333333333333");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("4444444444444444444444444");
        newsData.setReporterName("Sudeep Nanda");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);


        newsData = new NewsItem();
        newsData.setHeadline("555555555555555555 ");
        newsData.setReporterName("Rajiv Chandan");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("666666666666666666666");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("7777777777777");
        newsData.setReporterName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);

        newsData = new NewsItem();
        newsData.setHeadline("888888888888888888");
        newsData.setReporterName("Sudeep Nanda");
        newsData.setDate("May 26, 2013, 13:35");
        results.add(newsData);
        return results;
    }

    @Override
    public void OnCustomClick(View aView, int position) {
        long viewId = aView.getId();
        if (viewId == R.id.title) {
            Toast.makeText(ctx, "Button clicked position -->" +position, Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.reporter) {
            Toast.makeText(ctx, "Button clicked position --->"+position, Toast.LENGTH_SHORT).show();
        } else {
            System.out.println(viewId);
            System.out.println(R.id.title);
            Toast.makeText(ctx, "ListView clicked position-->" + position, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //final ArrayList<NewsItem> filteredModelList = filter(results, newText);
        //lv1.setFilter(filteredModelList);
        //lv1.getFilter().filter

        return true;
    }

    private ArrayList<NewsItem> filter(ArrayList<NewsItem> models, String query) {
        query = query.toLowerCase();

        final ArrayList<NewsItem> filteredModelList = new ArrayList<>();
        for (NewsItem model : models) {
            final String text = model.getHeadline().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        //lv1.setFilter(mCountryModel);


                        //lv1.clearTextFilter();

                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }
}
