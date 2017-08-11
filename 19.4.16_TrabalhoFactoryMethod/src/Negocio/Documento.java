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
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Capua
 */
public abstract class Documento {

    ModeloDocumento documento = new ModeloDocumento();
    String caminho;

    public abstract void criadocumento();

    public void abrearquivo(String caminho) {

        String doc = caminho;
        BufferedReader br = null;
        String line = "";
        documento.setTexto("");

        try {

            br = new BufferedReader(new FileReader(doc));
            while ((line = br.readLine()) != null) {

                documento.setTexto(documento.getTexto() + "\n" + line);

            }
            this.caminho = caminho;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(documento.getTexto());

    }

    public void gravaarquivo() {
        String nome = JOptionPane.showInputDialog("informe o nome do arquivo:");
        try (FileWriter arq = new FileWriter(nome + documento.getExtensão())) {
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.println(documento.getTexto());

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

}
