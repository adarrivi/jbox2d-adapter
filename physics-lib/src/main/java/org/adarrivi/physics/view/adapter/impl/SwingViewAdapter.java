package org.adarrivi.physics.view.adapter.impl;

import java.awt.Graphics2D;

import org.adarrivi.physics.model.element.PositionalElement;
import org.adarrivi.physics.physic.adapter.PhysicsAdapter;
import org.adarrivi.physics.view.adapter.ViewAdapter;

class SwingViewAdapter implements ViewAdapter<Graphics2D> {

    private PhysicsAdapter physicsAdapter;
    private ViewDecoratiorFactory viewDecoratiorFactory;

    SwingViewAdapter(PhysicsAdapter physicsAdapter, ViewDecoratiorFactory viewDecoratiorFactory) {
        this.physicsAdapter = physicsAdapter;
        this.viewDecoratiorFactory = viewDecoratiorFactory;
    }

    @Override
    public void drawAll(Graphics2D g2d) {
        for (PositionalElement element : physicsAdapter.getAllElements()) {
            ViewPositionalElementDecorator<?> viewElement = viewDecoratiorFactory.decoratePositionalElement(element);
            viewElement.drawYourself(g2d);
        }

    }

}
