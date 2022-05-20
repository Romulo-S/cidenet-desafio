package com.example.registerapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.example.registerapp.validation.Name;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Schema(hidden = true)
    private String id;

    @Size(max = 20, message = "{No puede tener mas de 20 letras}")
    @Name
    @NotNull
    String firstSurname;

    @Size(max = 20, message = "{No puede tener mas de 20 letras}")
    @Name
    @NotNull
    String secondSurname;

    @Size(max = 20, message = "{No puede tener mas de 20 letras}")
    @Name
    @NotNull
    String name;

    @Size(max = 50, message = "{No puede tener mas de 20 letras}")
    @Name
    String otherNames;

    @Enumerated(EnumType.STRING)
    @NotNull
    Country country;

    @Enumerated(EnumType.STRING)
    @NotNull
    IdType idType;

    @Size(max = 20, message = "{No puede tener mas de 20 letras}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    String idNumber;

    @Schema(hidden = true)
    String email;

    @NotNull
    @PastOrPresent
    LocalDate firstDay;

    @Enumerated(EnumType.STRING)
    @NotNull
    JobCategory jobCategory;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Schema(hidden = true)
    Status status;

    @Schema(hidden = true)
    final LocalDateTime createdAt = LocalDateTime.now();

    public Employee(String id, String firstSurname, String secondSurname, String name, String otherNames, Country country, IdType idType,
        String idNumber, String email, LocalDate firstDay, JobCategory jobCategory, Status status) {
        this.id = id;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.name = name;
        this.otherNames = otherNames;
        this.country = country;
        this.idType = idType;
        this.idNumber = idNumber;
        this.email = email;
        this.firstDay = firstDay;
        this.jobCategory = jobCategory;
        this.status = status;
    }

    public Employee() {
    }
}
