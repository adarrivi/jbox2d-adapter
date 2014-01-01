package org.adarrivi.physics.view;

import org.adarrivi.physics.model.element.Position;

class WorldScreenConverter {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    WorldScreenConverter(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    ScreenPosition toScreenPosition(Position worldPosition) {
        double offsetX = (screenWidth / 2) / pixelsPerMeter;
        double offsetY = (screenHeight / 2) / pixelsPerMeter;
        Double drawPositionX = (worldPosition.getX() + offsetX) * pixelsPerMeter;
        Double drawPositionY = (-worldPosition.getY() + offsetY) * pixelsPerMeter;
        return new ScreenPosition(drawPositionX.intValue(), drawPositionY.intValue());
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
