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
    private static final String USER_TABLE = "create table userTABLE(_id integer primary key, " + " User text, Password text ,Teacher text);";
    private static final String List_TABLE = "create table listTABLE(_id integer primary key ," + " Teacher text, Date text,StudentId text,Name text, ep1 int,ep2 int, ep3 int," +
            " ep4 int, ep5 int, ep6 int, ep7 int, ep8 int, ep9 int ,ep10 int ,ep11 int," +
            " ep12 int,ep13 int,ep14 int,ep15 int, ep16 int, ep17 int ,ep18 int ,Item integer);";
    private static final String DIPLOMA_TABLE = " create table diplomaTABLE(_id integer primary key," + " StudentId text,Name text,Present text,Late text,Leave text,Upsent text,CheckPoint text,Caption text);";







    public MyOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }//Contrutor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE);
        db.execSQL(List_TABLE);
        db.execSQL(DIPLOMA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}// main class
