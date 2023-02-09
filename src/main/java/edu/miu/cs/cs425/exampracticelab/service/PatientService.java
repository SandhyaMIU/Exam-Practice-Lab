package edu.miu.cs.cs425.exampracticelab.service;

import edu.miu.cs.cs425.exampracticelab.dto.PatientRequest;
import edu.miu.cs.cs425.exampracticelab.model.Patient;
import edu.miu.cs.cs425.exampracticelab.repository.PatientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService{

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients(){

        return patientRepository.findAll(Sort.by(Sort.Direction.ASC,"fullName"));
    }

    public Patient addNewPatient(Patient newPatient){

        return patientRepository.save(newPatient);
    }

    public Patient addNewPatientApi(PatientRequest newPatientRequest) {
        var newPatient = new Patient(null, newPatientRequest.getPatientNumber(),newPatientRequest.getIsAnOutPatient(),
                newPatientRequest.getFullName(),newPatientRequest.getEmailAddress(),
                newPatientRequest.getContactPhoneNumber(),newPatientRequest.getDateOfBirth());
        return patientRepository.save(newPatient);
    }

}
