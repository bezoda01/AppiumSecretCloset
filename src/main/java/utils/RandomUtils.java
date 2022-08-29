package utils;

public class RandomUtils {

    public static int getRandomNumber(int bound) {
        return (int) (Math.random() * bound);
    }
}