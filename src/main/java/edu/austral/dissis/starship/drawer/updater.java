package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Asteroid;
import edu.austral.dissis.starship.objects.AsteroidSpawner;
import edu.austral.dissis.starship.objects.Laser;
import edu.austral.dissis.starship.objects.Starship;

import java.util.List;

public class updater {

    private static final int height=720;
    private static final int width=1280;

     static void updateAsteroids(float timeSinceLastDraw, List<Asteroid> asteroids, AsteroidSpawner asteroidSpawner){
        asteroids = asteroidSpawner.AsteroidCheck(timeSinceLastDraw,asteroids);
        for (int i = asteroids.size()-1; i >= 0; i--) {
            if (!asteroids.get(i).active) asteroids.remove(i);
        }
        for (int i = 0; i < asteroids.size(); i++) {
            Asteroid current = asteroids.get(i).moveForward(asteroids.get(i).getSpeed());
            asteroids.set(i, current.screenWarp(width,height));
        }
    }
     static void updateProjectiles(List<Laser> lasers, List<Laser> lasers2, Starship starship1, Starship starship2){
        updateProjectilesHandler(lasers, starship1, starship2);
        updateProjectilesHandler(lasers2, starship1, starship2);
    }

    static  private void updateProjectilesHandler(List<Laser> laserList, Starship starship1, Starship starship2){
        for (int i = 0; i < laserList.size(); i++) {
            laserList.set(i, laserList.get(i).moveForward(8));
        }
        for (int i = laserList.size()-1; i >=0 ; i--) {
            Vector2 current = laserList.get(i).getPosition();
            if( !laserList.get(i).active || current.getX()>width || current.getX()<0 || current.getY()>height || current.getY()<0){
                updateStarshipScore(laserList.get(i), starship1, starship2);
                laserList.remove(i);
            }
        }
    }
    static private void updateStarshipScore(Laser laser, Starship starship1, Starship starship2){
        if(laser.scoreToAdd!=0){
            if (starship1.getShipName().equals(laser.shipName)) starship1.score+= laser.scoreToAdd;
            else starship2.score+= laser.scoreToAdd;
        }
    }
}
