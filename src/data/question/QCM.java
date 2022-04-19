package data.question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe QCM héritant de la classe question permettant de stocker les informations d'une question de type qcm
 *
 *
 * @see data.question.Question
 * @author Matteo Clabassi
 */
public class QCM extends Question {
	/** Attribut contenant le texte d'une mauvaise réponse */
	private String reponseA;
	/** Attribut contenant le texte d'une mauvaise réponse */
	private String reponseB;
	/** Attribut contenant le texte d'une mauvaise réponse */
	private String reponseC;
	/** Attribut contenant le texte de la bonne réponse */
	private String bonneReponse;
	/** Attribut permettant de stocker la position de la bonne réponse lorsqu'elle est affichée a l'utilisateur */
	private int indiceReponse;

	/**
	 * Constructeur de la classe QCM
	 * @param texte
	 * @param niveauDifficulte
	 * @param reponseA
	 * @param reponseB
	 * @param reponseC
	 * @param reponseD
	 */
	public QCM(String texte,int niveauDifficulte,String reponseA, String reponseB, String reponseC, String reponseD){ //Constructeur
		super(texte,niveauDifficulte);
		this.reponseA = reponseA;
		this.reponseB = reponseB;
		this.reponseC = reponseC;
		this.bonneReponse = reponseD;
	}

	/**
	 * Méthode permettant d'afficher une question de de type QCM avec les réponses non ordonnées
	 *
	 * @return string de la question
	 */
	@Override
	public String toString() { //Affichage des réponses de manière aléatoire
		ArrayList<String> listeQuestion = new ArrayList<String>(); 
		listeQuestion.add(reponseA); //Ajout des réponses dans un tableau
		listeQuestion.add(reponseB);
		listeQuestion.add(reponseC);
		listeQuestion.add(bonneReponse);
		Collections.shuffle(listeQuestion); //Mélange du tableau contenant les réponses
		StringBuilder reponses = new StringBuilder(this.numeroQuestion + " - " + this.texteQuestion + "\n");
		for(int i = 0; i < listeQuestion.size() ; i++) {
			reponses.append("	" + (i+1) + " - " + listeQuestion.get(i)+"\n");
			if(listeQuestion.get(i).compareToIgnoreCase(bonneReponse) == 0) {
				this.indiceReponse = i+1;
			}
		}
		return reponses.toString();
	}

	/**
	 * Méthode permettant de poser la quesiton QCM appelante et de reccueillir la réponse du joueur
	 *
	 * @return true ou false selon si la réponse est vraie ou fausse
	 */
	public boolean poserQuestion() {
		Scanner sc = new Scanner(System.in);
		System.out.println(this);
		System.out.println("entrez le numéro de votre réponse");
		int numRep = sc.nextInt();
		if (numRep == this.indiceReponse) {
			return true;
		}
		else return false;
	}

	/**
	 * Getter de indiceReponse
	 *
	 * @return indiceReponse
	 */
	public int getIndiceReponse() {
		return indiceReponse;
	}
}