package edu.austral.dissis.starship.collisionable;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Starship;

public class StarshipCollisionableShape extends CollisionableShape {
    Starship starship;
    public StarshipCollisionableShape(int size, float angle, Vector2 position, Starship starship) {
        super(size, angle, position);
        this.starship = starship;
    }

    @Override
    public void collisionedWith(CollisionableShape collisionable){
        collisionable.collisionedWithStarship(this);
    }

    @Override
    public void collisionedWithProjectile(LaserCollisionableShape collisionable) {
        if(!collisionable.laser.shipName.equals(starship.shipName)) {
            collisionable.laser.destroy();
        }
    }

    @Override
    public void collisionedWithStarship(StarshipCollisionableShape collisionable) {
        collisionable.starship.destroy();
    }

    @Override
    public void collisionedWithAsteroid(AsteroidCollisionableShape collisionable) {
        collisionable.asteroid.destroy();
    }
}
