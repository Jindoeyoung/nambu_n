package com.nambu.api.controller.uhj;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nambu.api.entity.uhj.UHJ01Entity;
import com.nambu.api.service.uhj.UHJ01Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * <p>Controller</p>
 */
@Api(tags="학생정보관리")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/uhj/uhj01", produces = "application/json; charset=utf8")
public class UHJ01Controller {
	private final UHJ01Service uhj01Service;

    //============================================================
    //< SELECT (List)
    //============================================================
	@ApiImplicitParams({
	@ApiImplicitParam(
	        name = "apikey",
	        value = "apikey",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	),
	@ApiImplicitParam(
	        name = "hakbeon",
	        value = "학번",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	)	
	})
    @ApiResponses({
        @ApiResponse(code=200, message="성공"),
        @ApiResponse(code=401, message="접근 권한이 없습니다.")
    })
	@ApiOperation(
		    value = "학생정보리스트 조회",
		    notes = "학생정보리스트에 해당하는 부분을 조회하는 API")
	@PostMapping("/getStudentList")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getUser(@RequestBody UHJ01Entity pUhj01Entity) throws Exception {
		return uhj01Service.getStudentList(pUhj01Entity);
	}

    //============================================================
    //< SELECT (Map)
    //============================================================
	@ApiImplicitParams({
	@ApiImplicitParam(
	        name = "apikey",
	        value = "apikey",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	),
	@ApiImplicitParam(
	        name = "hakbeon",
	        value = "학번",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	)	
	})
    @ApiResponses({
        @ApiResponse(code=200, message="성공"),
        @ApiResponse(code=401, message="접근 권한이 없습니다.")
    })
	@ApiOperation(
		    value = "학생정보상세 조회",
		    notes = "학생정보상세에 해당하는 부분을 조회하는 API")
	@PostMapping("/getStudentInfo")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getUserInfo(@RequestBody UHJ01Entity pUhj01Entity) throws Exception {
		return uhj01Service.getStudentInfo(pUhj01Entity);
	}

    //============================================================
    //< INSERT
    //============================================================
	@ApiImplicitParams({
	@ApiImplicitParam(
	        name = "apikey",
	        value = "apikey",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	),
	@ApiImplicitParam(
	        name = "hakbeon",
	        value = "학번",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	)	
	})
    @ApiResponses({
        @ApiResponse(code=200, message="성공"),
        @ApiResponse(code=401, message="접근 권한이 없습니다.")
    })	
	@ApiOperation(
		    value = "학생정보 저장",
		    notes = "학생정보를 저장하는 API")		
	@PostMapping("/insertStudent")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String insertUser(@RequestBody UHJ01Entity pUhj01Entity) throws Exception {
		return uhj01Service.insertStudent(pUhj01Entity);
	}	

    //============================================================
    //< UPDATE
    //============================================================
	@ApiImplicitParams({
	@ApiImplicitParam(
	        name = "apikey",
	        value = "apikey",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	),
	@ApiImplicitParam(
	        name = "hakbeon",
	        value = "학번",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	)	
	})
    @ApiResponses({
        @ApiResponse(code=200, message="성공"),
        @ApiResponse(code=401, message="접근 권한이 없습니다.")
    })	
	@ApiOperation(
		    value = "학생정보 수정",
		    notes = "학생정보를 수정하는 API")	
	@PutMapping("/updateStudent")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String updatetUser(@RequestBody UHJ01Entity pUhj01Entity) throws Exception {
		return uhj01Service.updateStudent(pUhj01Entity);
	}	

    //============================================================
    //< DELETE
    //============================================================
	@ApiImplicitParams({
	@ApiImplicitParam(
	        name = "apikey",
	        value = "apikey",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	),
	@ApiImplicitParam(
	        name = "hakbeon",
	        value = "학번",
	        dataTypeClass = String.class,
	        defaultValue = "None"
	)	
	})
    @ApiResponses({
        @ApiResponse(code=200, message="성공"),
        @ApiResponse(code=401, message="접근 권한이 없습니다.")
    })	
	@ApiOperation(
		    value = "학생정보 삭제",
		    notes = "학생정보를 삭제하는 API")	
	@DeleteMapping("/deleteStudent")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deletetUser(@RequestBody UHJ01Entity pUhj01Entity) throws Exception {
		return uhj01Service.deleteStudent(pUhj01Entity);
	}	
	
  //============================================================
  //< SAVE
  //============================================================
	@ApiOperation(
		    value = "학생정보 저장(CRUD)",
		    notes = "학생정보를 저장하는(CRUD) API")		
	@PostMapping("/saveStudent")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String saveUser(@RequestBody List<UHJ01Entity> pUhj01Entity) throws Exception {
		return uhj01Service.saveStudent(pUhj01Entity);
	}
}
