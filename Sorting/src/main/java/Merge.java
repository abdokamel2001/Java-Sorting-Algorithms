public class Merge {
    public static void sort(int[] a) {
        divide(a, 0, a.length - 1);
    }

    private static void divide(int[] a, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            divide(a, lo, mid);
            divide(a, mid + 1, hi);
            merge(a, lo, hi);
        }
    }

    private static void merge(int[] a, int lo, int hi) {
        int n1 = (hi - lo) / 2 + 1;
        int n2 = (hi - lo + 1) / 2;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, lo, L, 0, n1);
        System.arraycopy(a, lo + n1, R, 0, n2);
        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2)
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
    }
}