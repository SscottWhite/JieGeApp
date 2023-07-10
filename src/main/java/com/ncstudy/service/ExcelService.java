package com.ncstudy.service;

import com.ncstudy.mapper.ExcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService {

	private final ExcelMapper excelMapper;

	@Autowired
	public ExcelService(ExcelMapper excelMapper){
		this.excelMapper = excelMapper;
	}

	public void excelImport(List<String> list) {
		excelMapper.importExcel(list);
	}
}
