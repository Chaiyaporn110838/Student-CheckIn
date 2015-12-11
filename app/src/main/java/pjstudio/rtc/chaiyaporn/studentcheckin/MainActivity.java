package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private UserTABLE objUserTABLE;
    private ListTABLE objListTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objUserTABLE = new UserTABLE(this);
        objListTABLE = new ListTABLE(this);

    }//onCreate
}//main class
