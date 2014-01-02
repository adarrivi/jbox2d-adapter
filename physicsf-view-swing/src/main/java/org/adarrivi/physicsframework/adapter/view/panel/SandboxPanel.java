package org.adarrivi.physicsframework.adapter.view.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import org.adarrivi.physicsframework.view.adapter.ViewAdapter;

public class SandboxPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ViewAdapter<Graphics2D> viewAdapter;

    public SandboxPanel(ViewAdapter<Graphics2D> viewAdapter, int width, int height) {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(width, height);
        this.viewAdapter = viewAdapter;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        viewAdapter.drawAll(g2d);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

}
