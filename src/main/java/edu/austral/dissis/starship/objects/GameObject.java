package edu.austral.dissis.starship.objects;

import edu.austral.dissis.starship.base.vector.Vector2;

public abstract class GameObject {

    Vector2 position;
    Vector2 direction;
    public boolean active;

    public Vector2 getPosition() { return position; }

    public Vector2 getDirection() { return direction; }

    public abstract void destroy();

   // public abstract GameObject moveForward(); no me conviene hacerlo porque cada gameobject se mueve de forma distinta


}
