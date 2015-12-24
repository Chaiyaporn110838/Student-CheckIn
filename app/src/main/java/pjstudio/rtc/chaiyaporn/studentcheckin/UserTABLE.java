package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public String[] searchUser(String strUser) {

        try {
            String strData[] = null;
            Cursor objCursor = readSQLite.query(TABLE_USER, new String[] {COLUMN_ID_USER,COLUMN_USER,
                    COLUMN_PASSWORD,COLUMN_TEACHER},COLUMN_USER + "=?",
                    new String[] {String.valueOf(strUser)},null,null,null,null);

            if (objCursor != null) {
                if (objCursor.moveToFirst()) {

                    strData = new String[objCursor.getColumnCount()];
                    strData[0] = objCursor.getString(0);
                    strData[1] = objCursor.getString(1);
                    strData[2] = objCursor.getString(2);
                    strData[3] = objCursor.getString(3);
                }//if2
            }//if1
            objCursor.close();
            return strData;
        } catch (Exception e) {
            return null;
        }
       // return new String[0];


    } //searchUser





    public long addValueToUser(String strUser, String strPassword, String strTeacher) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER, strUser);
        objContentValues.put(COLUMN_PASSWORD, strPassword);
        objContentValues.put(COLUMN_TEACHER, strTeacher);
        return writeSQLite.insert(TABLE_USER, null, objContentValues);
    }// addValueToUser

}// User table
