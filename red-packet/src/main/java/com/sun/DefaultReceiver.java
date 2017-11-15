package com.sun;

import java.util.LinkedList;
import java.util.List;

public class DefaultReceiver implements Receiver {
	
	private int id;

	private int lcukyCount;

	private List<Float> Moneys;

	
	public DefaultReceiver(int id) {
		this.id = id;
		Moneys = new LinkedList();
	}
    
	
	public int getId() {
		return id;
	}


	public int getLuckyCount() {

		return lcukyCount;

	}

	public int getLcukyCount() {
		return lcukyCount;
	}

	public List<Float> Moneys() {
		return this.Moneys;
	}

	public void setLuckyCount(int lcukyCount) {
		this.lcukyCount = lcukyCount;
		
	}

	@Override
	public String toString() {
		return "DefaultReceiver [id=" + id + ", lcukyCount=" + lcukyCount + ", Moneys=" + Moneys + "]";
	}
	
	
}
