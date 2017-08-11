/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

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
public abstract class EmailMolde {

    protected String destinatario = "";
    protected String assunto = "";
    protected String texto_email = "";

    public EmailMolde() {

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

    public boolean Envio(String destinatario, String assunto, String texto) {
        if (destinatario == null) {
            destinatario = "";
        }
        if (assunto == null) {
            assunto = "";
        }
        if (texto == null) {
            texto = "";
        }
        boolean retorno = false;
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email","senha");
            }
        });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("email")); //Remetente

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)); //Destinatário(s)
            message.setSubject(assunto);//Assunto
            message.setText(texto);
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            retorno = true;
        } catch (MessagingException e) {
            new RuntimeException(e);

        }
        return retorno;
    }
}
