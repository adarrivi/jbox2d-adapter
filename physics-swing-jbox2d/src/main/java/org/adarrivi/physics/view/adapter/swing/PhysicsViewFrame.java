package org.adarrivi.physics.view.adapter.swing;

import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.adarrivi.physics.physic.adapter.PhysicsAdapter;
import org.adarrivi.physics.view.adapter.ViewAdapter;

public class PhysicsViewFrame extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private static final int PIXELS_PER_METER = 50;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private SandboxPanel sandboxPanel;
    private PhysicsAdapter physicsAdapter;

    public PhysicsViewFrame(PhysicsAdapter physicsAdapter) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        SwingUtilities.invokeLater(this);
        this.physicsAdapter = physicsAdapter;
    }

    @Override
    public void run() {
        centerFrame();
        WorldViewConverter worldViewConverter = new WorldViewConverter(WIDTH, HEIGHT, PIXELS_PER_METER);
        ViewDecoratiorFactory viewDecoratiorFactory = new ViewDecoratiorFactory(worldViewConverter);
        ViewAdapter<Graphics2D> viewAdapter = new SwingViewAdapter(physicsAdapter, viewDecoratiorFactory);
        sandboxPanel = new SandboxPanel(viewAdapter, WIDTH, HEIGHT);
        add(sandboxPanel);
    }

    private void centerFrame() {
        setSize(WIDTH, HEIGHT);
        // set location must be called after setSize to centre the frame
        setLocationRelativeTo(null);
    }

}
