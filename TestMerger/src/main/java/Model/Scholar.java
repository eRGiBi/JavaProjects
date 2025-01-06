package Model;

import Loading.RandomDataGenerator;

public class Scholar {

    private static final int defaultResult = 0;
    private final RandomDataGenerator rgen;

    private final String id;
    private float theory1Result;
    private float theory2Result;
    private float theory3Result;

    private float practice1Result;
    private float practice2Result;
    private float practice3Result;

    private String finalGrade;

    public Scholar(String id, RandomDataGenerator rgen) {
        this.id = id;
        this.theory1Result = defaultResult;
        this.theory2Result = defaultResult;
        this.theory3Result = defaultResult;
        this.practice1Result = defaultResult;
        this.practice2Result = defaultResult;
        this.practice3Result = defaultResult;

        this.rgen = rgen;

        this.theory3Result = this.rgen.getFloat();
        this.practice3Result = this.rgen.getFloat();
    }

    public String getId() {return id; }

    public float getTheory1Result() {
        return theory1Result;
    }

    public float getTheory2Result() {
        return theory2Result;
    }

    public float getTheory3Result() {
        return theory3Result;
    }

    public float getPractice1Result() {
        return practice1Result;
    }

    public float getPractice2Result() {
        return practice2Result;
    }

    public float getPractice3Result() {
        return practice3Result;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setExamResult(float result, String examType, int examNumber, boolean isRetake) {
        if (examNumber != 1 && examNumber != 2) {
            throw new IllegalArgumentException("Invalid exam number");
        }

        switch (examType) {
            case "theory" -> updateResult(result, examNumber, isRetake, true);
            case "practice" -> updateResult(result, examNumber, isRetake, false);
            default -> throw new IllegalArgumentException("Invalid exam type");
        }
    }

    private void updateResult(float result, int examNumber, boolean isRetake, boolean isTheory) {
        if (isTheory) {
            if (examNumber == 1) {
                this.theory1Result = calculateResult(this.theory1Result, result, isRetake);
            } else {
                this.theory2Result = calculateResult(this.theory2Result, result, isRetake);
            }
        } else {
            if (examNumber == 1) {
                this.practice1Result = calculateResult(this.practice1Result, result, isRetake);
            } else {
                this.practice2Result = calculateResult(this.practice2Result, result, isRetake);
            }
        }
    }

    private float calculateResult(float currentResult, float newResult, boolean isRetake) {
        return isRetake ? (currentResult + newResult) / 2 : newResult;
    }

    public void setFinalGrade() {

        float finalPracticeResult = (
                (this.theory1Result) * 100 +
                        (this.theory2Result) * 100 +
                        3 * (this.theory3Result * 100)) / 5;

        float finalTheoryResult = (
                (this.practice1Result) * 100 +
                        (this.practice2Result) * 100 +
                        3 * (this.practice3Result * 100)) / 5;

        this.finalGrade = determineGrade(finalPracticeResult, finalTheoryResult);
    }

    private static String determineGrade(float practicePercentage, float theoryPercentage) {

        double average = (practicePercentage + theoryPercentage)/2;

        if (practicePercentage < 50 || theoryPercentage < 50){
            return "Failed";
        } else if (average < 66){
            return "Sufficient";
        } else if (average < 81) {
            return "Satisfactory";
        } else if (average < 91) {
            return "Good";
        } else if (average < 101){
            return "Excellent";
        } else {
            throw new IllegalArgumentException("Invalid grade");
        }
    }

    @Override
    public String toString() {
        return "Id: '" + id + '\'' +
                ", Result of Theory 1: " + theory1Result +
                ", Result of Theory 2: " + theory2Result +
                ", Result of Theory 3: " + theory3Result +
                ", Result of Practice 1: " + practice1Result +
                ", Result of Practice 2: " + practice2Result +
                ", Result of Practice 3: " + practice3Result +
                ", Final Grade: " + finalGrade;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Scholar scholar)) {
            return false;
        }
        return scholar.getId().equals(this.id);
    }
}
