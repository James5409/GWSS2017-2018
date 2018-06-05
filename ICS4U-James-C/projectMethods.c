/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <math.h>
#include <stdio.h>
#include "projectMethods.h"

void acidRain(int ph){
    short int E = 12;
    long double F = 13;
    
    if(ph < 7)printf("The rain is acidic\n");
    else if(ph > 7)printf("The rain is basic\n");
    else printf("The rain in neutral\n");
  
}

void fibonacciSequence(int iterations){
    int lastNum = 0;
    int currNum = 1;
    int holder;
    printf("%d \n" , lastNum);
    printf("%d \n", currNum);
    for(int i = 0; i < iterations; i++){
        holder = currNum;
        currNum = currNum + lastNum;
        lastNum = holder;
        printf("%d \n", currNum);
    }
}

void arrayWeather(int mon, int tues, int wed, int thurs, int fri, int sat, int sun){
    int weekWeather[7];
    weekWeather[0] = mon;
    weekWeather[1] = tues;
    weekWeather[2] = wed;
    weekWeather[3] = thurs;
    weekWeather[4] = fri;
    weekWeather[5] = sat;
    weekWeather[6] = sun;
   
    int tempTotal = 0;
    int highestTemp = weekWeather[0];
    int lowestTemp = weekWeather[0];
    
    for (int i = 0; i < sizeof(weekWeather)/sizeof(weekWeather[0]); i++) {
        printf("%d \n", i);
        tempTotal = tempTotal + weekWeather[i];  
        if(weekWeather[i] > highestTemp) highestTemp = weekWeather[i];
        if(weekWeather[i] < lowestTemp) lowestTemp = weekWeather[i];   
    }
    printf("The highest temp is %d\n", highestTemp);
    printf("The lowest temp is %d\n", lowestTemp);
    printf("The average temp is %g\n", (double)tempTotal / (sizeof(weekWeather) / sizeof(weekWeather[0])));
}