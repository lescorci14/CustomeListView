package com.example.android.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoReporte extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Carro> carros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_reporte);
        tabla = (TableLayout)findViewById(R.id.tblReporte);
        carros = Datos.getCarros();

        for (int i = 0; i < carros.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);

            if(carros.get(i).getModelo().equalsIgnoreCase("2010")||
                    carros.get(i).getModelo().equalsIgnoreCase("2011")||
                    carros.get(i).getModelo().equalsIgnoreCase("2012")||
                    carros.get(i).getModelo().equalsIgnoreCase("2013")||
                    carros.get(i).getModelo().equalsIgnoreCase("2014")||
                    carros.get(i).getModelo().equalsIgnoreCase("2015")){

                c1.setText(""+(i+1));
                c2.setText(carros.get(i).getPlaca());
                c3.setText(carros.get(i).getMarca());
                c4.setText(carros.get(i).getModelo());
                c5.setText(carros.get(i).getColor());
                c6.setText(""+carros.get(i).getPrecio());

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);
                fila.addView(c6);

                tabla.addView(fila);
            }
        }
    }
}
