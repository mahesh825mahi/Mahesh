package com.zmax.allsamples.db;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.zmax.allsamples.R;
import com.zmax.allsamples.adapter.EmplistAdapter;
import com.zmax.allsamples.model.EmpModel;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by bfonics on 12/27/2015.
 */
public class EmpList extends Activity
{
    List<EmpModel> emparray;
    ListView listView;
    Context  ctx;
    DatabaseHandler db;
    EmplistAdapter emplistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplist);
        ctx = EmpList.this;
        db = new DatabaseHandler(ctx);
        emparray = new ArrayList<EmpModel>();
        loadData();
        listView = (ListView) findViewById(R.id.listView);
        emplistAdapter = new EmplistAdapter(EmpList.this,emparray);
        listView.setAdapter(emplistAdapter);
    }

public  void loadData()
{
    db.selectEmp();
    emparray.addAll(db.selectEmp());
}
}