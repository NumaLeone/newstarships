package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.Asteroid;
import edu.austral.dissis.starship.collisionable.AsteroidCollisionableShape;
import edu.austral.dissis.starship.collisionable.CollisionableShape;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;

public class AsteroidDrawer extends objectDrawer{


    public AsteroidDrawer(PImage image) {
        super(image);
    }
    @Override
    float getImageCenter() {
        return image.pixelHeight / -2f;
    }

    public void draw(PGraphics graphics, Asteroid asteroid) {
        final Vector2 position = asteroid.getPosition();
        final float angle = calculateRotation(asteroid);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        graphics.noFill();
        graphics.noStroke();
        graphics.rect(image.pixelHeight/-2f,image.pixelHeight/-2f,image.pixelHeight,image.pixelHeight);
        graphics.image(image, getImageCenter(), getImageCenter());

        graphics.popMatrix();
    }

    public CollisionableShape getCollisionable(Asteroid asteroid) {
        return new AsteroidCollisionableShape(
                image.pixelHeight,
                calculateRotation(asteroid),
                asteroid.getPosition(),
                asteroid
        );
    }
}

