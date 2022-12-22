package com.example.zaliczeniowy.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.zaliczeniowy.R;
import com.example.zaliczeniowy.User;

import org.w3c.dom.Text;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 35;
    public static final String DATABASE_NAME = "Items.db";
    String TAG = "KAWDA";



    public DbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.v(TAG,"Create działa");
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_MOUSE);
        sqLiteDatabase.execSQL(CREATE_KEYBOARD);
        sqLiteDatabase.execSQL(CREATE_CAMERA);
        sqLiteDatabase.execSQL(CREATE_SET);
        sqLiteDatabase.execSQL(CREATE_ORDER);


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(TAG,"Działa");



        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        sqLiteDatabase.execSQL(DELETE_MOUSE);
        sqLiteDatabase.execSQL(DELETE_KEYBOARD);
        sqLiteDatabase.execSQL(DELETE_CAMERA);
        sqLiteDatabase.execSQL(DELETE_SET);
        sqLiteDatabase.execSQL(DROP_ORDER);
        onCreate(sqLiteDatabase);
    }


    public class Mouse implements BaseColumns {
        public static final String MYSZ_TABLE = "Myszka";
        public static final String COLUMN_NAME_Rival_ID = "Myszka_Id";
        public static final String COLUMN_NAME_Rival = "Myszka ";
        public static final String COLUMN_NAME_Rival_PHOTO = "Zdjęcie_Myszki ";
        public static final String COLUMN_NAME_Rival_PRICE = "Cena_Myszki ";
    }

    public class Set implements BaseColumns {
        public static final String ZEST_TABLE = "Zestaw";
        public static final String COLUMN_NAME_Zestaw_ID = "Zestaw_Id";
        public static final String COLUMN_NAME_Zestaw = "Zestaw ";
        public static final String COLUMN_NAME_Zestaw_PHOTO = "Zdjęcie_Zestawu ";
        public static final String COLUMN_NAME_Zestaw_PRICE = "Cena_Zestawu ";
    }
    public class Keyboard implements BaseColumns {
        public static final String KLAW_TABLE = "Klawiatury";
        public static final String COLUMN_NAME_Klawiatura_ID = "Klawiatura_Id";
        public static final String COLUMN_NAME_Klawiatura = "Klawiatura ";
        public static final String COLUMN_NAME_Klawiatura_PHOTO = "Zdjęcie_Klawiatury ";
        public static final String COLUMN_NAME_Klawiatura_PRICE = "Cena_Klawiatury ";

    }
    public class Camera implements BaseColumns {
        public static final String KAM_TABLE = "Kamery";
        public static final String COLUMN_NAME_Kamera_ID = "Kamera_Id";
        public static final String COLUMN_NAME_Kamera = "Kamery ";
        public static final String COLUMN_NAME_Kamera_PHOTO = "Zdjęcie_Kamer ";
        public static final String COLUMN_NAME_Kamera_PRICE = "Cena_Kamer ";
    }

    public static class user implements BaseColumns {
        public static final String TABLE_USER = "user";
        public static final String COLUMN_USER_ID = "user_id"; //integer
        public static final String COLUMN_USER_NAME = "user_name"; //text unique
        public static final String COLUMN_USER_EMAIL = "user_email"; //text
        public static final String COLUMN_USER_PASSWORD = "user_password"; //text
    }
    public static class order implements BaseColumns {
        public static final String TABLE_ORDER = "order_list";
        public static final String COLUMN_ORDER_ID = "order_Id";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_NAME_Kamera_ID = "Kamera_Id";
        public static final String COLUMN_NAME_Klawiatura_ID = "Klawiatura_Id";
        public static final String COLUMN_NAME_Zestaw_ID = "Zestaw_Id";
        public static final String COLUMN_NAME_Rival_ID = "Myszka_Id";
    }

    public static final String CREATE_ORDER =
            "CREATE TABLE "
                + order.TABLE_ORDER + "("
                + order.COLUMN_ORDER_ID + " INTEGER PRIMARY KEY NOT NULL ,"
                + order.COLUMN_PRICE + " INT NOT NULL ,"
                + order.COLUMN_NAME_Kamera_ID + " INT NOT NULL ,"
                + order.COLUMN_NAME_Klawiatura_ID + " INT NOT NULL ,"
                + order.COLUMN_NAME_Zestaw_ID + " INT NOT NULL ,"
                + order.COLUMN_NAME_Rival_ID + " INT NOT NULL "
                + " ) ";

    public static final String DROP_ORDER =
            "DROP TABLE IF EXISTS "
                    + order.TABLE_ORDER;

    public static final String CREATE_SET =
            "CREATE TABLE "
                    + Set.ZEST_TABLE + " ("
                    + Set.COLUMN_NAME_Zestaw_ID + " INTEGER PRIMARY KEY NOT NULL,"
                    + Set.COLUMN_NAME_Zestaw + " TEXT NOT NULL,"
                    + Set.COLUMN_NAME_Zestaw_PHOTO + "INT NOT NULL, "
                    + Set.COLUMN_NAME_Zestaw_PRICE + "INT NOT NULL "
                    + " )";
        public static final String CREATE_MOUSE =
                "CREATE TABLE "
                        + Mouse.MYSZ_TABLE + " ("
                        + Mouse.COLUMN_NAME_Rival_ID + " INTEGER PRIMARY KEY NOT NULL ,"
                        + Mouse.COLUMN_NAME_Rival + " TEXT NOT NULL,"
                        + Mouse.COLUMN_NAME_Rival_PHOTO + "INT NOT NULL, "
                        + Mouse.COLUMN_NAME_Rival_PRICE + "INT NOT NULL"
                        + ")";

    public static final String DELETE_MOUSE =
            "DROP TABLE IF EXISTS "
                    + Mouse.MYSZ_TABLE;

    public static final String CREATE_KEYBOARD =
            "CREATE TABLE "
                    + Keyboard.KLAW_TABLE + " ("
                    + Keyboard.COLUMN_NAME_Klawiatura_ID + " INTEGER PRIMARY KEY NOT NULL ,"
                    + Keyboard.COLUMN_NAME_Klawiatura + " TEXT NOT NULL,"
                    + Keyboard.COLUMN_NAME_Klawiatura_PHOTO + "INT NOT NULL, "
                    + Keyboard.COLUMN_NAME_Klawiatura_PRICE + "INT NOT NULL"
                    + " )";

    public static final String DELETE_KEYBOARD =
            "DROP TABLE IF EXISTS "
                    + Keyboard.KLAW_TABLE;

    public static final String CREATE_CAMERA =
            "CREATE TABLE "
                    + Camera.KAM_TABLE + " ("
                    + Camera.COLUMN_NAME_Kamera_ID + " INTEGER PRIMARY KEY NOT NULL ,"
                    + Camera.COLUMN_NAME_Kamera + " TEXT NOT NULL,"
                    + Camera.COLUMN_NAME_Kamera_PHOTO + "INT NOT NULL, "
                    + Camera.COLUMN_NAME_Kamera_PRICE+ "INT NOT NULL"
                    + " )";

    public static final String DELETE_CAMERA =
            "DROP TABLE IF EXISTS "
                    + Camera.KAM_TABLE;



    public static final String DELETE_SET =
            "DROP TABLE IF EXISTS "
                    + Set.ZEST_TABLE;

    public static final String CREATE_USER_TABLE =
            "CREATE TABLE "
                    + user.TABLE_USER + "("
                    + user.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + user.COLUMN_USER_NAME + " TEXT NOT NULL,"
                    + user.COLUMN_USER_EMAIL + " TEXT UNIQUE NOT NULL,"
                    + user.COLUMN_USER_PASSWORD + " TEXT NOT NULL" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + user.TABLE_USER;


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            super.onDowngrade(db, oldVersion, newVersion);
    }





    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbHelper.user.COLUMN_USER_NAME, user.getName());
        values.put(DbHelper.user.COLUMN_USER_EMAIL, user.getEmail());
        values.put(DbHelper.user.COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(DbHelper.user.TABLE_USER, null, values);
        //db.close();
    }
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                user.COLUMN_USER_ID,
                user.COLUMN_USER_EMAIL,
                user.COLUMN_USER_NAME,
                user.COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                user.COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = sqLiteDatabase.query(user.TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor!=null && cursor.moveToFirst() ) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
            cursor.close();
        }

        sqLiteDatabase.close();

        // return user list
        return userList;
    }
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbHelper.user.COLUMN_USER_NAME, user.getName());
        values.put(DbHelper.user.COLUMN_USER_EMAIL, user.getEmail());
        values.put(DbHelper.user.COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(DbHelper.user.TABLE_USER, values, DbHelper.user.COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(DbHelper.user.TABLE_USER, DbHelper.user.COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                user.COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = user.COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(user.TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                user.COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = user.COLUMN_USER_EMAIL + " = ?" + " AND " + user.COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(user.TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public List readData(String columnName) {
        SQLiteDatabase db_read = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                Mouse.COLUMN_NAME_Rival,
                Mouse.COLUMN_NAME_Rival_PHOTO,
                Mouse.COLUMN_NAME_Rival_PRICE,

        };
        String sortOrder =
                Mouse.COLUMN_NAME_Rival + "DESC";

        Cursor cursor = db_read.query(
                Mouse.MYSZ_TABLE,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        List result = new ArrayList<>();
        while (cursor.moveToNext()) {
            if (columnName == BaseColumns._ID) {
                long item = cursor.getLong(
                        cursor.getColumnIndexOrThrow(Mouse._ID)
                );
                result.add(item);
            } else if (columnName == Mouse.COLUMN_NAME_Rival
                    || columnName == Mouse.COLUMN_NAME_Rival_PHOTO
                    || columnName == Mouse.COLUMN_NAME_Rival_PRICE
            ) {
                int item = cursor.getInt(cursor.getColumnIndexOrThrow(columnName));
                result.add(item);
            } else {
                String item = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
                result.add(item);
            }
        }
        cursor.close();
        Log.v(TAG,"-------------------" + result);
        return result;
    }
//    public int deleteData(String like) {
//        SQLiteDatabase db_write = getWritableDatabase();
//        String selection = ItemEntry.COLUMN_NAME_Rival + " LIKE >0";
//        String[] selectionArgs = {like};
//        return db_write.delete(MYSZ_TABLE,selection,selectionArgs);
//
//    }

}
