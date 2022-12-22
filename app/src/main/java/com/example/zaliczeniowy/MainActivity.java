package com.example.zaliczeniowy;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zaliczeniowy.activities.LoginActivity;
import com.example.zaliczeniowy.database.DbHelper;
import com.google.android.material.slider.Slider;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String TAG = "KAWDA";

    MyAdapter adapter;
    MyAdapter adapter2;
    MyAdapter adapter3;
    MyAdapter adapter4;

    SmsManager smsManager;
    String destinationAdress = "";
    String text = "";
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;

    Button send_button;
    int price;

    int pomocnicza1;
    int pomocnicza2;
    int pomocnicza3;
    int pomocnicza4;

    int klaw_id = 1;
    int mysz_id = 1;
    int zest_id = 1;
    int cam_id = 1;


    private com.example.zaliczeniowy.database.DbHelper dbHelper;


    String[] describtion1 = {
            "Intel Core i5 12400 6 X 2,4 GHz 16GB DDR4 SSD 250GB M.2 + HDD 1TB SATA GTX 1050 Ti 4GB, cena 3824 zł",
            "Intel Core i7 11700 8 X 2,9 GHz 16GB DDR4 SSD 500GB M.2 + GTX 1660 6GB, cena 5832 zł",
            "Ryzen 9 3900X 12 x 3 3,8GHz 32GB DDR4 SSD 500GB M.2 GTX 2060 6GB, cena 7764 zł"
    };
    int[] pcty1 = {
            R.drawable.zestaw1,
            R.drawable.zestaw2,
            R.drawable.zestaw3,
    };
    String[] describtion2 = {
            "Mysz SteelSeries Rival 100, cena 129: zł ",
            "Mysz dla graczy SteelSeries Rival 3, cena: 139 zł",
            "Mysz SteelSeries Aerox 9 Wireless, cena 499 zł"
    };
    int[] pcty2 = {
            R.drawable.rival1,
            R.drawable.rival3,
            R.drawable.rival9,
    };
    String[] describtion3 = {
            "Klawiatura gamingowa SteelSeries Apex 3, cena 299: zł ",
            "SteelSeries Apex Gaming, cena: 319 zł",
            "Klawiatura gamingowa SteelSeries Apex 7, cena 799 zł"
    };
    int[] pcty3 = {
            R.drawable.klawiatura1,
            R.drawable.klawiatura2,
            R.drawable.klawiatura3,
    };
    String[] describtion4 = {
            "Kamera internetowa LOGITECH HD Webcam C270, cena 149: zł ",
            "Logitech Streamcam Kamera Full Hd 960-001297, cena: 435 zł",
            "Kamera internetowa AUKEY PC-LM1E, cena 116 zł"
    };
    int[] pcty4 = {
            R.drawable.kamera1,
            R.drawable.kamera2,
            R.drawable.kamera3,
    };
    Button calculate_button;
    public TextView cena;
    public Button delete_button;

    SQLiteOpenHelper sqliteOpenHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapter();

        sqliteOpenHelper = new DbHelper(this);
        db = sqliteOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + DbHelper.Mouse.MYSZ_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if(!cursor.moveToFirst()) {
            Log.v(TAG,"Dodaje");
            db.execSQL(methodsInsert.insertMouse(1, "rival100", R.drawable.rival1, 129));
            db.execSQL(methodsInsert.insertMouse(2, "rival3", R.drawable.rival3, 139));
            db.execSQL(methodsInsert.insertMouse(3, "rival9", R.drawable.rival9, 499));


            db.execSQL(methodsInsert.insertKeyboard(1, "Apex 3", R.drawable.klawiatura1, 299));
            db.execSQL(methodsInsert.insertKeyboard(2, "Apex Gaming", R.drawable.klawiatura2, 319));
            db.execSQL(methodsInsert.insertKeyboard(3, "Apex 7", R.drawable.klawiatura3, 799));

            db.execSQL(methodsInsert.insertCamera(1, "LOGITECH HD Webcam C270", R.drawable.kamera1, 149));
            db.execSQL(methodsInsert.insertCamera(2, "Logitech Streamcam", R.drawable.kamera2, 435));
            db.execSQL(methodsInsert.insertCamera(3, "AUKEY PC-LM1E", R.drawable.kamera3, 116));


            db.execSQL(methodsInsert.insertSet(1, "Intel Core i5 12400 ", R.drawable.zestaw1, 3824));
            db.execSQL(methodsInsert.insertSet(2, "Intel Core i7 11700 ", R.drawable.zestaw2, 5832));
            db.execSQL(methodsInsert.insertSet(3, "Ryzen 9 3900X ", R.drawable.zestaw3, 7764));

        }
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pomocnicza1 = 1;
                        zest_id = 1;
                        break;
                    case 1:
                        pomocnicza1 = 2;
                        zest_id = 2;
                        break;
                    case 2:
                        pomocnicza1 = 3;
                        zest_id = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pomocnicza2 = 1;
                        mysz_id = 1;
                        if (checkBox1.isChecked()) {
                            mysz_id = 1;
                        } else mysz_id = 0;
                        break;
                    case 1:
                        pomocnicza2 = 2;
                        mysz_id = 2;
                        if (checkBox1.isChecked()) {
                            mysz_id = 2;
                        } else mysz_id = 0;
                        break;
                    case 2:
                        pomocnicza2 = 3;
                        mysz_id = 3;
                        if (checkBox1.isChecked()) {
                            mysz_id = 3;
                        } else mysz_id = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pomocnicza3 = 1;
                        klaw_id = 1;
                        if (checkBox2.isChecked()) {
                            klaw_id = 1;
                        } else klaw_id = 0;
                        break;
                    case 1:
                        pomocnicza3 = 2;
                        klaw_id = 2;
                        if (checkBox2.isChecked()) {
                            klaw_id = 2;
                        } else klaw_id = 0;

                        break;
                    case 2:
                        pomocnicza3 = 3;
                        klaw_id = 3;
                        if (checkBox2.isChecked()) {
                            klaw_id = 3;
                        } else klaw_id = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pomocnicza4 = 1;
                        cam_id = 1;
                        if (checkBox3.isChecked()) {
                            cam_id = 1;
                        } else cam_id = 0;
                        break;
                    case 1:
                        pomocnicza4 = 2;
                        cam_id = 2;
                        if (checkBox3.isChecked()) {
                            cam_id = 2;
                        } else cam_id = 0;
                        break;
                    case 2:
                        pomocnicza4 = 3;
                        cam_id = 3;
                        if (checkBox3.isChecked()) {
                            cam_id = 3;
                        } else cam_id = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void obliczanie() {
        price = 0;
        if (pomocnicza1 == 1) {
            price = (int) (price + 3824);
        } else if (pomocnicza1 == 2) {
            price = (int) (price + 5832);
        } else if (pomocnicza1 == 3) {
            price = (int) (price + 7764);
        }
        if (checkBox1.isChecked()) {
            if (pomocnicza2 == 1) {
                price = price + 129;
            } else if (pomocnicza2 == 2) {
                price = price + 139;
            } else if (pomocnicza2 == 3) {
                price = price + 499;
            }
        }
        if (checkBox2.isChecked()) {
            if (pomocnicza3 == 1) {
                price = price + 299;
            } else if (pomocnicza3 == 2) {
                price = price + 319;
            } else if (pomocnicza3 == 3) {
                price = price + 799;
            }
        }
        if (checkBox3.isChecked()) {
            if (pomocnicza4 == 1) {
                price = price + 149;
            } else if (pomocnicza4 == 2) {
                price = price + 435;
            } else if (pomocnicza4 == 3) {
                price = price + 116;
            }
        }
        Log.v(TAG, price + " CENA");
        Toast.makeText(MainActivity.this, "Cena to " + price + " zł", Toast.LENGTH_SHORT).show();
        cena.setText(Float.toString(price) + " zł");

    }

    private void setAdapter() {
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner_myszki);
        spinner3 = (Spinner) findViewById(R.id.spinner_klawiatury);
        spinner4 = (Spinner) findViewById(R.id.spinner_kamerki);

        adapter = new MyAdapter(this, pcty1, describtion1);
        adapter2 = new MyAdapter(this, pcty2, describtion2);
        adapter3 = new MyAdapter(this, pcty3, describtion3);
        adapter4 = new MyAdapter(this, pcty4, describtion4);

        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);

        cena = findViewById(R.id.cena);
        send_button = findViewById(R.id.button_send);
        calculate_button = findViewById(R.id.button_oblicz);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);


        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO " + DbHelper.order.TABLE_ORDER + " ("
                        + DbHelper.order.COLUMN_PRICE + ", " +
                        DbHelper.order.COLUMN_NAME_Kamera_ID + ", " +
                        DbHelper.order.COLUMN_NAME_Klawiatura_ID + ", " +
                        DbHelper.order.COLUMN_NAME_Zestaw_ID + ", " +
                        DbHelper.order.COLUMN_NAME_Rival_ID + ") " +
                        "VALUES (" + price + ", " + cam_id + ", " + klaw_id + ", " + zest_id + ", " + mysz_id + ")");
                sendWithSmsManager();
                Log.v(TAG, "Wysyła");

            }
        });
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obliczanie();
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setLocale(String language) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, metrics);
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.poland:
                Configuration config = getBaseContext().getResources().getConfiguration();
                Locale locale = new Locale("pl");
                Locale.setDefault(locale);
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                break;
            case R.id.england:
                config = getBaseContext().getResources().getConfiguration();
                locale = new Locale("en");
                Locale.setDefault(locale);
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                break;
            case R.id.Main_page:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.Zaloguj:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                showAlertDialog(findViewById(R.id.about));
                break;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    private void sendWithSmsManager() {
        Log.v(TAG, "tekst");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            destinationAdress = "570610514";
            text = "Wartość zamowienia:" + String.valueOf(price) + "zł";
            //text = smsMessage.getText().toString();
            Log.i(TAG, "cos");
            if (!destinationAdress.equals("") && !text.equals("")) {
                smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage(
                        destinationAdress,
                        null,
                        text,
                        null,
                        null
                );
                Toast.makeText(this, "SMS send", Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Sms send");
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Permission denied");
            }

        } else {
            requestPermissionLauncher.launch(
                    Manifest.permission.SEND_SMS);
        }
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(this, "SMS permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS permission not granted", Toast.LENGTH_SHORT).show();
                }
            });


//    public void sendEmail(){
//        String email = "szymon.banaszek128@onet.pl";
//
//        Intent mailIntent = new Intent(Intent.ACTION_SEND);
//
//        mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
////        mailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
////        mailIntent.putExtra(Intent.EXTRA_TEXT,body);
//        mailIntent.setType("message/rfc822");
//        startActivity(Intent.createChooser(mailIntent, "Choose an Email client :"));
//    }

    public void showAlertDialog(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.dialog_name);
        alert.setTitle(R.string.dialog_message);
        Dialog d = alert.setView(new View(this)).create();

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.20);
        d.show();
        d.getWindow().setLayout(width, height);
    }

    private static class methodsInsert {
        private static String insertMouse(int Id_mouse, String mouse, int image, int price) {
            return "INSERT INTO " + DbHelper.Mouse.MYSZ_TABLE + " (" +
                    DbHelper.Mouse.COLUMN_NAME_Rival_ID + ", " + DbHelper.Mouse.COLUMN_NAME_Rival + ", " + DbHelper.Mouse.COLUMN_NAME_Rival_PHOTO + ", " + DbHelper.Mouse.COLUMN_NAME_Rival_PRICE + ") " +
                    "VALUES (" + Id_mouse + ", '" + mouse + "', " + image + ", '" + price + "');";
        }

        private static String insertKeyboard(int Id_keyboard, String keyboard, int image, int price) {
            return "INSERT INTO " + DbHelper.Keyboard.KLAW_TABLE + " (" +
                    DbHelper.Keyboard.COLUMN_NAME_Klawiatura_ID + ", " + DbHelper.Keyboard.COLUMN_NAME_Klawiatura + ", " + DbHelper.Keyboard.COLUMN_NAME_Klawiatura_PHOTO + ", " + DbHelper.Keyboard.COLUMN_NAME_Klawiatura_PRICE + ") " +
                    "VALUES (" + Id_keyboard + ", '" + keyboard + "', " + image + ", '" + price + "');";
        }

        private static String insertCamera(int Id_camera, String camera, int image, int price) {
            return "INSERT INTO " + DbHelper.Camera.KAM_TABLE + " (" +
                    DbHelper.Camera.COLUMN_NAME_Kamera_ID + ", " + DbHelper.Camera.COLUMN_NAME_Kamera + ", " + DbHelper.Camera.COLUMN_NAME_Kamera_PHOTO + ", " + DbHelper.Camera.COLUMN_NAME_Kamera_PRICE + ") " +
                    "VALUES (" + Id_camera + ", '" + camera + "', " + image + ", '" + price + "');";
        }

        private static String insertSet(int Id_set, String set, int image, int price) {
            return "INSERT INTO " + DbHelper.Set.ZEST_TABLE + " (" +
                    DbHelper.Set.COLUMN_NAME_Zestaw_ID + ", " + DbHelper.Set.COLUMN_NAME_Zestaw + ", " + DbHelper.Set.COLUMN_NAME_Zestaw_PHOTO + ", " + DbHelper.Set.COLUMN_NAME_Zestaw_PRICE + ") " +
                    "VALUES (" + Id_set + ", '" + set + "', " + image + ", '" + price + "');";
        }

        private static String insertUser(int Id_user, String user, String email, String password) {
            return "INSERT INTO " + DbHelper.user.TABLE_USER + " (" +
                    DbHelper.user.COLUMN_USER_ID + ", " + DbHelper.user.COLUMN_USER_NAME + ", " + DbHelper.user.COLUMN_USER_EMAIL + ", " + DbHelper.user.COLUMN_USER_PASSWORD + ") " +
                    "VALUES (" + Id_user + ", '" + user + "', " + email + ", '" + password + "');";
        }
    }
}
