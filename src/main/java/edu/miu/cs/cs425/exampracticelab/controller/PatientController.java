package edu.miu.cs.cs425.exampracticelab.controller;

import edu.miu.cs.cs425.exampracticelab.model.Patient;
import edu.miu.cs.cs425.exampracticelab.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = {"/patient/list"})
    public ModelAndView listPatients(){
        var mav = new ModelAndView();
        mav.addObject("patients",patientService.getPatients());
        mav.setViewName("patient/list");
        return mav;
    }

    @GetMapping(value = {"/patient/new"})
    public String displayNewPatientForm(Model model){
        var patient = new Patient();
        model.addAttribute("patient",patient);
        return "patient/new";
    }

    @PostMapping(value = {"/patient/new"})
    public String addNewPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            var errors = bindingResult.getAllErrors();
            model.addAttribute("patient",patient);
            model.addAttribute("errors",errors);
            return "patient/new";
        }
        patientService.addNewPatient(patient);
        return "redirect:/patient/list";
    }


}
