/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Ventana1;
import vista.Vista;

/**
 *
 * @author Cristian
 */
public class Controlador implements ActionListener {

    Vista view;
    Modelo model;
    Ventana1 ayuda;

    public Controlador() {
        view = new Vista();
        model = new Modelo();
        ayuda = new Ventana1();
        view.setTitle("Ordenamiento de Txt");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.getBotonabrir().addActionListener(this);
        view.getBotonayuda().addActionListener(this);
        ayuda.getBotondevolver().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBotonayuda()) {
            ayuda.setTitle("ayuda");
            ayuda.setLocationRelativeTo(null);
            ayuda.setVisible(true);
            view.dispose();
        }
        if (e.getSource() == ayuda.getBotondevolver()) {
            view.setLocationRelativeTo(null);
            ayuda.dispose();
            view.setVisible(true);
        }
        if (view.Mburbuja.isSelected() == true) {
            if (view.Mayme.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {

                    model.burbujaMm(model.AbrirArchivo(), model.getArchivo());
                }
            }
            if (view.Memay.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    model.burbujamM(model.AbrirArchivo(), model.getArchivo());
                }
            }
        }
        if (view.Mseleccion.isSelected() == true) {
            if (view.Mayme.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    JOptionPane.showMessageDialog(null, "NOTA: esta metodo se encuentra en desarrollo, seleccione Menor a Mayor");
                }
            }
            if (view.Memay.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    model.seleccionsortmM(model.AbrirArchivo(), model.getArchivo());
                }
            }
        }
        if (view.Mquicksort.isSelected() == true) {
            if (view.Mayme.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    model.quicksortMm(model.AbrirArchivo(), model.getArchivo());
                }
            }
            if (view.Memay.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    JOptionPane.showMessageDialog(null, "NOTA: este metodo se encuentra en desarrollo, seleccione Mayor a Menor");
                }
            }
        }
        if (view.Minsercion.isSelected() == true) {
            if (view.Mayme.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    JOptionPane.showMessageDialog(null, "NOTA: este metodo se encuentra en desarrollo, seleccione Menor a Mayor");
                }
            }
            if (view.Memay.isSelected() == true) {
                if (e.getSource() == view.getBotonabrir()) {
                    model.insercionmM(model.AbrirArchivo(), model.getArchivo());
                }
            }
        }
    }

}
