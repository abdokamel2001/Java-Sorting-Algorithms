public class Heap {
    public static void sort(int[] a) {
        for (int i = (a.length + 1) / 2 - 1; i >= 0; i--)
            maxHeap(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeap(a, 0, i);
        }
    }

    public static void maxHeap(int[] a, int p, int size) {
        int max;
        int l = 2 * (p + 1) - 1;
        int r = 2 * (p + 1);
        if ((l < size) && (a[l] > a[p])) max = l;
        else max = p;
        if ((r < size) && (a[r] > a[max])) max = r;
        if (max != p) {
            int temp = a[p];
            a[p] = a[max];
            a[max] = temp;
            maxHeap(a, max, size);
        }
    }
}
