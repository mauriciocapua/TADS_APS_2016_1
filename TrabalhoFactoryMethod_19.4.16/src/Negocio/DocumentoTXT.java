/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Capua
 */
public class DocumentoTXT extends Documento {

    @Override
    public void criadocumento() {
        documento.setExtensão(".txt");
        documento.setTexto(JOptionPane.showInputDialog("informe o texto: "));
    }

}
