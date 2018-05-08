public class Ghost{
//class constants
public static final int STEP_SIZE = 2;
public static final int DIR_UP = 0;
public static final int DIR_LEFT = 1;
public static final int DIR_DOWN = 2;
public static final int DIR_RIGHT = 3;

//class varibles

//object varibles
private int xLoc = 300;
private int yLoc = 300;
private int currDirection;
private int red,green,blue;

public Ghost(){
  red = 255;
  green = 255;
  blue = 255;
}

public Ghost(int r, int g, int b){
  red = r;
  green = g;
  blue = b;
}

//Getters / Setters
public int getXLocation(){
  return this.xLoc;
}
public int getYLocation(){
  return this.yLoc;
}

void draw(){
  fill(red,green,blue);
  rect(xLoc, yLoc, 30, 30);
  ellipse((float)xLoc + 15, (float)yLoc, 30, 30);
}
void move(int direction){
  
  currDirection = direction;
  
  if(currDirection == 0) this.yLoc = this.yLoc - STEP_SIZE;
  else if(currDirection == 3) this.xLoc = this.xLoc + STEP_SIZE;
  else if(currDirection == 1)this.xLoc = this.xLoc - STEP_SIZE;
  else if(currDirection == 2) this.yLoc = this.yLoc + STEP_SIZE;
  
  
}
}