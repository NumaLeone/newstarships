package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.GameObject;
import processing.core.PConstants;

import processing.core.PImage;

public abstract class objectDrawer {

    PImage image;

    public objectDrawer(PImage image) {
        this.image = image;
    }

    abstract float getImageCenter();

   //public abstract void draw(); pienso que draw podria hacerse de forma abstracta pero la verdad que no estoy encontrando la manera de hacerlo, por lo que voy a repetir codigo
   //public SquareCollisionable getCollisionable(Starship starship) lo mismo que en draw

    float calculateRotation(GameObject gameObject) {
        return gameObject.getDirection().rotate(PConstants.PI / 2).getAngle();
    }


}
