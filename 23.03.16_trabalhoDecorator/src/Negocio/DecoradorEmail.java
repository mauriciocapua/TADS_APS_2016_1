/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mauricio Capua
 */
public abstract class DecoradorEmail extends EmailMolde {

    protected EmailMolde email;

    public DecoradorEmail(EmailMolde email) {
        this.email = email;
    }
}
