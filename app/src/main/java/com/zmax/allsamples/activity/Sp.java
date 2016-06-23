package com.zmax.allsamples.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.zmax.allsamples.R;
import com.zmax.allsamples.model.Book;
import com.zmax.allsamples.model.Person;
public class Sp extends Activity implements OnClickListener
{
    //http://stackoverflow.com/questions/17942179/passing-arraylistcustomobject-between-activities
    private Button sButton,pButton;  
    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser";  
    public  final static String PAR_KEY = "com.easyinfogeek.objectPass.par";  
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_passingobject);
        setupViews();
    }  
       
    public void setupViews()
    {
        sButton = (Button)findViewById(R.id.button1);  
        pButton = (Button)findViewById(R.id.button2);  
        sButton.setOnClickListener(this);  
        pButton.setOnClickListener(this);  
    }  
 
    public void SerializeMethod()
    {
        Person mPerson = new Person();
        mPerson.setName("Leon");  
        mPerson.setAge(25);  
        Intent mIntent = new Intent(this,Sp1.class);
        Bundle mBundle = new Bundle();  
        mBundle.putSerializable(SER_KEY,mPerson);  
        mIntent.putExtras(mBundle);
        startActivity(mIntent);  
    }  
 
    public void PacelableMethod()
    {
        Book mBook = new Book();
        mBook.setBookName("Android Developer Guide");  
        mBook.setAuthor("Leon");  
        mBook.setPublishTime(2014);  
        Intent mIntent = new Intent(this,Sp2.class);
        Bundle mBundle = new Bundle();  
        mBundle.putParcelable(PAR_KEY, mBook);  
        mIntent.putExtras(mBundle);
        startActivity(mIntent);  
    }
 
    public void onClick(View v)
    {
        if(v == sButton)
        {
            SerializeMethod();  
        }
        else
        {
            PacelableMethod();  
        }  
    }

    //Passing data from one activity to other in android
    /*Intent intent = new Intent(context, YourActivityClass.class);
    intent.putExtra(KEY, <your value here>);
    startActivity(intent);*/

   // Retrieving bundle data from android activity
   /* Intent intent = getIntent();
    if (null != intent) {
    String stringData= intent.getStringExtra(KEY);
    int numberData = intent.getIntExtra(KEY, defaultValue);
    boolean booleanData = intent.getBooleanExtra(KEY, defaultValue);
    char charData = intent.getCharExtra(KEY, defaultValue);*/

    //sending Message to whats App

    /*Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "Sending Data from My Application");
    sendIntent.setType("text/plain");
    // Do not forget to add this to open whatsApp App specifically
    sendIntent.setPackage("com.whatsapp");
    startActivity(sendIntent);*/
}


