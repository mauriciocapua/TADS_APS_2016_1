/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

/**
 *
 * @author Mauricio Capua
 */
public class TrabalhodoIgor extends Tarefa {
    
    private String trabalho;
    
    public TrabalhodoIgor(String trabalho) {
        this.trabalho = trabalho;
    }
    
    public TrabalhodoIgor() {
    }
    
    public void on() {
        setTrabalho(trabalho);
        System.out.println("Fazendo o trabalho " + this.trabalho + " do Igor");
    }
    
    public void off() {
        if (trabalho == null) {
            System.out.println("Desisti do trabalho do Igor ¯\\_(ツ)_/¯");
        } else {
            System.out.println("Desisti do trabalho " + this.trabalho + " do Igor ¯\\_(ツ)_/¯");
        }
    }
    
    public void setTrabalho(String trabalho) {
        if (trabalho == null) {
            this.trabalho = "";
        } else {
            this.trabalho = trabalho;
        }
        
    }
    
}
