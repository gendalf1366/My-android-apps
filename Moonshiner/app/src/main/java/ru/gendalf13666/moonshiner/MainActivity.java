package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_LANG = "auto";
    public static final String APP_PREFERENCES_THEME = "light";
    SharedPreferences mSettings;

    private void openBookFermentsBrew() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "ferments");
        this.startActivity(intent);
    }

    private void openBookFruittable() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "fruittable");
        this.startActivity(intent);
    }

    private void openBookHopTable() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "hoptable");
        this.startActivity(intent);
    }

    private void openSugarBraga() {
        this.startActivity(new Intent(this, sem_SugarBraga.class));
    }

    private void openbeeralco() {
        this.startActivity(new Intent(this, beer_alco.class));
    }

    private void openbeeribu() {
        this.startActivity(new Intent(this, beer_ibu.class));
    }

    private void openbeersuslo() {
        this.startActivity(new Intent((Context)this, beer_suslo.class));
    }

    private void openbeertempcorrect() {
        this.startActivity(new Intent(this, beer_tempcorrect.class));
    }

    private void openbookFertman() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "fertman");
        this.startActivity(intent);
    }

    private void openbookFruitwater() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "fruitwater");
        this.startActivity(intent);
    }

    private void openbookYeastTable() {
        Intent intent = new Intent(this, book_main.class);
        intent.putExtra("book", "yeasttable");
        this.startActivity(intent);
    }

    private void openmassmixing() {
        this.startActivity(new Intent((Context)this, sem_massmixing.class));
    }



    private void opensemBoiling() {
        this.startActivity(new Intent(this, sem_boiling.class));
    }

    private void opensemSpeedobor() {
        this.startActivity(new Intent(this, sem_Speedotbor.class));
    }

    private void opentemperaturemix() {
        this.startActivity(new Intent(this, sem_temperature.class));
    }

    private void openvinesugar() {
        this.startActivity(new Intent(this, vine_sugar.class));
    }

    private void setLocale(String string2) {
        Locale locale = new Locale(string2);
        Resources resources = this.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        this.getSupportActionBar().setDisplayUseLogoEnabled(true);
        this.setContentView(R.layout.activity_main);
        Button semDrobniy = this.findViewById(R.id.semDrobniy);
        semDrobniy.setOnClickListener(this::onClick);
        Button semBoiling = this.findViewById(R.id.semBoiling);
        semBoiling.setOnClickListener(view -> MainActivity.this.opensemBoiling());

        Button semTempCorrect = this.findViewById(R.id.semTempCorrect);
        semTempCorrect.setOnClickListener(view -> MainActivity.this.opensemtempcorrect());

        Button semRazbavka = this.findViewById(R.id.semRazbavka);
        semRazbavka.setOnClickListener(view -> MainActivity.this.opensemRazbavka());

        Button semNapitok = this.findViewById(R.id.semNapitok);
        semNapitok.setOnClickListener(view -> MainActivity.this.opensemnapitok());

        Button semSmeshivanie = this.findViewById(R.id.semSmeshivanie);
        semSmeshivanie.setOnClickListener(view -> MainActivity.this.opensemSmeshivanie());

        Button beerBrix = this.findViewById(R.id.beerBrix);
        beerBrix.setOnClickListener(view -> MainActivity.this.openbeerbrix());

        Button beerAlco = this.findViewById(R.id.beerAlco);
        beerAlco.setOnClickListener(view -> MainActivity.this.openbeeralco());

        Button beerTempCorrect = this.findViewById(R.id.beerTempCorrect);
        beerTempCorrect.setOnClickListener(view -> MainActivity.this.openbeertempcorrect());

        Button beerIbu = this.findViewById(R.id.beerIbu);
        beerIbu.setOnClickListener(view -> MainActivity.this.openbeeribu());

        Button vinesugar = this.findViewById(R.id.vinesugar);
        vinesugar.setOnClickListener(view -> MainActivity.this.openvinesugar());

        Button beerSuslo = this.findViewById(R.id.beersuslo);
        beerSuslo.setOnClickListener(view -> MainActivity.this.openbeersuslo());

        Button semSpeedOtbor = this.findViewById(R.id.speedotbor);
        semSpeedOtbor.setOnClickListener(view -> MainActivity.this.opensemSpeedobor());

        Button bookFruitTable = this.findViewById(R.id.bookFruitTable);
        bookFruitTable.setOnClickListener(view -> MainActivity.this.openBookFruittable());

        Button bookYeastTable = this.findViewById(R.id.bookYeastTable);
        bookYeastTable.setOnClickListener(view -> MainActivity.this.openbookYeastTable());

        Button bookHopTable = this.findViewById(R.id.bookHopTable);
        bookHopTable.setOnClickListener(view -> MainActivity.this.openBookHopTable());

        Button bookFermentsBrew = this.findViewById(R.id.bookFermentsBrew);
        bookFermentsBrew.setOnClickListener(view -> MainActivity.this.openBookFermentsBrew());

        Button bookFertman = this.findViewById(R.id.bookFertman);
        bookFertman.setOnClickListener(view -> MainActivity.this.openbookFertman());

        Button bookWater = this.findViewById(R.id.bookFruitwater);
        bookWater.setOnClickListener(view -> MainActivity.this.openbookFruitwater());

        Button semTempMix = this.findViewById(R.id.semTempMix);
        semTempMix.setOnClickListener(view -> MainActivity.this.opentemperaturemix());

        Button semSugarBraga = this.findViewById(R.id.semSugarBraga);
        semSugarBraga.setOnClickListener(view -> MainActivity.this.openSugarBraga());

        Button semMassmixing = this.findViewById(R.id.massmixing);
        semMassmixing.setOnClickListener(view -> MainActivity.this.openmassmixing());

    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.menu_main_scrol, menu2);
        MenuCompat.setGroupDividerEnabled(menu2, true);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n = menuItem.getItemId();
        SharedPreferences.Editor editor = this.mSettings.edit();
        if (n != R.id.action_auto) {
            if (n != R.id.action_dark) {
                switch (n) {
                    default: {
                        return super.onOptionsItemSelected(menuItem);
                    }
                    case R.id.action_light: {
                        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_THEME);
                        editor.apply();
                        menuItem.setChecked(true);
                        super.recreate();
                        return true;
                    }
                    case R.id.action_langRU: {
                        editor.putString(APP_PREFERENCES_LANG, "ru");
                        editor.apply();
                        MainActivity.this.setLocale("ru");
                        menuItem.setChecked(true);
                        super.recreate();
                        return true;
                    }
                    case R.id.action_langEN: {
                        editor.putString(APP_PREFERENCES_LANG, "en");
                        editor.apply();
                        MainActivity.this.setLocale("en");
                        menuItem.setChecked(true);
                        super.recreate();
                        return true;
                    }
                    case R.id.action_langAUTO:
                }
                editor.putString(APP_PREFERENCES_LANG, APP_PREFERENCES_LANG);
                editor.apply();
                MainActivity.this.setLocale(APP_PREFERENCES_LANG);
                menuItem.setChecked(true);
                super.recreate();
                return true;
            }
            editor.putString(APP_PREFERENCES_THEME, "dark");
            editor.apply();
            menuItem.setChecked(true);
            super.recreate();
            return true;
        }
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_LANG);
        editor.apply();
        menuItem.setChecked(true);
        super.recreate();
        return true;
    }

    public void openbeerbrix() {
        this.startActivity(new Intent(this, beer_brix.class));
    }

    public void opensemDrobniy() {
        this.startActivity(new Intent(this, sem_headbody.class));
    }

    public void opensemRazbavka() {
        this.startActivity(new Intent(this, sem_razbavka.class));
    }

    public void opensemSmeshivanie() {
        this.startActivity(new Intent(this, sem_smeshivanie.class));
    }

    public void opensemnapitok() {
        this.startActivity(new Intent(this, sem_Napitok.class));
    }

    public void opensemtempcorrect() {
        this.startActivity(new Intent(this, sem_Tempcorrect.class));
    }

    private void onClick(View view) {
        MainActivity.this.opensemDrobniy();
    }
}

