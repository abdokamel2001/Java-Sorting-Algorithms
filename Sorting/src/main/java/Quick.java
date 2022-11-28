public class Quick {
    public static void sort(int[] a) {
        divide(a, 0, a.length - 1);
    }

    private static void divide(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = scan(a, lo, hi);
            divide(a, lo, p);
            divide(a, p + 1, hi);
        }
    }

    private static int scan(int[] a, int lo, int hi) {
        int pivot = a[lo + (hi - lo) / 2];
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            while (a[++i] < pivot) ;
            while (a[--j] > pivot) ;
            if (i >= j)
                return j;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}