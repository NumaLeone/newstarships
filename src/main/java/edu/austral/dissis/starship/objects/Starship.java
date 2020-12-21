package edu.austral.dissis.starship.objects;

import edu.austral.dissis.starship.base.vector.Vector2;

public class Starship extends GameObject{
    public String shipName;
    public int score;
    public int lives;

    public Starship(Vector2 position, Vector2 direction, boolean active, String shipName, int score, int lives) {
        this.position = position;
        this.direction = direction.asUnitary();
        this.active = active;
        this.shipName = shipName;
        this.score=score;
        this.lives=lives;
    }

    public Starship rotate(float angle) {
        return new Starship(position, direction.rotate(angle),active,shipName,score,lives);
    }

    public Starship moveForward(float speed) {
        return new Starship(position.add(direction.multiply(speed)), direction,active,shipName,score,lives);
    }

    public Starship moveBackwards(float speed) {
        return new Starship(position.subtract(direction.multiply(speed)), direction,active,shipName,score,lives);
    }

    public Laser shoot() {
        return new Laser(this.position,this.direction, active,shipName,0);
    }

    @Override
    public void destroy() {
        active = false;
        lives = lives-1;
    }

    public int getLives(){
        return lives;
    }

    public int getScore(){
        return score;
    }

    public String getShipName(){
        return shipName;
    }
}
