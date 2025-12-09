package it.unibo.es1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";

    private final List<Integer> values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = Arrays.asList(new Integer[size]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.values.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return this.values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.values().stream()
                .map(v -> v < this.size())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        if (elem < 0 || elem >= this.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        final int newValue = this.values().get(elem) + 1;
        this.values().set(elem, newValue);
        return newValue;
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
