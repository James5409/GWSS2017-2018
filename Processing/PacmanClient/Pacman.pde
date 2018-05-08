public class Pacman{
//class constants
public static final int STEP_SIZE = 3;
public static final int DIR_UP = 0;
public static final int DIR_LEFT = 1;
public static final int DIR_DOWN = 2;
public static final int DIR_RIGHT = 3;
public static final int DIR_FREEZE = -1;

//class varibles

//object varibles
private int xLoc = 100;
private int yLoc = 100;
private int currDirection;
private int lives = 3;


public Pacman(){
}


//Getters / Setters
public int getXLocation(){
  return this.xLoc;
}
public int getYLocation(){
  return this.yLoc;
}

void draw(){ 
  clear();
  fill(288,215,0);
  noStroke();
  ellipse(xLoc, yLoc, 30, 30);
  //background(120);
}
void move(int direction){
  
  currDirection = direction;
  
  if(currDirection == 0) this.yLoc = this.yLoc - STEP_SIZE;
  else if(currDirection == 3) this.xLoc = this.xLoc + STEP_SIZE;
  else if(currDirection == 1)this.xLoc = this.xLoc - STEP_SIZE;
  else if(currDirection == 2) this.yLoc = this.yLoc + STEP_SIZE;
  
}


}