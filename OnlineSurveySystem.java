/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodsactivity;

/**
 *
 * @author Emo_CPE
 */
import java.util.*;

public class OnlineSurveySystem {
    private static Map<String, List<String>> surveyQuestions = new LinkedHashMap<>();
    private static Map<String, List<String>> surveyResponses = new LinkedHashMap<>();

    public static void main(String[] args) {
        initializeSurveyQuestions();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Survey System!");

        String participantName = getParticipantName(scanner);
        displaySurveyQuestions(scanner, participantName);

        displaySurveyResults();

        scanner.close();
    }

    private static void initializeSurveyQuestions() {
        surveyQuestions.put("Q1. What is your age group?", Arrays.asList("Under 18", "18-30", "31-45", "46-60", "Above 60"));
        surveyQuestions.put("Q2. Which course program you're in?", Arrays.asList("Nursing", "Med Tech", "Engineering", "Phychology", "Others"));
        surveyQuestions.put("Q3. Nya.. musta man?", Arrays.asList("Very Satisfied", "Satisfied", "Neutral", "Dissatisfied", "Very Dissatisfied"));
    }

    private static String getParticipantName(Scanner scanner) {
        System.out.print("Please enter your name: ");
        return scanner.nextLine();
    }

    private static void displaySurveyQuestions(Scanner scanner, String participantName) {
        System.out.println("\nWelcome, " + participantName + "! Please answer the following questions:");

        for (Map.Entry<String, List<String>> question : surveyQuestions.entrySet()) {
            String questionText = question.getKey();
            List<String> options = question.getValue();

            System.out.println(questionText);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int response = 0;
            while (true) {
                System.out.print("Enter your response (1-" + options.size() + "): ");
                try {
                    response = Integer.parseInt(scanner.nextLine());
                    if (response >= 1 && response <= options.size()) {
                        break;
                    }
                } catch (NumberFormatException ignored) {
                }
                System.out.println("Invalid input. Please enter a number between 1 and " + options.size() + ".");
            }

            surveyResponses.put(questionText, Arrays.asList(participantName, options.get(response - 1)));
        }

        System.out.println("\nThank you for completing the survey, " + participantName + "!");
    }

    private static void displaySurveyResults() {
        System.out.println("\nSurvey Results:");
        for (Map.Entry<String, List<String>> response : surveyResponses.entrySet()) {
            String question = response.getKey();
            List<String> answer = response.getValue();
            System.out.println(question + ": " + answer.get(1));
        }
    }
}


    
