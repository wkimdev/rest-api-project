package com.doublechain.ico.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doublechain.ico.response.JSONResponse;
import com.doublechain.ico.service.Param;
import com.doublechain.ico.service.WalletVO;

@RestController
@RequestMapping("${api.contextRoot}")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
		 
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
	
	//param에 required false, deaultValue 설정을 해놓음.
	@GetMapping("argsDefault")
	public WalletVO getArgDefault(@RequestParam(value = "Id")int Id,
								 @RequestParam(value = "address", required = false, 
								 defaultValue = "0x123456")String address,
								 @RequestParam(value = "key", required = false, 
								 defaultValue = "hikey")String key
								 ){
		WalletVO walletVO = new WalletVO(Id,address, key);
		walletVO.setAddress(walletVO.getId()+","+key+address);
		return walletVO;
	}
	
	@GetMapping("jsonResponse")
	public JSONResponse<WalletVO> getJSONResponse(@RequestParam(value="address")String address){
		
		WalletVO walletVO = new WalletVO(0, address, address);
		
		JSONResponse<WalletVO> response = new JSONResponse<WalletVO>();
		response.setCode(200);
		response.setMsg("제대로된 응답 처리 리스펀스 입니다.");
		response.setData(walletVO);
		
		return response;
	}
	
	
	// post요청 주소!!
	// 사용자가 Id와 addrsss, key를 설정할 경우!
	// 왜 WalletVO라는 같은 VO로 request, response하면 안되지?? --> 공통 response로 받도록 뺀다음 처리
	// VO에는 기본 생성자 선언을 해놓고 400에러 발생 방지.
	// (no suitable constructor found, can not deserialize from Object value)
	@PostMapping("/wallet")
	public JSONResponse<WalletVO> updateWallet(@RequestBody WalletVO walletVO){
		
		JSONResponse<WalletVO> response = new JSONResponse<WalletVO>();
		
		response.setCode(200);
		response.setMsg("response walletvo post success!!!");
		response.setData(walletVO);
		return response;
	} 
	
	//put
	//put 으로 추가받기.
	@PutMapping()
	public WalletVO put(@RequestParam(value = "param1")String param1){
		WalletVO walletVO = new WalletVO(0, "put request address :"+param1, "put request key :"+param1);
		return walletVO;
	}
}
