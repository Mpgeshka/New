public class Main {
    public static void ShakeSort(int[] Array) {
        for (int i = 0; i < Array.length / 2; i++) {
            for (int j = i; j < Array.length - i - 1; j++) {
                if (Array[j] > Array[j + 1]) {
                    int help = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = help;
                }
            }
            for (int j = Array.length - i - 1; j > i; j--) {
                if (Array[j - 1] > Array[j]) {
                    int help = Array[j - 1];
                    Array[j - 1] = Array[j];
                    Array[j] = help;
                }
            }
        }
    }

    final static int[] buf = new int[1000];

    public static void MergeSort(int[] Array) {
        MergeSort(Array, 0, Array.length - 1);
    }

    private static void MergeSort(int[] Array, int left, int right) {
        if (right == left) {
            return;
        }
        int mid = (right + left) / 2;

        MergeSort(Array, left, mid);
        MergeSort(Array, mid + 1, right);

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (Array[i] < Array[j]) {
                buf[k] = Array[i];
                i++;
            } else {
                buf[k] = Array[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            buf[k] = Array[i];
            i++;
            k++;
        }
        while (j <= right) {
            buf[k] = Array[j];
            j++;
            k++;
        }
        for (int q = left; q <= right; q++) {
            Array[q] = buf[q];
        }
    }

    public static void main(String[] args) {
        int N = 10;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int) (Math.random() * 100);
        }
        MergeSort(Array);

        for (int i = 0; i < N; i++) {
            System.out.println(Array[i]);
        }
    }
}