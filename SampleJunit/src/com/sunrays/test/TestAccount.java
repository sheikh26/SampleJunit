package com.Galaxy.test;

import com.Galaxy.dto.AccountDTO;
import com.Galaxy.service.AccountService;

public class TestAccount {

	public static void main(String[] args) {
		
		AccountDTO dto = new AccountDTO();
		dto.setId(1);
		dto.setNumber("SB123456");
		dto.setName("Galaxy Technologies");
		dto.setBalance(10000);
		
		AccountService.add(dto);

		AccountService.update(dto);

		AccountService.delete(dto);

		dto = AccountService.get(1);

	}

}
