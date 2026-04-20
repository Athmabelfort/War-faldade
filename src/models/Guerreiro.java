package models;

public class Guerreiro {
    private String nome;
    private int qtdVidas;
    private Bolsa myBolsa;

    public Guerreiro() {
    }

    public Guerreiro(String nome, int vidas, Bolsa myBolsa){
        this.nome = nome;
        this.qtdVidas = vidas;
        this.myBolsa = myBolsa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    public Bolsa getMyBolsa() {
        return myBolsa;
    }

    public void setMyBolsa(Bolsa myBolsa) {
        this.myBolsa = myBolsa;
    }

    public String vidaExtra(){
        return "vida extra";
    }
}
