package com.nambu.api.service.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nambu.api.entity.uhj.UHJ01Entity;
import com.nambu.api.mapper.uhj.UHJ01Mapper;
//import com.nambu.api.security.AuthCheck;
import com.nambu.api.util.Utils;

import lombok.RequiredArgsConstructor;

/**
 * <p>ServiceImpl</p>
 * <ul>
 * 	<li>Service 에 정의된 interface 를 상속받아 사용</li>
 * 	<li>각 서비스 로직 구현</li>
 * </ul> 
 */
@Service
@RequiredArgsConstructor
public class UHJ01ServiceImpl implements UHJ01Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UHJ01Mapper uhj01Mapper;

	Utils utils = new Utils();
	
	/**
	 * <p>SELECT (List)</p>
		 * <ul>
		 * 	<li>학생정보 리스트를 조회한다 </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	public String getStudentList(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey()).equals("{}")) {
			return utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey());
		}

        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		String Message = "SUCCESS";
		String Success = "1";
		
		try {
			List<UHJ01Entity> uhj01Entity = uhj01Mapper.getStudentList(pUhj01Entity);
			dataResult.addProperty("reason", Message);
			dataResult.addProperty("result", Success);
	
			if (uhj01Entity.size() > 0) {
				for (UHJ01Entity item : uhj01Entity) {
					JsonObject Obj1 = new JsonObject();
					JsonObject Obj2 = new JsonObject();
	
					Obj1.addProperty("hakbeon", item.getHakbeon());
					Obj1.addProperty("haknyeon", item.getCurr_haknyeon());
					Obj1.addProperty("h_name", item.getH_name());
					Obj1.addProperty("hakgwa", item.getHakgwa());
					Obj1.addProperty("ban", item.getCurr_ban());
					Obj1.addProperty("sex", item.getSex());
					Obj1.addProperty("sangtae", item.getSangtae());
					Obj1.addProperty("bigo", item.getBigo());
					jsonArr1.add(Obj1);
	
					Obj2.add("result", jsonArr1);
					dataResult.add("data", Obj2);
				}
			} else {
				JsonObject Obj3 = new JsonObject();
				Obj3.add("result", jsonArr1);
				dataResult.add("data", Obj3);
			}
			
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.getStudentList] ERROR : " + e);
			// TODO
			e.printStackTrace();
		}			
		return dataResult.toString();
	}

	/**
	 * <p>SELECT (Map)</p>
		 * <ul>
		 * 	<li>학생정보 상세를 조회한다 </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	public String getStudentInfo(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey()).equals("{}")) {
			return utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey());
		}

        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		String Message = "SUCCESS";
		String Success = "1";
		
		try {
			UHJ01Entity uhj01Entity = uhj01Mapper.getStudentInfo(pUhj01Entity.getHakbeon());
			dataResult.addProperty("reason", Message);
			dataResult.addProperty("result", Success);
	
			if (uhj01Entity != null) {
					JsonObject Obj1 = new JsonObject();
					JsonObject Obj2 = new JsonObject();
	
					Obj1.addProperty("hakbeon", uhj01Entity.getHakbeon());
					Obj1.addProperty("haknyeon", uhj01Entity.getCurr_haknyeon());
					Obj1.addProperty("h_name", uhj01Entity.getH_name());
					Obj1.addProperty("hakgwa", uhj01Entity.getHakgwa());
					Obj1.addProperty("ban", uhj01Entity.getCurr_ban());
					Obj1.addProperty("sex", uhj01Entity.getSex());
					Obj1.addProperty("sangtae", uhj01Entity.getSangtae());
					Obj1.addProperty("bigo", uhj01Entity.getBigo());
					jsonArr1.add(Obj1);
	
					Obj2.add("result", jsonArr1);
					dataResult.add("data", Obj2);
			} else {
				JsonObject Obj3 = new JsonObject();
				Obj3.add("result", jsonArr1);
				dataResult.add("data", Obj3);
			}
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.getStudentInfo] ERROR : " + e);
			// TODO
			e.printStackTrace();
		}			
		return dataResult.toString();
	}	
	
	/**
	 * <p>INSERT</p>
		 * <ul>
		 * 	<li>학생정보를 저장한다. </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	public String insertStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey()).equals("{}")) {
			return utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey());
		}		
		
        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		JsonArray jsonArr2 = new JsonArray();
		JsonObject Obj1 = new JsonObject();
		JsonObject Obj2 = new JsonObject();
		JsonObject Obj3 = new JsonObject();	
		
		String OK_MESSAGE = "SUCCESS";
		String NOT_OK_MESSAGE = "FAIL";
		
		try {
			int results = uhj01Mapper.insertStudent(pUhj01Entity);

	        //============================================================
	        //< Respnse Data (Sample)
			//< API 호출 시 공통으로 리턴받는 Response Data
	        //============================================================			
			String if_id = "IF-001-001";				// API id
			String version = "v1.0";					// API version
			String m_code = "HAK000";					// Menu Code
			String s_code = "HAK001";					// Sub Menu Code
			String response_format = "json";			// 반환 data 타입
			String result = "";							// 응답코드 4자리
			String reason = "";							// 응답 결과 메세지 ("성공", "필수항목 누락" 등)
			String server_time = "2021-04-13 15:40:40";	//응답 시 서버 시간
			String response_time = "132";				// 서버에서 처리한 경과 시간(milliseconds)
			// 인터페이스별로 반환되는 데이터가 있을 경우 "datas" Object 하위로 반환
			// 추가 반환할 데이터가 없을 경우 null 또는 ""(빈스트링) 반환
			
			if (results == 1) {
				dataResult.addProperty("reason", OK_MESSAGE);
				result = "0000";
				reason = "성공";
			} else {
				dataResult.addProperty("reason", NOT_OK_MESSAGE);
				result = "0001";	
				reason = "필수항목누락";				
			}
			dataResult.addProperty("result", results);
			
			Obj1.addProperty("if_id", if_id);
			Obj1.addProperty("version", version);
			Obj1.addProperty("m_code", m_code);
			Obj1.addProperty("s_code", s_code);
			Obj1.addProperty("response_format", response_format);
			Obj1.addProperty("result", result);
			Obj1.addProperty("reason", reason);
			Obj1.addProperty("server_time", server_time);
			Obj1.addProperty("response_time", response_time);

			Obj2.addProperty("hakbeon", pUhj01Entity.getHakbeon());
			jsonArr2.add(Obj2);
			Obj1.add("datas", jsonArr2);			
			
			jsonArr1.add(Obj1);
			Obj3.add("result", jsonArr1);
			
			dataResult.add("data", Obj3);
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.insertStudent] ERROR : " + e);
			// TODO
			e.printStackTrace();
		}
		return dataResult.toString();
	}	

	/**
	 * <p>UPDATE</p>
		 * <ul>
		 * 	<li>학생정보를 수정한다. </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	public String updateStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity) throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey()).equals("{}")) {
			return utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey());
		}		
		
        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		JsonArray jsonArr2 = new JsonArray();
		JsonObject Obj1 = new JsonObject();
		JsonObject Obj2 = new JsonObject();
		JsonObject Obj3 = new JsonObject();	
		
		String OK_MESSAGE = "SUCCESS";
		String NOT_OK_MESSAGE = "FAIL";
		
		try {
			int results = uhj01Mapper.updateStudent(pUhj01Entity);
	        //============================================================
	        //< Respnse Data (Sample)
			//< API 호출 시 공통으로 리턴받는 Response Data
	        //============================================================			
			String if_id = "IF-001-001";				// API id
			String version = "v1.0";					// API version
			String m_code = "HAK000";					// Menu Code
			String s_code = "HAK001";					// Sub Menu Code
			String response_format = "json";			// 반환 data 타입
			String result = "";							// 응답코드 4자리
			String reason = "";							// 응답 결과 메세지 ("성공", "필수항목 누락" 등)
			String server_time = "2021-04-13 15:40:40";	//응답 시 서버 시간
			String response_time = "132";				// 서버에서 처리한 경과 시간(milliseconds)
			// 인터페이스별로 반환되는 데이터가 있을 경우 "datas" Object 하위로 반환
			// 추가 반환할 데이터가 없을 경우 null 또는 ""(빈스트링) 반환
			
			if (results == 1) {
				dataResult.addProperty("reason", OK_MESSAGE);
				result = "0000";
				reason = "성공";
			} else {
				dataResult.addProperty("reason", NOT_OK_MESSAGE);
				result = "0001";	
				reason = "칼럼 길이 초과";				
			}
			dataResult.addProperty("result", results);
			
			Obj1.addProperty("if_id", if_id);
			Obj1.addProperty("version", version);
			Obj1.addProperty("m_code", m_code);
			Obj1.addProperty("s_code", s_code);
			Obj1.addProperty("response_format", response_format);
			Obj1.addProperty("result", result);
			Obj1.addProperty("reason", reason);
			Obj1.addProperty("server_time", server_time);
			Obj1.addProperty("response_time", response_time);

			Obj2.addProperty("hakbeon", pUhj01Entity.getHakbeon());
			jsonArr2.add(Obj2);
			Obj1.add("datas", jsonArr2);			
			
			jsonArr1.add(Obj1);
			Obj3.add("result", jsonArr1);
			
			dataResult.add("data", Obj3);
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.updateStudent] ERROR : " + e);
			// TODO
			e.printStackTrace();
		}
		return dataResult.toString();
	}	
	
	/**
	 * <p>DELETE</p>
		 * <ul>
		 * 	<li>학생정보를 삭제한다. </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	public String deleteStudent(@Param("ST_HAKJEOK_M") UHJ01Entity pUhj01Entity)  throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey()).equals("{}")) {
			return utils.getMetaAuthErrGenerator(pUhj01Entity.getApikey());
		}		
		
        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		JsonArray jsonArr2 = new JsonArray();
		JsonObject Obj1 = new JsonObject();
		JsonObject Obj2 = new JsonObject();
		JsonObject Obj3 = new JsonObject();	
		
		String OK_MESSAGE = "SUCCESS";
		String NOT_OK_MESSAGE = "FAIL";
		
		try {
			int results = uhj01Mapper.deleteStudent(pUhj01Entity);
	        //============================================================
	        //< Respnse Data (Sample)
			//< API 호출 시 공통으로 리턴받는 Response Data
	        //============================================================			
			String if_id = "IF-001-001";				// API id
			String version = "v1.0";					// API version
			String m_code = "HAK000";					// Menu Code
			String s_code = "HAK001";					// Sub Menu Code
			String response_format = "json";			// 반환 data 타입
			String result = "";							// 응답코드 4자리
			String reason = "";							// 응답 결과 메세지 ("성공", "필수항목 누락" 등)
			String server_time = "2021-04-13 15:40:40";	//응답 시 서버 시간
			String response_time = "132";				// 서버에서 처리한 경과 시간(milliseconds)
			// 인터페이스별로 반환되는 데이터가 있을 경우 "datas" Object 하위로 반환
			// 추가 반환할 데이터가 없을 경우 null 또는 ""(빈스트링) 반환
			
			if (results == 1) {
				dataResult.addProperty("reason", OK_MESSAGE);
				result = "0000";
				reason = "성공";
			} else {
				dataResult.addProperty("reason", NOT_OK_MESSAGE);
				result = "0001";	
				reason = "key 변경";				
			}
			dataResult.addProperty("result", results);
			
			Obj1.addProperty("if_id", if_id);
			Obj1.addProperty("version", version);
			Obj1.addProperty("m_code", m_code);
			Obj1.addProperty("s_code", s_code);
			Obj1.addProperty("response_format", response_format);
			Obj1.addProperty("result", result);
			Obj1.addProperty("reason", reason);
			Obj1.addProperty("server_time", server_time);
			Obj1.addProperty("response_time", response_time);

			Obj2.addProperty("hakbeon", pUhj01Entity.getHakbeon());
			jsonArr2.add(Obj2);
			Obj1.add("datas", jsonArr2);			
			
			jsonArr1.add(Obj1);
			Obj3.add("result", jsonArr1);
			
			dataResult.add("data", Obj3);
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.deleteStudent] ERROR : " + e);
			// TODO
			e.printStackTrace();
		}
		return dataResult.toString();
	}	
	
	/**
	 * <p>SAVE (CRUD Transaction process)</p>
		 * <ul>
		 * 	<li>Multi-row 학생정보 데이터를 CRUD 플래그에 맞게 처리한다. </li>
		 *  <li>Transaction 으로 처리한다 (All or Nothing) </li>
	     * </ul>
	 * @param pUhj01Entity 클라이언트에서 요청받은 학적정보
	 * @return String
	 */	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String saveStudent(@Param("ST_HAKJEOK_M") List<UHJ01Entity> pUhj01Entity) throws Exception {
		JsonObject dataResult = new JsonObject();
		String crud_gb = "";
		try {
			List<UHJ01Entity> datas = pUhj01Entity;
			
			for (UHJ01Entity item : datas) {
				crud_gb = item.getCrud_gb();
				
		        //============================================================
		        //< INSERT
		        //============================================================				
				if (crud_gb.equals("C")) {
					uhj01Mapper.insertStudent(item);
				} else if (crud_gb.equals("U")) {
					uhj01Mapper.updateStudent(item);
				} else if (crud_gb.equals("D")) {
					uhj01Mapper.deleteStudent(item);
				}
			}
		} catch (Exception e) {
			logger.error("[UHJ01ServiceImpl.saveStudent] ERROR : " + e);
			throw new RuntimeException(e);
		}
		return dataResult.toString();
	}
}
