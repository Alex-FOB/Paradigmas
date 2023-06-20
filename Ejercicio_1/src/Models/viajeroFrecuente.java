package Models;

public class viajeroFrecuente {
    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer millas;
    public viajeroFrecuente(Integer numero, String dni, String nombre, String apellido, Integer millas){
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.millas = millas;
    }
    public Integer getMillas(){
        return this.millas;
    }
    public Integer acumularMillas(Integer addMillas){
        this.millas += addMillas;
        return this.millas;
    }
    public Integer canjearMillas(Integer subMillas){
        if(subMillas <= this.millas){
            this.millas -= subMillas;
        }
        return this.millas;
    }
    //AGREGADOS
    public Integer getNro(){
        return this.numero;
    }
    public String getDNI(){
        return this.dni;
    }
    @Override
    public String toString(){
        return numero+" - "+"DNI: "+dni+" - "+nombre+" "+apellido+" - "+"Millas: "+millas;
    }
}
