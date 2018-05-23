/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: jamers444
 *
 * Created on May 9, 2018, 8:42 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*
 * 
 */
void fibonacciSequence(void);
void acidRain(int ph);
int main(int argc, char** argv) {
    //acidRain(10);
    fibonacciSequence();
}

void acidRain(int ph){
    if(ph > 7)printf("The rain is acidic");
    else if(ph < 7)printf("The rain is basic");
    else printf("The rain in neutral");
    
}

void fibonacciSequence(void){
    int lastNum = 0;
    int currNum = 1;
    int holder;
    printf("%d \n" , lastNum);
    printf("%d \n", currNum);
    for(int i = 0; i < 15; i++){
        holder = currNum;
        currNum = currNum + lastNum;
        lastNum = holder;
        printf("%d \n", currNum);
    }
}

