package edu.austral.dissis.starship.objects;

import edu.austral.dissis.starship.base.vector.Vector2;

public class Laser extends GameObject{
    public String shipName;
    public int scoreToAdd;

    public Laser(Vector2 position, Vector2 direction, boolean active, String shipName, int scoreToAdd) {
        this.position = position;
        this.direction = direction.asUnitary();
        this.active = active;
        this.shipName = shipName;
        this.scoreToAdd = scoreToAdd;
    }
    @Override
    public Laser moveForward(float speed) {
        return new Laser(position.add(direction.multiply(speed)), direction, active, shipName, scoreToAdd);
    }
    @Override
    public void destroy() {
        active = false;
    }
}
