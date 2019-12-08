package com.lixinyu.commonUtil;

import java.util.Random;

/**
 * 
* @ClassName: RandomUtil 
* @Description: ��������� 
* @author A18ccms a18ccms_gmail_com 
* @date 2019��12��8�� ����7:39:36 
*
 */
public class RandomUtil {
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��������   
	 * @param: @param min
	 * @param: @param max
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��Ķ�������
	 * @param: @param min
	 * @param: @param max
	 * @param: @param num
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
}