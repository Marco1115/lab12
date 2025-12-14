package it.unibo.es3;

import java.util.List;

/**
 * 
 */
public interface Logics {

    /**
     * Initialise the board with the initial random activations.
     * 
     * @return a list containing all the activated positions.
     */
    List<Pair<Integer, Integer>> initialiseCells();

    /**
     * Activates all the neighboring cells of an active cell.
     * 
     * @return a list containing all the newly activated cells
     */
    List<Pair<Integer, Integer>> advance();

    /**
     * @return true if it's time to quit.
     */
    boolean toQuit();

}
