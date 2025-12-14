package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class LogicsImpl implements Logics {

    final Map<Pair<Integer, Integer>, Boolean> status;

    /**
     * Constructor of the logics.
     * 
     * @param size the size of the logics.
     */
    public LogicsImpl(final int size) {
        status = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final Pair<Integer, Integer> position) {
        status.putIfAbsent(position, false);
        final boolean newValue = !status.get(position);
        status.put(position, newValue);
        return newValue;
    }

}
