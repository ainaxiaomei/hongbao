package com.sun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strat {
	public static void main(String[] args) {

		if (args == null || args.length < 3) {
			System.out.println("参数错误！");
			System.exit(0);
		}

		System.out.println("红包程序启动 ,接收参数为 : " + Arrays.toString(args));

		// 红包个数
		int packetCount = Integer.valueOf(args[0]);
		Config.packageCount = packetCount;

		// 每个红包金额
		int packetMoney = Integer.valueOf(args[1]);

		// 抢红包的人数
		int recCount = Integer.valueOf(args[2]);

		List<IPacket> packlist = new ArrayList<IPacket>();
		for (int i = 0; i < packetCount; i++) {
			IPacket packet = new DefaultPacket(packetMoney, recCount);
			packlist.add(packet);
		}

		// 打印红包信息

		System.out.println("红包信息 : ");
		packlist.forEach((element) -> {
			System.out.println(element);
		});

		//模拟抢红包
		List<Receiver> reclist = new ArrayList<Receiver>();
		for (int i = 0; i < recCount; i++) {
			Receiver rec = new DefaultReceiver(i);
			packlist.forEach((element) -> {
				element.distribute(rec);
			});
			reclist.add(rec);
		}
		
		System.out.println("");

		// 打印抢红包信息
		reclist.forEach((element) -> {
			System.out.println(String.format("用户%d获得%d次最佳手气", element.getId(), element.getLuckyCount()));
			System.out.println(String.format("用户%d的红包列表:\n %s", element.getId(), element.Moneys()));
		});

	}
}
