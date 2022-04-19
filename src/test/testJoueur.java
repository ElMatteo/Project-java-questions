package test;
import data.joueurs.Joueur;

public class testJoueur {
    public static void main(String[] args)
    {
       Joueur j1= new Joueur("hamza");
       Joueur j2= new Joueur("antoine");

        System.out.println(j1);
        j1.setEtat("Gagnant");
        j1.augmentationScore(30);
        System.out.println(j2);
        System.out.println(j1);


    }

}
