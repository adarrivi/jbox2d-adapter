package org.adarrivi.physicsframework.simulation.single;

import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.adarrivi.physicsframework.adapter.view.SwingViewAdapter;
import org.adarrivi.physicsframework.adapter.view.model.ShapeViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.model.ViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.panel.SandboxPanel;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.adarrivi.physicsframework.view.adapter.ViewAdapter;

/**
 * JFrame containing two panels, each one with a different view representation
 * of the same simulation
 * 
 * @author adarrivi
 * 
 */
public class ShapeSinglgePanelFrame extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private int frameWidth;
    private int frameHeight;
    private int pixelsPerMeter;

    private PhysicsAdapter physicsAdapter;

    public ShapeSinglgePanelFrame(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        SwingUtilities.invokeLater(this);
    }

    public void setFrameSize(int width, int height, int pixelsPerMeter) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    @Override
    public void run() {
        centerFrame();
        ViewDecoratorFactory shapeDecoratiorFactory = new ShapeViewDecoratorFactory(frameWidth, frameHeight, pixelsPerMeter);
        ViewAdapter<Graphics2D> shapeViewAdapter = new SwingViewAdapter(physicsAdapter, shapeDecoratiorFactory);
        add(new SandboxPanel(shapeViewAdapter, frameWidth, frameHeight));
    }

    private void centerFrame() {
        setSize(frameWidth, frameHeight);
        // set location must be called after setSize to centre the frame
        setLocationRelativeTo(null);
    }

}
