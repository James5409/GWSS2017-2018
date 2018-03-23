/*
 * 'Merica
 * 2017-18.S2
 */
import java.util.Scanner;
import java.util.StringTokenizer;

final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt"
};
//text files
int value;
String fileName;
String[][] electionResults;
double resRed,resBlue,resGreen;
//varible inilization
/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  size( 1200, 600 );

  // DEFAULT MAP
  fileName = FILE_NAMES_ELECTIONS[0];

  // ELECTION RESULTS
  electionResult();
  drawMap();
  
}
/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
 void draw(){
   
 }
void electionResult() {
  try {
    
    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "//" + fileName ) );
    data.nextLine();
    electionResults = new String[51][4];
    StringTokenizer st;
    
     //local varibles
    int i = 0;
    int j;
    while(data.hasNextLine()){
      st = new StringTokenizer(data.nextLine(), ",");
        j = 0;
        while(st.hasMoreTokens()){
          electionResults[i][j] = st.nextToken();
          j++;
        }
      i++;
    }
    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() {
  // MAP
  try {

    // USA MAP DATA
    float red =0, blue = 0, green = 0;
    int rep = 0, dem = 0, oth= 0;
    Scanner data = new Scanner( new File( dataPath("") + "//" +"USA.txt" ) );
    String currState;
    //MIN LAT AND LONG
    double minLong = data.nextDouble();
    double minLat = data.nextDouble();
    //MAX LAT AND LONG
    data.nextLine();
    double maxLong = data.nextDouble();
    double maxLat = data.nextDouble();
    //FINDS AMOUNT OF LOOPS
    data.nextLine();
    int regionLoops = data.nextInt();
    //MAP CONST
    double mapConstDiff;
    double mapConstSize;
    
    //DRAWING MAP CALCS
    if(maxLat - minLat < maxLong - minLong){
      mapConstDiff = maxLat - minLat;
    }else{
      mapConstDiff = maxLong = minLong;
    }
    
    if(1200/mapConstDiff < 600/mapConstDiff){
      mapConstSize = 1200/mapConstDiff;
    }else{
      mapConstSize = 600/mapConstDiff;
    }
    
    
    int localLoops;
    int k;
    boolean stateFound;
    for(int i = 0; i < regionLoops; i++){
      
      stateFound = false;
      //GETTING CURRENT LINE
      data.nextLine();
      currState = data.next();
      data.nextLine();
      data.nextLine();
      stateFound = false;
      k = 0;
      for(int region = 0; region < electionResults.length; region++){
        if(currState.equals(electionResults[region][0])){
          //election results
          rep = Integer.parseInt(electionResults[region][1]);
          dem = Integer.parseInt(electionResults[region][2]);
          oth = Integer.parseInt(electionResults[region][3]);
        }
      }
        //COLOUR CALCULATIONS
        red = ((float)rep / (rep + dem + oth)) * 255;
        blue = ((float)dem / (rep + dem + oth)) * 255;
        green = ((float)oth / (rep + dem + oth)) * 255;
      fill(red, green, blue);
      //drawing each state
      beginShape();
      localLoops = data.nextInt();
      for(int j = 0; j < localLoops; j++){
        vertex((float)(((data.nextDouble() + Math.abs(minLong)) * (mapConstSize - 3.399))), (float)(((Math.abs(maxLat) - data.nextDouble()) * mapConstSize)));
        //Calculations for centering map
        data.nextLine();
      }
      endShape();
    } 
    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 */
 //Switches colour for each year
void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    println( fileName );
    electionResult();
    drawMap();
  }
}