package com.anchtun.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.constant.Constants;
import com.anchtun.service.FinalResultService;
import com.anchtun.util.DateUtility;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("finalResult")
@RestController
public class FinalResultController {
	
	private final FinalResultService finalResultService;
	
	@GetMapping("/genarateAllExcel")
	public void genarateAllExcel(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=finalResults_" + DateUtility.nowToString() + Constants.EXCEL_EXTENSION_XLSX;
		response.setHeader(headerKey, headerValue);
		finalResultService.generateAllExcel(response);
	}

}
