package org.adarrivi.physicsframework.simulation.multi;

import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.adarrivi.physicsframework.adapter.view.SwingViewAdapter;
import org.adarrivi.physicsframework.adapter.view.model.ShapeViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.model.ViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.panel.SandboxPanel;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.adarrivi.physicsframework.view.adapter.ViewAdapter;

import candy.ViewCandyDecoratorFactory;

/**
 * JFrame containing two panels, each one with a different view representation
 * of the same simulation
 * 
 * @author adarrivi
 * 
 */
public class ShapeAndCandyPanelFrame extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private int frameWidth;
    private int frameHeight;
    private int pixelsPerMeter;

    private PhysicsAdapter physicsAdapter;
    private JPanel contentPane;

    public ShapeAndCandyPanelFrame(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));
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
        Double panelWidth = frameWidth * 0.5;
        ViewDecoratorFactory shapeDecoratiorFactory = new ShapeViewDecoratorFactory(panelWidth.intValue(), frameHeight, pixelsPerMeter);
        ViewDecoratorFactory candyDecoratorFactory = new ViewCandyDecoratorFactory(panelWidth.intValue(), frameHeight, pixelsPerMeter);
        ViewAdapter<Graphics2D> shapeViewAdapter = new SwingViewAdapter(physicsAdapter, shapeDecoratiorFactory);
        ViewAdapter<Graphics2D> imageViewAdapter = new SwingViewAdapter(physicsAdapter, candyDecoratorFactory);
        contentPane.add(new SandboxPanel(shapeViewAdapter, panelWidth.intValue(), frameHeight));
        contentPane.add(new SandboxPanel(imageViewAdapter, panelWidth.intValue(), frameHeight));
    }

    private void centerFrame() {
        setSize(frameWidth, frameHeight);
        // set location must be called after setSize to centre the frame
        setLocationRelativeTo(null);
    }

}
