package com.example.hospitalpro.common.entity;

import java.sql.Date;

/*
 * 	挂号单
 */
public class Regi {
	private Patient patient; // 就诊人信息
	private Doctor doctor; // 挂号的医生
	private Date time; // 挂号时间
	private int statu; // 是否就诊
	private int sign; // 是否签到
	private int isdelete; // 是否删除
	private End end; // 可以查到病历

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public End getEnd() {
		return end;
	}

	public void setEnd(End end) {
		this.end = end;
	}

	public Regi() {
		super();
		// TODO Auto-generated constructor stub
	}

}
