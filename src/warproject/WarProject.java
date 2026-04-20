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
        if(!level1)
            System.out.println(oraculo.prologoPerdedor());
         else {
            System.out.println("Você acertou! Avançando para o próximo nível...");
            var level2 = oraculo.loadLevel02();
            if (!level2)
                System.out.println(oraculo.prologoPerdedor());
            else {
                var level3 = oraculo.loadLevel03();
                if(!level3)
                    System.out.println(oraculo.prologoPerdedor());
                oraculo.prologoVencedor();
            }
        }

    }
}
