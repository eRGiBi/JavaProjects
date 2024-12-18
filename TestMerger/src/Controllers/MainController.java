package Controllers;

import Loading.*;

import Model.ScholarContainer;
import Model.ScholarFactory;
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    private RandomDataGenerator randomGenerator;
    private Loader loader;
    private ScholarContainer scholars;

    public MainController(int seed) {
        this.randomGenerator = new RandomDataGenerator(seed);
        this.loader = new Loader();
        this.scholars = new ScholarContainer(new ScholarFactory(this.randomGenerator));
    }

    private void processExams(String[] exams, boolean isRetake) throws FileNotFoundException,
            IllegalArgumentException, IllegalStateException {

        for (String exam : exams) {
            String type = exam.toLowerCase().contains("theory") ? "theory" : "practice";

            int examNumber = extractExamNumber(exam);

            scholars.extractExam(
                    loader.readFile(exam),
                    examNumber,
                    type,
                    isRetake
            );
        }
    }

    private int extractExamNumber(String exam) throws IllegalArgumentException, IllegalStateException {
        return Integer.parseInt(
                Pattern.compile("\\d+").matcher(exam).results()
                        .map(MatchResult::group)
                        .reduce((a, b) -> { throw new IllegalStateException("Multiple matches found"); })
                        .orElseThrow(() -> new IllegalArgumentException("No match found"))
        );
    }

    public void start() throws IOException, NoSuchAlgorithmException, IllegalArgumentException, IllegalStateException {

        new HashingController().hash(
                "TestMerger/data/original_data/",
                "TestMerger/data/hashed_data/"
        );

        String[] exams = {"TestMerger/data/hashed_data//Theory 1.csv", "TestMerger/data/hashed_data//Theory 2.csv",
                "TestMerger/data/hashed_data//Practice 1.csv", "TestMerger/data/hashed_data//Practice 2.csv"};

        String[] retakeExams = {"TestMerger/data/hashed_data//Theory 1 pj.csv", "TestMerger/data/hashed_data/Theory 2 pj.csv",
                "TestMerger/data/hashed_data/Practice 1 pj.csv", "TestMerger/data/hashed_data/Practice 2 pj.csv"};

        processExams(exams, false);

        scholars.grade();

        System.out.println(scholars);

        processExams(retakeExams, true);

        scholars.grade();

        System.out.println(scholars);

        new WriteController().writeFile(scholars);

    }
}
