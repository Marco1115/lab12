package it.unibo.es2;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 */
public class LogicsImpl implements Logics, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer, Integer>, Boolean> status;
    private final int size;

    /**
     * Constructor of the logics.
     * 
     * @param size the size of the logics.
     */
    public LogicsImpl(final int size) {
        status = new HashMap<>();
        this.size = size;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (int i = 0; i < this.size; i++) {
            final int index = i;
            final long starsInLine = this.status.entrySet().stream()
                    .filter(entry -> entry.getKey().x().equals(index))
                    .filter(Entry::getValue)
                    .count();
            if (starsInLine == this.size) {
                return true;
            }
            final long starsInColumn = this.status.entrySet().stream()
                    .filter(entry -> entry.getKey().y().equals(index))
                    .filter(Entry::getValue)
                    .count();
            if (starsInColumn == this.size) {
                return true;
            }
        }
        return false;
    }

}
