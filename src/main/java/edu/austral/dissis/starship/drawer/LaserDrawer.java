package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.Laser;
import edu.austral.dissis.starship.collisionable.LaserCollisionableShape;
import edu.austral.dissis.starship.collisionable.CollisionableShape;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;

public class LaserDrawer extends objectDrawer {
    private static final float IMAGE_SIZE = 10;
    public static final int SQUARE_SIZE = 10;

    public LaserDrawer(PImage image) {
        super(image);
    }


    @Override
    float getImageCenter() {
        return IMAGE_SIZE / -2f;
    }

    public void draw(PGraphics graphics, Laser laser) {
        final Vector2 position = laser.getPosition();
        final float angle = calculateRotation(laser);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        graphics.noFill();
        graphics.noStroke();
        graphics.rect(SQUARE_SIZE/-2f,SQUARE_SIZE/-2f,SQUARE_SIZE,SQUARE_SIZE);
        graphics.image(image, getImageCenter(), getImageCenter());

        graphics.popMatrix();
    }

    public CollisionableShape getCollisionable(Laser laser) {
        return new LaserCollisionableShape(
                SQUARE_SIZE,
                calculateRotation(laser),
                laser.getPosition(),
                laser
        );
    }
}
