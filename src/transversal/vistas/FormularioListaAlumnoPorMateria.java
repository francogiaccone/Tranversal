package transversal.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import transversal.accesoADatos.*;
import transversal.entidades.*;

public class FormularioListaAlumnoPorMateria extends javax.swing.JInternalFrame {
    
    private ArrayList<Materia> listaMaterias;
    
    private InscripcionData inscData;
    private MateriaData matData;
    
    private DefaultTableModel modelo;
    
    public FormularioListaAlumnoPorMateria() {
        initComponents();
        
        inscData = new InscripcionData();
        matData = new MateriaData();
        
        listaMaterias = (ArrayList<Materia>) matData.listarMaterias();
        
        cargarCombo();
        
        jcbMateria.setSelectedIndex(-1);
        
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int f, int c) {
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
        jcbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumno = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Listado Alumno Por Materia");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione una Materia:");

        jcbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new Materia[] {}));
        jcbMateria.setSelectedIndex(-1);
        jcbMateria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMateriaItemStateChanged(evt);
            }
        });

        jtAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtAlumno);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jbSalir)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalir)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMateriaItemStateChanged
        try {
            borrarFilas();
        
            Materia materiaSeleccionada = (Materia) jcbMateria.getSelectedItem();

            ArrayList<Alumno> alumnos = (ArrayList<Alumno>) inscData.obtenerAlumnosXMateria(materiaSeleccionada.getIdMateria());

            for (Alumno alumno : alumnos) {
                modelo.addRow(new Object[] {alumno.getIdAlumno(), alumno.getDni(), alumno.getApellido(), alumno.getNombre()});
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jcbMateriaItemStateChanged

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    private void cargarCombo() {
        for (Materia materia : listaMaterias) {
            jcbMateria.addItem(materia);
        }
    }
    
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        
        jtAlumno.setModel(modelo);
    }
    
    private void borrarFilas() {
        DefaultTableModel modelo = (DefaultTableModel) jtAlumno.getModel();
        modelo.setRowCount(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcbMateria;
    private javax.swing.JTable jtAlumno;
    // End of variables declaration//GEN-END:variables
}
