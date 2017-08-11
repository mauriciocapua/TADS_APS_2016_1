package negocio;

import java.util.ArrayList;

public class Dados {

    protected int codigo;
    protected ArrayList<String> titulo = new ArrayList<>();
    protected String publicacao;
    protected String editora;
    protected String autores;
    protected String formatoCapa;
    protected String valorCapa;

    public Dados(int codigo, String publicacao, String editora, String autores, String formatoCapa, String valorCapa) {
        this.codigo = codigo;
        this.publicacao = publicacao;
        this.editora = editora;
        this.autores = autores;
        this.formatoCapa = formatoCapa;
        this.valorCapa = valorCapa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<String> getTitulo() {
        return titulo;
    }

    public void setTitulo(ArrayList<String> titulo) {
        this.titulo = titulo;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getFormatoCapa() {
        return formatoCapa;
    }

    public void setFormatoCapa(String formatoCapa) {
        this.formatoCapa = formatoCapa;
    }

    public String getValorCapa() {
        return valorCapa;
    }

    public void setValorCapa(String valorCapa) {
        this.valorCapa = valorCapa;
    }

}
