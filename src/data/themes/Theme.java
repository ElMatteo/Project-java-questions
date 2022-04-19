package data.themes;

import data.question.Question;

import java.util.ArrayList;

/**
 * Classe thème permettant de stocker les informations sur un thème du jeux
 *
 * @author Antoine Rincheval
 */
public class Theme {

    /** nom du Thème */
    private String nom;
    /** indice permettant de savoir si le thème est séléctioné */
    private boolean selectionne;
    /** liste des Qestions contenues dans le thème */
    private ArrayList<Question> questions;

    /**
     * Constructeur de la classe Thème
     *
     * @param nom
     * @param questions
     */
    public Theme(String nom, ArrayList questions) {
        this.nom = nom;
        this.questions = questions;
        this.selectionne = false;
    }

    /**
     * Méthode toString de la classe Thème
     *
     * @return string du Thème contenant son nom et ses questions
     */
    @Override
    public String toString() {
        return "Theme{" + nom + " "+ "slected : " + selectionne + " " +
                "questions=\n" + questions +
                '}';
    }

    /**
     * Méthode permettant d'inverser le statut de l'attribut selected
     */
    public void changementStatus() {
        this.selectionne = (!this.selectionne);
    }

    /**
     * Méthode permettant d'obtenir une quesiton aléatoire du thème selon une difficultée choisie
     * @param difficulty
     * @return question aléatoire
     */
    public Question getRandomQuestion(int difficulty) {
        return this.questions.get((int)(Math.random()*this.questions.size()));
    }

    /**
     * Méthode permettant d'afficher la liste des questions d'une difficulté donnée
     * @param diff
     */
    public void afficheQuestionDifficulte(int diff) {
        for (Question q : this.questions) {
            if (q.getNiveauDifficulte() == diff) {
                System.out.println(q);
            }
        }
    }

    /**
     * Méthode permettant d'ajouter une nouvelle question dans le thème
     * @param question
     */
    public void ajoutQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * Getter de l'attribut name
     * @return
     */
    public String getNom() {
        return nom;
    }
}
