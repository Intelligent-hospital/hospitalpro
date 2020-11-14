package com.example.hospitalpro.common.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalpro.common.entity.Doctor;
import com.example.hospitalpro.common.entity.Patient;
import com.example.hospitalpro.common.entity.Regi;
import com.example.hospitalpro.doctor.service.DoctorService;
import com.example.hospitalpro.user.mapper.PatientMapper;
import com.example.hospitalpro.user.mapper.RegiMapper;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	RegiMapper regiMapper;
	@Autowired
	PatientMapper patinetmapper;
	@Autowired
	DoctorService doctorservice;

//	挂号
	@PostMapping("/doctor/registration")
	public String addregi(@RequestBody Regi regi) {
		return doctorservice.addregistr(regi);
	}

//	查询医生坐诊时间
	@GetMapping("/doctor/{id}")
	public List<Doctor> show(@PathVariable int id) {
		return regiMapper.findbywork(id);
	}

// 查询挂号信息具体
	@GetMapping("/doctor/pat/{id}")
	public List<Regi> findreg(@PathVariable int id) {
		return regiMapper.findallreg(id);
	}

	/**
	 * 找到所有就诊人信息
	 * 
	 * @return 所有就诊人信息集合
	 */
	@GetMapping("/patients")
	public List<Patient> findAllPatient() {
		return patinetmapper.findAllPatient();
	}

	/**
	 * 添加就诊人
	 * 
	 * @param patient
	 * @return
	 */
	@PostMapping("/patient")
	public Patient addPatient(@RequestBody Patient patient) {
		String idCard = patient.getPaidCard();
		// 截取身份证第15位判断性别
		int sex = idCard.charAt(16);
		if (sex == 1) {
			patient.setSex("男");
		} else {
			patient.setSex("女");
		}
		// 获取当年年份再减去身份证的7到10位得出年龄
		int age = (Calendar.getInstance().get(Calendar.YEAR)) - (Integer.parseInt(idCard.substring(6, 10)));
		patient.setAge(age);
		System.out.println(patient);
		// 调用添加方法
		patinetmapper.addPatient(patient);
		return patient;

	}

	/*
	 * 取消预约
	 */
	@PutMapping("/doctor/{appointmentid}")
	public String cancelReservation(int id) {
		return doctorservice.callback(id);
	}
}
