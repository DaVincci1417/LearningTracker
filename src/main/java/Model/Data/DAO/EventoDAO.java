package Model.Data.DAO;

import Model.Data.DBGenerator;
import Model.Evento;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class EventoDAO {
    public static void agregarEvento(DSLContext query, Evento evento){
        Table tablaEvento = table(name("Evento"));
        Field[] columnas = tablaEvento.fields("cod_evento","nombre_evento","descripcion_evento","fecha_evento");
        query.insertInto(tablaEvento, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(evento.getCodEvento(), evento.getNombreEvento(), evento.getDescripcionEvento(), evento.getFechaEvento())
                .execute();
    }
    public static void modificarEvento(DSLContext query, Object nombre, String columnaTabla, Object dato){
        query.update(table("Evento")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("cod_evento").eq(nombre)).execute();
    }
    public static List<Evento> obtenerEvento(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(table("Evento")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaEventos(resultados);
    }
    public static List<Evento> obtenerEventos() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("learning_tracker");
        Result resultados = query.select().from(table("Evento")).fetch();
        return obtenerListaEventos(resultados);
    }
    public static void eliminarEvento(DSLContext query, Object nombre){
        Table tablaEvento = table(name("Evento"));
        query.delete(table("Evento")).where(DSL.field("cod_evento").eq(nombre)).execute();
    }
    private static List<Evento> obtenerListaEventos(Result resultados){
        List<Evento> eventos = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            int codEvento = (int) resultados.getValue(fila,"cod_evento");
            String nombreEvento = (String) resultados.getValue(fila,"nombre_evento");
            String descripcionEvento = (String) resultados.getValue(fila,"descripcion_evento");
            Date fechaEvento = (Date) resultados.getValue(fila,"fecha_evento");

            eventos.add(new Evento(codEvento, nombreEvento, descripcionEvento, fechaEvento));
        }
        return eventos;
    }
}