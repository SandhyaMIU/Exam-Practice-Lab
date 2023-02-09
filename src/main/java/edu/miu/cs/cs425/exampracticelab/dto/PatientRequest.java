package edu.miu.cs.cs425.exampracticelab.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PatientRequest {


    @NotBlank(message = "Patient Number have to fill")
    @Column(nullable = false, unique = true)
    private String patientNumber;

    @NotNull(message = "Not null")
    private String isAnOutPatient;

    @NotBlank
    private String fullName;
    private String emailAddress;
    private String contactPhoneNumber;

    @NotNull
    private LocalDate dateOfBirth;



}
