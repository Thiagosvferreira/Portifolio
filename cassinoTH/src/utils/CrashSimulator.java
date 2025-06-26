package utils;

import java.util.Random;

public class CrashSimulator {
    private final Random random = new Random();

    public double gerarCrash() {
        return 1.0 + (9.0 * random.nextDouble()); // Crash entre 1.00 e 10.00
    }
}
