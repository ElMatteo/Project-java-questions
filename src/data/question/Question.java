package data.question;

//Classe m�re des questions

/**
 * Classe abstraite Question permettant de stocker les informations des questions qui peuvent être posées
 *
 * @author Matteo Clabassi, Hugo Anceaux
 */
public abstract class Question {
	/** Enconcé de la question */
	protected String texteQuestion;
	/** Nombre de questions déjà crées */
	private static int idQuestion=1;
	/** Numéro de la question */
	protected final int numeroQuestion;



	/** niveau de difficulté de la question */
	private int niveauDifficulte; //Niveau de difficulté de la question

	/**
	 * Constructeur de la classe quesstion
	 * @param texteQuestion
	 * @param niveauDifficulte
	 */
	Question(String texteQuestion, int niveauDifficulte){ //Constructeur
		this.texteQuestion = texteQuestion;
		this.niveauDifficulte = niveauDifficulte;
		this.numeroQuestion = this.idQuestion++;
	}

	/**
	 * Getter de l'attribut niveauDifficulte
	 *
	 * @return niveauDifficulte
	 */
	public int getNiveauDifficulte() {
		return niveauDifficulte;
	}

	/**
	 * Methode abstraite permettant de poser une question à un joueur
	 * @return
	 */
	public abstract boolean poserQuestion() ;


}
