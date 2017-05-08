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

    public static int audi(){
        int cont=0;

        for (int i=0;i<carros.size();i++){
            if(carros.get(i).getMarca().equals("Audi")){
                cont=cont+1;
            }
        }

        return cont;
    }

    public static int chevrolet(){
        int cont=0;

        for (int i=0;i<carros.size();i++){
            if(carros.get(i).getMarca().equals("Chevrolet")){
                cont=cont+1;
            }
        }

        return cont;
    }

    public static int kia(){
        int cont=0;

        for (int i=0;i<carros.size();i++){
            if(carros.get(i).getMarca().equals("KIA")){
                cont=cont+1;
            }
        }

        return cont;
    }

    public static int renault(){
        int cont=0;

        for (int i=0;i<carros.size();i++){
            if(carros.get(i).getMarca().equals("Renault")){
                cont=cont+1;
            }
        }

        return cont;
    }

}
