package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.collision.Collisionable;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public abstract class CollisionableShape implements Collisionable<CollisionableShape> {
    private final float size;
    private final float angle;
    private final Vector2 position;

    public CollisionableShape(int size, float angle, Vector2 position) {
        this.size = size;
        this.angle = angle;
        this.position = position;
    }

    @Override
    public Shape getShape() {
        final Rectangle2D baseSquare = new Rectangle2D.Float(size / -2, size / -2, size, size);
        final Path2D.Float path = new Path2D.Float();
        path.append(baseSquare, false);

        final AffineTransform transform = new AffineTransform();
        transform.translate(position.getX(), position.getY());
        transform.rotate(angle);

        path.transform(transform);

        return path;
    }

    @Override
    public void collisionedWith(CollisionableShape collisionable) {
        System.out.println("Collisioned with " + collisionable);
    }

    public abstract void collisionedWithProjectile(LaserCollisionableShape collisionable);

    public abstract void collisionedWithShip(ShipCollisionableShape collisionable);

    public abstract void collisionedWithAsteroid(AsteroidCollisionableShape collisionable);
}
