
package tranversal;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import transversal.accesoADatos.AlumnoData;
import transversal.accesoADatos.Conexion;
import transversal.accesoADatos.MateriaData;
import transversal.entidades.Alumno;
import transversal.entidades.Inscripcion;
import transversal.accesoADatos.InscripcionData;
import transversal.entidades.Materia;

        
public class Tranversal {
    
    public static void main(String[] args) {
        Conexion.getConexion();
        
        //Alumno pedro=new Alumno(1,35609123,"Emerson","Genaro Pedro",LocalDate.of(2001, 05, 10),true);
        //Alumno clare=new Alumno(13789231,"Kagenou","clare",LocalDate.of(1988, 03, 06),true);
        //Alumno sergio=new Alumno(3,42220985,"Leguizamon","Daniel Sergio",LocalDate.of(1999, 02, 03),true);
        //Alumno franco=new Alumno(23768091,"Giacone","Franco",LocalDate.of(1678, 01, 24),true);
        //AlumnoData alu=new AlumnoData();
        //alu.guardarAlumno(pedro);
        //alu.guardarAlumno(clare);
        //alu.guardarAlumno(sergio);
        //alu.guardarAlumno(franco);
        //alu.modificarAlumno(pedro);
        //alu.modificarAlumno(sergio);
        //alu.eliminarAlumno(1);
       /*Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(42220985);
       if(alumnoEncontrado!=null){
       System.out.println("dni "+ alumnoEncontrado.getDni());
        System.out.println("apelido "+ alumnoEncontrado.getApellido());
        System.out.println("nombre "+ alumnoEncontrado.getNombre()); */
       
       /*for(Alumno alumno:alu.listarAlumno()){
           System.out.println(alumno);
       }
   }*/
        //Materia lengua=new Materia(1,"Lengua",2,true);
        //Materia educacionFisica=new Materia(2,"educacion",5,true);
        //Materia quimica=new Materia("fisica quimica",3,true);
        //Materia musica=new Materia("musica",4,true);
       //MateriaData mat= new MateriaData();
       //mat.guardarMateriaData(lengua);
       //mat.guardarMateriaData(educacionFisica);
       //mat.guardarMateriaData(quimica);
       //mat.guardarMateriaData(musica);
       //mat.modificarMateriaData(educacionFisica);
      //mat.eliminarMateria(3);
      //Materia materiaEncontrada = mat.buscarMateria(1);
      /*if(materiaEncontrada!=null){
          System.out.println("nombre "+ materiaEncontrada.getNombre());
          System.out.println("anio "+ materiaEncontrada.getAnioMateria());
      }*/
      
      /*for(Materia materias:mat.listarMateria()){
          System.out.println(materias);
      }*/
      
      AlumnoData alu=new AlumnoData();
      MateriaData mat=new MateriaData();
      InscripcionData in=new InscripcionData();
      
      //Alumno clare=alu.buscarAlumno(2);
      //Materia Lengua=mat.buscarMateria(1);
     //Inscripcion inscripcion = new Inscripcion(clare,Lengua,4.3);
      
     //Alumno sergio=alu.buscarAlumno(3);
     //Materia educacion=mat.buscarMateria(2);
     //Inscripcion inscripcion = new Inscripcion(sergio,educacion,7.8);
     
     //Alumno sergio=alu.buscarAlumno(3);
     //Materia musica=mat.buscarMateria(4);
     //Inscripcion inscripcion = new Inscripcion(sergio,musica,2.1);
     
      //in.guardarInscripcion(inscripcion);
      //in.guardarInscripcion(inscripcion);
      //in.guardarInscripcion(inscripcion);
    
      //in.actualizarNota(3,4,10.0);
      //in.borrarInscripcionMateriaAlumno(2, 1);
      
      /*for(Inscripcion cursadas:in.obtenerInscripciones()){
          System.out.println(cursadas);
      }*/
      
      /*for(Materia materiasCursadas:in.obtenerMateriasCursadas(3)){
          System.out.println(materiasCursadas);
      }*/
      
      /*for(Materia materiasNoCursadas:in.obtenerMateriasNoCursadas(3)){
          System.out.println(materiasNoCursadas);
      }*/
      
      for(Alumno alumnosMaterias:in.obtenerAlumnosXMateria(2)){
          System.out.println(alumnosMaterias);
      }
      
}
}
