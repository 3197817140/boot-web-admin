package com.eternity.admin.mapper;

import com.eternity.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface CityMapper {

    @Select("select * from t_city where id=#{id}")
    public City getById(Long id);

    @Insert("insert into t_city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);

}
