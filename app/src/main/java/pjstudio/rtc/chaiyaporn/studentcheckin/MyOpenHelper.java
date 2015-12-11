package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 11/12/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String  DATABASE_NAME = "Student.db";
    private static final int DATABASE_VERSION = 1;
    private static final String USER_TABLE = "create table userTABLE(_id integer primary key, "+" User text, Password text ,Teacher text);";
    private static final String List_TABLE = "create table listTABLE(_id integer primary key," + " Name text,Item integer);";





    public MyOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }//Contrutor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE);
        db.execSQL(List_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}// main class
