package com.example.hospitalpro.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalpro.common.entity.End;
import com.example.hospitalpro.common.entity.Regi;
import com.example.hospitalpro.doctor.mapper.DoctorMapper;
import com.example.hospitalpro.doctor.service.DoctorService;
import com.example.hospitalpro.user.mapper.RegiMapper;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	RegiMapper regiMapper;
	@Autowired
	DoctorMapper Doctormapper;
	@Autowired
	DoctorService doctorservice;

	/*
	 * 医生排号
	 */
	@GetMapping("/regi")
	public List<Regi> findbynowtime(@PathVariable int id) {
		return doctorservice.rownumber(id);
	}

	/*
	 * 添加病历
	 */
	@PostMapping("/patientid/medical")
	public Regi addend(@RequestBody End end) {
		return doctorservice.subend(end);
	}

}
