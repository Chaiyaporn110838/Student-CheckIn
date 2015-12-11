package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 11/12/2558.
 */
public class UserTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;
    public static final String TABLE_USER = "userTABLE";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_TEACHER = "Teacher";


    public UserTABLE(Context context) {


        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();
    }//constuctor

    public long addValueToUser(String strUser, String strPassword, String strTeacher) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER, strUser);
        objContentValues.put(COLUMN_PASSWORD, strPassword);
        objContentValues.put(COLUMN_TEACHER, strTeacher);
        return writeSQLite.insert(TABLE_USER, null, objContentValues);
    }// addValueToUser


}// User table
