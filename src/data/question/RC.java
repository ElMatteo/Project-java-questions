package data.question;

import java.util.Scanner;

/**
 * Classe RC héritant de la classe question permettant de stocker les informations d'une question de type rc (Réponse Courte)
 *
 * @see data.question.Question
 * @author Matteo Clabassi
 */
public class RC extends Question { //1 variable r�ponse
	/** Réponse à la question */
	private String reponse;

	/**
	 * Constructeur de la classe RC
	 *
	 * @param texte
	 * @param niveauDifficulte
	 * @param reponse
	 */
	public RC(String texte, int niveauDifficulte,String reponse){ //Constructeur
		super(texte,niveauDifficulte);
		this.reponse = reponse;
	}

	/**
	 * Méthode toString de la classe RC permettant d'afficher la question
	 *
	 * @return string de la question de type RC
	 */
	@Override
	public String toString() { //Affichage
		return this.numeroQuestion + " - " + this.texteQuestion + " ?";
	}

	/**
	 * Méthode permettant de poser la quesiton RC appelante et de reccueillir la réponse du joueur
	 *
	 * @return true ou false selon si la réponse est vraie ou fausse
	 */
	public boolean poserQuestion() {
		Scanner sc = new Scanner(System.in);
		System.out.println(this + "\n\n");
		String str = sc.nextLine();
		if (str.compareToIgnoreCase(reponse) == 0) {
			return true;
		}
		else return false;
	}
}
