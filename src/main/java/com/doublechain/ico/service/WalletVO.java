package com.doublechain.ico.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletVO {
	
	private int Id;
	private String address;
	private String key;
	
	public WalletVO(int Id, String address, String key){
		this.Id = Id;
		this.address = address;
		this.key = key;
	}
}

