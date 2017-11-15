package com.sun;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DefaultPacketTest {

	@Test
	public void genTest() {
		List<IPacket> packlist = new ArrayList<IPacket>();
		for (int i = 0; i < 20; i++) {
			IPacket packet = new DefaultPacket(10, 10);
			packlist.add(packet);
		}

		Receiver rec = new DefaultReceiver(1);

		packlist.forEach((ele) -> {
			ele.distribute(rec);
		});

		System.out.println(rec);
		Assert.assertTrue("红包总数不是20", rec.Moneys().size() == 20);
		Assert.assertTrue("最佳手气超过6", rec.getLuckyCount() <= 6);
	}

}
