/**
 * Created by matthewwojkowski on 12/8/16.
 */
import java.util.*;
import java.lang.Math.*;

class Record {

    //constant values(coefficients) of the model
    private double incomeCoeff = 2.10919;
    private double balanceCoeff = .23065;
    private double cardsCoeff = -.64582;
    private double educationCoeff = .28396;
    private double ageCoeff = .14402;
    private double genderCoeff = 2.30468;//only used it female... therefore pass 1 or 0
    private double studentCoeff = -99.60758; //only used it student... therefore pass 1 or 0
    private double intercept = 139.01832;


    private double income;
    private int balance;
    private int cards;
    private int education;
    private int age;
    private int gender;
    private int student;

    private int actual;

    public Record(String income, String balance, String cards, String education,
                  String age, int gender, int student, String actual){
        this.income = Double.valueOf(income);
        this.balance = Integer.valueOf(balance);
        this.cards = Integer.valueOf(cards);
        this.education = Integer.valueOf(education);
        this.age = Integer.valueOf(age);
        this.gender = gender;
        this.student = student;
        this.actual = Integer.valueOf(actual);
    }//close Record() overloaded

    public double calculateAccuracy(){
        double score = 0;
        double accuracy = 0.0;

        score = income*incomeCoeff + balance * balanceCoeff + cards * cardsCoeff +
                education * educationCoeff + age * ageCoeff + gender * genderCoeff +
                student * studentCoeff + intercept;

        accuracy = (score / actual) * 100;


        System.out.println("Actual score: " + actual);
        System.out.println("Calculated score: " + score);
        return Math.abs(accuracy-100);

    }





}//close class
