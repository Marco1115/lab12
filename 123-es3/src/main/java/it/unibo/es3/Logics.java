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

    List<Pair<Integer, Integer>> advance();

}
