package com.example.estudioexamen1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button botonMostrar, botonLink, botonCam;
    TextView textView;
    RadioButton botonLower, botonUpper;
    CheckBox botonFurbo, botonMaincra;
    EditText editText;
    String add = "";
    String url = "https://www.youtube.com/watch?v=RjGH9JXbg4s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMostrar = findViewById(R.id.botonMostrar);
        botonMostrar.setOnClickListener(this);
        botonLink = findViewById(R.id.botonLink);
        botonLink.setOnClickListener(this);
        botonCam = findViewById(R.id.botonCam);
        botonCam.setOnClickListener(this);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        botonFurbo = findViewById(R.id.checkBoxFurbo);
        botonMaincra = findViewById(R.id.checkBoxMaincra);

        botonLower = findViewById(R.id.radioButtonLower);
        botonUpper = findViewById(R.id.radioButtonUpper);

        Spinner genero = findViewById(R.id.spinner);
        genero.setOnItemSelectedListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textview", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("textview"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonMostrar:
                estaCheck();
                if (botonLower.isChecked()){
                    textView.setText(editText.getText().toString().toLowerCase()+add.toLowerCase());
                }if (botonUpper.isChecked()){
                    textView.setText(editText.getText().toString().toUpperCase()+add.toUpperCase());
                }else{
                textView.setText(editText.getText() + add);
        }

            Toast toast = Toast.makeText(this, "listo!", Toast.LENGTH_SHORT);
            toast.show();
            break;
            case R.id.botonLink:
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.botonCam:
                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cam);
                break;
        }
    }

    public String estaCheck(){
        if (botonFurbo.isChecked()) {
            add = " y le gusta el furbo";
        }
        if (botonMaincra.isChecked()){
            add = " y le gusta el maincra";
        }
        if (!botonFurbo.isChecked() && !botonMaincra.isChecked()){
            add = "";
        }
        return add;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}