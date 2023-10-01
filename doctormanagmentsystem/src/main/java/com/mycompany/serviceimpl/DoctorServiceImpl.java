package com.mycompany.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.entity.Doctor;
import com.mycompany.exception.DoctorNotFoundException;
import com.mycompany.repository.DoctorRepository;
import com.mycompany.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository docRepository;

	@Override
	public Doctor newDoctor(Doctor d) {
		return docRepository.save(d);
	}

	@Override
	public List<Doctor> getAll() {
		return docRepository.findAll();
	}

	@Override
	public Doctor getADoctor(int id) {
		java.util.Optional<Doctor> doDb = this.docRepository.findById(id);

		if (doDb.isPresent()) {
			return doDb.get();
		} else {
			throw new DoctorNotFoundException("Doctor not found with id : " + doDb);
		}
	}

	// @Override
	// public Doctor getADoctor(int id) {
	// return docRepository.findById(id).get();

	// }

	@Override
	public Doctor updateDoctor(Doctor ds, int id) {
		Doctor doc = getADoctor(id);
		doc.setSpecalization(ds.getSpecalization());
		doc.setName(ds.getName());

		return newDoctor(doc);
	}

	@Override
	public String deleteDoctor(int id) {
		Doctor temp = getADoctor(id);
		docRepository.deleteById(temp.getId());
		return "doctor with id" + id + "has been deleted";
	}

	@Override
	public Doctor getByName(String name) {
		return docRepository.findByName(name);
	}

	@Override
	public Doctor getBySpecalization(String specalization) {
		return docRepository.findBySpecalization(specalization);
	}

	@Override
	public List<Doctor> getbyNameOrSpecalization(String name, String specalization) {
		// TODO Auto-generated method stub
		return docRepository.findByNameOrSpecalization(name, specalization);
	}

	// @Override
	// public List<Doctor> getbyNameOrSpecalization(String name, String
	// specalization) {
	// return docRepository.findByNameOrSpecalization(name, specalization);
	// }

}
