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
    //< SELECT (List)
    //============================================================	
	List<UHJ01Entity> getStudentList(
		@Param("ST_HAKJEOK_M") UHJ01Entity uhj01Entity
	);

    //============================================================
    //< SELECT (Map)
    //============================================================	
	UHJ01Entity getStudentInfo(
		@Param("hakbeon") String hakbeon 
	);	
	
    //============================================================
    //< INSERT
    //============================================================	
	int insertStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity uhj01Entity
	);

    //============================================================
    //< UPDATE
    //============================================================	
	int updateStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity uhj01Entity
	);

    //============================================================
    //< DELETE
    //============================================================	
	int deleteStudent(
		@Param("ST_HAKJEOK_M") UHJ01Entity uhj01Entity
	);
}
