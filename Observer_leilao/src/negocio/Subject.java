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
public interface Subject {

    public void subscribeParticipante(Participante observer);

    public void unscribeParticipante(int i);

    public void notifyObservers();
}
