package com.zmax.allsamples.activity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.zmax.allsamples.R;
import com.zmax.allsamples.model.States;
import java.util.ArrayList;
public class ListviewCheckboxesActivity extends Activity
{
          MyCustomAdapter dataAdapter = null;
            @Override
            public void onCreate(Bundle savedInstanceState)
            {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_listview_checkbox);
               //Generate list View from ArrayList
               displayListView();
               checkButtonClick();
            }
 
            private void displayListView()
            {
                    //Array list of countries
                    ArrayList<States> stateList = new ArrayList<States>();
                    States _states = new States("AP","Andhra Pradesh",false);
                    stateList.add(_states);
                    _states = new States("DL","Delhi",true);
                    stateList.add(_states);
                    _states = new States("GA","Goa",false);
                    stateList.add(_states);
                    _states = new States("JK","Jammu & Kashmir",true);
                    stateList.add(_states);
                    _states = new States("KA","Karnataka",true);
                    stateList.add(_states);
                    _states = new States("KL","Kerala",false);
                    stateList.add(_states);
                    _states = new States("RJ","Rajasthan",false);
                    stateList.add(_states);
                    _states = new States("WB","West Bengal",false);
                    stateList.add(_states);

                _states = new States("DL","Delhi",true);
                stateList.add(_states);
                _states = new States("GA","Goa",false);
                stateList.add(_states);
                _states = new States("JK","Jammu & Kashmir",true);
                stateList.add(_states);
                _states = new States("KA","Karnataka",true);
                stateList.add(_states);
                _states = new States("KL","Kerala",false);
                stateList.add(_states);
                _states = new States("RJ","Rajasthan",false);
                stateList.add(_states);
                _states = new States("WB","West Bengal",false);
                stateList.add(_states);


                _states = new States("DL","Delhi",true);
                stateList.add(_states);
                _states = new States("GA","Goa",false);
                stateList.add(_states);
                _states = new States("JK","Jammu & Kashmir",true);
                stateList.add(_states);
                _states = new States("KA","Karnataka",true);
                stateList.add(_states);
                _states = new States("KL","Kerala",false);
                stateList.add(_states);
                _states = new States("RJ","Rajasthan",false);
                stateList.add(_states);
                _states = new States("WB","West Bengal",false);
                stateList.add(_states);
 
                    //create an ArrayAdaptar from the String Array
                    dataAdapter = new MyCustomAdapter(this,R.layout.singleview_checkbox, stateList);
                    final ListView listView = (ListView) findViewById(R.id.listView1);
                    // Assign adapter to ListView
                    listView.setAdapter(dataAdapter);
 
                    listView.setOnItemClickListener(new OnItemClickListener() 
                    {
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
                            {
                                    // When clicked, show a toast with the TextView text
                                    States state = (States) parent.getItemAtPosition(position);
                                    Toast.makeText(getApplicationContext(),"Clicked on Row: " + state.getName(), 
                                    Toast.LENGTH_LONG).show();
                            }
                    });
            }
 
private class MyCustomAdapter extends ArrayAdapter<States>
{
   private ArrayList<States> stateList;
  public MyCustomAdapter(Context context, int textViewResourceId,
  ArrayList<States> stateList) 
  {
        super(context, textViewResourceId, stateList);
        this.stateList = new ArrayList<States>();
        this.stateList.addAll(stateList);
  }
 
    private class ViewHolder
    {
      TextView code;
      CheckBox name;
    }
 
    @Override
   public View getView(int position, View convertView, ViewGroup parent) 
    {
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));
            if (convertView == null)
            {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView = vi.inflate(R.layout.singleview_checkbox, null);
              holder = new ViewHolder();
              holder.code = (TextView) convertView.findViewById(R.id.code);
              holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
              convertView.setTag(holder);
                holder.name.setOnClickListener( new OnClickListener()
                        {
                                   public void onClick(View v)  
                                   {
                                     CheckBox cb = (CheckBox) v;
                                     States _state = (States) cb.getTag();
                                     Toast.makeText(getApplicationContext(), "Clicked on Checkbox: " + cb.getText() + " is " + cb.isChecked(), 
                                     Toast.LENGTH_LONG).show();
                                     _state.setSelected(cb.isChecked());
                                  }
                        });
 
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
 
            States state = stateList.get(position);
            holder.code.setText(" (" + state.getCode() + ")");
            holder.name.setText(state.getName());
            holder.name.setChecked(state.isSelected());
            holder.name.setTag(state);
            return convertView;
    }


    @Override
    public int getViewTypeCount()
    {
        return 2;
    }

    @Override
    public int getItemViewType(int position)
    {
        return 1;
    }
}
        private void checkButtonClick() 
        {
                Button myButton = (Button) findViewById(R.id.findSelected);
                myButton.setOnClickListener(new OnClickListener() 
                {
                            @Override
                            public void onClick(View v) 
                            {
                                            StringBuffer responseText = new StringBuffer();
                                            responseText.append("The following were selected...\n");
                                            ArrayList<States> stateList = dataAdapter.stateList;
                                            for(int i=0;i<stateList.size();i++)
                                            {
                                                 States state = stateList.get(i);
                                                if(state.isSelected())
                                                {
                                                    responseText.append("\n" + state.getName());
                                                }
                                            }
                                            Toast.makeText(getApplicationContext(),
                                            responseText, Toast.LENGTH_LONG).show();
                            }
                });
        }
 
}