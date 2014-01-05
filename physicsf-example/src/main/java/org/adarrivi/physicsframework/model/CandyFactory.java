package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.ElementFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class CandyFactory extends ElementFactory {

    public CandyFactory(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter);
    }

    public CandyBall createCandyBall(Position position) {
        CandyBall candyBall = new CandyBall(getPhysicsAdapter());
        getPhysicsAdapter().createElement(candyBall, position);
        return candyBall;
    }

    public CandyBar createCandyBar(Position position) {
        CandyBar candyBar = new CandyBar(getPhysicsAdapter());
        getPhysicsAdapter().createElement(candyBar, position);
        return candyBar;
    }

    public CandySquare createCandySquare(Position position) {
        CandySquare candySquare = new CandySquare(getPhysicsAdapter());
        getPhysicsAdapter().createElement(candySquare, position);
        return candySquare;
    }

}
