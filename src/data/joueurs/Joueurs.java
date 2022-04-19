package data.joueurs;
import data.question.Question;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe Joueurs permettant de regrouper des objets de la classe Joueur
 *
 * @see Joueur
 * @author Hamza Sahmoune
 */
public class Joueurs {

    /** Tableau d'objets de la classe Joueur */
    private Joueur[] joueurs;
    /** nombre de Joueur contenu*/
    private int taille;
    /** taille maximum de Joueur qui peuvent etre contenus*/
    private int tailleMax;

    /**
     * constructeur de la classe Joueurs
     *
     * @param tailleMax
     */
    public Joueurs(int tailleMax) {
        this.joueurs = new Joueur[tailleMax];
        this.taille = 0;
        this.tailleMax = tailleMax;
    }

    /**
     * Méthode permettant d'ajouter un objet de la classe Joueur dans le tableau de Joueurs
     *
     * @param j
     */
    public void ajoutJoueur(Joueur j) {
        if (j == null) {
            System.out.println("pas de joueur entré");
        }
        else if (taille < tailleMax) {
            this.joueurs[taille] = j;
            this.taille++;
        }
        else System.out.println("le tableau est plein");
    }

    /**
     * Méthode permettant d'ajouter un joueur avec un nom personnalisé
     *
     */
    public void ajoutJoueurSaisie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nouveau joueur saississez votre nom");
        String nom = sc.nextLine();
        this.ajoutJoueur(new Joueur(nom));
    }

    /**
     * Méthode permettant de retirer un objet de la classe Joueur dans le tableau de Joueurs à l'index choisi
     *
     * @param index
     */
    public void retirerJoueur(int index) {
        for (int i = index; i < this.taille - 1; i++) {
            joueurs[i] = joueurs[i + 1];
        }
        joueurs[taille-1] = null;
        taille--;
    }

    /**
     * Méthode permettant de séléctionner un objet de la classe Joueur dans le tableau de Joueur
     *
     * @return j
     */
    public Joueur selectionJoueurAlea() {
        int index = (int)(Math.random() * taille-1);
        //System.out.println(index + "    index/taille" + taille);
        Joueur j = this.joueurs[index];
        j.setEtat("Selectioné");
        this.retirerJoueur(index);

        return j;
    }

    /**
     * Getter de l'attribut joueurs
     *
     * @return Joueurs
     */
    public Joueur[] getJoueurs() {
        return this.joueurs;
    }

    /**
     * Getter de l'attribut taille
     *
     * @return taille
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Méthode toString de la classe Joueurs
     *
     * @return
     */
    @Override
    public String toString() {
        return "Joueurs{" +
                "\n " + Arrays.toString(joueurs) +
                '}';
    }

}




