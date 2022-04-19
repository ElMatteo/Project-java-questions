package phases;

import data.joueurs.Joueur;
import data.joueurs.Joueurs;
import data.themes.Themes;

import java.util.Arrays;

/**
 * Classe Phase1 permettant de jouer la première phase du jeux
 *
 * @author Antoine Rincheval
 */
public class Phase1 implements Phase{

    /** Joueurs présents dans la phase */
    private Joueurs joueurs;
    /** Themes pouvant être utilisés dans la phase */
    private Themes themes;

    /**
     * Constructeur de la classe Phase1
     * @param themes
     */
    public Phase1(Themes themes) {
        joueurs = new Joueurs(4);
        this.themes = themes;
    }

    /**
     * Méthode permettant de séléctionner les joueurs de la phase 1
     * @param joueurs
     */
    @Override
    public void selectPlayers(Joueurs joueurs) {
        Joueur j;
        System.out.println("les joueurs vont répondre a tour de role à des questions de niveau facile");
        System.out.println("ce groupe est composé de : \n");

        for (int i = 0; i < 4  ; i++) {
            j = joueurs.selectionJoueurAlea();
            this.joueurs.ajoutJoueur(j);
            System.out.println("    "+j.getNom());

        }
    }

    /**
     * Méthode permettant de lancer la phase 1
     */
    @Override
    public void playPhase() {
        themes.melangeThemes();
        //System.out.println(joueurs.getJoueurs());
        int k = 0;
        for(int i = 0; i < 1; i++) {
            for (Joueur j : joueurs.getJoueurs()) {
                //System.out.println(i);
                System.out.println("C'est au joueur " + j.getNom() + " de répondre");
                System.out.println("Thème : " + themes.getTheme(k).getNom());
                if(themes.getTheme(k).getRandomQuestion(1).poserQuestion()) {
                    System.out.println("Bonne réponse !! vous gagnez 2 points\n");
                    j.augmentationScore(2);
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
        Joueur joueur = this.joueurs.getJoueurs()[joueurs.getTaille()-1];
        joueur.setEtat("En attente");
        return joueur;
    }

    /**
     * Méthode permettant de récupérer les perdants de la phase
     * @return perdants
     */
    public Joueurs perdants() {
        Joueurs perdants = new Joueurs(3) ;
        for (int i = 0; i<3; i++) {
            this.joueurs.getJoueurs()[i].setEtat("Perdant");
            perdants.ajoutJoueur(this.joueurs.getJoueurs()[i]);
        }
        return perdants;
    }
}
