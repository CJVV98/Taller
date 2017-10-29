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
      public static void crear (Actividad actividad1) {
        
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

   public static int comparar(Date fecha1, Time horainicial, Time horafinal, String recreador1) {
       int bandera=0,bandera1=0;
        try {
            String query = "SELECT * FROM actividad WHERE recreador = '" +recreador1+"';";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();
            System.out.println("ID ES      -------------------------");
            while(resultado.next()){
                  System.out.println("Esta fecha ya esta"+resultado.getDate("fechai")+""+fecha1+horainicial+" Esta hora"+resultado.getTime("horafinal"));
                if(fecha1.equals(resultado.getDate("fechai"))){
                    if((resultado.getTime("horafinal").after(horainicial)&& resultado.getTime("horainicio").before(horainicial))|| (resultado.getTime("horafinal").after(horafinal)&& resultado.getTime("horainicio").before(horafinal))
                            || horainicial.equals(resultado.getTime("horafinal")) || horainicial.equals(resultado.getTime("horainicio")) || horafinal.equals(resultado.getTime("horafinal")) || horafinal.equals(resultado.getTime("horainicio"))){
                            System.out.println("Esta hora ya esta ok");
                            bandera1++;
                    }                  
                }             
            }
             sentenciaP.close();
             database.close();
           if(bandera1>0){
               bandera=1;
           }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bandera;
    }
    
    }
    
   
    



