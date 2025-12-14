package it.unibo.es3;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * 
 */
public class LogicsImpl implements Logics, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final int size;
    private final Map<Pair<Integer, Integer>, Boolean> board;

    /**
     * Constructs a new logics.
     * 
     * @param width the size of the logic.
     */
    public LogicsImpl(final int width) {
        this.size = width;
        this.board = new HashMap<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                this.board.put(new Pair<>(i, j), false);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressFBWarnings(
        value = "DMI_RANDOM_USED_ONLY_ONCE",
        justification = "False positive: random object used multiple times"
    )
    @Override
    public List<Pair<Integer, Integer>> initialiseCells() {
        final List<Pair<Integer, Integer>> activated = new ArrayList<>();
        final Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            final Pair<Integer, Integer> randomPos = new Pair<>(rand.nextInt(this.size), rand.nextInt(this.size));
            this.board.put(randomPos, true);
            activated.add(randomPos);
        }
        return activated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pair<Integer, Integer>> advance() {
        final List<Pair<Integer, Integer>> neighborsList = this.board.entrySet().stream()
                .filter(entry -> !entry.getValue() && isNeighbor(entry.getKey()))
                .map(Entry::getKey)
                .toList();
        for (final var pos: neighborsList) {
            board.put(pos, true);
        }
        return neighborsList;
    }

    private boolean isNeighbor(final Pair<Integer, Integer> pos) {
        for (int i = pos.y() - 1; i <= pos.y() + 1; i++) {
            for (int j = pos.x() - 1; j <= pos.x() + 1; j++) {
                if (board.getOrDefault(new Pair<>(j, i), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return this.board.entrySet().stream().filter(Entry::getValue).count() == (long) size * size; 
    }

}
