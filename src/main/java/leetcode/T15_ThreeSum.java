package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 20:28 2019/6/30
 * @Description:  三数之和
 */
public class T15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums != null && nums.length>2){
            for(int i=0;i<nums.length-2;){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    if(nums[j]+nums[k]==-nums[i]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        j++;
                        k--;
                        while((j<k) && nums[j]==nums[j-1]){
                            j++;
                        }
                        while((j<k) && nums[k]==nums[k+1]){
                            k++;
                        }
                    }else if(nums[j]+nums[k]>-nums[i]){
                        k--;
                        while((j<k) && nums[k]==nums[k+1]){
                            k--;
                        }
                    }else{
                        j++;
                        while((j<k) && nums[j]==nums[j-1]){
                            j++;
                        }
                    }
                }

                i++;
                while(i<nums.length-2 && nums[i]==nums[i-1]){
                    i++;
                }
            }
        }

        return result;
    }
}
