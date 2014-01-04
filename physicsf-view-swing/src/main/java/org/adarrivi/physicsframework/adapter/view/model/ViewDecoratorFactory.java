package org.adarrivi.physicsframework.adapter.view.model;

import org.adarrivi.physicsframework.model.element.PositionalElement;

public interface ViewDecoratorFactory {
    ViewPositionalElementDecorator<?> decoratePositionalElement(PositionalElement positionalElement);
}
