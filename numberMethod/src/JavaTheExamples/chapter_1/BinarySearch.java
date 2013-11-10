package JavaTheExamples.chapter_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BinarySearch {
    public static void main(String[] args) throws IOException {
        double[] nums = new double[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = Math.random()*100;
        }
        nums = sort(nums);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double numder = Double.parseDouble(reader.readLine());
        binarySearch(nums, numder);
    }

    private static int binarySearch(double[] a, double key) {
        int fromIndex = 0;
        int toIndex = a.length;

        int low = fromIndex;

        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            double midVal = a[mid];


            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else {
                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits){
                    System.out.println(a[mid]);
                    return mid;
                } else if (midBits < keyBits)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        System.out.println(a[low]);
        System.out.println(a[high]);
        return low;  // key not found.
    }


    public static double[] sort(double[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]){
                    double min = nums[i];
                    nums[i] = nums[j];
                    nums[j] = min;
                }

            }
        }
        return nums;
    }
}

