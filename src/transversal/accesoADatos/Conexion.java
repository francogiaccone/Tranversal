
package transversal.accesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "transversal";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection;
    
    private Conexion(){
        
    }
    
    public static Connection getConexion() {
        if(connection == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
                
                
                JOptionPane.showMessageDialog(null, "Connectado exitosamente");
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar driver " + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
            }
        }
        return connection;
    }
}
