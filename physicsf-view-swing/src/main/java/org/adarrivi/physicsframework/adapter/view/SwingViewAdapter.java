package org.adarrivi.physicsframework.adapter.view;

import java.awt.Graphics2D;

import org.adarrivi.physicsframework.adapter.view.model.ViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.adarrivi.physicsframework.view.adapter.ViewAdapter;

public class SwingViewAdapter implements ViewAdapter<Graphics2D> {

    private PhysicsAdapter physicsAdapter;
    private ViewDecoratorFactory viewDecoratiorFactory;

    public SwingViewAdapter(PhysicsAdapter physicsAdapter, ViewDecoratorFactory viewDecoratiorFactory) {
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
