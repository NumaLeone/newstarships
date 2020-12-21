package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.collisionable.NullCollisionableShape;
import edu.austral.dissis.starship.collisionable.StarshipCollisionableShape;
import edu.austral.dissis.starship.collisionable.CollisionableShape;
import edu.austral.dissis.starship.objects.Starship;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;

public class StarshipDrawer extends objectDrawer{
    private static final float IMAGE_SIZE = 100;
    public static final int SQUARE_SIZE = 70;

    public StarshipDrawer(PImage image) {
        super(image);
    }


    @Override
    float getImageCenter() {
        return IMAGE_SIZE / -2f;
    }

    public void draw(PGraphics graphics, Starship starship) {
        if(starship.getLives()<1) return;
        final Vector2 position = starship.getPosition();
        final float angle = calculateRotation(starship);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        graphics.noFill();
        graphics.noStroke();
        graphics.rect(SQUARE_SIZE/ -2f, SQUARE_SIZE / -2f, SQUARE_SIZE, SQUARE_SIZE);
        graphics.image(image, getImageCenter(), getImageCenter());

        graphics.popMatrix();
    }

    public CollisionableShape getCollisionable(Starship starship) {
        if(starship.getLives()<1) return new NullCollisionableShape();
        return new StarshipCollisionableShape(
                SQUARE_SIZE,
                calculateRotation(starship),
                starship.getPosition(),
                starship
        );
    }
}
