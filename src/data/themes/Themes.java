package data.themes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe Themes permettant de regrouper des objets de la classe Theme
 *
 * @author Antoine Rincheval
 */
public class Themes {

    /** Liste d'objets de la classe Theme */
    private List<Theme> themes;

    /**
     * Constructeur sans paramètres de la classe Thèmes
     */
    public Themes() {
        this.themes = new ArrayList<Theme>();
    }

    /**
     * Constructeur premant en paramètres une liste de Theme
     * @param themes
     */
    public Themes(List<Theme> themes) {
        this.themes = themes;
    }

    /**
     * Méthode toString de la classe Thèmes permettant d'afficher l'objet Themes
     * @return string de la liste des Theme
     */
    @Override
    public String toString() {
        return "Themes{" +
                "themes=" + themes +
                '}';
    }

    /**
     * Méthode permettant de séléctionné un nombre de thèmes aléatoires voulu
     *
     * @param nombre
     * @return Themes contenant les Theme séléctionnés
     */
    public Themes selectXthemes(int nombre) {

        Themes themesSelect = new Themes();
        this.melangeThemes();

        if(nombre > this.themes.size()) {
            nombre = this.themes.size();
            System.out.println("il n'existe pas assez de themes enregistrés (" + nombre + ")");
        }

        for(int i = 0; i < nombre; i++) {
            themesSelect.themes.add(this.themes.get(i));
        }
        return themesSelect;
    }

    /**
     * Méthode permettant de séléctionner un thème aléatoirement
     *
     * @return le Theme
     */
    public Theme select1theme() {
        this.melangeThemes();
        return themes.get((int)(Math.random()*this.themes.size()));
    }

    /**
     * Méthode permettant de selectionnér un thème à l'indice voulu
     * @param indice
     * @return Theme
     */
    public Theme getTheme(int indice) {
        return this.themes.get(indice);
    }

    /**
     * Méthode permettant de mélanger les Theme
     */
    public void melangeThemes() {
        Collections.shuffle(this.themes);
    }

    /**
     * Méthode permettant d'ajouter un Theme à la liste
     * @param theme
     */
    public void ajoutTheme(Theme theme) {
        this.themes.add(theme);
    }

    /**
     * Méthode permettant de retirer un thème
     * @param theme
     */
    public void retirerTheme(Theme theme) {
        this.themes.remove(theme);
    }

    /**
     * Méthode permettant d'obtenir le nombre de Theme contenus
     * @return taille
     */
    public int getTaille() {
        return this.themes.size();
    }

    public List<Theme> getThemes() {
        return this.themes;
    }
}
