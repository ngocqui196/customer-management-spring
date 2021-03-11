package com.codegym.cms.controller;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public ModelAndView showListForm(){
        ModelAndView modelAndView = new ModelAndView("/province/list-province");
        modelAndView.addObject("listProvince", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/province/create-province");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
    @PostMapping("/create")
    public String addProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        return "redirect:/provinces";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/province/update-province");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateProvince(@ModelAttribute Province province) {
        provinceService.save(province);
        return "redirect:/provinces";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/province/delete-province");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String DeleteProvince(@ModelAttribute Province province) {
        provinceService.remove(province.getId());
        return "redirect: /provinces";
    }




}
