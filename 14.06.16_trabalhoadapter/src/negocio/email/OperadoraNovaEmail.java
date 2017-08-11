/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.email;

import java.util.Properties;
import negocio.sms.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class OperadoraNovaEmail implements EnviadorEmail {

    @Override
    public void enviarEmail(String destino, String assunto, String[] mensagem) throws Exception {

        for (int i = 0; i < mensagem.length; i++) {
            //System.out.println("Enviando sms: " + destino + " " + origem + " " + mensagens[i]);
            if (destino == null) {
                destino = "";
            }
            if (assunto == null) {
                assunto = "";
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
                    return new PasswordAuthentication("email", "senha");
                }
            });

            session.setDebug(true);

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("email")); //Remetente

                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(destino)); //Destinatário(s)
                message.setSubject(assunto);//Assunto
                message.setText(mensagem[i]);
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);
                retorno = true;
            } catch (MessagingException e) {
                new RuntimeException(e);

            }
        }
    }

}
