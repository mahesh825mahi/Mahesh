package com.zmax.allsamples.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zmax.allsamples.R;
import com.zmax.allsamples.model.EmpModel;

import java.util.ArrayList;
import java.util.List;

public class ListveiwBTClickAdapter extends BaseAdapter {

	List<EmpModel> emparray = new ArrayList<EmpModel>();
	Activity activity;

	// = new java.util.ArrayList<Boolean>();

	public ListveiwBTClickAdapter(Activity activity, List<EmpModel> arrayName)
	{
		this.emparray = arrayName;
		this.activity = activity;
	}

	@Override
	public int getCount()
	{
		return emparray.size();
	}

	@Override
	public Object getItem(int position)
	{
		return emparray.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		View view = convertView;
		Holder holder;
		if (view == null)
		{
			holder = new Holder();
			LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = li.inflate(R.layout.custom_emplist, null);
			holder.name = (TextView) view.findViewById(R.id.name);
			holder.emai = (TextView) view.findViewById(R.id.emai);
			holder.userimage = (ImageView) view.findViewById(R.id.userimage);
			view.setTag(holder);
		}
		else
		{
			holder = (Holder) view.getTag();
		}
		holder.name.setText(emparray.get(position).getUsername());
		holder.emai.setText(emparray.get(position).getEmail());

		return view;
	}

	class Holder
	{
		TextView name,emai;
		ImageView userimage;
	}
}
