package leetcode;

public class M11 {
    public int maxArea(int[] height) {
    	int cubage = 0;
        for (int i = 0; i < height.length - 1; i++) {
			for (int j = 1; j < height.length; j++) {
				cubage = Math.max(cubage, (j - i) * Math.min(height[i], height[j]));
			}
		}
        return cubage;
    }
    
    public int maxArea2(int[] height) {
    	int cubage = 0, i = 0, j = height.length - 1;
    	while(i < j) {
    		cubage = Math.max(cubage, (j - i) * Math.min(height[i], height[j]));
    		if(height[i] < height[j]) {
    			i++;
    		}else {
    			j--;
    		}
    	}
    	return cubage;
    }
}
