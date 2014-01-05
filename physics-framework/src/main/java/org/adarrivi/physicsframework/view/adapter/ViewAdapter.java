package org.adarrivi.physicsframework.view.adapter;

/**
 * Defines the interface that any graphics engine must implement to be used
 * 
 * @author adarrivi
 * 
 * @param <G>
 */
public interface ViewAdapter<G extends Object> {

    void drawAll(G graphics);
}
