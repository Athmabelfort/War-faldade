package models;

import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    final private String imagemOraculo = "models/oraculo.png";
    final private String imagemGuerreiro = "https://pt.pngtree.com/free-picture";

    public Oraculo(Guerreiro warrior){
        this.warrior = warrior;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public int sortearVIdas(){
        var limiteMaximo = 12;
        var limiteMinimo = 9;
        return new Random().nextInt((limiteMaximo - limiteMinimo) + 1) + limiteMinimo;
    }

    public String prologoIntroducao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- PRÓLOGO --");
        System.out.println("\nQual o seu nome Guerreiro?");
        var nomeGuerreiro = scanner.nextLine();
        warrior.setNome(nomeGuerreiro);
        var vidasGuerreiro = sortearVIdas();
        warrior.setQtdVidas(vidasGuerreiro);

        return "Nome do Guerreiro " + warrior.getNome() + " | Quantidade de vida do guerreiro: " + warrior.getQtdVidas() + "| Nome do Oráculo " + this.nome;
    }
    
    public String prologoPerdedor(){
        return "perdedor";
    }
    
    public String prologoVencedor(){
        return "Vencedor";
    }
    
    public boolean loadLevel01(){
        int min = 1;
        int max = 100;
        int vida = warrior.getQtdVidas();
        Random r = new Random();
        var numeroAleatorio = r.nextInt((max - min) + 1) + min;

        while(warrior.getQtdVidas() > 0){
            var lerInt =  InOut.leInt("Digite o numero secreto!");
            InOut.MsgDeInformacao("Espero ter acertado!","", imagemGuerreiro);
            if(lerInt == numeroAleatorio){
                return true;
            } else if(lerInt < numeroAleatorio){
                vida -= 1;
               InOut.MsgDeInformacao("OPA", "O número secreto é maior que o seu chute.", imagemOraculo);
            } else {
                vida -= 1;
                InOut.MsgDeInformacao("OPA", "O número secreto é menor que seu chute.", imagemOraculo);
            }
        }
        return false;
    }
    
    public boolean loadLEvel02(){
        return true;
    }
    
    public boolean decidirVidaExtra(String misericordia){
        return misericordia.length() > 5;
    }

    public String RelatorioFimGame(){
        return "fim";
    }
}
