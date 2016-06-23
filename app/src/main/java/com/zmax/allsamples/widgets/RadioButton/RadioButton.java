package com.zmax.allsamples.widgets.RadioButton;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import com.zmax.allsamples.R;
public class RadioButton extends AppCompatActivity
{
    private RadioGroup radioGroup1;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.tab1:

                        break;
                    case R.id.tab2:
                        break;
                    case R.id.tab3:

                        break;
                    case R.id.tab4:
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
