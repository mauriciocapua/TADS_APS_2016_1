/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Strategy;

/**
 *
 * @author Mauricio Capua
 */
public abstract class Produto {

    private String nome;
    private Double preco;
    private Promocao p;
    private String pagamento;

    public Produto() {

    }

    ;
    
    public Produto(String nome, Double preco, Promocao p) {
        this.nome = nome;
        this.preco = preco;
        this.p = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        if (this.p != null) {
            this.preco = p.Descontar(preco);
        }
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Promocao getP() {
        return p;
    }

    public void setP(Promocao p) {
        this.p = p;
    }

    public String getPagamento() {

        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

}
