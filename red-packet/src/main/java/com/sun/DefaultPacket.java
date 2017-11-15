package com.sun;

import java.util.LinkedList;
import java.util.Random;

/**
 * 红包分成的个数可以大于抢红包的人数也可以小于抢红包的人数
 * 
 * @author Administrator
 *
 */
public class DefaultPacket extends AbstractPacket {

	private IPacketGenerator gen;

	/**
	 * 默认红包实现构造函数
	 * 
	 * @param sum
	 *            红包总金额
	 * @param divideCount
	 *            红包分成个数。
	 */
	public DefaultPacket(float sum, int divideCount) {
		init(sum, divideCount);
	}

	private void init(float sum, int divideCount) {
		this.gen = new DefaultPacketGenerator(0.01f, sum * 0.9f);
		this.packageList = gen.generateMoneyList(divideCount, sum);
	}

	public void distribute(Receiver rec) {
		int count = this.packageList.size();
		Random radom = new Random();

		if (rec.getLuckyCount() < Math.floor(0.3 * Config.packageCount)) {
			// 可以获取最大红包
			int cell = radom.nextInt(count + 100) & (count - 1);
			Boll boll = packageList.get(cell);
			rec.Moneys().add(boll.getMoney());
			if (boll.isLucky()) {
				rec.setLuckyCount(rec.getLuckyCount() + 1);
				;
			}
			packageList.remove(cell);
		} else {
			// 不能获取最大红包
			int cell = radom.nextInt(count - 2);
			Boll boll = packageList.get(cell);
			rec.Moneys().add(boll.getMoney());
			packageList.remove(cell);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < packageList.size(); i++) {

			Boll element = packageList.get(i);
			sb.append(element.getMoney());

			if (element.isLucky()) {
				sb.append(" 大红包!");
			}

			if (i != packageList.size() - 1) {
				sb.append(" ,");
			}
		}
		sb.append("]");
		return sb.toString();

	}

}
