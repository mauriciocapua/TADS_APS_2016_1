/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mauricio Capua
 */
public class Email {

    private String destinatario = "";
    private String assunto = "";
    private String texto_email = "";

    public Email() {
    }

    public Email(String destinatario, String assunto, String texto_email) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.texto_email = texto_email;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto_email() {
        return texto_email;
    }

    public void setTexto_email(String texto_email) {
        this.texto_email = texto_email;
    }

}
