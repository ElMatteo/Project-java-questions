package phases;

import data.joueurs.Joueurs;

/**
 * Interface Phase permettant de déclarer les méthodes devant être implémentées dans les différentes phases
 *
 * @author Antoine Rincheval
 */
public interface Phase {

    /**
     * Méthode permettant de choisir les joueurs d'une phase
     *
     * @param joueurs
     */
    public void selectPlayers(Joueurs joueurs);

    /**
     * Méthode permettant de lancer une phase de jeu
     */
    public void playPhase();


}
