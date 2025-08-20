import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        int n = arr.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefix[j+1] - prefix[i] == 0) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> res = findZeroSumSubarrays(arr);
        for (int[] sub : res) {
            System.out.println("(" + sub[0] + ", " + sub[1] + ")");
        }
    }
}
