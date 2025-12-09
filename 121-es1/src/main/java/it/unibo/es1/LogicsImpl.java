package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.values.add(0);
        }
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
        return Collections.unmodifiableList(this.values);
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
        this.values.set(elem, newValue);
        return newValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        final String res = this.values().stream()
                .map(String::valueOf)
                .collect(Collectors.joining("|"));
        return "<<" + res + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        final long distinctElems = this.values().stream()
                .distinct()
                .count();
        return distinctElems == 1;
    }
}
