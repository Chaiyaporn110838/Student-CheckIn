package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
    private EditText editUser , editPassword;
    private String strUserChoose,strPasswordChoose,strPasswordTrue,strName;
    private DiplomaTABLE objDiplomaTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind Widget
        bindWidget();


        objUserTABLE = new UserTABLE(this);
        objListTABLE = new ListTABLE(this);
        objDiplomaTABLE = new DiplomaTABLE(this);
        //Tester
        //testAddValue();
        //delete All Data
        deleteAllData();

        //synJsonToSQLite
        SynJSonToSQLite();

    }//onCreate

    private void deleteAllData() {
        SQLiteDatabase ojbSQLite = openOrCreateDatabase("Student.db", MODE_PRIVATE, null);
        ojbSQLite.delete("userTABLE", null, null);


    }//deleteAllData

    public void clickLogin(View view) {
        strUserChoose = editUser.getText().toString().trim();
        strPasswordChoose = editPassword.getText().toString().trim();
        if (strUserChoose.equals("") || strUserChoose.equals("")) {
            //Alert Error
            MyAlert objMyAlert = new MyAlert();
            objMyAlert.errorDialog(MainActivity.this, "Warning","Please fill in blank data ");

        } else {

            checkUser();
        }
    }//clickLogin

    private void checkUser() {
        try {
            String strData[] = objUserTABLE.searchUser(strUserChoose);
            strPasswordTrue = strData[2];
            strName = strData[3];



            Log.d("Student CheckIn", "Wellcome" + strName );

            checkPassword();

        } catch (Exception e) {
            MyAlert objMyAlert = new MyAlert();
            objMyAlert.errorDialog(MainActivity.this,"No This User", "No "+ strUserChoose + "  in my DataBase");
        }


    }//checkUser

    private void checkPassword() {
        if (strPasswordChoose.equals(strPasswordTrue)) {
            //Intent to list Activity
            wellcomeUser();
        } else {
            MyAlert objMyAlert = new MyAlert();
            objMyAlert.errorDialog(MainActivity.this,"Password False","Please Try agains Password False");

        }

    }//checkPassword

    private void wellcomeUser() {
        final AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setIcon(R.drawable.user);
        objAlert.setTitle("Wellcome to My Student CheckIn");
        objAlert.setMessage("Wellcome " + strName + "\n" + "To Student CheckIn ");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent objIntent = new Intent(MainActivity.this, ListActivity.class);
                objIntent.putExtra("Name", strName);
                startActivity(objIntent);
                finish();
            }
        });
        objAlert.show();

    }//wellcomeUser

    private void bindWidget() {
        editUser = (EditText) findViewById(R.id.editText);
        editPassword = (EditText) findViewById(R.id.editText2);

    }//bind Widget

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
                JSONObject objJSonObject = objJsonArray.getJSONObject(i);
                String strUser = objJSonObject.getString("User");
                String strPassword = objJSonObject.getString("Password");
                String strTeacher = objJSonObject.getString("Teacher");

                long insertVale = objUserTABLE.addValueToUser(strUser, strPassword, strTeacher);
            }//for


        } catch (Exception e) {
            Log.d("Student CheckIn", "Error Up Value ==>" + e.toString());
        }

    }//synJSonToSQLite

    private void testAddValue() {
        objUserTABLE.addValueToUser("somboonT", "12345", "อ.สมบูรณ์ แซ่เจ็ง Online");
        objListTABLE.addValueOrder("Teacher", "Date", "Name", 4);
        objDiplomaTABLE.addValueToDiploma("StudentId", "Name","Present","Late","Leave","Upsent","CheckPoint","Caption");

    }//test
}//main class
