package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
            HttpPost objHttpPost = new HttpPost("http://pjstudio.pe.hu/stude/php_get_data%20.php");
            HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
            HttpEntity objHttpEntity = objHttpResponse.getEntity();
            objInputStream = objHttpEntity.getContent();
        } catch (Exception e) {

            Log.d("Student CheckIn","Error from InputStream ==> " + e.toString());

        }

        //change InputStream to string
        try {

            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
            StringBuilder objStringBuilder = new StringBuilder();
            String strLine = null;
            while ((strLine = objBufferedReader.readLine() ) != null) {
                objStringBuilder.append(strLine);
            }//while


            objInputStream.close();
            strJSon = objStringBuilder.toString();
        } catch (Exception e) {
            Log.d("Student CheckIn", "Error Create String ==>" + e.toString());
        }
        //Up Value to SQLite
        try {
            final JSONArray objJsonArray = new JSONArray(strJSon);
            for (int i = 0; i < objJsonArray.length(); i++) {
                JSONObject objJSONObject = objJsonArray.getJSONObject(i);
                String strUser = objJSONObject.getString("User");
                String strPassword = objJSONObject.getString("Password");
                String strTeacher = objJSONObject.getString("Teacher");

                long insertVale = objUserTABLE.addValueToUser(strUser, strPassword, strTeacher);
            }//for

        } catch (Exception e) {
            Log.d("Student CheckIn", "Error Up Value ==>" + e.toString());
        }

    }//synJSonToSQLite

    private void testAddValue() {
        objUserTABLE.addValueToUser("User", "Password", "Teacher");
        objListTABLE.addValueOrder("Teacher", "Date", "Name", 4);

    }//test
}//main class
