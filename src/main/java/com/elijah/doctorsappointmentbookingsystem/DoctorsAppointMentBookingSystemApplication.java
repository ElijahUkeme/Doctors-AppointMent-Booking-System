package com.elijah.doctorsappointmentbookingsystem;

import com.elijah.doctorsappointmentbookingsystem.security.model.AppUser;
import com.elijah.doctorsappointmentbookingsystem.security.model.Role;
import com.elijah.doctorsappointmentbookingsystem.security.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@EnableCaching
@SpringBootApplication
public class DoctorsAppointMentBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorsAppointMentBookingSystemApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
