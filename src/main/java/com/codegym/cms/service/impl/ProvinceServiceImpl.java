package com.codegym.cms.service.impl;

import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ProvinceRepository;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProvinceServiceImpl implements ProvinceService {

   @Autowired
   private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long Id) {
        return provinceRepository.findOne(Id);
    }

    @Override
    public void update(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(id);
    }

    @Override
    public Province findByName(String name) {
        return provinceRepository.findByName(name);
    }
}
