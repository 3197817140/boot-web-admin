package com.eternity.admin.service;

import com.eternity.admin.bean.City;
import com.eternity.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getCity(Long id){
        City byId = cityMapper.getById(id);
        return byId;
    }


    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
