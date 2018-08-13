package com.doublechain.ico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublechain.ico.service.WalletVO;

@RestController
@RequestMapping(value = "api")
public class TestController {
	
	@GetMapping
	public WalletVO get(){
		WalletVO walletVO = new WalletVO();
		walletVO.setId(1);
		walletVO.setAddress("AKJDFLKJDSALFJ");
		walletVO.setKey("oxoddksajflkdj");
		return walletVO;
	}
	
	@GetMapping("args")
	public WalletVO getArgs(@RequestParam(value = "Id")int Id, 
							@RequestParam(value = "address")String address){
		
		WalletVO walletVO = new WalletVO();
		
		return null;
	}
	
	//post
	@PostMapping
	public WalletVO post(@RequestBody WalletVO param){
		return param;
	}
	
	
	
}
