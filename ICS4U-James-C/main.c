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
#include "projectMethods.h"
/*
 * 
 */

typedef struct{
    int age;
    int id;

    char * firstName;
    char * lastName ;
} Student;


int main(int argc, char** argv) {
    
    Student ahmad;
    Student james;
    
    ahmad.age = 17;
    ahmad.firstName = "Ahmad";
    ahmad.lastName = "Elmasri";
    printf("%s", ahmad.firstName);
    printf("\n%s", ahmad.lastName);
    
    
    struct number{
        int f1;
        int f2;
    }numberOne, numberTwo;
    numberOne.f1 = 4;
    printf("\n%d", numberOne.f1);
    printf("%d", numberTwo.f1);
    
    
    int userInput;
    double ahmadIsALoser = 4.2;
    printf("Input ph level of water\n");
    scanf("%d", &userInput);
    acidRain(userInput);
    fibonacciSequence(30);
    arrayWeather(21,-5,10,15,10,-4,20); 
    
    
    return(0);
    
    
}