/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class Leilao implements Subject {

    private double lance = 0;
    private ArrayList<Participante> Participantes_array = new ArrayList<>();
    private Participante Participante_maiorlance = new Participante();

    public void Maior_lance() {
        for (int i = 0; i < Participantes_array.size(); i++) {
            if (Participantes_array.get(i).getLance_Participante() > lance) {
                setLance(Participantes_array.get(i).getLance_Participante());
                Participante_maiorlance = Participantes_array.get(i);
            }
        }
        notifyObservers();
    }

    @Override
    public void subscribeParticipante(Participante observer
    ) {
        Participantes_array.add(observer);
    }

    @Override
    public void unscribeParticipante(int i
    ) {
        Participantes_array.remove(i);
    }

    @Override
    public void notifyObservers() {
        Participante participante = null;
        for (int i = 0; i < Participantes_array.size(); i++) {
            participante = Participantes_array.get(i);
            participante.update(Participante_maiorlance.getNome(), Participante_maiorlance.getLance_Participante());
        }

    }

    public double getLance() {
        return lance;
    }

    public void setLance(double lance) {
        this.lance = lance;
    }

    public ArrayList<Participante> getParticipantes_array() {
        return Participantes_array;
    }

    public void setParticipantes_array(ArrayList<Participante> Participantes_array) {
        this.Participantes_array = Participantes_array;
    }

    public Participante getParticipante_maiorlance() {
        return Participante_maiorlance;
    }

    public void setParticipante_maiorlance(Participante Participante_maiorlance) {
        this.Participante_maiorlance = Participante_maiorlance;
    }

}
