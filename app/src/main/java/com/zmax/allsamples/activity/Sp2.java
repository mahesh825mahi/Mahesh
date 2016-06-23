package com.zmax.allsamples.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.zmax.allsamples.model.Book;

public class Sp2 extends Activity {  
    
    public void onCreate(Bundle savedInstanceState) {  
 super.onCreate(savedInstanceState);  
 TextView mTextView = new TextView(this);  
 Book mBook = (Book)getIntent().getParcelableExtra(Sp.PAR_KEY);
 mTextView.setText("Book name is: " + mBook.getBookName()+"/n"+  
     "Author is: " + mBook.getAuthor() + "/n" +  
     "PublishTime is: " + mBook.getPublishTime());  
 setContentView(mTextView);  
    }  
}  