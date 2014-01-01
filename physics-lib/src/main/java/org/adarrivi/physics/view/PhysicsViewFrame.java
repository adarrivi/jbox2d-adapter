package org.adarrivi.physics.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.adarrivi.physics.Utils;

public class PhysicsViewFrame extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private SandboxPanel sandboxPanel;

    public PhysicsViewFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        centerFrame();
        sandboxPanel = new SandboxPanel(Utils.WIDTH, Utils.HEIGHT);
        add(sandboxPanel);
    }

    private void centerFrame() {
        setSize(Utils.WIDTH, Utils.HEIGHT);
        // set location must be called after setSize to centre the frame
        setLocationRelativeTo(null);
    }

}
