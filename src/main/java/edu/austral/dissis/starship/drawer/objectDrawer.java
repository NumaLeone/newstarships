package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.collisionable.AsteroidCollisionableShape;
import edu.austral.dissis.starship.collisionable.CollisionableShape;
import edu.austral.dissis.starship.objects.Asteroid;
import edu.austral.dissis.starship.objects.GameObject;
import processing.core.PConstants;

import processing.core.PImage;

import static edu.austral.dissis.starship.drawer.StarshipDrawer.SQUARE_SIZE;

public abstract class objectDrawer {

    PImage image;

    public objectDrawer(PImage image) {
        this.image = image;
    }

    abstract float getImageCenter();

   //public abstract void draw(); pienso que draw podria hacerse de forma abstracta pero la verdad que no estoy encontrando la manera de hacerlo, por lo que voy a repetir codigo
   //public SquareCollisionable getCollisionable(Starship starship) lo mismo que en draw
   //public CollisionableShape getCollisionable() {}; lo mismo, pienso que se puede hacer, pero no me esta saliendo como, por lo tanto voy a tener que repetir codigo

    float calculateRotation(GameObject gameObject) {
        return gameObject.getDirection().rotate(PConstants.PI / 2).getAngle();
    }


}
