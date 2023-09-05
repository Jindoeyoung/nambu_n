package com.nambu.api.util;

import com.google.gson.JsonObject;
import com.nambu.api.security.SignVerifier;

/**
 * <p>Util</p>
 * <ul>
 * 	<li>공통 function을 구현하여 사용</li>
 * </ul> 
 */
public class Utils {
	/**
	 * <p>api-key 인증</p>
	 * @param apikey 클라이언트로 부터 받은 apikey
	 * @return Json 
	 */	
	public String getMetaAuthErrGenerator(String apikey) throws Exception {
		SignVerifier verifier = new SignVerifier();
		JsonObject result = new JsonObject();
	    //============================================================
	    //< api-key 인증 처리
	    //============================================================
	    if (!verifier.verifySignature(apikey)) {
	        result = getMetaErrGenerator(10000);
	        return result.toString();
	    }
	    return result.toString();
	}	
	
	/**
	 * <p>Error Json Return</p>
	 * @param responseCode Error code
	 * @return Json 
	 */	
	public JsonObject getMetaErrGenerator(Integer responseCode) throws Exception {

		JsonObject dataResult = new JsonObject();
		String desc = "";
		String result = "0";

		try {
			if (responseCode == 10000 ) {
		        //============================================================
		        //< api-key 오류 시
		        //============================================================				
				desc = "AUTHENTICATION RESTRICTIONS";
				result = "-3";
			} else {
		        //============================================================
		        //< 기타 오류 시
		        //============================================================				
				desc = "ETC ERROR, PLEASE CHECK";
				result = "-4";
			}
			dataResult.addProperty("reason", "[" + responseCode + " ERROR] " + desc);
			dataResult.addProperty("result", result);
			dataResult.addProperty("data", "");

			return dataResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataResult;
	}
}