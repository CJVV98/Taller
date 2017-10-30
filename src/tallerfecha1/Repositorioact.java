package tallerfecha1;

import co.edu.unicundinamarca.database.DBManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Repositorioact {

    private static DBManager database = new DBManager();
    static Statement sentencia;
    static ResultSet resultado;

    public static void crear(Actividad actividad1) {

        try {
            String query = "INSERT INTO actividad (nombre, fechai,horainicio, horafinal, descripcion, recreador,fecharegistro1) VALUES (?, ?, ?, ?, ?, ?, ?);";
            //Colocar esos interrogantes l
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, actividad1.getNombre());
            sentenciaP.setDate(2, actividad1.getFechai());
            sentenciaP.setTime(3, actividad1.getHorainicio());
            sentenciaP.setTime(4, actividad1.getHorafin());
            sentenciaP.setString(5, actividad1.getDescripcion());
            sentenciaP.setString(6, actividad1.getRecreador());
            sentenciaP.setTimestamp(7, actividad1.getFecharegistro1());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//Aqui le llegaron los datos

    public static int comparar(Date fecha1, Time horainicial, Time horafinal, String recreador1) {
        int bandera = 0, bandera1 = 0;
        try {
            //aqui ese select me selecciona la tabla ese where me indica donde recreador = String recreador1 si lo encuentra
            String query = "SELECT * FROM actividad WHERE recreador = '" + recreador1 + "';";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);// esto es para preparar lo del mysql eso si lo copie del ejercicio anterior hast
            ResultSet resultado = sentenciaP.executeQuery();
            System.out.println("ID ES      -------------------------");
            while (resultado.next()) {//aqui copie
                System.out.println("Esta fecha ya esta" + resultado.getDate("fechai") + "" + fecha1 + horainicial + " Esta hora" + resultado.getTime("horafinal"));
                //Si la fecha que me llega del metodo es igual a la de la base de datos
                if (fecha1.equals(resultado.getDate("fechai"))) {
                    //Entra a evaluar las horas si resultado.getTime("horafinal") esto lo vi ene ejemplo del profesor lo que hace esto es traerme informacion con respecto a esta columna desde mysql
                    if ((resultado.getTime("horafinal").after(horainicial) && resultado.getTime("horainicio").before(horainicial)) || (resultado.getTime("horafinal").after(horafinal) && resultado.getTime("horainicio").before(horafinal))
                            || horainicial.equals(resultado.getTime("horafinal")) || horainicial.equals(resultado.getTime("horainicio")) || horafinal.equals(resultado.getTime("horafinal")) || horafinal.equals(resultado.getTime("horainicio"))) {
                        // si se cumplehice una bandera es decir hay errores en los horarios   
                        System.out.println("Esta hora ya esta ok");
                        bandera1++;
                    }
                }
            }
            sentenciaP.close();
            database.close();
            // esto fue lo que se me ocurrio que si aumentaba quiere decir que no cumple las horas
            if (bandera1 > 0) {
                bandera = 1;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bandera;
    }

    public static void eliminar(Actividad act) {
        try {
            String query = "DELETE FROM actividad WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(act.getId()));

            sentenciaP.execute();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editar(Actividad act) {
        try {
            String query = "UPDATE actividad SET nombre = ?, fechai = ?, horainicio = ?, horafinal = ?, descripcion = ?, recreador = ?, fecharegistro1 = ? WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, act.getNombre());
            sentenciaP.setDate(2, act.getFechai());
            sentenciaP.setTime(3, act.getHorainicio());
            sentenciaP.setTime(4, act.getHorafin());
            sentenciaP.setString(5, act.getDescripcion());
            sentenciaP.setString(6, act.getRecreador());
            sentenciaP.setTimestamp(7, act.getFecharegistro1());
            sentenciaP.setInt(8, act.getId());

            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
       public static ArrayList<Actividad> obtenerTodos() {
        System.out.println("AQUI ESTOY 2");
        ArrayList<Actividad> actividad = new ArrayList<Actividad>();
 
        try {
            String query = "SELECT * FROM actividad;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();
            while (resultado.next()) {
                actividad.add(Actividad.crear(resultado.getInt("id"), resultado.getString("nombre"),  resultado.getString("descripcion"), resultado.getString("recreador"),
                       resultado.getDate("fechai"),resultado.getTime("horainicio"),resultado.getTime("horafinal"),resultado.getTimestamp("fecharegistro1")));
            }
            sentenciaP.close();
            database.close();
            return actividad;
        } catch (SQLException e) {
 
            System.out.println(e.getMessage());
 
        }
 

 
        return actividad;
 
    }
    /*public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM registro WHERE cedula = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getInt("cedula"), resultado.getInt("edad"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("tipo"), resultado.getDate("fechanac"),  resultado.getTimestamp("fecharegistro"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }*/
  
}
