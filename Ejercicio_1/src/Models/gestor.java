package Models;

import Models.viajeroFrecuente;
import java.util.ArrayList;

public class gestor {
    private ArrayList<viajeroFrecuente> arreglo;
    private Integer cantidad;
    public gestor(Integer cantidad){
        this.arreglo = new ArrayList<viajeroFrecuente>(cantidad);
        this.cantidad = cantidad;
    }
    public void cargarViajero(Integer num, String dni, String nom, String ape, Integer millas){
        String retorno;
        try{
            this.arreglo.add(new viajeroFrecuente(num, dni, nom, ape, millas));
            retorno = "DATO: viajero creado";
        } catch (Exception e){
            retorno = "ERROR: viajero invalido";
        }
        System.out.println(retorno);
    }
    public void mostrarViajero(Integer num){
        String retorno = "ERROR: viajero no encontrado";
        Boolean band = false;
        Integer i = 0;
        
        while(band == false && i<this.arreglo.size()){
            if(num == this.arreglo.get(i).getNro()){
                retorno = this.arreglo.get(i).toString();
                band = true;
            }
            else{
                i += 1;
            }
        }
        System.out.println(retorno);
    }
    public void consultarMillas(String dni){
        String retorno = "ERROR: viajero no encontrado";
        Boolean band = false;
        Integer i = 0;
        while(!band){
            if(dni.equals(this.arreglo.get(i).getDNI())){
                retorno = ""+this.arreglo.get(i).getMillas();
                band = true;
            }
            else{
                i += 1;
            }
        }
        System.out.println(retorno);
    }
    public void acumMillas(String dni, Integer millas){
        String retorno = "ERROR: viajero no encontrado";
        Boolean band = false;
        Integer i = 0;
        while(!band){
            if(dni.equals(this.arreglo.get(i).getDNI())){
                retorno = "RESULTADO: "+this.arreglo.get(i).acumularMillas(millas);
                band = true;
            }
            else{
                i += 1;
            }
        }
        System.out.println(retorno);
    }
    public void canjMillas(String dni, Integer millas){
        String retorno = "ERROR: viajero no encontrado";
        Boolean band = false;
        Integer i = 0;
        while(!band){
            if(dni.equals(this.arreglo.get(i).getDNI())){
                Integer antMillas = this.arreglo.get(i).getMillas();
                Integer newMillas = this.arreglo.get(i).canjearMillas(millas);
                if(newMillas != antMillas){
                    retorno = "RESULTADO: "+newMillas;
                }
                else{
                    retorno = "ERROR: no se puede canjear millas";
                }
                band = true;
            }
            else{
                i += 1;
            }
        }
        System.out.println(retorno);
    }
    public Integer maxMillas(){
        Integer max = 0;
        for(int i = 0; i<this.arreglo.size(); ++i){
            if(this.arreglo.get(i).getMillas()>max){
                max = this.arreglo.get(i).getMillas();
            }
        }
        return max;
    }
    public void mejorViajero(){
        ArrayList<viajeroFrecuente> newArreglo = new ArrayList<viajeroFrecuente>(this.cantidad);
        Integer max = this.maxMillas();
        for(int i=0; i<this.arreglo.size(); ++i){
            if(this.arreglo.get(i).getMillas()==max){
                newArreglo.add(this.arreglo.get(i));
            }
        }
        System.out.println(newArreglo);
    }
}
