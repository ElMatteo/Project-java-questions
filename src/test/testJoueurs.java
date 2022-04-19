package test;
import data.joueurs.Joueur;
import data.joueurs.Joueurs;


import java.util.Arrays;

public class testJoueurs {
    public static void main(String[] args) {


        Joueurs js = new Joueurs(20);
        Joueur newJ;


        for (int i = 0; i < 20; i++) {
            newJ = new Joueur(Character.toString((char) i + 65));
            newJ.augmentationScore(20-i);
            js.ajoutJoueur(newJ);

        }

        System.out.println(js.getJoueurs().length);
        System.out.println(js);
        Arrays.sort(js.getJoueurs());
        System.out.println(js);
    }

}
