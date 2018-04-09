void setup() {
  size( 900, 900 ); 
  ellipseFractal(450,450,450);
}

void ellipseFractal(float x, float y, float d){
  stroke(200,0,0);
  noFill();
  ellipse(x, y, d, d);
  if(d > 8){//draws circle to the top,bottem,left,right of the circle
  ellipseFractal(x + d/2, y, d/2);
  ellipseFractal(x - d/2, y, d/2);
  ellipseFractal(x, y + d/2, d/2);
  ellipseFractal(x, y - d/2, d/2);
  }
}