package edu.miu.cs.cs425.exampracticelab.repository;

import edu.miu.cs.cs425.exampracticelab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
