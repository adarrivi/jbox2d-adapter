package org.adarrivi.physics.view.adapter.impl;

import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.view.ViewPosition;

public class WorldViewConverter {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    public WorldViewConverter(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    ViewPosition toScreenPosition(Position worldPosition) {
        double offsetX = (screenWidth / 2) / pixelsPerMeter;
        double offsetY = (screenHeight / 2) / pixelsPerMeter;
        Double drawPositionX = (worldPosition.getX() + offsetX) * pixelsPerMeter;
        Double drawPositionY = (-worldPosition.getY() + offsetY) * pixelsPerMeter;
        return new ViewPosition(drawPositionX.intValue(), drawPositionY.intValue());
    }

    int toScreenValue(float worldValue) {
        Float screenValue = worldValue * pixelsPerMeter;
        return screenValue.intValue();
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

}
