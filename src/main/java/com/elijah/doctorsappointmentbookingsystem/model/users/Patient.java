package com.elijah.doctorsappointmentbookingsystem.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

import static java.time.Month.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String profileImage;
    private LocalDate dateOfBirth;
    private String category;
    private int cardFee;
    private Integer age;
    private Date createdDate;

}
