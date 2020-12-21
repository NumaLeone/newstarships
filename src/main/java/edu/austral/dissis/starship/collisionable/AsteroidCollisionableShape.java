package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Asteroid;

public class AsteroidCollisionableShape extends CollisionableShape {

    Asteroid asteroid;

    public AsteroidCollisionableShape(int size, float angle, Vector2 position, Asteroid asteroid) {
        super(size, angle, position);
        this.asteroid=asteroid;
    }

    @Override
    public void collisionedWith(CollisionableShape collisionable){
        collisionable.collisionedWithAsteroid(this);
    }

    @Override
    public void collisionedWithProjectile(LaserCollisionableShape collisionable) {
        collisionable.laser.destroy();
        this.asteroid.destroy();
    }

    @Override
    public void collisionedWithStarship(StarshipCollisionableShape collisionable) {
        collisionable.starship.destroy();
    }

    @Override
    public void collisionedWithAsteroid(AsteroidCollisionableShape collisionable) {
    }
}
