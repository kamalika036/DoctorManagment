package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.entity.Doctor;
import com.mycompany.service.DoctorService;

import jakarta.validation.Valid;

@RestController
public class DoctorControllerB {
	@Autowired
	private DoctorService DocService;

	@PostMapping("/doctorbs")
	public ResponseEntity<Doctor> saveNewDoctor(@RequestBody @Valid Doctor d) {
		try {
			Doctor dts = DocService.newDoctor(new Doctor(d.getName(), d.getSpecalization()));
			return new ResponseEntity<>(dts, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/doctorbs")
	public ResponseEntity<List<Doctor>> showAllDoctors() {
		try {
			List<Doctor> docall = new ArrayList<Doctor>();
			DocService.getAll().forEach(docall::add);
			if (docall.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(docall, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/doctorbs/{id}")
	public ResponseEntity<Doctor> fetchAStudent(@PathVariable int id) {
		return ResponseEntity.ok().body(DocService.getADoctor(id));
	}

	@PutMapping("/doctor/{id}")
	public Doctor updateDoc(@RequestBody @Valid Doctor ds, @PathVariable int id) {
		return DocService.updateDoctor(ds, id);
	}

	@DeleteMapping("/doctor/{id}")
	public String deleteDoctor(@PathVariable int id) {
		return DocService.deleteDoctor(id);
	}

	@GetMapping("/doctorsname")
	public ResponseEntity<Doctor> fetchAStudentByName(@RequestParam String name) {
		return ResponseEntity.ok().body(DocService.getByName(name));
	}

	// @GetMapping("/doctorspecality")
	// public ResponseEntity<Doctor> fetchAStudentBySpecalization(@RequestParam
	// String specalization) {
	// return
	// ResponseEntity.ok().body(DocService.getBySpecalization(specalization));
	// }

	@GetMapping("/doctorspecality/")
	public ResponseEntity<Doctor> fetchAStudentBySpecalization(@RequestParam String specalization) {
		return ResponseEntity.ok().body(DocService.getBySpecalization(specalization));
	}

}
