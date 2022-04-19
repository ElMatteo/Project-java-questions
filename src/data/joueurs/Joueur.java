package data.joueurs;
import java.util.Scanner;

/**
 * Classe Joueur permettant de stocker les informations d'un joueur
 *
 * @author Hamza Sahmoune
 */
public class Joueur implements Comparable<Joueur>
{

    /** numéro du joueur*/
    private int numero;
    /** nom du joueur*/
    private String nom;
    /** score du joueur*/
    private int score;
    /** état du joueur ("En attente", "Seletcioné", "Gagnant", "perdant")*/
    private String etat;
    /** nombre de joueurs ayant été crée dans le jeux*/
    public static int NBRJOUEURS=0;


    /**
     * Construteur de la classe Joueur
     *
     * @param Nom
     */
    public Joueur(String Nom)
    {
        this.score=0;
        this.nom =Nom;
        this.etat="en attente";
        this.numero=100 + NBRJOUEURS*10;
        this.NBRJOUEURS++;
    }


    /**
     * Getter de l'attribut score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Getter de l'attribut numero
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Getter de l'attribut nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut etat
     * @return etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Setter de l'attribut nom
     * @param nom
     */
    public void setNom(String nom) {this.nom = nom;}

    /**
     * Setter de l'attribut etat
     * @param etat
     */
    public void setEtat(String etat) {this.etat = etat;}

    /**
     * Setter de l'attribut score
     * @param score
     */
    public void setScore(int score) {
        this.score=score;
    }

    /**
     * Méthode d'augmentation du score d'un nombre de points indéfini
     * @param points
     */
    public void augmentationScore(int points) {
        this.score += points;
    }

    /**
     * Methode toString de la classe Joueur
     * @return
     */
    @Override
    public String toString() {
       return("[Le joueur numéro "+numero+", nommé :"+getNom()+" a le score suivant : "+score+" et est : "+etat+" ]\n   ");
    }

    /**
     * Methode compareTo pour un objet Joueur
     *
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html#compareTo(T)">voir Interface comparable</a>
     * @param o
     * @return
     */
    @Override
    public int compareTo(Joueur o) {
        if(this.score != o.score) {
            return this.score - o.score;
        }
        return 0;
    }
}



