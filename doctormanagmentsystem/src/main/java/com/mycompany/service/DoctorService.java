package com.mycompany.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.entity.Doctor;

@Component
public interface DoctorService {

	Doctor newDoctor(Doctor d);

	List<Doctor> getAll();

	Doctor getADoctor(int id);

	Doctor updateDoctor(Doctor ds, int id);

	String deleteDoctor(int id);

	Doctor getByName(String name);

	Doctor getBySpecalization(String specalization);

	List<Doctor> getbyNameOrSpecalization(String name, String specalization);
}
