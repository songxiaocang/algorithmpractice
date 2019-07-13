package leetcode;

/**
 * @Author: Songxc
 * @Date: 10:27 2019/7/13
 * @Description:  盛水最多的容器
 *  https://leetcode-cn.com/problems/container-with-most-water/submissions/
 *   思路：
 *    1）暴力破解法  时间复杂度 0（N2）  空间复杂度0(1)
 *    2）双指针法 时间复杂度 0(n)   空间复杂度0(1)
 */
public class T11_MaxArea {
    public int maxArea(int[] height) {
        //双指针
        if(height == null || height.length <= 1){
            return -1;
        }
        int maxArea = 0, l = 0, r = height.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
