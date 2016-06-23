package com.zmax.allsamples.widgets.Listview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.zmax.allsamples.R;
import java.util.ArrayList;
public class CustomListAdapter extends BaseAdapter
{
	private ArrayList<NewsItem> listData;
	private LayoutInflater layoutInflater;
	OnCustomClickListener onCustomClickListener;

	public CustomListAdapter(Context context, ArrayList<NewsItem> listData,OnCustomClickListener onCustomClickListener)
	{
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
		this.onCustomClickListener =onCustomClickListener;
	}

	@Override
	public int getCount() {
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView,final ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.custom_listview, null);
			holder = new ViewHolder();
			holder.headlineView = (Button) convertView.findViewById(R.id.title);
			holder.reporterNameView = (Button) convertView.findViewById(R.id.reporter);
			holder.reportedDateView = (TextView) convertView.findViewById(R.id.date);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		//holder.headlineView.setText(listData.get(position).getHeadline());
		//holder.reporterNameView.setText("By, " + listData.get(position).getReporterName());
		holder.reportedDateView.setText(listData.get(position).getDate());

		holder.headlineView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				long viewId = v.getId();
				onCustomClickListener.OnCustomClick(v,position);
				//((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
			}
		});



		holder.reporterNameView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onCustomClickListener.OnCustomClick(v,position);
				//((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
			}
		});


	/*	holder.reportedDateView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
			}
		});*/

		return convertView;
	}

	static class ViewHolder {
		Button headlineView;
		Button reporterNameView;
		//TextView headlineView;
		//TextView reporterNameView;
		TextView reportedDateView;
	}
}
