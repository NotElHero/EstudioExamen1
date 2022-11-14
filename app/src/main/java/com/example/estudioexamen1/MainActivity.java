package com.example.estudioexamen1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button botonMostrar, botonLink;
    TextView textView;
    RadioButton botonLower, botonUpper;
    CheckBox botonFurbo, botonMaincra;
    EditText editText;
    String add = "";
    boolean seleccion = false;
    String url = "https://www.youtube.com/watch?v=RjGH9JXbg4s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMostrar = findViewById(R.id.botonMostrar);
        botonMostrar.setOnClickListener(this);
        botonLink = findViewById(R.id.botonLink);
        botonLink.setOnClickListener(this);

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
        switch (view.getId()){
            case R.id.botonMostrar:
                estaCheck();
                estaSeleccionado();
                if (seleccion){

                }
                textView.setText(editText.getText()+add);
            Toast toast = Toast.makeText(this, "listo!", Toast.LENGTH_SHORT);
            toast.show();

            break;
            case R.id.botonLink:
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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

    public boolean estaSeleccionado(){
        if (botonLower.isChecked()) {
            seleccion = false;
        }
        if (botonUpper.isChecked()){
            seleccion = true;
        }
        return seleccion;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}