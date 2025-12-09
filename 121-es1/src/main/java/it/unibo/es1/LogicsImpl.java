package it.unibo.es1;

import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";

    private final int[] values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = new int[size];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.values.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }
}
