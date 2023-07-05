package Model.Data.DAO;

import Model.Asignatura;
import Model.Data.DBGenerator;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;


public class AsignaturaDAO {
    public static void agregarAsignatura(DSLContext query, Asignatura asignatura){
        Table tablaAsignatura = table(name("Asignatura"));
        Field[] columnas = tablaAsignatura.fields("cod_asignatura","nombre_asignatura","modulo","semestre","rut_academico");
        query.insertInto(tablaAsignatura, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(asignatura.getCodAsignatura(), asignatura.getNombreAsignatura(), asignatura.getModulo(), asignatura.getSemestre(), asignatura.getRutAcademico())
                .execute();
    }
    public static void modificarAsignatura(DSLContext query, Object nombre, String columnaTabla, Object dato){
        query.update(table("Asignatura")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("cod_asignatura").eq(nombre)).execute();
    }
    public static List<Asignatura> obtenerAsignatura(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(table("Asignatura")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAsignaturas(resultados);
    }
    public static List<Asignatura> obtenerAsignaturas() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("learning_tracker");
        Result resultados = query.select().from(table("Asignatura")).fetch();
        return obtenerListaAsignaturas(resultados);
    }
    public static void eliminarAsignatura(DSLContext query, Object nombre){
        Table tablaAsignatura= table(name("Asignatura"));
        query.delete(table("Asignatura")).where(DSL.field("cod_asignatura").eq(nombre)).execute();
    }
    private static List<Asignatura> obtenerListaAsignaturas(Result resultados){
        List<Asignatura> asignaturas = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            int codAsignatura  = (int) resultados.getValue(fila,"cod_asignatura");
            String nombreAsignatura = (String) resultados.getValue(fila,"nombre_asignatura");
            int modulo  = (int) resultados.getValue(fila,"modulo");
            int semestre = (int) resultados.getValue(fila,"semestre");
            String rutAcademico = (String) resultados.getValue(fila,"rut_academico");

            asignaturas.add(new Asignatura(codAsignatura, nombreAsignatura, modulo, semestre, rutAcademico));
        }
        return asignaturas;
    }
}
