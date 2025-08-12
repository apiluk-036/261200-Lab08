class FailedSignificantlyException extends RuntimeException {
    public FailedSignificantlyException(String message) {
        super(message);
    }
}

class StudentGrades {

    public double calculateAverage(int[] scores) {
        if (scores == null) {
            throw new IllegalArgumentException("Scores array cannot be null.");
        }
        if (scores.length == 0) {
            throw new IllegalArgumentException("Scores array cannot be empty.");
        }
        for (int score : scores) {
            if (score < 0) {
                throw new IllegalArgumentException("Score cannot be less than 0.");
            }
            if (score > 100) {
                throw new IllegalArgumentException("Score cannot be greater than 100.");
            }
        }

        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.length;

        if (average < 40) {
            throw new FailedSignificantlyException(
                    "Student average is " + average + ", which is a significant failure."
            );
        }

        return average;
    }
}