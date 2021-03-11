package com.codegym.cms.service;

import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService extends IService<Province> {

//    Iterable<Province> findAll(Pageable pageable);
    Province findByName(String name);
}
