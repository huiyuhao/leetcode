package leetcode;

public class E167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while(index1 < index2) {
        	if(numbers[index1] + numbers[index2] < target)
        		index1++;
        	if(numbers[index1] + numbers[index2] > target)
        		index2--;
        	if(numbers[index1] + numbers[index2] == target)
        		break;
        }
        return new int[] {index1 + 1, index2 + 1};
    }
}
