/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dog.word.search;

/**
 *
 * @author jamers444
 */
public class DogWordSearch {

    /**
     * @param args the command line arguments
     */
    static char[][] wordSearch = {
        {'D', 'G', 'O', 'O', 'D', 'D', 'O', 'D', 'G', 'O', 'O', 'D', 'D', 'O'},
        {'O', 'D', 'O', 'O', 'G', 'G', 'G', 'D', 'O', 'D', 'G', 'O', 'G', 'G'},
        {'O', 'G', 'O', 'G', 'D', 'O', 'O', 'D', 'G', 'O', 'O', 'D', 'D', 'D'},
        {'D', 'G', 'D', 'O', 'O', 'O', 'G', 'G', 'O', 'O', 'G', 'D', 'G', 'O'},
        {'O', 'G', 'G', 'O', 'D', 'G', 'D', 'G', 'O', 'G', 'G', 'O', 'G', 'D'},
        {'D', 'D', 'D', 'G', 'D', 'D', 'O', 'D', 'O', 'O', 'G', 'D', 'O', 'O'},
        {'O', 'D', 'G', 'O', 'G', 'G', 'D', 'O', 'O', 'G', 'G', 'O', 'O', 'D'}

    };

    public static void main(String[] args) {
        boolean wordFound = false; 
        
        for (int r = 0; r < wordSearch.length && wordFound == false; r++) {
            for (int c = 0; c < wordSearch[0].length && wordFound == false; c++) {
                //System.out.println("row:" + r + " col:" + c );
                
                if(checkUp(c, r) == true){
                    System.out.println("the word was found at row:" + (r + 1) + " and col:" + (c + 1) + " going up");
                    wordFound = true;
                }
                if(checkDown(c, r) == true){
                    System.out.println("the word was found at row:" + (r + 1) + " and col:" + (c + 1) + " going Down");
                    wordFound = true;
                }
                if(checkLeft(c, r) == true){
                    System.out.println("the word was found at row:" + (r + 1) + " and col:" + (c + 1) + " going Left");
                    wordFound = true;
                }
                if(checkRight(c, r) == true){
                    System.out.println("the word was found at row:" + (r + 1) + " and col:" + (c + 1) + " going Right");
                    wordFound = true;
                }
                
                
//                checkUp(c, r);
//                checkDown(c, r);
//                checkLeft(c, r);
//                checkRight(c, r);
            }

        }
    }

    public static boolean checkUp(int c, int r) {
        String foundWord = null;
        boolean wordFound = false;
        boolean valid = false;
        if (r >= 2 && r <= 5) {
            valid = true;
            foundWord = "" + wordSearch[r][c] + wordSearch[r - 1][c] + wordSearch[r - 2][c];
        }
        if (valid == true) {
            wordFound = foundWord.equals("DOG");
        }
        return wordFound;
    }

    public static boolean checkDown(int c, int r) {
        String foundWord = null;
        boolean wordFound = false;
        boolean valid = false;
        if (r >= 0 && r <= 3) {
            valid = true;
            foundWord = "" + wordSearch[r][c] + wordSearch[r + 1][c] + wordSearch[r + 2][c];
        }
        if (valid == true) {
            wordFound = foundWord.equals("DOG");
        }
        return wordFound;
    }

    public static boolean checkRight(int c, int r) {
        String foundWord = null;
        boolean wordFound = false;
        boolean valid = false;
        if (c >= 0 && c <= 11) {
            valid = true;
            foundWord = "" + wordSearch[r][c] + wordSearch[r][c + 1] + wordSearch[r][c + 2];
        }
        if (valid == true) {
            wordFound = foundWord.equals("DOG");
        }
        return wordFound;
    }

    public static boolean checkLeft(int c, int r) {
        String foundWord = null;
        boolean wordFound = false;
        boolean valid = false;
        if (c >= 2 && c <= 14) {
            valid = true;
            foundWord = "" + wordSearch[r][c] + wordSearch[r][c - 1] + wordSearch[r][c - 2];
        }
        if (valid == true) {
            wordFound = foundWord.equals("DOG");
        }
        return wordFound;
    }
}
