package org.adarrivi.physics.view.adapter.swing;

import org.adarrivi.physics.model.element.PositionalElement;

abstract class ViewPositionalElementDecorator<P extends PositionalElement> implements SwingDrawable {

    private P decoratedElement;
    private WorldViewConverter worldViewConverter;

    protected ViewPositionalElementDecorator(P decoratedElement, WorldViewConverter worldScreenConverter) {
        this.decoratedElement = decoratedElement;
        this.worldViewConverter = worldScreenConverter;
    }

    protected P getDecoratedElement() {
        return decoratedElement;
    }

    protected WorldViewConverter getWorldViewConverter() {
        return worldViewConverter;
    }

}
