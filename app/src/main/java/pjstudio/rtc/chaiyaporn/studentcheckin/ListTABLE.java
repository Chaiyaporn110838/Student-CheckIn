package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 11/12/2558.
 */
public class ListTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite,readSQLite;
    public static final String TABLE_LIST = "listTABLE";
    public static final String COLUMN_ID_LIST = "_id";
    public static final String COLUMN_TEACHER = "Teacher";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_ITEM = "Item";




    public ListTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();

    }//construtor

    public long addValueOrder(String strTeacher, String strDate, String strName, int intItem) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_TEACHER, strTeacher);
        objContentValues.put(COLUMN_DATE, strDate);
        objContentValues.put(COLUMN_NAME, strName);
        objContentValues.put(COLUMN_ITEM, intItem);

        return writeSQLite.insert(TABLE_LIST, null, objContentValues);
    }

}//main class
