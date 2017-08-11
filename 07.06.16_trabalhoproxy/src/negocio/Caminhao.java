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
public class Caminhao extends Veiculo {

    public Caminhao(String modelo, String marca, int ano, String placa, String chassi) {
        super(modelo, marca, ano, placa, chassi);
    }

    @Override
    public void manobrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
