package Model.Data.DAO;

import Model.Academico;
import Model.Data.DBGenerator;
import Model.Inscripcion;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class InscripcionDAO {
    public static void agregarInscripcion(DSLContext query, Inscripcion inscripcion){
        Table tablaInscripcion = table(name("Inscripcion"));
        Field[] columnas = tablaInscripcion.fields("cod_inscripcion","matricula_estudiante","cod_asignatura");
        query.insertInto(tablaInscripcion, columnas[0], columnas[1], columnas[2])
                .values(inscripcion.getCodInscripcion(), inscripcion.getNumeroMatricula(), inscripcion.getCodAsignatura())
                .execute();
    }
    public static void modificarInscripcion(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(table("Inscripcion")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("cod_inscripcion").eq(nombre)).execute();
    }
    public static List<Inscripcion> obtenerInscripcion(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(table("Inscripcion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaInscripcion(resultados);
    }
    public static List<Inscripcion> obtenerAcademicos() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("learning_tracker");
        Result resultados = query.select().from(table("Inscripcion")).fetch();
        return obtenerListaInscripcion(resultados);
    }
    public static void eliminarInscripcion(DSLContext query, Object nombre){
        Table tablaInscripcion = table(name("Inscripcion"));
        query.delete(table("Inscripcion")).where(DSL.field("cod_inscripcion").eq(nombre)).execute();
    }
    private static List<Inscripcion> obtenerListaInscripcion(Result resultados){
        List<Inscripcion> inscripcioness = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            int rut = (int) resultados.getValue(fila,"cod_inscripcion");
            String numeroMatricula = (String) resultados.getValue(fila,"matricula_estudiante");
            int codAsignatura = (int) resultados.getValue(fila,"cod_asignatura");

            inscripcioness.add(new Inscripcion(rut, numeroMatricula, codAsignatura));
        }
        return inscripcioness;
    }
}
