package com.sun;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class DefaultPacketGenerator implements IPacketGenerator {

	private float defaultMin;

	private float defaultMax;

	public DefaultPacketGenerator(float min, float max) {
		super();
		this.defaultMin = min;
		this.defaultMax = max;
	}

	public LinkedList<Boll> generateMoneyList(int divideCount, float sum) {
		LinkedList<Boll> list = new LinkedList<Boll>();
		for (int i = divideCount; i > 0; i--) {
			float num = generate(i, sum, defaultMin, defaultMax);
			list.add(new Boll(num));
			sum = sum - num;
			defaultMax = sum;
		}
        
		Collections.sort(list);
		list.getLast().setLucky(true);
		return list;
	}
    
	//确保递归不会溢出
	private float generate(int count, float sum, float min, float max) {
		
		if(min >= sum){
			throw new RuntimeException("最小值设置过小 !");
		}
		
		if(count == 1){
			return sum;
		}
		
		Random radom = new Random();
		float num = radom.nextFloat() * (max - min) + min;
		float avg = sum / count;

		if (test(num, count - 1, sum) == 1) {
			return generate(count, sum, min, avg);
		} else if (test(num, count - 1, sum) == -1) {
			return generate(count, sum, avg, max);
		}

		return num;
	}

	/**
	 * 判断随机数是大还是小
	 * 
	 * @param num
	 * @param restCount
	 * @param sum
	 * @return 1大 -1小 0合适
	 */
	private int test(float num, int restCount, float sum) {
		double avg = (sum - num) / restCount;
		if (avg < defaultMin) {
			return 1;
		} else if (avg > defaultMax) {
			return -1;
		}
		return 0;
	}

}
