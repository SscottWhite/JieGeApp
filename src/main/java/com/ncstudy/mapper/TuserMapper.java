package com.ncstudy.mapper;
import com.ncstudy.pojo.Tuser;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TuserMapper {
    void saveUser(Tuser tuser);

    void saveList(@Param("list") List<Tuser> list);
}
