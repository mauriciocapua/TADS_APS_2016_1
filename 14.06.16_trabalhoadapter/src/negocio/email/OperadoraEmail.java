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
public class OperadoraEmail implements EmailSender {

    @Override
    public boolean sendEmail(Email email) {

        if (email.getDestinatario() == null) {
            email.setDestinatario("");
        }
        if (email.getAssunto() == null) {
            email.setAssunto("");
        }
        if (email.getTexto_email() == null) {
            email.setTexto_email("");
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
                return new PasswordAuthentication("EMAIL", "SENHA");
            }
        });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("EMAIL")); //Remetente

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getDestinatario())); //Destinatário(s)
            message.setSubject(email.getAssunto());//Assunto
            message.setText(email.getTexto_email());
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
