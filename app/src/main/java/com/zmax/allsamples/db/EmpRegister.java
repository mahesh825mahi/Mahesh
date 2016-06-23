package com.zmax.allsamples.db;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.zmax.allsamples.R;

/**
 * Created by bfonics on 12/27/2015.
 */
public class EmpRegister extends Activity {
    DatabaseHandler db;

    Context ctx;
    EditText username,password,emailid;
    Button register,next;
    com.zmax.allsamples.font.RobotoLightItalicTextView  status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ctx = EmpRegister.this;
         db = new DatabaseHandler(ctx);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        emailid = (EditText) findViewById(R.id.emailid);
        register = (Button) findViewById(R.id.register);
        next = (Button) findViewById(R.id.next);
        status = (com.zmax.allsamples.font.RobotoLightItalicTextView) findViewById(R.id.status);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(EmpRegister.this,EmpList.class);
                startActivity(in);
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String _username = username.getText().toString();
                String _password = password.getText().toString();
                String _emailid = emailid.getText().toString();

                if(_username.length()>0 && _password.length()>0 && _emailid.length()>0)
                {
                    String _status = db.insertEmp(_username,_password,_emailid);

                    System.out.println("Register----->"+_status);

                     if(_status.equals("exist"))
                        {
                            status.setText("User Already Registered...!!!!");
                        }

                     else if(!_status.equals("-1"))
                    {
                        status.setText("Success...!!");
                        username.setText("");
                        password.setText("");
                        emailid.setText("");
                    }

                    else
                    {
                        status.setText("Faild...!!");
                    }
                }

                else
                {

                }
            }
        });

    }
}
