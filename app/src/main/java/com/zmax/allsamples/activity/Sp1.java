package com.zmax.allsamples.activity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.zmax.allsamples.model.Person;
public class Sp1 extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
{
 super.onCreate(savedInstanceState);
 TextView mTextView = new TextView(this);  
 Person mPerson = (Person)getIntent().getSerializableExtra(Sp.SER_KEY);
 mTextView.setText("You name is: " + mPerson.getName() + "/n"+ "You age is: " + mPerson.getAge());
 setContentView(mTextView);  
}
}  