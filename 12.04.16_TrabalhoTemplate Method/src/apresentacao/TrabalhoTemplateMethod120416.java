/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.HTML;
import negocio.Sql;
import negocio.Template;
import negocio.Texto_Plano;
import negocio.Xml;

/**
 *
 * @author Mauricio Capua
 */
public class TrabalhoTemplateMethod120416 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Template teste_txt = new Texto_Plano();
        teste_txt.parseDataAndGenerateOutput();
        Template teste_sql = new Sql();
        teste_sql.parseDataAndGenerateOutput();
        Template teste_html = new HTML();
        teste_html.parseDataAndGenerateOutput();
        Template teste_xml = new Xml();
        teste_xml.parseDataAndGenerateOutput();

    }

}
