package com.example.android.listviewpersonalizado;

import java.util.ArrayList;

/**
 * Created by android on 05/05/2017.
 */

public class Datos {
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void guardar(Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> getCarros(){
        return carros;
    }

    public static int registrados(){
        int cont=0;

        for (int i = 0; i < carros.size(); i++){
            cont = cont+1;
        }
        return cont;
    }
}
