package ohara.linda.quizApp.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Scanner;

/*
public class Quiz {
    public static ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public static void takeQuiz(ArrayList<Question> questions){
        int totalCorrect= 0;
        Double topicScore = 0.0;
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> studentGrades = new HashMap<>();
        for (Question question:questions) {
            System.out.println(question.getPrompt());
            String answer = input.nextLine();
            if(answer.equals(question.getAnswer())){
                int score = studentGrades.getOrDefault(question.getTopic(), 0);
                studentGrades.put(question.getTopic, score + 1);
                totalCorrect++;

             }

        }

    }
}
*/