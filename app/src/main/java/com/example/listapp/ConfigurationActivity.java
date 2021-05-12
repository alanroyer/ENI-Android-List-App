package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class ConfigurationActivity extends AppCompatActivity {

    private EditText etPrixDefault;
    private Switch tri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        SharedPreferences sp = getPreferences(MODE_PRIVATE);

        String prixDefault = sp.getString("prix_default","");
        boolean prixTri = sp.getBoolean("prix_tri",false);

        etPrixDefault = findViewById(R.id.et_prix_defaut);
        tri = findViewById(R.id.s_tri_prix);

        etPrixDefault.setText(prixDefault);
        tri.setChecked(prixTri);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences sp = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("prix_default",etPrixDefault.getText().toString());
        editor.putBoolean("prix_tri",tri.isChecked());

        editor.apply();
    }
}