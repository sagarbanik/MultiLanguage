package com.sagar.multilanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Button bd,en;
    Resources resources;
    String title, des;
    TextView tvTiltle, tvDesc;
    private RadioGroup radioGroup;

    //Declaring Shared Preference
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String MYPREFS = "my_prefs";
    private final int MODE = MODE_PRIVATE;
    private boolean isChecked ;
    private RadioButton banglaRB,englishRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init Resource
        //resources = getResources();
        tvTiltle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        radioGroup = findViewById(R.id.radioGroup);
        banglaRB = findViewById(R.id.bangla);
        englishRB = findViewById(R.id.english);


        sharedPreferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        editor  = sharedPreferences.edit();

        isChecked = sharedPreferences.getBoolean(MYPREFS,false);

        if (isChecked){
            //radioGroup.check(R.id.bangla);
            banglaRB.setChecked(true);
            englishRB.setChecked(false);
            banglaLan();
        }else {
            //radioGroup.check(R.id.english);
            banglaRB.setChecked(false);
            englishRB.setChecked(true);
            englishLan();
        }



        radioGroup.check(R.id.bangla);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.bangla){
                    banglaLan();
                    editor.putBoolean(MYPREFS,true).apply();
                }

                if (checkedId == R.id.english){
                    englishLan();
                    editor.putBoolean(MYPREFS,false).apply();
                }

            }
        });



        //Getting Strings from the array
        title = getResources().getString(R.string.title);
        des = getResources().getString(R.string.description);

















       /* bd = findViewById(R.id.b1);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("bn");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;

                getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

                //Setting Strings from upgradation
                title = getResources().getString(R.string.title);
                des = getResources().getString(R.string.description);

                tvTiltle.setText(title);
                tvDesc.setText(des);
            }
        });

        en = findViewById(R.id.b2);
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("en");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;

                getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

                //Setting Strings from upgradation
                title = getResources().getString(R.string.title);
                des = getResources().getString(R.string.description);

                tvTiltle.setText(title);
                tvDesc.setText(des);

            }
        });*/
    }

    public void banglaLan(){
        Locale locale = new Locale("bn");
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        //Setting Strings from upgradation
        title = getResources().getString(R.string.title);
        des = getResources().getString(R.string.description);
        tvTiltle.setText(title);
        tvDesc.setText(des);
    }

    public void englishLan(){
        Locale locale1 = new Locale("en");
        Locale.setDefault(locale1);

        Configuration configuration1 = new Configuration();
        configuration1.locale = locale1;

        getResources().updateConfiguration(configuration1, getResources().getDisplayMetrics());

        //Setting Strings from upgradation
        title = getResources().getString(R.string.title);
        des = getResources().getString(R.string.description);

        tvTiltle.setText(title);
        tvDesc.setText(des);
    }
}
