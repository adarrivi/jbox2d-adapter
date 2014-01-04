package org.adarrivi.physicsframework;

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
import org.adarrivi.physicsframework.image.ImageDecoratorFactory;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.adarrivi.physicsframework.view.adapter.ViewAdapter;

public class DoublePanelFrame extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private static final int PIXELS_PER_METER = 25;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 600;

    private PhysicsAdapter physicsAdapter;
    private JPanel contentPane;

    public DoublePanelFrame(PhysicsAdapter physicsAdapter) {
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

    @Override
    public void run() {
        centerFrame();
        ViewDecoratorFactory viewDecoratiorFactory = new ShapeViewDecoratorFactory(PANEL_WIDTH, PANEL_HEIGHT, PIXELS_PER_METER);
        ViewDecoratorFactory imageDecoratorFactory = new ImageDecoratorFactory(PANEL_WIDTH, PANEL_HEIGHT, PIXELS_PER_METER);
        ViewAdapter<Graphics2D> shapeViewAdapter = new SwingViewAdapter(physicsAdapter, viewDecoratiorFactory);
        ViewAdapter<Graphics2D> imageViewAdapter = new SwingViewAdapter(physicsAdapter, imageDecoratorFactory);
        contentPane.add(new SandboxPanel(shapeViewAdapter, PANEL_WIDTH, PANEL_HEIGHT));
        contentPane.add(new SandboxPanel(imageViewAdapter, PANEL_WIDTH, PANEL_HEIGHT));
    }

    private void centerFrame() {
        setSize(WIDTH, HEIGHT);
        // set location must be called after setSize to centre the frame
        setLocationRelativeTo(null);
    }

}
