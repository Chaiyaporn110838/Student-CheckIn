package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by User on 24/12/2558.
 */
public class MyAlert {
    AlertDialog.Builder objAlert;
    public void errorDialog(Context context, String strTitle, String strMessage) {

        objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.alert);
        objAlert.setTitle(strTitle);
        objAlert.setMessage(strMessage);
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlert.show();

    }//errorDialog



}//main class
