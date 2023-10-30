/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversal.accesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import transversal.entidades.*;

/**
 *
 * @author alumno
 */
public class InscripcionData {
    
    private Connection con=null;
    private MateriaData matData=new MateriaData();
    private AlumnoData aluData=new AlumnoData();
    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion inscripcion){
        String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria)" 
            + "VALUES(?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria){
        String sql="DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
         
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno,int idMateria,double nota){
        String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
               JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        
        ArrayList<Inscripcion> cursadas=new ArrayList<>();
        
        String sql="SELECT * FROM inscripcion";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);   
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return cursadas;
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        
        ArrayList<Inscripcion> cursadas=new ArrayList<>();
        
        String sql="SELECT * FROM inscripcion WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);  
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return cursadas;
    }
    
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno){
        ArrayList<Materia> materiasCursadas=new ArrayList<>();
        
        String sql="SELECT inscripcion.idMateria, nombre, anio FROM inscripcion," 
                + " materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materiasCursadas.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return materiasCursadas;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
        ArrayList<Materia> materiasNoCursadas=new ArrayList<>();
        
        String sql="SELECT * FROM materia WHERE estado = 1 AND idMateria not in"
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materiasNoCursadas.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return materiasNoCursadas;
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        ArrayList<Alumno> alumnosMaterias = new ArrayList<>();
        
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
             + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMaterias.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return alumnosMaterias;
    }
   }


