/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.email.Email;
import negocio.sms.*;
import negocio.email.*;

/**
 *
 * @author Mauricio Capua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        SMS sms = new SMS("destino", "origem", "mensagensasdasbhdasdhasdkjasjdjadasdasdknlasdknlasknldsakndaskndknlasdknasndasknldsknladknlasnldasdknlasndklasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeasdasudhasdusadasuhdasdasdasuhduhashduasuhdsuhdhuasdashdasduhasuhduhasdauhdhasudiasuhdaiusdhasiudhasiduhaidasuhdasidhasdashdiuasduhiasuhdasiuduahdasudaudihaudhuauhddasuhdadasudasuduase");
        /*OperadoraSMS operadora = new OperadoraSMS();
        operadora.sendSMS(sms);*/

        /*OperadoraNovaSMS operadora2 = new OperadoraNovaSMS();
        SMSAdapter adapter = new SMSAdapter(operadora2);
        adapter.sendSMS(sms);*/

        //////////////////////////////////////////////////////////////////////////////////
        Email email = new Email(email, "assunto", "mensagensasasdasdasdasdjasdijoasdijasjdijasdijaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasijdjasidijasijodijoasdijoasijodijasodijoasijodasddasbhdasdhasdkjasjdjadasdasdknlasdknlasknldsakndaskndknlasdknasndasknldsknladknlasnldasdknlasndklasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        OperadoraNovaEmail operadoraemail = new OperadoraNovaEmail();
        EmailAdapter emailAdapter = new EmailAdapter(operadoraemail);
        emailAdapter.sendEmail(email);
    }

}
