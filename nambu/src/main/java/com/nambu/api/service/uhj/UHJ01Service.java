package com.nambu.api.service.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.UHJ01Entity;

/**
 * <p>Service</p>
 */
public interface UHJ01Service {
    //============================================================
    //< SELECT (List)
    //============================================================	
	public String getStudentList(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception;

    //============================================================
    //< SELECT (Map)
    //============================================================	
	public String getStudentInfo(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception;	
	
    //============================================================
    //< INSERT
    //============================================================
	public String insertStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception;

    //============================================================
    //< UPDATE
    //============================================================	
	public String updateStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception;	

    //============================================================
    //< DELETE
    //============================================================	
	public String deleteStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception;
	
    //============================================================
    //< SAVE
    //============================================================
	public String saveStudent(@Param("ST_HAKJEOK_M") List<UHJ01Entity> pUhj01Entity) throws Exception;	
}
