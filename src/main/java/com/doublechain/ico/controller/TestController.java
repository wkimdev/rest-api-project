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
	
	//id, address, key
	//get 지갑등록후 홈에 나타날 정보 VO몇개 뿌리기
	@GetMapping()
	public WalletVO get(){
		return new WalletVO(78, "adsfsa35415", "7898454");
	}
	
	//get param을 받기.
	@GetMapping("args")
	public WalletVO getArgs(@RequestParam(value = "Id")int Id,
							@RequestParam(value = "address")String address,
							@RequestParam(value = "key")String key
							){
		//http://localhost:8090/api/args?Id=88&address=sdfsad&key=7897
		WalletVO walletVO = new WalletVO(Id, address, key);
		walletVO.setAddress(walletVO.getAddress() + "," + key);
		
		return walletVO;
	}
	
	//post요청 주소!!
	
}
