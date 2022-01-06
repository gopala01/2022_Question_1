package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int start = inputInt("Enter x start (start > 0)");
        start = checkStart(start); //Ensures start is greater than 0

        int end = inputInt("Enter x end (end>=start)");
        end = checkEnd(start, end); //Ensures end is greater than start

        assignScore(start, end); //Assign scores to print out the final message
    }

    public static void assignScore(int start, int end){

        float count = 0; //A running count of the score of the user
        float numQuestions = 0; //A running count of the number of questions the computer asks

        for (int i = start; i <= end; i++) { //For the numbers that the user requested to ask
            for (int j = 1; j <= 12; j++) { //For the times table to go up to 12
                numQuestions++; //Running count of how many questions there are, which will increment after every question
                int answer = inputInt("What is " + i + " * " + j);
                if (answer == i*j){
                    print("Correct"); //Prints correct
                    count++; //Increments count
                }
                else {
                    print("Incorrect"); //Doesn't increment count and prints incorrect
                }
            }
        }

        int percentage = calculatePercentage(count, numQuestions); //Uses calculatePercentage to work out an integer percentage

        String grade = calculateGrade(percentage); //Uses the calculateGrade and percentage calculated to work out a grade

        finalSentence(count, numQuestions, percentage, grade); //Uses all the  values calculated to print the final sentence

    }

    public static void finalSentence(float count, float numQuestions, int percentage, String grade){

        int countInt = round(count);
        int numQuestionsInt = round(numQuestions);
        print("You scored " + countInt + "/" + numQuestionsInt + " (" + percentage + "%) " + grade + " grade");
    } //Converts count and numQuestions to integer without any of the points with a percentage and grade



    public static int calculatePercentage(float count, float numQuestions){
        float percentage = (count / numQuestions) * 100;

        return round(percentage);
    } //Divides the score of the user by the number of questions and multiples by 100 to get final percentage

    public static String calculateGrade(int percentage){
        if (percentage >= 70){
            return "A";
        }
        else if (percentage >= 60){
            return "B";
        }
        else if (percentage >= 50){
            return "C";
        }
        else if (percentage >= 40){
            return "D";
        }
        else {
            return "F";
        }
    } //Uses the score of the student to work out the grade


    public static int checkStart(int start){
        while (start < 0){
            start = inputInt("Start must be greater than 0");
        }
        return start;
    } //Ensures start is greater than 0

    public static int checkEnd(int start, int end){
        while (start > end){
            end = inputInt("Make sure end is greater than or equal to end");
        }
        return end;
    } //Ensures end is greater than or equal to start
    public static void print(String m) {
        System.out.println(m);
    } //Prints a message

    public static int inputInt(String m) {
        int answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextInt();
        return answer;
    } //Returns an integer input

    public static int round(float f){
        return Math.round(f);
    } //Converts a float to an integer

}
