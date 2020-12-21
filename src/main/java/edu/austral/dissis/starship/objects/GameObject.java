package edu.austral.dissis.starship.objects;

import edu.austral.dissis.starship.base.vector.Vector2;

public abstract class GameObject {

    Vector2 position;
    Vector2 direction;
    public boolean active;
    public int lives;

    public Vector2 getPosition() { return position; }

    public Vector2 getDirection() { return direction; }

    public void destroy(){
        active = false;
        lives = lives-1;
    }
    public int getLives(){
        return lives;
    }

   public abstract GameObject moveForward(float speed);


}
