/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import negocio.*;

/**
 *
 * @author iapereira
 */
public class Comanda {

    private int numero;
    private Cliente cliente;
    private Garcom garcom;
    private ArrayList<Bebida> vetBebida;
    private ArrayList<Prato> vetPrato;
    private ArrayList<Sobremesas> vetSobremesas;
    private ArrayList<Saladas> vetSaladas;
    private boolean tem10Porcento;
    private double somatorio;

    
    public Comanda() {
        this.tem10Porcento = true;
        this.vetBebida = new ArrayList();
        this.vetPrato = new ArrayList();
        
    }

    public Comanda(int numero, Cliente cliente, Garcom garcom, ArrayList<Bebida> vetBebida, ArrayList<Prato> vetPrato, ArrayList<Sobremesas> vetSobremesas, ArrayList<Saladas> vetSaladas, boolean tem10Porcento, double somatorio) {
        this.numero = numero;
        this.cliente = cliente;
        this.garcom = garcom;
        this.vetBebida = vetBebida;
        this.vetPrato = vetPrato;
        this.vetSobremesas = vetSobremesas;
        this.vetSaladas = vetSaladas;
        this.tem10Porcento = tem10Porcento;
        this.somatorio = somatorio;
    }

    public Comanda(double somatorio) {
        this.somatorio = somatorio;
    }

    public boolean isTem10Porcento() {
        return tem10Porcento;
    }

    public void setTem10Porcento(boolean tem10Porcento) {
        this.tem10Porcento = tem10Porcento;
    }

    public ArrayList<Sobremesas> getVetSobremesas() {
        return vetSobremesas;
    }

    public void setVetSobremesas(ArrayList<Sobremesas> vetSobremesas) {
        this.vetSobremesas = vetSobremesas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public ArrayList<Bebida> getVetBebida() {
        return vetBebida;
    }

    public void setVetBebida(ArrayList<Bebida> vetBebida) {
        this.vetBebida = vetBebida;
    }

    public ArrayList<Prato> getVetPrato() {
        return vetPrato;
    }

    public void setVetPrato(ArrayList<Prato> vetPrato) {
        this.vetPrato = vetPrato;
    }

    public ArrayList<Saladas> getVetSaladas() {
        return vetSaladas;
    }

    public void setVetSaladas(ArrayList<Saladas> verSaladas) {
        this.vetSaladas = verSaladas;
    }

    public double obtemTotal() {
        double total = 0;
        for (int i = 0; i < vetBebida.size(); i++) {
            Bebida bebida = vetBebida.get(i);
            total += bebida.getPreco();

        }

        for (int i = 0; i < vetPrato.size(); i++) {
            Prato prato = vetPrato.get(i);
            total += prato.getPreco();

        }

        if (tem10Porcento) {
            return total * 1.10;
        }

        return total;
    }

    public double getSomatorio() {
        return somatorio;
    }

    public void setSomatorio(double somatorio) {
        this.somatorio = somatorio;
    }

   

}
