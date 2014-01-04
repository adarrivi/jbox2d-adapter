package org.adarrivi.physicsframework.adapter.physics.model;

import java.util.List;

import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.jbox2d.common.Vec2;

public abstract class PhysicsElementDecorator<P extends PositionalElement> implements WorldElement {

    private P decoratedElement;

    protected PhysicsElementDecorator(P decoratedElement) {
        this.decoratedElement = decoratedElement;
    }

    protected P getDecoratedElement() {
        return decoratedElement;
    }

    protected Vec2 toVec2(Position position) {
        return new Vec2(position.getX(), position.getY());
    }

    protected Vec2[] toVec2Array(List<Position> positionList) {
        Vec2[] vec2Array = new Vec2[positionList.size()];
        for (int i = 0; i < positionList.size(); i++) {
            vec2Array[i] = toVec2(positionList.get(i));
        }
        return vec2Array;
    }

}
