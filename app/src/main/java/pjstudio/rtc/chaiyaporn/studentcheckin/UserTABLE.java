package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 11/12/2558.
 */
public class UserTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;


    public UserTABLE(Context context) {


        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();
    }//constuctor
}// User table
