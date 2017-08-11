/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Mauricio Capua
 */
public class Participante {

    private double lance_Participante = 0;
    private String nome = null;

    public void update(String nome, double maior_lance) {
        System.out.println(this.nome+":Participante" + nome + " - maior lance: " + maior_lance);
    }
    
    public Participante(){
        
    }

    public Participante(double lance_Participante, String nome) {
        this.lance_Participante = lance_Participante;
        this.nome = nome;
    }

    public double getLance_Participante() {
        return lance_Participante;
    }

    public void setLance_Participante(double lance_Participante) {
        this.lance_Participante = lance_Participante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
