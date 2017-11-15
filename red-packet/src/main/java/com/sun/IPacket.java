package com.sun;



public interface IPacket {
	
	/**
	 * 抢红包方法，根据接受者抢购红包数的不同抢到的红包数额也不相同
	 * @param rec
	 */
	public void distribute(Receiver rec);
	
}

