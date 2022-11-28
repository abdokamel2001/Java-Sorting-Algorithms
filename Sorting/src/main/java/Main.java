import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String printSample(int[] a) {
        int length = 10;
        if (a.length <= length)
            return Arrays.toString(a);
        String string = "";
        int[] sample = new int[length];
        for (int i = 1; i <= length; i++)
            sample[i - 1] = a[(i * a.length / length) - 1];
        string += "[";
        for (int i = 0; i < length - 1; i++)
            string += sample[i] + ", ";
        string += sample[length - 1] + "]";
        return string;
    }

    public static void generate(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = i + 1;
    }

    public static void shuffle(int[] a) {
        generate(a);
        for (int i = 0; i < a.length; i++) {
            int random = (int) (a.length * Math.random());
            int temp = a[random];
            a[random] = a[i];
            a[i] = temp;
        }
    }

    public static void reverse(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = a.length - i;
    }

    public static String time(long timeInNano) {
        String unit;
        if (timeInNano > 10000000) {
            timeInNano /= 1000000;
            unit = " ms";
        } else if (timeInNano > 10000) {
            timeInNano /= 1000;
            unit = " μs";
        } else {
            unit = " ns";
        }
        return timeInNano + unit;
    }

    public static void measure(String name, Runnable mode, Runnable sort, int[] a, int num) {
        long average = 0;
        mode.run();
        System.out.println("\n" + name + " : \t" + printSample(a));
        for (int i = 0; i < num; i++) {
            long startTime = System.nanoTime();
            sort.run();
            long endTime = System.nanoTime();
            long sortTime = (endTime - startTime);
            average += sortTime;
            System.out.println((i + 1) + ". " + time(sortTime) + "\t\t" + printSample(a));
            mode.run();
        }
        average /= num;
        System.out.println("Average time = " + time(average));
    }

    public static void inputFeature() {
        int s, m, max, num;
        Scanner input = new Scanner(System.in);
        System.out.print("""
                
                1.Bubble Sot
                2.Select Sort
                3.Insert Sort
                4.Merge Sort
                5.Quick Sort
                6.Flash Sort
                7.Heap Sort
                8.Count Sort
                9.Radix Sort
                10.Radix256 Sort
                11.All Of Them
                Choose Sorting Algorithm :\s""");
        while (!input.hasNextInt()) input.nextLine();
        s = input.nextInt();
        System.out.print("""

                1. Sorted
                2. Reversed
                3. Shuffled
                Choose Array Type :\s""");
        while (!input.hasNextInt()) input.nextLine();
        m = input.nextInt();
        System.out.print("\nType the array length : ");
        while (!input.hasNextInt()) input.nextLine();
        max = input.nextInt();
        System.out.print("\nHow many times to repeat ? ");
        while (!input.hasNextInt()) input.nextLine();
        num = input.nextInt();
        input.close();
        int[] a = new int[max];
        Runnable mode; 
        switch (m) {
            case 1 -> mode = () -> generate(a);
            case 2 -> mode = () -> reverse(a);
            default -> mode = () -> shuffle(a);
        }
        switch (s) {
            case 1 -> measure("Bubble Sort",    mode, () -> Bubble.sort(a),   a, num);
            case 2 -> measure("Select Sort",    mode, () -> Select.sort(a),   a, num);
            case 3 -> measure("Insert Sort",    mode, () -> Insert.sort(a),   a, num);
            case 4 -> measure("Merge Sort",     mode, () -> Merge.sort(a),    a, num);
            case 5 -> measure("Quick Sort",     mode, () -> Quick.sort(a),    a, num);
            case 6 -> measure("Flash Sort",     mode, () -> Flash.sort(a),    a, num);
            case 7 -> measure("Heap Sort",      mode, () -> Flash.sort(a),    a, num);
            case 8 -> measure("Count sort",     mode, () -> Count.sort(a),    a, num);
            case 9 -> measure("Radix sort",     mode, () -> Radix.sort(a),    a, num);
            case 10 ->measure("Radix256 sort",  mode, () -> Radix256.sort(a), a, num);
            default -> {
                measure("Bubble Sort",    mode, () -> Bubble.sort(a),   a, num);
                measure("Select Sort",    mode, () -> Select.sort(a),   a, num);
                measure("Insert Sort",    mode, () -> Insert.sort(a),   a, num);
                measure("Merge Sort",     mode, () -> Merge.sort(a),    a, num);
                measure("Quick Sort",     mode, () -> Quick.sort(a),    a, num);
                measure("Flash Sort",     mode, () -> Flash.sort(a),    a, num);
                measure("Heap Sort",      mode, () -> Flash.sort(a),    a, num);
                measure("Count sort",     mode, () -> Count.sort(a),    a, num);
                measure("Radix sort",     mode, () -> Radix.sort(a),    a, num);
                measure("Radix256 sort",  mode, () -> Radix256.sort(a), a, num);
            }
        }
    }

    public static void main(String[] args) {
        /*
        int num = 5;
        int[] a = new int[10000000];
        Runnable mode = () -> shuffle(a);
        measure("Bubble Sort",    mode, () -> Bubble.sort(a),   a, num);
        measure("Select Sort",    mode, () -> Select.sort(a),   a, num);
        measure("Insert Sort",    mode, () -> Insert.sort(a),   a, num);
        measure("Merge Sort",     mode, () -> Merge.sort(a),    a, num);
        measure("Quick Sort",     mode, () -> Quick.sort(a),    a, num);
        measure("Flash Sort",     mode, () -> Flash.sort(a),    a, num);
        measure("Heap Sort",      mode, () -> Flash.sort(a),    a, num);
        measure("Count sort",     mode, () -> Count.sort(a),    a, num);
        measure("Radix sort",     mode, () -> Radix.sort(a),    a, num);
        measure("Radix256 sort",  mode, () -> Radix256.sort(a), a, num);
        */

        inputFeature();
    }
}