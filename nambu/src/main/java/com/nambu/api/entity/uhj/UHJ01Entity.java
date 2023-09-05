package com.nambu.api.entity.uhj;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="학적마스터 정보 관리")
@Data
public class UHJ01Entity {
	/* StHakJeok M*/
	private String apikey;
	@ApiModelProperty(value="학번", example = "201901013", required = true)
	private String hakbeon;
	@ApiModelProperty(value="프로파일 이미지", required = false)
	private String profile;
	@ApiModelProperty(value="주민번호", example = "8012153048123", required = false)
	private String jumin_no;
	@ApiModelProperty(value="생년월일", example = "19801215", required = false)
	private String birthday;
	@ApiModelProperty(value="한글성명", example = "김철수", required = false)
	private String h_name;
	@ApiModelProperty(value="한문성명", example = "金哲水", required = false)
	private String c_nane;
	@ApiModelProperty(value="국적", example = "대한민국", required = false)
	private String gukga;
	@ApiModelProperty(value="영문이름", example = "cheol su", required = false)
	private String e_name_last;
	@ApiModelProperty(value="영문성", example = "Kim", required = false)
	private String e_name;
	@ApiModelProperty(value="상태", example = "01(재학)", required = false)
	private String sangtae;
	@ApiModelProperty(value="변동사유", example = "02(복학)", required = false)
	private String byeondongsayu;
	@ApiModelProperty(value="변동일자", example = "20220304", required = false)
	private String byeondong_ilja;
	@ApiModelProperty(value="과정구분", example = "01(학부)", required = false)
	private String gwajeong_gb;
	@ApiModelProperty(value="주야구분", example = "01(주간)", required = false)
	private String juya_gb;
	@ApiModelProperty(value="주야구분명", example = "주간", required = false)
	private String juya_gb_nm;
	@ApiModelProperty(value="학과", example = "소프트웨어융합과", required = false)
	private String hakgwa;
	@ApiModelProperty(value="전공", example = "소프트웨어융합", required = false)
	private String jeongong;
	@ApiModelProperty(value="학년", example = "3", required = false)
	private String haknyeon;
	@ApiModelProperty(value="반", example = "A", required = false)
	private String ban;
	@ApiModelProperty(value="학기", example = "4", required = false)
	private String hakgi;
	@ApiModelProperty(value="이수학기", example = "2", required = false)
	private String isuhakgi;
	@ApiModelProperty(value="입학학과", example = "멀티미디어컨텐츠과", required = false)
	private String iphak_hakgwa;
	@ApiModelProperty(value="전형구분", example = "수능", required = false)
	private String jeonhyeong_gb;
	@ApiModelProperty(value="위탁회사", example = "삼성전자", required = false)
	private String wetak_company;
	@ApiModelProperty(value="입학일자", example = "20210304", required = false)
	private String iphak_ilja;
	@ApiModelProperty(value="졸업학년", example = "4", required = false)
	private String joleop_haknyeon;
	@ApiModelProperty(value="졸업학과", example = "소프트웨어융합", required = false)
	private String joleop_hakgwa;
	@ApiModelProperty(value="입학주야", example = "01(주간)", required = false)
	private String iphak_juya;
	@ApiModelProperty(value="입학구분", example = "01(입학)", required = false)
	private String iphak_gb;
	@ApiModelProperty(value="병역구분", example = "01(예비역)", required = false)
	private String byunguk_gb;
	@ApiModelProperty(value="졸업증서번호", example = "22-12485478", required = false)
	private String joleop_jeungseo_no;
	@ApiModelProperty(value="학위번호", example = "남부대학교(석)007", required = false)
	private String hakwi_no;
	@ApiModelProperty(value="임시학적", example = "01(재적)", required = false)
	private String imsi_hakjeok;
	@ApiModelProperty(value="복학예정일자", example = "20250801", required = false)
	private String bokhakyejeong_ilja;
	@ApiModelProperty(value="성별", example = "01(남자)", required = false)
	private String sex;
	@ApiModelProperty(value="비고", example = "비고내용", required = false)
	private String bigo;
	@ApiModelProperty(value="년도", example = "2023", required = false)
	private String year;
	@ApiModelProperty(value="현재학년", example = "3", required = false)
	private String curr_haknyeon;
	@ApiModelProperty(value="현재반", example = "A", required = false)
	private String curr_ban;
	@ApiModelProperty(value="핸드폰", example = "01042483325", required = false)
	private String hp_no;
	@ApiModelProperty(value="봉사시간", example = "30", required = false)
	private String bongsa_sigan;
	@ApiModelProperty(value="등록일자", example = "20220805122521", required = false)
	private String reg_dt;
	@ApiModelProperty(value="등록자", example = "202205013", required = false)
	private String reg_id;
	@ApiModelProperty(value="수정일자", example = "20220805123055", required = false)
	private String upt_dt;
	@ApiModelProperty(value="수정자", example = "202205013", required = false)
	private String upt_id;
	private String crud_gb;
}
