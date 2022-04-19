package data.question;

import java.util.Scanner;

/**
 * Classe VF héritant de la classe Question permettant de stocker les informations d'une question de type vf (Vrai ou Faux)
 *
 *
 * @see data.question.Question
 * @author Matteo Clabassi
 */
public class VF extends Question { //1 variable bonne r�ponse
	/** Réponse à la question */
	private boolean reponse;

	/**
	 * Constructeur de la classe VF
	 *
	 * @param texte
	 * @param niveauQuestion
	 * @param reponse
	 */
	public VF(String texte, int niveauQuestion, boolean reponse){ //Constructeur
		super(texte,niveauQuestion);
		this.reponse = reponse;
	}

	/**
	 * Méthode toString de la classe VF permettant d'afficher la question
	 *
	 * @return String de la question
	 */
	@Override
	public String toString() { //Affichage
		return this.numeroQuestion + " - " + this.texteQuestion;
	}

	/**
	 * Méthode permettant de poser la quesiton VF appelante et de reccueillir la réponse du joueur
	 *
	 * @return true ou false selon si la réponse est vraie ou fausse
	 */
	public boolean poserQuestion() {
		boolean reponseJoueur;
		Scanner sc = new Scanner(System.in);
		System.out.println(this + "\n\nRépondez par vrai ou faux" );
		String str = sc.nextLine();

		if (str.compareToIgnoreCase("vrai") == 0) {
			reponseJoueur = true;
		} else reponseJoueur = false;

		if (reponseJoueur == reponse) {
			return true;
		}
		else return false;
	}
}
