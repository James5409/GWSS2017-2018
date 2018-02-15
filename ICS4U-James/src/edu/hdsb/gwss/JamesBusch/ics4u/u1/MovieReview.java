/*
 *
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReview {
    
    /**
     *
     */
    public static final int WORD_COUNT = 0;
    public static final int TOTAL_SCORE = 1;
    //to give getting array numbers meaning
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {

        // MOVIE REVIEW FILE
        File reviews = new File( "/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/MovieReviews.txt" );
        File wordList = new File("/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/negTest.txt");
        File compareWords = new File("/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/userInput.txt");
        //file inilization
        
        double x;
        
        
       
        mutipleWordScore(compareWords, reviews);
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     * @throws java.lang.Exception
     */
    public static int wordCount( String word, File reviews ) throws Exception {
       int[] finalAnswers;
       finalAnswers = readLineByLine(word, reviews);
       return finalAnswers[WORD_COUNT]; 
    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     * @throws java.lang.Exception
     */
    public static int wordTotalScore( String word, File reviews ) throws Exception {
        int[] finalAnswers;
        finalAnswers = readLineByLine(word, reviews);
        return finalAnswers[TOTAL_SCORE];
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @return the average score for the key word. Word Total Score / Word Count
     * @throws java.lang.Exception
     */
    public static double wordAverage( String word, File reviews ) throws Exception {
        double totalScore;
        double numOfWords;
        double answer;
        
        int[] finalAnswers;
        finalAnswers = readLineByLine(word, reviews);
        totalScore = finalAnswers[TOTAL_SCORE];
        numOfWords = finalAnswers[WORD_COUNT];
        if(numOfWords == 0){
            answer = 0;
        }else{
            answer = totalScore/numOfWords;
            }  
        System.out.println(answer);
        return answer;
       
    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given the specified movie review file.
     * @param wordList list of words to be tested
     * @param reviews file of all reviews
     * @return the average score of all words combined 
     * @throws java.lang.Exception 
     */
    public static double sentenceAverage( File wordList, File reviews ) throws Exception {
        Scanner userData = new Scanner(wordList);    
        double currScore = 0;
        int i = 0;
        String currLine;

        while(userData.hasNextLine()){
            currLine = userData.nextLine();
            System.out.println(currLine);
            currScore = currScore + wordAverage(currLine,reviews);
            if(wordCount(currLine, reviews) != 0){ 
                i++;
            }
        }
        return currScore / i;
    }
    
    /**
     *
     * @param wordList list of user input words
     * @param reviews list of all reviews
     * @throws Exception
     */
    public static void mutipleWordScore( File wordList, File reviews ) throws Exception{
        Scanner userData = new Scanner(wordList);
        
        double currScore;
        double bestScore = 0;
        double worstScore = 4;
        String bestWord = null;
        String worstWord = null;
        String currWord;
        
        
        while(userData.hasNextLine()){
            currWord = userData.nextLine();
            currScore = wordAverage(currWord,reviews);
            if(currScore > bestScore){
                bestScore = currScore;
                bestWord = currWord;
            }else if(currScore < worstScore){
                worstScore = currScore;
                worstWord = currWord;
            }   
            System.out.println("The worst word is " + worstWord + " with a " + worstScore);
            System.out.println("The best word is " + bestWord + "with a " + bestScore);   
        }
    }
    
    public static void wordSort(File wordList, File reviews) throws Exception{
        Scanner userData = new Scanner(wordList);
        FileWriter badWords = new FileWriter("/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/negative.txt");
        FileWriter goodWords = new FileWriter("/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/positive.txt");
        PrintWriter printBadWords = new PrintWriter(badWords);
        PrintWriter printGoodWords = new PrintWriter(goodWords);
        int i = 0;
        double score;
        System.out.println("done start");
        
        while(userData.hasNextLine()){
            score = wordAverage(userData.nextLine(), reviews);
            if(score >= 2.1){
                printBadWords.println(userData.toString());
            }else if(score <= 1.9){
                printGoodWords.println(userData.toString());
            }
            System.out.println(i++);
        }
        
        badWords.close();
        goodWords.close();
        printBadWords.close();
        printGoodWords.close();
        
        
    }
    
    
    /**
     *
     * @param word the key word that wants to be found
     * @param reviews the list of reviews
     * @return an array with wordCount at i = 0 and totalScore at i = 1
     * @throws java.lang.Exception
     */
    public static int[] readLineByLine(String word, File reviews) throws Exception {//a = 0 is word count, a = 1 is score count
        Scanner textFile = new Scanner(reviews);
        word = word.toLowerCase();
        int[] arrayTotal = new int[2];
        int currScore;
        int i = 0;
        int totalScore = 0;
        boolean hasWord;
        while(textFile.hasNextLine()){
            hasWord = false;
            StringTokenizer st = new StringTokenizer(textFile.nextLine().toLowerCase());
            currScore = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                if(st.nextToken().equals(word) && hasWord == false){
                    hasWord = true;
                    totalScore = currScore + totalScore;
                    i++;
                }      
            }
        }
        arrayTotal[0] = i;
        arrayTotal[1] = totalScore;
        return arrayTotal;
    }
}
