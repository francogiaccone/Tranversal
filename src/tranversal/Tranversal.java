
package tranversal;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import transversal.accesoADatos.AlumnoData;
import transversal.accesoADatos.Conexion;
import transversal.entidades.Alumno;
        
public class Tranversal {
    
    public static void main(String[] args) {
        Conexion.getConexion();
        
        //Alumno pedro=new Alumno(1,35609123,"Emerson","Genaro Pedro",LocalDate.of(2001, 05, 10),true);
        //Alumno clare=new Alumno(13789231,"Kagenou","clare",LocalDate.of(1988, 03, 06),true);
        Alumno sergio=new Alumno(42220985,"Leguizamon","Sergio",LocalDate.of(1999, 02, 03),true);
        AlumnoData alu=new AlumnoData();
        //alu.guardarAlumno(pedro);
        //alu.guardarAlumno(clare);
        //alu.guardarAlumno(sergio);
        //alu.modificarAlumno(pedro);
        //alu.eliminarAlumno(1);
       /*Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(42220985);
       if(alumnoEncontrado!=null){
       System.out.println("dni "+ alumnoEncontrado.getDni());
        System.out.println("apelido "+ alumnoEncontrado.getApellido());
        System.out.println("nombre "+ alumnoEncontrado.getNombre()); */
       
       for(Alumno alumno:alu.listarAlumno()){
           System.out.println(alumno);
       }
   }
    
}
