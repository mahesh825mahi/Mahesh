package com.zmax.allsamples.widgets.Listview;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.zmax.allsamples.R;
import java.util.ArrayList;
public class ActivityCustomListClick extends Activity implements OnCustomClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ArrayList<NewsItem> image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
        lv1.setAdapter(new CustomListAdapter(this, image_details,this));
        lv1.setOnItemClickListener(new OnItemClickListener()
        {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
				Object o = lv1.getItemAtPosition(position);
				NewsItem newsData = (NewsItem) o;
				Toast.makeText(ActivityCustomListClick.this, "Selected :--> "+position + " " + newsData, Toast.LENGTH_LONG).show();
			}

		});

    }

    private ArrayList<NewsItem> getListData() {
        ArrayList<NewsItem> results = new ArrayList<NewsItem>();
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
    public void OnCustomClick(View aView, int position)
    {
        long viewId = aView.getId();
        if (viewId == R.id.title) {
            Toast.makeText(this, "Button clicked position -->" +position, Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.reporter) {
            Toast.makeText(this, "Button clicked position --->"+position, Toast.LENGTH_SHORT).show();
        } else {
            System.out.println(viewId);
            System.out.println(R.id.title);
            Toast.makeText(this, "ListView clicked position-->" + position, Toast.LENGTH_SHORT).show();
        }
    }
}
