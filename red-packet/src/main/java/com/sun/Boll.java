package com.sun;

/**
 * 装在红包里的实体对象
 * @author Administrator
 *
 */
public class Boll implements Comparable<Boll> {
	
	/**
	 * 金额
	 */
	private float money;
	
	/**
	 * 是否是最佳手气
	 */
	private boolean lucky;
	
	public Boll(float money) {
		super();
		this.money = money;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public boolean isLucky() {
		return lucky;
	}

	public void setLucky(boolean lucky) {
		this.lucky = lucky;
	}

	@Override
	public String toString() {
		return "Boll [money=" + money + ", lucky=" + lucky + "]";
	}

	public int compareTo(Boll o) {
		if(this.money >= o.money){
			return 1;
		}else {
			return -1;
		}
	}
	
	
	
}
