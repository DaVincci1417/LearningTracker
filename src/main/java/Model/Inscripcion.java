package Model;

public class Inscripcion {
    private int codInscripcion;
    private String numeroMatricula;
    private int codAsignatura;

    public Inscripcion(int codInscripcion, String numeroMatricula, int codAsignatura) {
        setCodInscripcion(codInscripcion);
        setNumeroMatricula(numeroMatricula);
        setCodAsignatura(codAsignatura);
    }
    public Inscripcion(String numeroMatricula, int codAsignatura) {
        setNumeroMatricula(numeroMatricula);
        setCodAsignatura(codAsignatura);
    }

    public int getCodInscripcion() {
        return codInscripcion;
    }
    private void setCodInscripcion(int codInscripcion) {
        this.codInscripcion = codInscripcion;
    }
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    private void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public int getCodAsignatura() {
        return codAsignatura;
    }
    private void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }
}
