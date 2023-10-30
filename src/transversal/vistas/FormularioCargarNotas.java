package transversal.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import transversal.accesoADatos.*;
import transversal.entidades.*;

public class FormularioCargarNotas extends javax.swing.JInternalFrame {

    private ArrayList<Alumno> listaAlumnos;
    
    private InscripcionData inscData;
    private MateriaData matData;
    private AlumnoData aluData;
    
    private DefaultTableModel modelo;
    
    public FormularioCargarNotas() {
        initComponents();
        
        inscData = new InscripcionData();
        aluData = new AlumnoData();
        matData = new MateriaData();
        
        listaAlumnos = (ArrayList<Alumno>) aluData.listarAlumnos();
        
        cargarCombo();
        
        jcbAlumno.setSelectedIndex(-1);
        
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int f, int c) {
                if (c == 2) {
                    return true;
                }
                return false;
            }
        };
        armarCabecera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCargarNota = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cargar Nota");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione un Alumno:");

        jcbAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new Alumno[] {}));
        jcbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnoItemStateChanged(evt);
            }
        });
        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jtCargarNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nota", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtCargarNota);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbGuardar)
                .addGap(112, 112, 112)
                .addComponent(jbSalir)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        
            int fila = jtCargarNota.getSelectedRow();

            int idMateria = (int) modelo.getValueAt(fila, 0);
            int idAlumno = alumnoSeleccionado.getIdAlumno();
            double nota = Double.parseDouble((String) modelo.getValueAt(fila, 2));

            if (nota > 10 || nota < 0) {
                JOptionPane.showMessageDialog(this, "Ingrese una nota correcta.");
                return;
            }

            inscData.actualizarNota(idAlumno, idMateria, nota);

            borrarFilas();
            jcbAlumno.setSelectedIndex(-1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una fila para guardar la nota.");
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "Confirme la nota a guardar.");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jcbAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnoItemStateChanged
        try {
            borrarFilas();
            
            Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();

            ArrayList<Inscripcion> inscripciones = (ArrayList<Inscripcion>) inscData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getIdAlumno());

            for (Inscripcion inscripcion : inscripciones) {
                modelo.addRow(new Object[] {inscripcion.getMateria().getIdMateria(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jcbAlumnoItemStateChanged

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed

    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        
        jtCargarNota.setModel(modelo);
    }
    
    private void cargarCombo() {
        for (Alumno alumno : listaAlumnos) {
            jcbAlumno.addItem(alumno);
        }
    }
    
    private void borrarFilas() {
        DefaultTableModel modelo = (DefaultTableModel) jtCargarNota.getModel();
        modelo.setRowCount(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JTable jtCargarNota;
    // End of variables declaration//GEN-END:variables
}
