package models;

import java.util.Random;
import java.util.Scanner;

public class Oraculo {
    private static final Scanner scanner = new Scanner(System.in);
    private String nome;
    private Guerreiro warrior;
    final private String imagemOraculo = "C:\\Users\\athma\\Desktop\\WarProject\\RPGWar\\src\\originaloraculo.png";
    final private String imagemGuerreiro = "C:\\Users\\athma\\Desktop\\WarProject\\RPGWar\\src\\originalguerreiro.png";

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
        System.out.println("-- PRÓLOGO --");
        var nomeGuerreiro = InOut.leString("Qual o seu nome Guerreiro:");
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
        InOut.MsgDeInformacao("LEVEL 01", "Você agora está no primeiro nivel!", imagemOraculo);

        while(vida > 0){
            var lerInt = InOut.leInt("Digite o numero secreto!");
            InOut.MsgDeInformacao("!!!!!!!!", "Espero ter acertado!", imagemGuerreiro);
            if(lerInt == numeroAleatorio){
                return true;
            } else if(lerInt < numeroAleatorio){
                vida -= 1;
                warrior.setQtdVidas(vida);
                InOut.MsgDeInformacao("OPA", "O número secreto é maior que o seu chute.", imagemOraculo);
            } else {
                vida -= 1;
                warrior.setQtdVidas(vida);
                InOut.MsgDeInformacao("OPA", "O número secreto é menor que seu chute.", imagemOraculo);
            }
        }
        return false;
    }
    
    public boolean loadLevel02(){
        InOut.MsgDeInformacao("LEVEL 02", "Você agora está no segundo nivel, Guerreiro!", imagemOraculo);
        InOut.MsgDeInformacao("CHARADAS", "Responda as 3 charadas e você poderá passar para o próximo nível", imagemOraculo);

        int vida = warrior.getQtdVidas();

//        while(vida > 0){
//            while()
//        }

        return false;
    }

    public boolean loadLevel03(){
        InOut.MsgDeInformacao("LEVEL 03", "------", imagemOraculo);
        return false;
    }
    
    public boolean decidirVidaExtra(String misericordia){
        return misericordia.length() > 5;
    }

    public String RelatorioFimGame(){
        return "fim";
    }
}
