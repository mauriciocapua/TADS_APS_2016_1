/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Mauricio Capua
 */
public class Gerenciamento implements Iveiculo {

    private Veiculo veiculo;
    private Funcionario funcionario;

    public Gerenciamento(Veiculo veiculo, Funcionario funcionario) {
        this.veiculo = veiculo;
        this.funcionario = funcionario;
    }

    @Override
    public void manobrar() {
        Period p = Period.between(funcionario.getData_nascimento(), LocalDate.now());
        if (!funcionario.getCnh().isEmpty() && p.getYears() >= 18) {
            System.out.println(funcionario.getNome() + " habilitado para dirigir o veículo: " + veiculo.toString());
        } else {
            System.out.println(funcionario.getNome() + " não habilitado para dirigir");
        }
    }

}
