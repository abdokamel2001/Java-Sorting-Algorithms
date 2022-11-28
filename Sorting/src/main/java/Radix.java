import java.util.Arrays;

public class Radix {
    public static void sort(int[] a) {
        int max = Arrays.stream(a).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            int[] digits = new int[10];
            for (int value : a)
                digits[(value / exp) % 10]++;
            for (int i = 1; i < 10; i++)
                digits[i] += digits[i - 1];
            int[] output = new int[a.length];
            for (int i = a.length - 1; i >= 0; i--)
                output[--digits[(a[i] / exp) % 10]] = a[i];
            System.arraycopy(output, 0, a, 0, a.length);
        }
    }
}