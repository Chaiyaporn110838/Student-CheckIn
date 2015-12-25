package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 25/12/2558.
 */
public class DiplomaTABLE {
    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite,readSQLite;
    public static final String DIPLOMA_TABLE = "diplomaTABLE";
    public static final String COLUMN_ID_DIPLOMA = "_id";
    public static final String COLUMN_STUDENTID = "StudentId";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PRESENT = "Present";
    public static final String COLUMN_LATE = "Late";
    public static final String COLUMN_LEAVE = "Leave";
    public static final String COLUMN_UPSENT = "Upsent";
    public static final String COLUMN_CHECKPOINT = "CheckPoint";
    public static final String COLUMN_CAPTION = "Caption";




    public DiplomaTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();
    }//contructor

    //Add value to Diploma
    public long addValueToDiploma(String strStudentId, String strName, String strPresent, String strLate, String strLeave, String strUpsent,
                                  String strCheckPoint, String strCaption) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_STUDENTID, strStudentId);
        objContentValues.put(COLUMN_NAME, strName);
        objContentValues.put(COLUMN_PRESENT, strPresent);
        objContentValues.put(COLUMN_LATE, strLate);
        objContentValues.put(COLUMN_LEAVE, strLeave);
        objContentValues.put(COLUMN_UPSENT, strUpsent);
        objContentValues.put(COLUMN_CHECKPOINT, strCheckPoint);
        objContentValues.put(COLUMN_CAPTION, strCaption);
        return writeSQLite.insert(DIPLOMA_TABLE, null, objContentValues);


    }//AddValueToDiploma
}//Main class
