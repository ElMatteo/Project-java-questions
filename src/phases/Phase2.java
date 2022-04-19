package phases;

import data.joueurs.Joueur;
import data.joueurs.Joueurs;
import data.themes.Theme;
import data.themes.Themes;

import java.util.Arrays;

public class Phase2 implements Phase{

    private Joueurs joueurs;
    private Themes themes;

    public Phase2(Themes themes) {
        //this.joueurs = joueurs;
        joueurs = new Joueurs(5);
        this.themes = themes;
    }

    @Override
    public void selectPlayers(Joueurs joueurs) {
        System.out.println("les joueurs vont répondre a tour de role à des questions de niveau Moyen");
        System.out.println("ce groupe est composé de : \n");
        this.joueurs = joueurs;

        for (Joueur j : joueurs.getJoueurs()) {
            j.setScore(0);
            System.out.println("    " + j.getNom());
        }
    }

    @Override
    public void playPhase() {
        themes.melangeThemes();
        //System.out.println(joueurs.getJoueurs());
        int k = 0;
        for(int i = 0; i < 1; i++) {
            for (Joueur j : joueurs.getJoueurs()) {
                System.out.println(i);
                System.out.println("C'est au joueur " + j.getNom() + " de répondre");
                if(themes.getTheme(k).getRandomQuestion(3).poserQuestion()) {
                    System.out.println("Bonne réponse !! vous gagnez 3 points\n");
                    j.augmentationScore(3);
                }
                else System.out.println("Mauvaise réponse...");
                k = (k+1)%themes.getTaille();
            }
        }

        Arrays.sort(joueurs.getJoueurs());
    }

    public Joueurs gagnant() {
        Joueurs gagnants = new Joueurs(2) ;
        for (int i = 3; i<5; i++) {
            this.joueurs.getJoueurs()[i].setEtat("En attente");
            gagnants.ajoutJoueur(this.joueurs.getJoueurs()[i]);
        }

        return gagnants;
    }

    public Joueurs perdants() {
        Joueurs perdants = new Joueurs(3) ;
        for (int i = 0; i<3; i++) {
            this.joueurs.getJoueurs()[i].setEtat("Perdant");
            perdants.ajoutJoueur(this.joueurs.getJoueurs()[i]);
        }
        return perdants;
    }

    public Themes selectionTheme() {





        return null;
    }
}
