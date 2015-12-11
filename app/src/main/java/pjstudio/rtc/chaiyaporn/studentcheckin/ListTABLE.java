package pjstudio.rtc.chaiyaporn.studentcheckin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 11/12/2558.
 */
public class ListTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite,readSQLite;


    public ListTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();

    }//construtor
}//main class
