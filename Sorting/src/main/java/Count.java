import java.util.Arrays;

public class Count {
    public static void sort(int[] a) {
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        int[] count = new int[max - min + 1];
        int[] output = new int[a.length];
        for (int j : a)
            count[j - min]++;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            output[count[a[i] - min] - 1] = a[i];
            count[a[i] - min]--;
        }
        System.arraycopy(output, 0, a, 0, a.length);
    }
}