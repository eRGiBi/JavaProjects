package Model;

import Loading.RandomDataGenerator;

public class ScholarFactory {

    private final RandomDataGenerator randomGenerator;

    public ScholarFactory(RandomDataGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Scholar createScholar(String id) {
        return new Scholar(id, this.randomGenerator);
    }

}
