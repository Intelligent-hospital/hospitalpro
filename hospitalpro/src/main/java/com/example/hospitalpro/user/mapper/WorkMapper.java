package com.example.hospitalpro.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.hospitalpro.common.entity.Doctor;

@Mapper
public interface WorkMapper {
//	查询所有时间
	@Select("selet * from work")
	List<Doctor> findbywork();
}
