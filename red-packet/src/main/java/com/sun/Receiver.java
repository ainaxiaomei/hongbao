package com.sun;

import java.util.List;

/**
 * 红包的抢购者
 * 
 * @author Administrator
 *
 */
public interface Receiver {
	/**
	 * 获取最佳手气的次数
	 * 
	 * @return
	 */
	int getLuckyCount();

	/**
	 * 获取抢到红包列表
	 * 
	 * @return
	 */
	List<Float> Moneys();
	
	public int getId();

	void setLuckyCount(int lcukyCount);
}
