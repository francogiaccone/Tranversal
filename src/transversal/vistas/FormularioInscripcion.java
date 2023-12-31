package transversal.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import transversal.accesoADatos.*;
import transversal.entidades.*;

public class FormularioInscripcion extends javax.swing.JInternalFrame {

    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;
    
    private InscripcionData inscData;
    private MateriaData matData;
    private AlumnoData aluData;
    
    private DefaultTableModel modelo;
    
    
    public FormularioInscripcion() {
        initComponents();
        
        inscData = new InscripcionData();
        aluData = new AlumnoData();
        matData = new MateriaData();
        
        listaAlumnos = (ArrayList<Alumno>) aluData.listarAlumnos();
        
        cargarCombo();
        
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int f, int c) {
                return false;
            }
        };
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jrMateriasIncriptas = new javax.swing.JRadioButton();
        jrMateriasNoIncriptas = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbInscribir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Seleccion de Alumno:");

        jcbAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new Alumno[] {}));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jrMateriasIncriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriasIncriptasActionPerformed(evt);
            }
        });

        jrMateriasNoIncriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriasNoIncriptasActionPerformed(evt);
            }
        });

        jLabel4.setText("Materias no Inscripta");

        jLabel5.setText("Materias Incriptas");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setText("Anular Inscripcion");
        jbAnularInscripcion.setEnabled(false);
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
            }
        });

        jbInscribir.setText("Inscribir");
        jbInscribir.setEnabled(false);
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbInscribir)
                                .addGap(81, 81, 81)
                                .addComponent(jbAnularInscripcion)
                                .addGap(114, 114, 114)
                                .addComponent(jbSalir)))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrMateriasIncriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrMateriasNoIncriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrMateriasIncriptas)
                    .addComponent(jrMateriasNoIncriptas)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbInscribir))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrMateriasIncriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriasIncriptasActionPerformed
        borrarFilas();
        
        jrMateriasNoIncriptas.setSelected(false);
        
        cargarTablaInscriptas();
        
        jbAnularInscripcion.setEnabled(true);
        jbInscribir.setEnabled(false);
    }//GEN-LAST:event_jrMateriasIncriptasActionPerformed

    private void jrMateriasNoIncriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriasNoIncriptasActionPerformed
        borrarFilas();
        
        jrMateriasIncriptas.setSelected(false);
        
        cargarTablaNoInscriptas();
        
        jbInscribir.setEnabled(true);
        jbAnularInscripcion.setEnabled(false);
    }//GEN-LAST:event_jrMateriasNoIncriptasActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        int filaSeleccionada = jtMaterias.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
            
            int idMateria = (int) modelo.getValueAt(filaSeleccionada, 0);
            String nombreMateria = (String) modelo.getValueAt(filaSeleccionada, 1);
            int anioMateria = (int) modelo.getValueAt(filaSeleccionada, 2);
            
            Materia materia = new Materia(idMateria, nombreMateria, anioMateria, true);
            
            Inscripcion inscripcion = new Inscripcion(alumno, materia, 0);
            
            inscData.guardarInscripcion(inscripcion);
            
            borrarFilas();
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una materia");
        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
        int filaSeleccionada = jtMaterias.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            
            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
            
            int idMateria = (int) modelo.getValueAt(filaSeleccionada, 0);
            
            inscData.borrarInscripcionMateriaAlumno(alumno.getIdAlumno(), idMateria);
            
            borrarFilas();
            
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una materia");
        }
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    private void cargarCombo() {
        for (Alumno alumno : listaAlumnos) {
            jcbAlumno.addItem(alumno);
        }
    }
    
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        
        jtMaterias.setModel(modelo);
    }
    
    private void borrarFilas() {
        int filas = modelo.getRowCount() - 1;
        
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void cargarTablaNoInscriptas() {
        Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        
        listaMaterias = (ArrayList<Materia>) inscData.obtenerMateriasNoCursadas(alumnoSeleccionado.getIdAlumno());
        
        for (Materia materia : listaMaterias) {
            modelo.addRow(new Object[] {materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
        }
    }
    
    private void cargarTablaInscriptas() {
        Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        
        listaMaterias = (ArrayList<Materia>) inscData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());
        
        for (Materia materia : listaMaterias) {
            modelo.addRow(new Object[] {materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JRadioButton jrMateriasIncriptas;
    private javax.swing.JRadioButton jrMateriasNoIncriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
