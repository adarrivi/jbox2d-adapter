package org.adarrivi.physics.view.adapter.impl;

import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.PositionalElement;
import org.adarrivi.physics.model.element.Rectangle;

class ViewDecoratiorFactory {

    private WorldViewConverter worldViewConverter;

    ViewDecoratiorFactory(WorldViewConverter worldViewConverter) {
        this.worldViewConverter = worldViewConverter;
    }

    <P extends PositionalElement> ViewPositionalElementDecorator<?> decoratePositionalElement(P positionalElement) {
        if (positionalElement instanceof Circle) {
            return new ViewCircle((Circle) positionalElement, worldViewConverter);
        }
        if (positionalElement instanceof Rectangle) {
            return new ViewRectangle((Rectangle) positionalElement, worldViewConverter);
        }
        return null;
    }

}
