package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();
    private final Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * width, 100 * width);
        // Create a panel with a grid layout
        final JPanel innerPanel = new JPanel(new GridLayout(width, width));
        // Create a panel with border layout
        final JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(innerPanel, BorderLayout.CENTER);
        // Create the ">" button
        final JButton advance = new JButton(">");
        outerPanel.add(advance, BorderLayout.SOUTH);
        this.getContentPane().add(outerPanel);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(i, j);
                final JButton button = new JButton(" ");
                this.cells.put(pos, button);
                innerPanel.add(button);
            }
        }
        for (final var pos: logics.initialiseCells()) {
            cells.get(pos).setText("*");
        }
        // Create the advance button handler
        advance.addActionListener(e -> {
            for (final var pos: logics.advance()) {
                cells.get(pos).setText("*");
            }
            if (logics.toQuit()) {
                dispose();
            }
        });
        pack();
        this.setVisible(true);
    }
}
