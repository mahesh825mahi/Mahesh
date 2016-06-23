package com.zmax.allsamples.widgets.Listview.Sectionheader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.zmax.allsamples.R;
public class SectionListView extends AppCompatActivity implements OnCustomClickListener
{
    private CustomAdapter mAdapter;
    ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sectionheader);
        listView1 = (ListView) findViewById(R.id.listView1);
        mAdapter = new CustomAdapter(this, (OnCustomClickListener) this);
        for (int i = 1; i < 30; i++) {
            mAdapter.addItem("Row Item #" + i);
            if (i % 4 == 0) {
                mAdapter.addSectionHeaderItem("Section #" + i);
            }
        }
        listView1.setAdapter(mAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SectionListView.this, "listview clicked", Toast.LENGTH_LONG).show();
            }
        });
        //setListAdapter(mAdapter);
        /*mAdapter = new CustomAdapter(this);
		for (int i = 1; i < 30; i++)
		{
			mAdapter.addItem("Row Item #" + i);
			if (i % 4 == 0)
			{
				mAdapter.addSectionHeaderItem("Section #" + i);
			}
		}
		setListAdapter(mAdapter);*/
    }

    @Override
    public void OnCustomClick(View aView, int position) {
        String output = aView.getTag().toString();
        Toast.makeText(SectionListView.this, output, Toast.LENGTH_LONG).show();
    }
}