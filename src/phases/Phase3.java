package phases;

import data.joueurs.Joueur;
import data.joueurs.Joueurs;
import data.themes.Themes;

import java.util.Arrays;

/**
 * Classe Phase2 permettant de jouer la première phase du jeux
 *
 * @author Antoine Rincheval
 */
public class Phase3 implements Phase{

    /** Joueurs présents dans la phase */
    private Joueurs joueurs;
    /** Themes pouvant être utilisés dans la phase */
    private Themes themes;

    /**
     * Constructeur de la classe Phase2
     * @param themes
     */
    public Phase3(Themes themes) {
        joueurs = new Joueurs(2);
        this.themes = themes;
    }

    /**
     * Méthode permettant de séléctionner les joueurs de la phase 3
     * @param joueurs
     */
    @Override
    public void selectPlayers(Joueurs joueurs) {
        System.out.println("les joueurs vont répondre a tour de role à des questions de niveau Difficile");
        System.out.println("ce groupe est composé de : \n");
        this.joueurs = joueurs;

        for (Joueur j : joueurs.getJoueurs()) {
            j.setScore(0);
            System.out.println("    " + j.getNom());
        }
    }

    /**
     * Méthode permettant de lancer la phase 3
     */
    @Override
    public void playPhase() {
        themes.melangeThemes();
        //System.out.println(joueurs.getJoueurs());
        int k = 0;
        for(int i = 0; i < 1; i++) {
            for (Joueur j : joueurs.getJoueurs()) {
                System.out.println(i);
                System.out.println("C'est au joueur " + j.getNom() + " de répondre");
                System.out.println("Thème : " + themes.getTheme(k).getNom());
                if(themes.getTheme(k).getRandomQuestion(3).poserQuestion()) {
                    System.out.println("Bonne réponse !! vous gagnez 5 point\n");
                    j.augmentationScore(5);
                }
                else System.out.println("Mauvaise réponse...");
                k = (k+1)%themes.getTaille();
            }
        }

        Arrays.sort(joueurs.getJoueurs());
    }

    /**
     * Méthode permettant de récuperer le gagnants de la phase
     * @return joueur gagnant
     */
    public Joueur gagnant() {
        Joueur j = this.joueurs.getJoueurs()[1];
        j.setEtat("Gagnant");
        return j;
    }

    /**
     * Méthode permettant de récupérer les perdants de la phase
     * @return perdants
     */
    public Joueur perdant() {
        Joueur j = this.joueurs.getJoueurs()[1];
        j.setEtat("Perdant");
        return j;
    }
}
