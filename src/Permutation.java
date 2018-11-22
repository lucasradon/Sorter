import java.util.Random;

public class Permutation {

    public static Integer[] fisher_yates_shuffle(Integer[] array) {
        Random random = new Random();
        int n = array.length;
        for (int i = n-1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
            return array;
    }
}
