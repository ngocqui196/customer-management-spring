package com.codegym.cms.formater;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormater implements Formatter<Province> {
    private ProvinceService provinceService;


    @Autowired
    public ProvinceFormater(ProvinceService provinceService1) {
        this.provinceService = provinceService1;
    }

    @Override
    public Province parse(String text, Locale locale){
        Province province = new Province();
        try {
            province = provinceService.findById(Long.parseLong(text));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
