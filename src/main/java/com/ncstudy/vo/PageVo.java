package com.ncstudy.vo;

import com.ncstudy.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
	
	private int pageNum;
	private int pageSize;
}
