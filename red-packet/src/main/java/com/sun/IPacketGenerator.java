package com.sun;

import java.util.LinkedList;

/**
 * 红包生成算法
 * @author Administrator
 *
 */
public interface IPacketGenerator {
	LinkedList<Boll> generateMoneyList( int divideCount,float sum);
}
