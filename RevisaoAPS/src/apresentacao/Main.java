/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Bebida;
import negocio.Cliente;
import negocio.Comanda;
import negocio.Garcom;
import persistencia.BebidaDAO;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        /*
        Bebida schin = new Bebida();
        schin.setMarca("Schin");
        schin.setTipo("Cerveja");
        schin.setVolume(350);
        schin.setPreco(5.0);

        Bebida coca = new Bebida();
        coca.setMarca("CocaCola");
        coca.setTipo("Refri");
        coca.setVolume(350);
        coca.setPreco(3.0);

        Garcom garcom = new Garcom();
        garcom.setNome("Mifael");

        //Comanda cliente 1
        Comanda comanda1 = new Comanda();
        //comanda1.setTem10Porcento(true);
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Igor");
        comanda1.setCliente(cliente1);
        comanda1.setGarcom(garcom);
        comanda1.getVetBebida().add(schin);
        comanda1.getVetBebida().add(coca);
        System.out.println("Total:" + comanda1.obtemTotal());
        System.out.printf("%.2f", comanda1.obtemTotal());
        System.out.println("");

        //Comanda cliente 2
        Comanda comanda2 = new Comanda();
        comanda2.setTem10Porcento(false);
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Monica");
        comanda2.setCliente(cliente2);
        comanda2.setGarcom(garcom);
        comanda2.getVetBebida().add(coca);

        //System.out.println("Total:"+comanda2.obtemTotal());
        System.out.printf("%.2f", comanda2.obtemTotal());
        System.out.println("");
*/
        
        BebidaDAO bebidaDAO = new BebidaDAO();
        ArrayList<Bebida> vetBebida = bebidaDAO.listar();
        for (int i = 0; i < vetBebida.size(); i++) {
            Bebida bebida = vetBebida.get(i);
            System.out.println("Bebida "+(i+1)+" do banco:"+bebida.getMarca());
        }
        
        bebidaDAO.deletar(3);
        
        //Bebida novaBebida = new Bebida();
        //novaBebida.setMarca("Natasha");
        //novaBebida.setPreco(100.0);
        //novaBebida.setTipo("Vodka");
        //novaBebida.setVolume(1000);
        //bebidaDAO.inserir(novaBebida);
    }

}
