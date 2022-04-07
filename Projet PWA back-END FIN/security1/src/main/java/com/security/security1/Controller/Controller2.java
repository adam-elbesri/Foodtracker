package com.security.security1.Controller;

import java.util.List;

import com.security.security1.Model.Aliments;
import com.security.security1.Repository.AlimentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller2 {

    @Autowired
    AlimentsRepository labd2;

    @RequestMapping("/p2")
    public String acl(Model model) {
        model.addAttribute("hi", "helowwwwwww");
        model.addAttribute("al", new Aliments());
        return "/simple2";
    }

    @RequestMapping("/addaliments")
    public String acl(Aliments ali) {
        labd2.save(ali);
        return "redirect:/p2";
    }

    @RequestMapping("/validerandgetReport")
    public String listAliment(Model model1) {
        List<Aliments> listAliments = (List<Aliments>) labd2.findAll();
        model1.addAttribute("listAliment", listAliments);
        Integer total_cal = labd2.selectTotals();
        model1.addAttribute("total_cal", total_cal);
        return "simple3";
    }

    @RequestMapping("/aliment/{id}/suppr")
    public String showSuppAlimentForm(@PathVariable("id") Long id) {
        labd2.deleteById(id);
        return "redirect:/validerandgetReport";
    }

    @RequestMapping("/ajouterDesAliments")
    public String listAliment1(Model model) {

        List<Aliments> listAliments = (List<Aliments>) labd2.findAll();
        model.addAttribute("listAliment", listAliments);
        return "redirect:/p2";
    }

    @RequestMapping("/aliment/{id}/modidier")
    public String showEditAlimentForm(@PathVariable("id") Long id, Model model) {
        Aliments almt = labd2.findById(id).get();
        model.addAttribute("ali", almt);
        labd2.deleteById(id);
        return "redirect:/p2";
    }
}
