package edu.miu.cs.cs425.exampracticelab.controller;

import edu.miu.cs.cs425.exampracticelab.dto.PatientRequest;
import edu.miu.cs.cs425.exampracticelab.model.Patient;
import edu.miu.cs.cs425.exampracticelab.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/hcmcpatientmgmt/api/patient"})
public class PatientRestController {

    private PatientService patientService;

    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }



    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Patient>> listPatient(){
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Patient> addNewPatient(@Valid @RequestBody PatientRequest patientRequest){
        return new ResponseEntity<Patient>(patientService.addNewPatientApi(patientRequest),
                HttpStatus.CREATED);
    }

}
