package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ScholarContainer implements Iterable<Scholar> {

    private ArrayList<Scholar> scholars;
    private ScholarFactory factory;

    public ScholarContainer(ScholarFactory factory) {
        this.scholars = new ArrayList<>();
        this.factory = factory;
    }


    public void extractExam(HashMap<String, Float> map, int examNumber, String type, boolean retake) {

        map.forEach((k, v) -> {

            if (scholars.stream().noneMatch(s -> s.getId().equals(k))) {
                scholars.add(factory.createScholar(k));
            }
            scholars.stream().filter(s -> s.getId().equals(k)).
                    forEach(s -> s.setExamResult(v, type, examNumber, retake));
        });
    }

    public void grade(){
        for (Scholar scholar: scholars) {
            scholar.setFinalGrade();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Scholar scholar: scholars) {
            sb.append(scholar.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Scholar> iterator() {
        return new ScholarContainerIterator(scholars);
    }
}
