package com.mycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mycompany.entity.Doctor;
import com.mycompany.repository.DoctorRepository;

@SpringBootApplication
public class DoctormanagmentsystemApplication implements CommandLineRunner {

	@Autowired
	private DoctorRepository doctorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoctormanagmentsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Doctor ds1 = Doctor.builder().name("Kamalika").specalization("urology").build();
		Doctor ds2 = Doctor.builder().name("Amit").specalization("radiology").build();
		Doctor ds3 = Doctor.builder().name("Puja").specalization("gynaecology").build();
		Doctor ds4 = Doctor.builder().name("Rittika").specalization("dermatology").build();
		Doctor ds5 = Doctor.builder().name("Bipasha").specalization("cardiologist").build();
		doctorRepository.save(ds1);
		doctorRepository.save(ds2);
		doctorRepository.save(ds3);
		doctorRepository.save(ds4);
		doctorRepository.save(ds5);
		System.out.println("____________ALL SAVED________________");

	}

}
