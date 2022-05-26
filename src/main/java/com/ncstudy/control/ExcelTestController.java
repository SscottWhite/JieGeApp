package com.ncstudy.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelTestController {

	@PostMapping("getExcel")
	public void getExcelContent(@RequestParam("file")MultipartFile file) {
		
		
		
	}
}
