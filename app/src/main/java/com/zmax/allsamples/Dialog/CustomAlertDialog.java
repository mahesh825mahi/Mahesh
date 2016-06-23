package com.zmax.allsamples.Dialog;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.zmax.allsamples.R;
/**
 * Created by Kasturi on 09-May-16.
 */
public class CustomAlertDialog extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    public static Dialog CustomAlertDialog;
    public static boolean AlertDialog_Validation(final Context ctx, final String content)
    {
        CustomAlertDialog = new Dialog(ctx, R.style.Dialog);
        CustomAlertDialog.setCancelable(false);
        CustomAlertDialog.setContentView(R.layout.custom_alertdialog);
        //CustomAlertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        TextView dialog_title = (TextView) CustomAlertDialog.findViewById(R.id.dialog_title);
        dialog_title.setText("Title");
        TextView Content = (TextView) CustomAlertDialog.findViewById(R.id.dialog_content);
        Button Ok = (Button) CustomAlertDialog.findViewById(R.id.dialog_no);
        Content.setText(content);
        CustomAlertDialog.show();

        Ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CustomAlertDialog.dismiss();
            }
        });
        return true;
    }
}
