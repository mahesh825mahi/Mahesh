package com.zmax.allsamples.widgets.Listview.Sectionheader;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zmax.allsamples.R;
import java.util.ArrayList;
import java.util.TreeSet;
class CustomAdapter extends BaseAdapter
{
	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
	private ArrayList<String> mData = new ArrayList<String>();
	private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
	private LayoutInflater mInflater;
	OnCustomClickListener onCustomClickListener;
	Context ctx;

	public CustomAdapter(Context context,OnCustomClickListener onCustomClickListener)
	{
		this.ctx=context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.onCustomClickListener =onCustomClickListener;
	}

	public void addItem(final String item)
	{
		mData.add(item);
		notifyDataSetChanged();
	}

	public void addSectionHeaderItem(final String item)
	{
		mData.add(item);
		sectionHeader.add(mData.size() - 1);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public String getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int rowType = getItemViewType(position);

		if (convertView == null)
		{
			holder = new ViewHolder();
			switch (rowType)
			{
			case TYPE_ITEM:
				convertView = mInflater.inflate(R.layout.sectionheader_item1, null);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case TYPE_SEPARATOR:
				convertView = mInflater.inflate(R.layout.sectionheader_item2, null);
				holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
				break;
			}
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(mData.get(position));
		holder.textView.setTag(""+mData.get(position));
		holder.textView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				onCustomClickListener.OnCustomClick(v,position);

			}
		});

		return convertView;
	}

	public static class ViewHolder
	{
		public TextView textView;
	}

}