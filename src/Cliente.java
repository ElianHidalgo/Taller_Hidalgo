public class Cliente {

    private long Cedula;
    private String nombre;
    private int cantidadentradas;


    public Cliente(long cedula, String nombre, int cantidadentradas) {
        Cedula = cedula;
        this.nombre = nombre;
        this.cantidadentradas = cantidadentradas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public long getCedula() {
        return Cedula;
    }

    public int getCantidadentradas() {
        return cantidadentradas;
    }

    public void setCantidadentradas(int cantidadentradas) {
        this.cantidadentradas = cantidadentradas;
    }



}
