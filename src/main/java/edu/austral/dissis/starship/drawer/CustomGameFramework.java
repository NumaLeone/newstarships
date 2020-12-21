package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.StarshipController;
import edu.austral.dissis.starship.base.collision.CollisionEngine;
import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.collisionable.CollisionableShape;
import edu.austral.dissis.starship.objects.Asteroid;
import edu.austral.dissis.starship.objects.AsteroidSpawner;
import edu.austral.dissis.starship.objects.Laser;
import edu.austral.dissis.starship.objects.Starship;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class CustomGameFramework implements GameFramework {

    private final int height = 720;
    private final int width = 1280;

    private GlobalDrawer globalDrawer;

    private AsteroidSpawner asteroidSpawner;
    private Starship starship1;
    private final StarshipController starshipController1 = new StarshipController(0x26, 0x28, 0x25, 0x27, 0x6B);
    private Starship starship2;
    private final StarshipController starshipController2 = new StarshipController(0x57, 0x53, 0x41, 0x44, 0x20);

    private List<Laser> lasers = new ArrayList<>();
    private List<Laser> lasers2 = new ArrayList<>();
    private List<Asteroid> asteroids = new ArrayList<>();

    private final CollisionEngine engine = new CollisionEngine();

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(width, height);

        globalDrawer = new GlobalDrawer(imageLoader);

        String player1Name;
        String player2Name;
        player1Name = JOptionPane.showInputDialog("What is player 1's name? ");
        player2Name = JOptionPane.showInputDialog("What is player 2's name? ");
        starship1 = new Starship(vector(200, 200), vector(0, 1), true, player1Name, 0, 3);
        starship2 = new Starship(vector(800, 520), vector(0, -1), true, player2Name, 0, 3);

        asteroidSpawner = new AsteroidSpawner(width, height);
        for (int i = 0; i < 5; i++) {
            asteroids.add(asteroidSpawner.spawnAsteroid());
        }

    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        updateStarship(keySet);
        updater.updateProjectiles(lasers, lasers2, starship1, starship2);
        updater.updateAsteroids(timeSinceLastDraw, asteroids, asteroidSpawner);
        globalDrawer.draw(graphics, asteroids, lasers, lasers2, starship1, starship2);
        checkCollisions();
    }

    private void checkCollisions() {
        List<CollisionableShape> collisionables = globalDrawer.getCollisionables(asteroids, lasers, lasers2, starship1, starship2);
        engine.checkCollisions(collisionables);
    }

    private void updateStarship(Set<Integer> keySet) {

        if (starship1.getLives() > 0) {
            if (!starship1.active) {
                starship1 = new Starship(vector(200, 200), vector(0, 1), true, starship1.shipName, starship1.score, starship1.lives);
            } else {
                starship1 = starshipController1.keyHandle(keySet, starship1, lasers);
            }
            starship1 = starshipController1.starshipWarpEdge(starship1, width, height);
        }

        if (starship2.getLives() > 0) {
            if (!starship2.active) {
                starship2 = new Starship(vector(800, 520), vector(0, -1), true, starship2.shipName, starship2.score, starship2.lives);
            } else {
                starship2 = starshipController2.keyHandle(keySet, starship2, lasers2);
            }
            starship2 = starshipController2.starshipWarpEdge(starship2, width, height);
        }

    }

    @Override
    public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }
}
