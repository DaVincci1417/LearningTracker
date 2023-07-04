package Model;

import java.util.Date;

public class Evento {
    private int codEvento;
    private String nombreEvento;
    private String descripcionEvento;
    private Date fechaEvento;

    public Evento(int codEvento, String nombreEvento, String descripcionEvento, Date fechaEvento) {
        setCodEvento(codEvento);
        setNombreEvento(nombreEvento);
        setDescripcionEvento(descripcionEvento);
        setFechaEvento(fechaEvento);
    }
    public Evento(String nombreEvento, String descripcionEvento, Date fechaEvento) {
        setNombreEvento(nombreEvento);
        setDescripcionEvento(descripcionEvento);
        setFechaEvento(fechaEvento);
    }

    public int getCodEvento() {
        return codEvento;
    }
    private void setCodEvento(int codEvento) {
        this.codEvento = codEvento;
    }
    public String getNombreEvento() {
        return nombreEvento;
    }
    private void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    public String getDescripcionEvento() {
        return descripcionEvento;
    }
    private void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }
    public Date getFechaEvento() {
        return fechaEvento;
    }
    private void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
}
