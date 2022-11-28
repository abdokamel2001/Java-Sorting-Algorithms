class Flash {
    public static void sort(int[] a) {
        int m = a.length / 50;
        m = m == 0 ? 1 : m;
        int[] l = new int[m];
        int i, j, k;
        int min = a[0];
        int max = 0;
        for (i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > a[max]) max = i;
        }
        if (min == a[max]) return;
        double c1 = ((double) m - 1) / (a[max] - min);
        for (i = 0; i < a.length; i++) {
            k = (int) (c1 * (a[i] - min));
            l[k]++;
        }
        for (k = 1; k < m; k++)
            l[k] += l[k - 1];
        int hold = a[max];
        a[max] = a[0];
        a[0] = hold;
        int move = 0;
        int flash;
        j = 0;
        k = m - 1;
        while (move < a.length - 1) {
            while (j > (l[k] - 1)) {
                j++;
                k = (int) (c1 * (a[j] - min));
            }
            flash = a[j];
            while (!(j == l[k])) {
                k = (int) (c1 * (flash - min));
                hold = a[l[k] - 1];
                a[l[k] - 1] = flash;
                flash = hold;
                l[k]--;
                move++;
            }
        }
        insertionSort(a);
    }

    private static void insertionSort(int[] a) {
        int i, j, hold;
        for (i=a.length-3; i>=0; i--){
            if (a[i+1] < a[i]){
                hold = a[i];
                j=i;
                while (a[j+1] < hold) {
                    a[j] = a[j+1];
                    j++;
                }
                a[j] = hold;
            }
        }
    }
}