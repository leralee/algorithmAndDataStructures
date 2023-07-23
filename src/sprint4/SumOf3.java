package sprint4;

import java.io.*;
import java.util.*;

/**
 * @author valeriali on {14.07.2023}
 * @project algorithms
 */
public class SumOf3 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine());
            long target = Integer.parseInt(reader.readLine());
            long[] nums = new long[n];
            String[] numsStr = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Long.parseLong(numsStr[i]);
            }

            List<List<Long>> quadruplets = findTriples(target, n, nums);
            int quadrupletCount = quadruplets.size();

            writer.write(quadrupletCount + "");
            writer.newLine();
            for (List<Long> quadruplet : quadruplets) {
                for (long num : quadruplet) {
                    writer.write(num + " ");
                }
                writer.newLine();
            }

        }
    }

    public static List<List<Long>> findTriples(long target, int n, long[] nums) {
        Arrays.sort(nums);
        List<List<Long>> quadruplets = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long total = nums[i] + nums[j] + nums[left] + nums[right];

                    if (total == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (total < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
