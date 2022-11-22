package com.example.springboot.controller;

import com.example.springboot.model.Carrier;
import com.example.springboot.service.CarrierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    // Display a list of all carriers
    @GetMapping("/")
    public String viewHomePage(Model model) {
       return findPaginated(1, model);
    }

    @GetMapping("/showNewCarrierForm")
    public String showNewCarrierForm(Model model) {
        Carrier carrier = new Carrier();
        model.addAttribute("carrier", carrier);
        return "new_carrier";
    }

    @PostMapping("/saveCarrier")
    public String saveCarrier(@ModelAttribute("carrier") Carrier carrier) {
        carrierService.saveCarrier(carrier);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
        Carrier carrier = carrierService.getCarrierById(id);
        model.addAttribute("carrier", carrier);
        return "update_carrier";
    }

    @GetMapping("/deleteCarrier/{id}")
    public String deleteCarrier(@PathVariable(value="id") long id) {
        this.carrierService.deleteCarrierById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Carrier> page = carrierService.findPaginated(pageNo, pageSize);
        List<Carrier> listCarriers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listCarriers", listCarriers);
        return "index";
    }
}
