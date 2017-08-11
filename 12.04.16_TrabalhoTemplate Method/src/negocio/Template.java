/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public abstract class Template {

    private ArrayList<Dados> dados;
    protected ArrayList<String> saida = new ArrayList<>();
    protected String extensao = "";

    public final void parseDataAndGenerateOutput() {
        readData();
        processData(dados);
        writeData(extensao, saida);
    }

    private void readData() {
        dados = new ArrayList<>();
        String csvFile = "Pasta1.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] coluna = line.split(cvsSplitBy);
                dados.add(new Dados(coluna[0], coluna[1], coluna[2]));
            }
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
    }

    protected abstract void processData(ArrayList<Dados> dados);

    private void writeData(String extensao, ArrayList<String> saida) {
        try (FileWriter arq = new FileWriter("teste_" + extensao + "." + extensao)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            for (int i = 0; i < saida.size(); i++) {
                gravarArq.println(saida.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

}
