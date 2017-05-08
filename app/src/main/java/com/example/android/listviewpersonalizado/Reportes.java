package com.example.android.listviewpersonalizado;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reportes extends AppCompatActivity {
    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        ls = (ListView) findViewById(R.id.lvReportes);
        res = this.getResources();
        opc = res.getStringArray(R.array.reportes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        reporte1();
                        break;
                    case 1:
                        reporte2();
                        break;
                    case 2:
                        i = new Intent(Reportes.this, ListadoReporte.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }

    public void reporte1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.result));
        builder.setMessage(res.getString(R.string.resultado1)+" "+Datos.registrados())
                .setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void reporte2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.result));
        builder.setMessage(res.getString(R.string.audi)+": "+Datos.audi()+"\n"+
        res.getString(R.string.chevrolet)+": "+Datos.chevrolet()+"\n"+
        res.getString(R.string.kia)+": "+Datos.kia()+"\n"+
        res.getString(R.string.renault)+": "+Datos.renault())
                .setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
    }

}
