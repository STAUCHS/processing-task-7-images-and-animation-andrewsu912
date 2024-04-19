import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Declare Variables
  PImage imgBeach;
  PImage imgBeachBall;

  float fltBeachBallX = 50;
  float fltBeachBallY = 290;
  float fltBeachBallXSpeed = 5;
  float fltBeachBallYSpeed = 5;

  float fltSunX = 50;
  float fltSunY = 150;
  float fltSunXSpeed = 3;
  float fltSunYSpeed = -5; 
  float fltSunGravity = 0.1f; 

  int yellow = color(255, 238, 48);

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // Load images
    imgBeachBall = loadImage("BeachBall.png");
    imgBeachBall.resize(50, 50);

    imgBeach = loadImage("Beach.png");
    imgBeach.resize(400, 400);
  }

  public void draw() {
    // Beach ball movement
    background(imgBeach);

    image(imgBeachBall, fltBeachBallX, fltBeachBallY);
    fltBeachBallX += fltBeachBallXSpeed;
    fltBeachBallY += fltBeachBallYSpeed;

    // Border restrictions
    if (fltBeachBallX > width - imgBeachBall.width || fltBeachBallX < 0) {
      fltBeachBallXSpeed *= -1;
    }

    if (fltBeachBallY > height - imgBeachBall.height || fltBeachBallY < 0) {
      fltBeachBallYSpeed *= -1;
    }

    // Sun movement
    fill(yellow);
    ellipse(fltSunX, fltSunY, 60, 60);

    fltSunX += fltSunXSpeed;
    fltSunY += fltSunYSpeed;
    fltSunYSpeed += fltSunGravity;

    // Sun restrictions
    if (fltSunX > width - 25) {
      fltSunXSpeed *= -1;
      fltSunYSpeed *= -1;
    }

    if (fltSunX < 25) {
      fltSunXSpeed *= -1;
      fltSunYSpeed *= -1;
    }
  }
}
