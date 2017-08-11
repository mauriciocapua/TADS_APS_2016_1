/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Decorator;

import java.util.Random;

/**
 *
 * @author Mauricio Capua
 */
public abstract class Cargo {

    //protected String[] nomes = {"John", "Arthur", "Ed", "Sam", "Dexter"};
    private String nome;
    private double inicial = 500;
    private Double salario;

    public Cargo() {

    }

    public Cargo(String nome) {

        this.nome = nome;
    }

    public Cargo(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void Mostrar() {
        System.out.println("Funcionario: " + getNome() + " Salário: " + getSalario());
    }

    public double getInicial() {
        return inicial;
    }

}
