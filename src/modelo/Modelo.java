/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class Modelo {

    private FileInputStream entrada;
    private FileOutputStream salida;
    private File archivo;
    private JFileChooser seleccionado = new JFileChooser();
    private int numeroEntero;
    private int cont = 0;
    private FileWriter fichero = null;
    private FileWriter escribir = null;
    private PrintWriter pw;
    private BufferedReader br = null;
    private FileReader fr = null;
    private String texto;
    private int i, j, temp = 0;
    private boolean flag = true;
    private int tamaño = 0;
    private String textot;
    private int p;   
    
   
    private int[] array;

    private int aux;

    public FileWriter getEscribir() {
        return escribir;
    }

    public void setEscribir(FileWriter escribir) {
        this.escribir = escribir;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getTextot() {
        return textot;
    }

    public void setTextot(String textot) {
        this.textot = textot;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public JFileChooser getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(JFileChooser seleccionado) {
        this.seleccionado = seleccionado;
    }

    public FileWriter getFichero() {
        return fichero;
    }

    public void setFichero(FileWriter fichero) {
        this.fichero = fichero;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public Modelo() {
        this.pw = null;
    }

    public FileInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(FileInputStream entrada) {
        this.entrada = entrada;
    }

    public FileOutputStream getSalida() {
        return salida;
    }

    public void setSalida(FileOutputStream salida) {
        this.salida = salida;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public int getNumeroEntero() {
        return numeroEntero;
    }

    public void setNumeroEntero(int numeroEntero) {
        this.numeroEntero = numeroEntero;
    }

    public int getIterador() {
        return cont;
    }

    public void setIterador(int iterador) {
        this.cont = iterador;
    }

    public int[] AbrirArchivo() {
        if (seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(archivo));
                        BufferedReader br2 = new BufferedReader(new FileReader(archivo));
                        texto = br.readLine();
                        textot = br2.readLine();
                        FileReader f = new FileReader(archivo);
                        BufferedReader b = new BufferedReader(f);
                        while (textot != null) {
                            textot = br2.readLine();
                            tamaño++;
                        }
                        array = new int[tamaño];
                        while (texto != null) {
                            array[cont] = Integer.parseInt(texto);
                            // System.out.println("Dato.. " + texto + " - Posicion.. " + cont);
                            texto = br.readLine();
                            cont++;
                        }
                        b.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: Fichero no encontrado");
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error de lectura del fichero");
                        System.out.println(e.getMessage());
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de texto con los numeros");
                }
            }

        }
        return array;
    }

    public void burbujaMm(int array[], File archivo) {
        JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el txt ordenado");
        if (seleccionado.showDialog(null, "Guardar texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                for (i = 1; i < array.length; i++) {
                    for (i = 1; i < array.length; i++) {
                        for (j = 0; j < array.length - 1; j++) {
                            if (array[j] < array[j + 1]) {
                                temp = array[j];
                                array[j] = array[j + 1];
                                array[j + 1] = temp;
                            }
                        }
                    }
                }
                try {
                    FileWriter fichero = null;
                    fichero = new FileWriter(archivo, true);
                    PrintWriter pw = null;
                    pw = new PrintWriter(archivo);
                    for (int i = 0; i < array.length; i++) {
                        pw.println(array[i]);
                    }
                    fichero.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Error al imprimir archivo" + e);
                }
            }

        }
    }

    public void burbujamM(int array[], File archivo) {
        JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el txt ordenado");
        if (seleccionado.showDialog(null, "Guardar texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                for (i = 1; i < array.length; i++) {
                    for (j = 0; j < array.length - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                try {
                    FileWriter fichero = null;
                    fichero = new FileWriter(archivo, true);
                    PrintWriter pw = null;
                    pw = new PrintWriter(archivo);
                    for (int i = 0; i < array.length; i++) {
                        pw.println(array[i]);
                    }
                    fichero.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Error al imprimir archivo" + e);
                }
            }

        }
    }

    public void seleccionsortmM(int array[], File archivo) {
        JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el txt ordenado");
        if (seleccionado.showDialog(null, "Guardar texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                int i, j, menor, pos, tmp;
                for (i = 0; i < array.length - 1; i++) {      
                    menor = array[i];                                
                    pos = i;                            
                    for (j = i + 1; j < array.length; j++) { 
                        if (array[j] < menor) {           
                            menor = array[j];             
                            pos = j;
                        }
                    }
                    if (pos != i) {                                              
                        tmp = array[i];
                        array[i] = array[pos];
                        array[pos] = tmp;
                    }
                }
                try {
                    FileWriter fichero = null;
                    fichero = new FileWriter(archivo, true);
                    PrintWriter pw = null;
                    pw = new PrintWriter(archivo);
                    for (int u = 0; u < array.length; u++) {
                        pw.println(array[u]);
                    }
                    fichero.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Error al imprimir archivo" + e);
                }
            }
        }
    }
    public void quicksortMm(int array[], File archivo) {
        JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el txt ordenado");
        if (seleccionado.showDialog(null, "Guardar texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
               Arrays.sort(array);
                try {
                    FileWriter fichero = null;
                    fichero = new FileWriter(archivo, true);
                    PrintWriter pw = null;
                    pw = new PrintWriter(archivo);
                    for (int u = 0; u < array.length; u++) {
                        pw.println(array[u]);
                    }
                    fichero.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Error al imprimir archivo" + e);
                }
            }
        }
    }

    public void insercionmM(int array[], File archivo) {
        JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el txt ordenado");
        if (seleccionado.showDialog(null, "Guardar texto") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                for (p = 1; p < array.length; p++) { 
                    aux = array[p];           
                    j = p - 1;            
                    while ((j >= 0) && (aux < array[j])) { 
                        array[j + 1] = array[j];   
                        j--;             
                    }
                    array[j + 1] = aux;      
                }
                try {
                    FileWriter fichero = null;
                    fichero = new FileWriter(archivo, true);
                    PrintWriter pw = null;
                    pw = new PrintWriter(archivo);
                    for (int i = 0; i < array.length; i++) {
                        pw.println(array[i]);
                    }
                    fichero.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Error al imprimir archivo" + e);
                }
            }
        }
    }
}
