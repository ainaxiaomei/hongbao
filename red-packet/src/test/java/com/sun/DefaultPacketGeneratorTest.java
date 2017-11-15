package com.sun;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DefaultPacketGeneratorTest {

	@Test
	public void genTest() {
		DefaultPacketGenerator gen = new DefaultPacketGenerator(0.01f, 10f);
		List<Boll> list = gen.generateMoneyList(10, 20);
		System.out.println(list);
		
		float sum = 0;
		for(int i = 0 ;i <list.size();i++){
			float num = list.get(i).getMoney();
			Assert.assertTrue("最小金额小于0.01",num >= 0.01);
			Assert.assertTrue("最大金额大于90%",num <= 18);
			sum = sum + num;
		}
		
		//float存在精度丢失的情况
		Assert.assertTrue("红包总数不是10",list.size() == 10);
		System.out.println("红包总和: " + sum);
		Assert.assertTrue("红包总和不是20",sum == 20);
	}

}
