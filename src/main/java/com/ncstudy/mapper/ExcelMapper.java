package com.ncstudy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelMapper {

    void importExcel(@Param("list") List<String> list);
}
