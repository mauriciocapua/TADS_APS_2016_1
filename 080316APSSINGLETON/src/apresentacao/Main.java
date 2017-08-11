/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import persistencia.Conexao;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        // com o padrao singleton        
        Conexao conexao1 =  Conexao.getInstance();
        System.out.println("Conexao1:"+conexao1.hashCode());
        
        Conexao conexao2 = Conexao.getInstance();
        System.out.println("Conexao2:"+conexao2.hashCode());
        */
        
       // sem o padrao singleton
        /*
        Conexao conexao3 = new Conexao();
        System.out.println("Conexao3:"+conexao3.hashCode());
        
        Conexao conexao4 = new Conexao();
        System.out.println("Conexao4:"+conexao4.hashCode());
        */
        
        //Conexao conexao5 =  Conexao.getInstance();
        //Conexao conexao6 = conexao5.
        
    }
    
}
