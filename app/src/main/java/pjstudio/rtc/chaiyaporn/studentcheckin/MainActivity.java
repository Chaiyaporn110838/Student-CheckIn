package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

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
        //synJsonToSQLite
        SynJSonToSQLite();

    }//onCreate

    private void SynJSonToSQLite() {

        //setup Policy
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(myPolicy);
        }//if
        InputStream objInputStream = null;
        String strJSon = "";

        //create objInputStream
        try {

            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost();

        } catch (Exception e) {

            Log.d("Student CheckIn","Error from InputStream ==> " + e.toString());

        }



    }//synJSonToSQLite

    private void testAddValue() {
        objUserTABLE.addValueToUser("User", "Password", "Teacher");
        objListTABLE.addValueOrder("Teacher", "Date", "Name", 4);

    }//test
}//main class
