/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Observer;

import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class Telefone {

    protected boolean toque;
    protected ArrayList<Observer> Observadores = new ArrayList<>();

    public Telefone() {

    }

    public void TelefoneToca() {
        if (isToque() == true) {
            notifyObservers();
        } else {
            System.out.println("Silencio...");
        }

    }

    public void subscribeObservador(Observer observador
    ) {
        Observadores.add(observador);
    }

    public void unscribeObservador(int i
    ) {
        Observadores.remove(i);
    }

    public void notifyObservers() {
        //Participante participante = null;
        for (int i = 0; i < Observadores.size(); i++) {

            Observadores.get(i).update();
        }

    }

    public boolean isToque() {
        return toque;
    }

    public void setToque(boolean toque) {
        this.toque = toque;
    }

    public ArrayList<Observer> getObservadores() {
        return Observadores;
    }

    public void setObservadores(ArrayList<Observer> Observadores) {
        this.Observadores = Observadores;
    }

}
