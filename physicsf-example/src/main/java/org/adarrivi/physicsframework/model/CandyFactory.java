package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.ElementFactory;
import org.adarrivi.physicsframework.model.element.Position;

public class CandyFactory extends ElementFactory {

    public CandyBall createCandyBall(Position position) {
        return new CandyBall(position);
    }

    public CandyBar createCandyBar(Position position) {
        return new CandyBar(position);
    }

    public CandySquare createCandySquare(Position position) {
        return new CandySquare(position);
    }
}
