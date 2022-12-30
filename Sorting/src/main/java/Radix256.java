public class Radix256 {
    public static void sort(int[] a) {
        int[] output = new int[a.length];
        for (int s = 0; s < 32 ; s += 8) {
            int[] count = new int[256];
            for (int j : a) count[(j >> s) & 0xff]++;
            for (int i = 1; i < 256; i++) count[i] += count[i - 1];
            for (int i = a.length - 1; i >= 0; i--)
                output[--count[(a[i] >> s) & 0xff]] = a[i];
            System.arraycopy(output, 0, a, 0, a.length);
        }
    }
}
