package studentProcessor;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class processor {

    public static void main(String[] args) {

        ReadStudents s = new ReadStudents();
        
        // calling menu
        
        while (true) {
        menu();
        }
        
        }
        
        public static void menu() {
        // menu template
        Scanner in = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("options: ");
        
        System.out.println("1- student base data");
        System.out.println("2- student total sum ");
        System.out.println("3- total percentage");
        System.out.println("4- top ten students");
        System.out.println("5- number of students passed or failed each class");
        System.out.println("6- number of students who failed in each subject");
        System.out.println("7- pass percentage in each subject");
        System.out.println("8- students who failed more than 2 subjects");
        
        System.out.println("9-exit ");
        
        int input = in.nextInt();
        switch (input) {
        
        case 1:
        ReqOne();
        break;
        case 2:
        ReqTwo();
        break;
        case 3:
        ReqThree();
        break;
        case 4:
        
        reqfour();
        break;
        case 5:
        System.out.println("number who passed science: " + sciencepass() + " failed: " + (200 - sciencepass()));
        System.out.println("number who passed math" + mathpass() + " failed: " + (200 - mathpass()));
        System.out.println("number who passed history" + histpass() + " failed: " + (200 - histpass()));
        System.out.println("number who passed english" + englishpass() + " failed: " + (200 - englishpass()));
        
        break;
        case 6:
        double mpass1 = mathpass();
        double spass1 = sciencepass();
        double hpass1 = histpass();
        double epass1 = englishpass();
        reqsix("math", mpass1);
        reqsix("science", spass1);
        reqsix("history", hpass1);
        reqsix("english", epass1);
        
        break;
        case 7:
        double mpass = mathpass();
        double spass = sciencepass();
        double hpass = histpass();
        double epass = englishpass();
        calcPercent("math", mpass);
        calcPercent("science", spass);
        calcPercent("history", hpass);
        calcPercent("english", epass);
        break;
        
        case 8:
        System.out.println("number of students who failed more than 2 subjects: " + failures());
        case 9:
        System.out.println("exiting...");
        break;
        }
        
        }
        
        public static void ReqOne() {
        // retrieving data from ReadStudents and converting into arrays
        
        int[] StudentIds = ReadStudents.getStudentId();
        String[] FirstNames = ReadStudents.getFirstName();
        String[] LastNames = ReadStudents.getLastName();
        int[] SciScores = ReadStudents.getScienceScore();
        int[] HistScores = ReadStudents.getHistoryScore();
        int[] MathScores = ReadStudents.getMathematicsScore();
        int[] EnglishScores = ReadStudents.getEnglishScore();
        
        // creating new array for total scores and percentage
        
        int[] totalScore = new int[FirstNames.length];
        int[] percentage = new int[FirstNames.length];
        
        // Iterating through arrays and displaying first, last name, student id, total
        // score, and percentage
        
        for (int i = 0; i < FirstNames.length; i++) {
        String FirstName = FirstNames[i];
        String LastName = LastNames[i];
        int Studentid = StudentIds[i];
        totalScore[i] = SciScores[i] + HistScores[i] + MathScores[i] + EnglishScores[i];
        
        percentage[i] = totalScore[i] / 4;
        System.out.println("first name| " + FirstName + " |last name| " + LastName + " |student id| " + Studentid
        + " |Total Score| " + totalScore[i] + " |percentage| " + percentage[i]);
        
        }
        
        }
        
        public static void ReqTwo() {
        String[] FirstNames = ReadStudents.getFirstName();
        String[] LastNames = ReadStudents.getLastName();
        int[] SciScores = ReadStudents.getScienceScore();
        int[] HistScores = ReadStudents.getHistoryScore();
        int[] MathScores = ReadStudents.getMathematicsScore();
        int[] EnglishScores = ReadStudents.getEnglishScore();
        int[] totalScore = new int[FirstNames.length];
        // forming an array for student total scores
        
        for (int i = 0; i < FirstNames.length; i++) {
        String FirstName = FirstNames[i];
        String LastName = LastNames[i];
        totalScore[i] = SciScores[i] + HistScores[i] + MathScores[i] + EnglishScores[i];
        int tscore = totalScore[i];
        System.out.println(FirstName + " " + LastName + "'s total score: " + tscore);
        
        }
        
        }
        
        public static void ReqThree() {
        String[] FirstNames = ReadStudents.getFirstName();
        String[] LastNames = ReadStudents.getLastName();
        int[] SciScores = ReadStudents.getScienceScore();
        int[] HistScores = ReadStudents.getHistoryScore();
        int[] MathScores = ReadStudents.getMathematicsScore();
        int[] EnglishScores = ReadStudents.getEnglishScore();
        int[] totalScore = new int[FirstNames.length];
        int[] percentage = new int[FirstNames.length];
        
        // forming array for total score then calculating percentage
        
        for (int i = 0; i < FirstNames.length; i++) {
        String FirstName = FirstNames[i];
        String LastName = LastNames[i];
        totalScore[i] = SciScores[i] + HistScores[i] + MathScores[i] + EnglishScores[i];
        int tscore = totalScore[i];
        percentage[i] = totalScore[i] / 4;
        int percent = percentage[i];
        System.out.println(FirstName + " " + LastName + "'s percentage: " + percent);
        
        }
        }
        
        public static void reqfour() {
        String[] FirstNames = ReadStudents.getFirstName();
        int[] StudentIds = ReadStudents.getStudentId();
        
        String[] LastNames = ReadStudents.getLastName();
        int[] SciScores = ReadStudents.getScienceScore();
        int[] HistScores = ReadStudents.getHistoryScore();
        int[] MathScores = ReadStudents.getMathematicsScore();
        int[] EnglishScores = ReadStudents.getEnglishScore();
        int[] totalscore = new int[FirstNames.length];
        
        for (int i = 0; i < FirstNames.length; i++) {
        totalscore[i] = SciScores[i] + HistScores[i] + MathScores[i] + EnglishScores[i];
        }
        for (int i = 0; i < FirstNames.length - 1; i++) {
        for (int j = i + 1; j < FirstNames.length; j++) {
        if (totalscore[i] < totalscore[j]) {
        // StudentIds = null;
        int id = StudentIds[i];
        StudentIds[i] = StudentIds[j];
        StudentIds[j] = id;
        
        String fname = FirstNames[i];
        FirstNames[i] = FirstNames[j];
        FirstNames[j] = fname;
        
        String lname = LastNames[i];
        LastNames[i] = LastNames[j];
        LastNames[j] = lname;
        
        int tscore = totalscore[i];
        totalscore[i] = totalscore[j];
        totalscore[j] = tscore;
        }
        }
        }
        System.out.println("top ten students:");
        for (int i = 0; i < 10; i++) {
        System.out.println((i + 1) + " " + FirstNames[i] + " " + LastNames[i] + " id:" + StudentIds[i]
        + " Total Score " + totalscore[i]);
        }
        
        }
        
        //using the calculated passing students and subtracting from 200 to find
        // students that failed
        public static void reqsix(String subject, double pass) {
        double failed = 200 - pass;
        System.out.println(failed + " students failed " + subject);
        
        }
        
        // calculating students that passed science, history, etc.
        public static int sciencepass() {
        int[] SciScores = ReadStudents.getScienceScore();
        
        int pass = 60;
        int sci = 0;
        
        for (int i = 0; i < SciScores.length; i++) {
        
        if (SciScores[i] >= pass)
        sci++;
        }
        return sci;
        }
        
        public static int histpass() {
        int[] HistScores = ReadStudents.getHistoryScore();
        int pass = 60;
        int hist = 0;
        for (int i = 0; i < HistScores.length; i++) {
        if (HistScores[i] >= pass)
        hist++;
        
        }
        return hist;
        }
        
        public static int mathpass() {
        int[] MathScores = ReadStudents.getMathematicsScore();
        int pass = 60;
        int math = 0;
        for (int i = 0; i < MathScores.length; i++) {
        if (MathScores[i] >= pass)
        math++;
        }
        return math;
        }
        
        public static int englishpass() {
        int[] EnglishScores = ReadStudents.getEnglishScore();
        int pass = 60;
        int eng = 0;
        for (int i = 0; i < EnglishScores.length; i++) {
        if (EnglishScores[i] >= pass)
        eng++;
        }
        return eng;
        
        }
        
        public static void calcPercent(String subject, double passcount) {
        
        double percentage = (passcount / 200) * 100;
        System.out.println("percentage of students who passed " + subject + ": " + percentage + "%");
        }
        
        public static int failures() {
        
        int[] SciScores = ReadStudents.getScienceScore();
        int[] HistScores = ReadStudents.getHistoryScore();
        int[] MathScores = ReadStudents.getMathematicsScore();
        int[] EnglishScores = ReadStudents.getEnglishScore();
        // given that a passing grade is 60, over four classes, if a student fails
        // two classes, the max score than can possibly earn is a 318 overall
        int maxScore = 319;
        int j = 0;
        int[] totalScore = new int[SciScores.length];
        for (int i = 0; i < SciScores.length; i++) {
        
        totalScore[i] = SciScores[i] + HistScores[i] + MathScores[i] + EnglishScores[i];
        if (totalScore[i] < maxScore)
        j++;
        
        }
        return j;
        }
}
