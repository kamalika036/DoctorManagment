package com.mycompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	Doctor findByName(String name);

	Doctor findBySpecalization(String specalization);

	List<Doctor> findByNameOrSpecalization(String name, String specalization);
}
