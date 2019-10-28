package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class M46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		helper(nums, cur, res, nums.length);
		return res;
	}

	public void helper(int[] nums, List<Integer> cur, List<List<Integer>> res, int n) {
		for (int i = 0; i < nums.length; i++) {
			cur.add(nums[i]);
			if (cur.size() == n) {
				res.add(new ArrayList<>(cur));
			}
			int temp[] = new int[nums.length - 1];
			for (int j = 0; j < i; j++) {
				temp[j] = nums[j];
			}
			for (int j = i; j < temp.length; j++) {
				temp[j] = nums[j + 1];
			}
			helper(temp, cur, res, n);
			cur.remove(cur.size() - 1);
		}
	}

	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> output = new LinkedList<List<Integer>>();
		ArrayList<Integer> nums_lst = new ArrayList<>();
		for (Integer num : nums) {
			nums_lst.add(num);
		}
		backtrack(nums.length, nums_lst, output, 0);
		return output;
	}

	public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
		if(first == n)
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < n; i++) {
			Collections.swap(nums, first, i);
			backtrack(n, nums, output, first + 1);
			Collections.swap(nums, first, i);
		}
	}
	
	
	
	
	
	
	// curSize 表示当前的路径 path 里面有多少个元素

    private void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

	
	
    
    
    
    
	

	public static void main(String[] args) {
		M46 m46 = new M46();
		int[] nums = { 1, 2, 3 };
		System.out.println(m46.permute(nums));
	}
}
