/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author iapereira
 */
public class Conexao {
    private static Conexao conexao = new Conexao();
    private String host;
    private String port;
    private String usuario;
    private String senha;
    
    
    private Conexao(){
        
    }
    
    
    public static synchronized Conexao getInstance(){
        if (conexao == null){
            conexao = new Conexao();
        }
        return conexao;
    }
    
    
}
