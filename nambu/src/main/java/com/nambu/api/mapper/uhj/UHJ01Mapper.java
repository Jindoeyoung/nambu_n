package com.nambu.api.mapper.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.UHJ01Entity;

/**
 * <p>Mapper</p>
 */
@Mapper
public interface UHJ01Mapper {
	
    //============================================================
    //< SELECT
    //============================================================	
	List<UHJ01Entity> getStudentList(
		@Param("ST_HAKJEOK_M") UHJ01Entity hakjeokm
	);

    //============================================================
    //< INSERT
    //============================================================	
	int insertStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity hakjeokm
	);

    //============================================================
    //< UPDATE
    //============================================================	
	int updateStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity hakjeokm
	);

    //============================================================
    //< DELETE
    //============================================================	
	int deleteStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity hakjeokm
	);
}
