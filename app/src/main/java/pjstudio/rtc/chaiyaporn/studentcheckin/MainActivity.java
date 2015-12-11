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
        //Tester
        testAddValue();

    }//onCreate

    private void testAddValue() {
        objUserTABLE.addValueToUser("User", "Password", "Teacher");
        objListTABLE.addValueOrder("Teacher", "Date", "Name", 4);

    }//test
}//main class
