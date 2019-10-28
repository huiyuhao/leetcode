package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_Sum_Recursive {
    /**
     * ����һ���ӿڣ���ϵͳ�ṩ�����ǵķ�����������Ҽ���
     * 
     * �൱����һ���װ�������ṩ��һ��ϵͳ����ʹ�õĽӿ�
     * @param nums ϵͳ����������
     * @param target ϵͳҪ���Ŀ��ֵ
     * @return ϵͳҪ��ķ���ֵ
     */
    public List<List<Integer>> kSum(int[] nums, int target, int k) {
        // ����������Ǳ���ġ�
        Arrays.sort(nums);

        // ����ģ�巽����Ҫ�󣬽��÷�����Ҫ�����붼׼���á�
        int[] stack = new int[k];
        Arrays.fill(stack, 0x3f3f3f3f);
        int stack_index = -1;
        int begin = 0;
        // �ݹ鿪ʼ
        List<List<Integer>> ans = K_Sum_Recursive_Template(nums, stack, stack_index, k, begin, target);
        // �ݹ���������ؽ�
        return ans;
    }

    /**
     * K��֮�������ģ�巽��������K�����ⶼ���Ե����������
     * @param nums ���������
     * @param stack �����һ������Ϊ k_sum �����е� k �����飬��ʼ��Ϊ0x3f3f3f3f
     * @param stack_index ջָ�룬��ʼ��ֵΪ-1
     * @param k ������ǰ���ⱻ �ֽ�/�ݹ� ���� k��֮�� ������
     * @param begin ��ǰ����Ҫ�̶���ֵ�����
     * @param target ��ǰ k��֮�� ��Ŀ���
     * @return ��ǰ k��֮�� �Ľ⼯��Ҫ����һ��ϲ������ս⼯��ȥ
     */
    private List<List<Integer>> K_Sum_Recursive_Template(int[] nums, int[] stack, int stack_index, int k, int begin, int target){
        List<List<Integer>> ans = new ArrayList<>();

        // ���ݹ鵽����֮�͵�ʱ�򣬲��ٽ��еݹ飬ֱ��ʹ������ָ�뷨���
        if(k == 2){
            List<Integer> temp_ans;

            int left = begin;
            int right = nums.length - 1;

            while(left < right){
                if(nums[left] + nums[right] > target){
                    // ���������ָ������
                    right--;
                }else if(nums[left] + nums[right] < target){
                    // ��С�������ָ������
                    left++;
                }else {
                    // ��ȣ����������У�����ָ��ͬʱ�����ƶ�һ��
                    temp_ans = new ArrayList<>();
                    stack[++stack_index] = nums[left];
                    stack[++stack_index] = nums[right];

                    // ��ǰջ�е�Ԫ�ط�����ĿҪ�� ������뵽List��ȥ��������List���뵽��ǰ����Ľ⼯��
                    for(int i = 0; i <= stack_index; i++){
                        temp_ans.add(stack[i]);
                    }
                    ans.add(temp_ans);

                    // ջ������������ʵ����Ҳ���ԣ���Ϊջָ�������βΣ�����Ӱ��������Ǹ�ջָ�룬
                    // ���ǻ���������ȽϺã�������ԡ�
                    stack[stack_index--] = 0x3f3f3f3f;
                    stack[stack_index--] = 0x3f3f3f3f;

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (right > left && right < nums.length - 1 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }else {
            int target_temp;
            for(int i = begin; i < nums.length - k + 1; i++){
                if(i > begin && nums[i] == nums[i - 1]){
                    continue;
                }
                // �ڹ̶�һ���������ⱻ����Ϊһ�� k - 1 ��֮�� ����
                // ȷ�� k - 1 ��֮�� ��Ŀ���
                target_temp = target - nums[i];
                // ����ǰѡ��������ѹ��ջ�У�����������⼯��
                stack[++stack_index] = nums[i];
                // �ݹ���� k - 1 ��֮�� ��������
                List<List<Integer>> ans_temp = K_Sum_Recursive_Template(nums,stack, stack_index, k - 1, i + 1, target_temp);
                // ��ѡ����ǰ���ֵ�����£� k - 1 ��֮�� ���������ϣ�
                // ����������ջ��Ϊѡ����һ����ѡֵ��׼��
                stack[stack_index--] = 0x3f3f3f3f;
                // ����ǰ�⼯���뵱ǰ k��֮�͵Ľ⼯��
                ans.addAll(ans_temp);
            }
        }
        return ans;
    }

    public static void test(){
        K_Sum_Recursive solution = new K_Sum_Recursive();
        int [] input = {0,0,0,0};
        int k = 4;
        int target = 0;
        solution.kSum(input, target, k);
    }
}

