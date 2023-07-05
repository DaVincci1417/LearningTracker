package Model;

public class Estudiante extends Persona{
    private String numeroMatricula;
    private String carrera;

    public Estudiante(String rut, String nombre, String apellidoP, String apellidoM, String correoInstitucional, String sexo, String nombreUsuario, String contraseña, String tipoUsuario, String carrera, String numeroMatricula){
        super(rut, nombre, apellidoP, apellidoM, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario);
        setNumeroMatricula(numeroMatricula);
        setCarrera(carrera);
    }

    //Getters and Setters
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    private void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getCarrera() {
        return carrera;
    }
    private void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
