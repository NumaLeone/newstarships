package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.vector.Vector2;

public class NullCollisionableShape extends CollisionableShape {

    public NullCollisionableShape() {
        super(0,0, Vector2.vector(0,0));
    }

    @Override
    public void collisionedWithProjectile(LaserCollisionableShape collisionable) {

    }

    @Override
    public void collisionedWithShip(ShipCollisionableShape collisionable) {

    }

    @Override
    public void collisionedWithAsteroid(AsteroidCollisionableShape collisionable) {

    }
}
