package test;
import data.joueurs.Joueur;
import data.joueurs.Joueurs;
import data.themes.Themes;
import phases.Phase1;
import phases.Phase2;
import phases.Phase3;
import tools.ChargementQuestion;

import java.awt.desktop.SystemEventListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Joueurs joueurs = new Joueurs(20);
        Joueurs GagnantsP1 = new Joueurs(5);
        Joueurs GagnantsP2 = new Joueurs(2);
        Joueurs perdants = new Joueurs(19);
        Joueur grandGagnant;
        Themes themes = ChargementQuestion.recuperationThemes("src/Files/Themes.txt");

        if (themes.getTaille() < 10) {
            System.err.println("il faut au moins 10 thèmes pour commencer une partie");
            System.exit(1);
        }

        for (int i = 0; i < 20; i++) { //Création des Joueurs
            joueurs.ajoutJoueur(new Joueur(Character.toString((char) i + 65)));      //ajout Joueur automatique
            //joueurs.ajoutJoueurSaisie();   // ajout avec saisie des joueurs
        }
        ArrayList<Phase1> phase1 = new ArrayList<>();

        System.out.println("début de la phase 1\n------------------------------------------------------");
        for (int i = 0; i < 5; i++) {//Phase 1
            phase1.add(new Phase1(themes.selectXthemes(10)));
            phase1.get(i).selectPlayers(joueurs);
            phase1.get(i).playPhase();
            GagnantsP1.ajoutJoueur(phase1.get(i).gagnant());

            for (Joueur j : phase1.get(i).perdants().getJoueurs()) {
                perdants.ajoutJoueur(j);
            }
        }
        System.out.println("les gagnants de la pahse 1 sont :");
        System.out.println(GagnantsP1);


        System.out.println("début de la phase 2\n------------------------------------------------------");
        //Phase2
        Phase2 p2 = new Phase2(themes.selectXthemes(10));
        p2.selectPlayers(GagnantsP1);
        p2.playPhase();
        GagnantsP2 = p2.gagnant();
        for (Joueur j: p2.perdants().getJoueurs()) {
            perdants.ajoutJoueur(j);
        }
        System.out.println("les gagnants de la pahse 2 sont :");
        System.out.println(GagnantsP2);

        System.out.println("début de la phase 1\n------------------------------------------------------");
        Phase3 p3 = new Phase3(themes.selectXthemes(3));
        p3.selectPlayers(GagnantsP2);
        p3.playPhase();
        grandGagnant = p3.gagnant();
        perdants.ajoutJoueur(p3.perdant());


        System.out.println("le grand Gagnant est :" + grandGagnant.getNom());




    }
    // write your code here
}