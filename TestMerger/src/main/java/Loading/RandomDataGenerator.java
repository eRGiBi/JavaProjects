package Loading;

import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomDataGenerator {

    private Random rgen;
    private DecimalFormat df;

    public RandomDataGenerator(int seed) {
        this.df = new DecimalFormat("#.#");
        this.df.setRoundingMode(RoundingMode.CEILING);

        this.rgen = new Random(seed);
    }

    public int getInt(){
        return rgen.nextInt();
    }

    public double getDouble(){
        return Double.parseDouble(this.df.format(rgen.nextDouble()).replace(",", "."));
    }

    public float getFloat(){
        return Float.parseFloat(this.df.format(rgen.nextFloat()).replace(",", "."));
    }
}
