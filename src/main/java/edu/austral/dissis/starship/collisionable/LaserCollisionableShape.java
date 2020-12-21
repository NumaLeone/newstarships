package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Laser;

public class LaserCollisionableShape extends CollisionableShape {
    Laser laser;
    public LaserCollisionableShape(int size, float angle, Vector2 position, Laser laser) {
        super(size, angle, position);
        this.laser = laser;
    }

    @Override
    public void collisionedWith(CollisionableShape collisionable) {
        collisionable.collisionedWithProjectile(this);
    }

    @Override
    public void collisionedWithProjectile(LaserCollisionableShape collisionable) {
    }

    @Override
    public void collisionedWithStarship(StarshipCollisionableShape collisionable) {
        if(!this.laser.shipName.equals(collisionable.starship.shipName)) {
            collisionable.starship.destroy();
            this.laser.scoreToAdd = 100;
        }
    }

    @Override
    public void collisionedWithAsteroid(AsteroidCollisionableShape collisionable) {
        collisionable.asteroid.destroy();
        this.laser.scoreToAdd = (int) (collisionable.asteroid.speed*20);
        this.laser.destroy();
    }

}
