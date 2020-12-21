package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.StarshipController;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.objects.Asteroid;
import edu.austral.dissis.starship.objects.AsteroidSpawner;
import edu.austral.dissis.starship.objects.Laser;
import edu.austral.dissis.starship.objects.Starship;

import java.util.List;
import java.util.Set;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class updater {

    private static final int height=720;
    private static final int width=1280;
    private static final StarshipController starshipController1 = new StarshipController(0x26,0x28,0x25,0x27, 0x6B);
    private static final StarshipController starshipController2 = new StarshipController( 0x57,0x53,0x41,0x44,0x20);

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
//    static void updateStarship(Set<Integer> keySet, Starship starship1, Starship starship2, List<Laser> lasers, List<Laser> lasers2) {
//
//        if(starship1.getLives()>0){
//            if(!starship1.active){
//                starship1 =  new Starship(vector(200, 200), vector(0, 1),true,starship1.shipName,starship1.score,starship1.lives);
//            }else {
//                starship1 = starshipController1.keyHandle(keySet,starship1, lasers);
//            }
//            starship1 = starshipController1.starshipWarpEdge(starship1,width,height);
//        }
//
//        if(starship2.getLives()>0){
//            if(!starship2.active){
//                starship2 = new Starship(vector(200,520),vector(0,-1),true,starship2.shipName,starship2.score,starship2.lives);
//            } else {
//                starship2 = starshipController2.keyHandle(keySet,starship2, lasers2);
//            }
//            starship2 = starshipController2.starshipWarpEdge(starship2,width,height);
//        }
//
//    }
    private void updateStarships(Set<Integer> keySet, List<Laser> lasers, List<Laser> lasers2, Starship starship1, Starship starship2){
         updateStarship(keySet, starship1, lasers);
         updateStarship(keySet, starship2, lasers2);
    }
private void updateStarship(Set<Integer> keySet, Starship starship,List<Laser> lasers) {

    if(starship.getLives()>0){
        if(!starship.active){
            starship =  new Starship(vector(200, 200), vector(0, 1),true,starship.shipName,starship.score,starship.lives);
        }else {
            starship = starshipController1.keyHandle(keySet,starship, lasers);
        }
        starship = starshipController1.starshipWarpEdge(starship,width,height);
    }

}



}
