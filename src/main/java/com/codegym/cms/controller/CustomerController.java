    package com.codegym.cms.controller;

    import com.codegym.cms.model.Customer;
    import com.codegym.cms.model.Province;
    import com.codegym.cms.service.CustomerService;
    import com.codegym.cms.service.ProvinceService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Controller;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.ModelAndView;

    import java.util.Optional;

    @Controller
    @RequestMapping("/customers")
    public class CustomerController {

        @Autowired
        private CustomerService customerService;

        @Autowired
        private ProvinceService provinceService;

        @ModelAttribute("provinces")
        public Iterable<Province> provinces() {
            return provinceService.findAll();
        }

        @GetMapping

//        public ModelAndView listCustomer(Pageable pageable) {
//            Page<Customer> customers = customerService.findAll(pageable);
//            ModelAndView modelAndView = new ModelAndView("/list");
//            modelAndView.addObject("customer",customers);
//            return modelAndView;
//        }
        public ModelAndView showListForm(
                @RequestParam("s") Optional<String> keyword,
                @RequestParam("page") Optional<Integer> page) {
            Page<Customer> customerList;
//                    = customerService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/list");
            int pageNum = 0;
            if (page.isPresent() && page.get() > 1){
                pageNum = page.get() - 1;
            }

            PageRequest pageRequest = new PageRequest(pageNum,5,new Sort("firstName"));
            if (keyword.isPresent() ){
                customerList = customerService.findAllByFirstNameContaining(keyword.get(),pageRequest);
                modelAndView.addObject("keyword", keyword.get());
            }else {
               customerList = customerService.findAll(pageRequest);
            }

            modelAndView.addObject("customer", customerList);
            return modelAndView;
        }

        @GetMapping("/create")
        public ModelAndView showCreateForm() {
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }

        @PostMapping("/create")
        public ModelAndView createForm(@Validated @ModelAttribute("customer") Customer customer,
                                       BindingResult bindingResult) {
            ModelAndView modelAndView = new ModelAndView("/create");
            if (bindingResult.hasFieldErrors()) {
                return modelAndView;
            }else {
                customerService.save(customer);
                modelAndView.addObject("customer",new Customer());
                modelAndView.addObject("message","New customer created successfully");

                return modelAndView;
            }

        }
        @GetMapping("/edit/{id}")
        public ModelAndView updateCustomer(@PathVariable Long id) {
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        @PostMapping(value = "/edit")
        public ModelAndView updateCustomer(@Validated @ModelAttribute("customer") Customer customer,
                                           BindingResult bindingResult) {

            ModelAndView modelAndView = new ModelAndView("/update");
            if (bindingResult.hasFieldErrors()){
                return modelAndView;
            }else {
                customerService.save(customer);
                modelAndView.addObject("message","Updated " + customer.getFirstName() +" success!");
                return modelAndView;
            }

        }
        @GetMapping("/delete/{id}")
        public ModelAndView showCutomerDelete(@PathVariable Long id) {
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }
        @PostMapping("/delete")
        public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
            customerService.remove(customer.getId());
            return  "redirect:/customers";
        }
    }
