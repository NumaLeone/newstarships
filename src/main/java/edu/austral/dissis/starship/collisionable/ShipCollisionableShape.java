package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Starship;

public class ShipCollisionableShape extends CollisionableShape {
    Starship starship;
    public ShipCollisionableShape(int size, float angle, Vector2 position, Starship starship) {
        super(size, angle, position);
        this.starship = starship;
    }

    @Override
    public void collisionedWith(CollisionableShape collisionable){
        collisionable.collisionedWithShip(this);
    }

    @Override
    public void collisionedWithProjectile(LaserCollisionableShape collisionable) {
        if(!collisionable.laser.shipName.equals(starship.shipName)) {
            collisionable.laser.destroy();
        }
    }

    @Override
    public void collisionedWithShip(ShipCollisionableShape collisionable) {
        collisionable.starship.destroy();
    }

    @Override
    public void collisionedWithAsteroid(AsteroidCollisionableShape collisionable) {
        collisionable.asteroid.destroy();
    }
}
