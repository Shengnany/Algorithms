import java.util.Random;

public class StdRandom {
    private static Random random;
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return (int)(Math.random()+ n);
    }

}
