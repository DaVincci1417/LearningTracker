package Model.Data.DAO;

import Model.Academico;
import Model.Administrador;
import Model.Data.DBGenerator;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class AdministradorDAO {
    public static void agregarAdministrador(DSLContext query, Administrador administrador){
        Table tablaAcademico = table(name("Administrador"));
        Field[] columnas = tablaAcademico.fields("rut_administrador","nombre_administrador","apellido_paterno","apellido_materno","correo_institucional","sexo","nombre_usuario","contraseña","tipo_usuario");
        query.insertInto(tablaAcademico, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5], columnas[6], columnas[7], columnas[8])
                .values(administrador.getRut(), administrador.getNombre(), administrador.getApellidoP(), administrador.getApellidoM(), administrador.getCorreoInstitucional(),
                        administrador.getSexo(), administrador.getNombreUsuario(), administrador.getContraseña(), administrador.getTipoUsuario())
                .execute();
    }
    public static void modificarAdministrador(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(table("Administrador")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("rut_administrador").eq(nombre)).execute();
    }
    public static List<Administrador> obtenerAdministrador(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(table("Administrador")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAdministradores(resultados);
    }
    public static List<Administrador> obtenerAdministradores() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("learning_tracker");
        Result resultados = query.select().from(table("Administrador")).fetch();
        return obtenerListaAdministradores(resultados);
    }
    public static void eliminarAdministrador(DSLContext query, Object nombre){
        Table tablaAdministrador= table(name("Administrador"));
        query.delete(table("Administrador")).where(DSL.field("rut_administrador").eq(nombre)).execute();
    }
    private static List<Administrador> obtenerListaAdministradores(Result resultados){
        List<Administrador> administradores = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String rut = (String) resultados.getValue(fila,"rut_administrador");
            String nombreAcademico = (String) resultados.getValue(fila,"nombre_administrador");
            String apellidoPaterno = (String) resultados.getValue(fila,"apellido_paterno");
            String apellidoMaterno = (String) resultados.getValue(fila,"apellido_materno");
            String correoInstitucional = (String) resultados.getValue(fila,"correo_institucional");
            String sexo = (String) resultados.getValue(fila,"sexo");
            String nombreUsuario = (String) resultados.getValue(fila,"nombre_usuario");
            String contraseña = (String) resultados.getValue(fila,"contraseña");
            String tipoUsuario = (String) resultados.getValue(fila,"tipo_usuario");

            administradores.add(new Administrador(rut, nombreAcademico, apellidoPaterno, apellidoMaterno, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario));
        }
        return administradores;
    }
}
