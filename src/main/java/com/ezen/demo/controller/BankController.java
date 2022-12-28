package com.ezen.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

	@GetMapping("/bank/money")
	public String goMoney(Model model) {
		model.addAttribute("money","백만원");
		return "views/bank/money";
	}
	
	@GetMapping("/banks")
	public String goBanks(Model model) {
		List<String> bankList = new ArrayList<>();
		bankList.add("신한");
		bankList.add("국민");
		bankList.add("신협");
		bankList.add("수협1");
		model.addAttribute("bankList",bankList);
		return "views/bank/list";
	}
}
