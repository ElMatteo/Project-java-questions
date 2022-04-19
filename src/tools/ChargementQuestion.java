package tools;
import data.themes.Theme;
import data.themes.Themes;
import data.question.QCM;
import data.question.Question;
import data.question.RC;
import data.question.VF;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe ChargementQuestion permettant de crée un objet Thèmes contenant
 *
 * @author Hugo Anceaux
 */
public class ChargementQuestion {

    /** HashMap permettant de reccueillir les informations lues dans le fichier*/
    private static Map<String, Theme> dicotheme = new HashMap<>();

    /**
     * Méthode permettant permettant de transoformer un fichier txt en objet de la classe Thèmes
     *
     * @param path
     * @return themes chargées
     * @throws FileNotFoundException
     */
    public static Themes recuperationThemes(String path) throws FileNotFoundException {
        String ligne = "";
        final String SEPARATEUR = ";";
        Themes thms = new Themes();
        Question question;

        FileReader file = new FileReader(path);                                                                         //on va chercher le fichier
        Scanner scanner = new Scanner(file);                                                                            //on l'introduit dans le scanner de fichier
                                                                                                                   //boucle qui permet de lire à l'aide de scanner.nextline() de retourner la ligne du fichier txt et de l'ajouter à une ArrayList tant qu'il y a une ligne suivante.
        while (scanner.hasNextLine()) {                                                                                 //La boucle s'effectue tant que le fichier possède des autres lignes

            ligne = scanner.nextLine();                                                                                 //on affecte à la variable ligne tout ce qu'il y a sur la première ligne du fichier txt
            String[] mots = ligne.split(SEPARATEUR);                                                                    //on sépare à l'aide du séparateur défini la ligne et on memt chaque mot séparé dans un tableau

            Theme thme = new Theme(mots[0], new ArrayList());
            if (dicotheme.containsKey(mots[0])){
                question = creationQuestion(mots);
                dicotheme.get(mots[0]).ajoutQuestion(question);
            }
            else {
                Theme thme2 = new Theme(mots[0], new ArrayList());
                dicotheme.put(mots[0], thme2);
                question = creationQuestion(mots);
                dicotheme.get(mots[0]).ajoutQuestion(question);
                //System.out.println(dicotheme.keySet());
            }
        }

        for (Theme t: dicotheme.values()) {
            thms.ajoutTheme(t);
        }
        //System.out.println(thms);
        return thms;
    }

    /**
     * Méthode transformant une ligne du fichier txt en objet de la classe Question
     *
     * @param mots
     * @return question
     */
    public static Question creationQuestion(String[] mots) {

        String strQCM = "QCM";
        String strVF = "VF";
        //String strRC = "RC";

        if(mots[1].compareToIgnoreCase(strQCM) == 0 ) {                                                             //On cherche à savoir si c'est un type QCM, VF ou RC
            QCM question = new QCM(mots[2], Integer.parseInt(mots[3]), mots[4], mots[5], mots[6], mots[7]);         //Création de la question à l'aide du constructeur
            //System.out.println(question + "\n");
            return question;
        }
        else if(mots[1].compareToIgnoreCase(strVF) == 0 ) {
            VF question = new VF(mots[2], Integer.parseInt(mots[3]), Boolean.parseBoolean(mots[4]));
            //System.out.println(question + "\n");
            return question;
        }
        else  {
            RC question = new RC(mots[2], Integer.parseInt(mots[3]), mots[4]);
            //System.out.println(question + "\n");
            return question;
        }

    }

}

