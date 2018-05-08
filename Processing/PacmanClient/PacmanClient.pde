Pacman p;
Ghost blinky;
final int SCREEN_WIDTH = 600;
final int SCREEN_LENGTH = 600;

void setup(){
  frameRate(60);
  size(600, 600);
  p = new Pacman();
  blinky = new Ghost(255,0,0);
}

void draw(){
  p.draw();
  blinky.draw();
  pacManMovment();
  blinkyMovment();
}

void pacManMovment(){
  switch(key){
    case 'd':
      if(p.getXLocation() < SCREEN_LENGTH - 40)p.move(Pacman.DIR_RIGHT);
      break;
    case 'a':
      if(p.getXLocation() > 40)p.move(Pacman.DIR_LEFT);
      break;
    case 's':
      if(p.getYLocation() < SCREEN_WIDTH - 40)p.move(Pacman.DIR_DOWN);
      break;
    case 'w':
      if(p.getYLocation() > 40)p.move(Pacman.DIR_UP);
  }
}

void blinkyMovment(){
  if(p.getXLocation() > blinky.getXLocation()){
    blinky.move(blinky.DIR_RIGHT);
  }
  else if(p.getXLocation() < blinky.getXLocation()){
    blinky.move(blinky.DIR_LEFT);
  }
  else if(p.getYLocation() < blinky.getYLocation()){
    blinky.move(blinky.DIR_UP);
  }
  else if(p.getYLocation() > blinky.getYLocation()){
    blinky.move(blinky.DIR_DOWN);
  }
}