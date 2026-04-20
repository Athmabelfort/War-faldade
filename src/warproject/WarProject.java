package warproject;

import models.Guerreiro;
import models.Oraculo;

public class WarProject {

    public static void main(String[] args) {
        Guerreiro guerreiro1 = new Guerreiro();
        Oraculo oraculo = new Oraculo(guerreiro1);
        oraculo.definirNome("Java");
        System.out.println(oraculo.prologoIntroducao());
        var level1 = oraculo.loadLevel01();
        if(level1){

        }


    }
}
