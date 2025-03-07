package Arrays;

import java.io.*;
import java.util.*;

class Array04SumAsPerFrequency {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        String[] arrInput = br.readLine().trim().split(" ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(arrInput[i]);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, Long> freqBuckets = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            freqBuckets.put(frequency, freqBuckets.getOrDefault(frequency, 0L) + (long) value * frequency);
        }

        List<Integer> sortedFreqs = new ArrayList<>(freqBuckets.keySet());
        long[] prefixSum = new long[sortedFreqs.size() + 1];

        for (int i = 0; i < sortedFreqs.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + freqBuckets.get(sortedFreqs.get(i));
        }
        int maxFrequency = sortedFreqs.get(sortedFreqs.size() - 1);

        int Q = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();

        for (int j = 0; j < Q; j++) {
            String[] query = br.readLine().trim().split(" ");
            int l = Integer.parseInt(query[0]);
            int r = Integer.parseInt(query[1]);

            if (l > maxFrequency) {
                output.append("0\n");
                continue;
            }
            int leftIdx = lowerBound(sortedFreqs, l);
            int rightIdx = upperBound(sortedFreqs, r);
            long res = prefixSum[rightIdx] - prefixSum[leftIdx];
            output.append(res).append("\n");
        }

        System.out.print(output);
    }

    private static int lowerBound(List<Integer> arr, int val) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) >= val) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int upperBound(List<Integer> arr, int val) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) > val) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
