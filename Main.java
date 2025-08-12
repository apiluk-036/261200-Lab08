import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGrades studentGrades = new StudentGrades();

        try {
            System.out.print("Enter scores (comma-separated): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Scores array cannot be empty.");
            }

            String[] scoreStrings = input.split(",");
            int[] scores = new int[scoreStrings.length];

            for (int i = 0; i < scoreStrings.length; i++) {
                scores[i] = Integer.parseInt(scoreStrings[i].trim()); // May throw NumberFormatException
            }

            double average = studentGrades.calculateAverage(scores);
            System.out.println("Average score: " + average);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid number for scores. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FailedSignificantlyException e) {
            System.out.println("Significant Failure: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Grade calculation process concluded.");
        }
    }
}