package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    private EditText cajaPlaca;
    private Spinner comboMarca;
    private Spinner comboModelo;
    private Spinner comboColor;
    private EditText cajaPrecio;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private String[] opc1;
    private String[] opc2;
    private String[] opc3;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        cajaPlaca = (EditText)findViewById(R.id.txtPlaca);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);
        comboModelo = (Spinner)findViewById(R.id.cmbModelo);
        comboColor = (Spinner)findViewById(R.id.cmbColor);
        cajaPrecio = (EditText)findViewById(R.id.txtPrecio);

        res = this.getResources();
        opc1 = res.getStringArray(R.array.marca);
        opc2 = res.getStringArray(R.array.modelo);
        opc3 = res.getStringArray(R.array.color);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc3);

        comboMarca.setAdapter(adapter1);
        comboModelo.setAdapter(adapter2);
        comboColor.setAdapter(adapter3);

    }

    public void registrar(View v){

        String placa, marca, modelo, color, aux="", foto;
        int precio;

        if(validar()){

            placa = cajaPlaca.getText().toString().trim();
            marca = comboMarca.getSelectedItem().toString();
            modelo = comboModelo.getSelectedItem().toString();
            color = comboColor.getSelectedItem().toString();
            precio = Integer.parseInt(cajaPrecio.getText().toString().trim());

            foto = String.valueOf(fotoAleatoria());
            Carro c = new Carro(foto,placa,marca,modelo,color,precio);
            c.guardar();
            limpiar();

            new AlertDialog.Builder(this).setMessage(res.getString(R.string.guardar)).show();

        }


    }

    public boolean validar() {
        if (cajaPlaca.getText().toString().isEmpty()) {
            cajaPlaca.setError(res.getString(R.string.error1));
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()) {
            cajaPrecio.setError(res.getString(R.string.error2));
            return false;
        }

        return true;
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cajaPlaca.setText("");
        cajaPrecio.setText("");
    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int) (Math.random() *3);
        return fotos[numero];
    }

}
