import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(double[] arr) {
        int n = arr.length;

        ArrayList<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double v : arr) {
            int bucketIndex = (int) (n * v);
            buckets[bucketIndex].add(v);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            for (double num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }
}
