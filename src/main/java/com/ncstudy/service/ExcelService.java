package com.ncstudy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Service
public class ExcelService {

	@ApiOperation(value = "多线程处理excel内容")
	@Async("task1")
	public void excelHold() {
		
	}
}
