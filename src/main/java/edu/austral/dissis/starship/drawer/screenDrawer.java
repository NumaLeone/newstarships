package edu.austral.dissis.starship.drawer;

import edu.austral.dissis.starship.objects.Starship;
import processing.core.PGraphics;
import processing.core.PImage;

public class screenDrawer {

    private final PImage BackgroundImage;
    private final PImage goImage;

    public screenDrawer(PImage image, PImage goImage) {
        this.BackgroundImage = image;
        this.goImage = goImage;
    }

    public void draw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.noFill();
        graphics.noStroke();
        graphics.image(BackgroundImage, 0, 0);
        graphics.popMatrix();
    }

    public void drawGameOver(PGraphics graphics){
        graphics.pushMatrix();
        graphics.noFill();
        graphics.noStroke();
        graphics.image(goImage, 0, 0);
        graphics.popMatrix();
    }
    public void draw(PGraphics graphics, Starship starship, float ypos) {
        graphics.pushMatrix();
        String text;
        if(starship.getLives()<1) text=starship.shipName+ " Died!";
        else text=starship.getShipName() + " Lives: " + starship.getLives() + "| Points: " + starship.getScore();
        graphics.textSize(22);
        graphics.text(text,0,ypos);
        graphics.popMatrix();
    }

    public void drawGameOver(PGraphics graphics, Starship starship, float ypos, boolean winner) {
        graphics.pushMatrix();
        String text=starship.shipName+ " scored "+starship.getScore()+ " points!";
        if(winner) text += " WINNER!";
        graphics.textSize(32);
        if(winner) graphics.text(text,380,ypos);
        else graphics.text(text,450,ypos);
        graphics.popMatrix();
    }
}
