package com.ncstudy;

import java.util.ArrayList;
import java.util.List;

import com.ncstudy.Persons;

/**
 * 2万条数据
 * @author KJS_352
 *
 */
public class BigPojos {

	public static List<Persons> getBigList(){
		List<Persons> list  = new ArrayList<>();
		
		for(int i = 0; i < 20000; i++) {
			list.add(new Persons(""+i,"jack"+i, i));
		}
		return list;
	}
}
