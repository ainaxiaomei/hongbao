package com.sun;

import java.util.LinkedList;

public abstract class  AbstractPacket implements IPacket{
	
	
	/**
	 * 一个红包被分成几份
	 */
	protected int divideCount;
	
	
	/**
	 * 红包的金额数
	 */
	protected  float sum;
	
	/**
	 * 红包的数组
	 */
	protected  LinkedList<Boll> packageList;
	
	
	
	public int getDivideCount() {
		return divideCount;
	}



	public void setDivideCount(int divideCount) {
		this.divideCount = divideCount;
	}



	public float getMoney() {
		return sum;
	}



	public void setMoney(int money) {
		this.sum = money;
	}





	
	
	
	
	
}
