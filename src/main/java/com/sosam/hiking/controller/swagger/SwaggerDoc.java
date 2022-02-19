package com.sosam.hiking.controller.swagger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/sg/api")
public class SwaggerDoc {  
 
    @ApiOperation(value = "산 목록 검색", notes = "산 이름을 통한 산 목록 검색")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
            @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
    })
    @GetMapping("/mountains")
    public List<Map<String, String>> selectOneEmployee(@ApiParam(value = "산 이름") 
    											 @RequestParam String mName) {
    	List<Map<String,String>> map = new ArrayList<>();
        Map<String, String> result = new HashMap<>(); 
        result.put("사번", "1");
        result.put("사원명", "유재석");
        result.put("사원정보", "유재석 사원입니다.");
        map.add(result);
        return map; //JSON 포멧으로 응답
    }
    
    
    /* @RequestBody
     * - 요청시에 json 포멧으로 parameter 전송될 경우 처리하는 애노테이션
     * - swagger doc 개발시에는 생략 금지
     * - DTO 클래스의 각 변수 상단에 선언한 @ApiModelProperty(example=테스트데이터)
    
    @ApiOperation(value = "사원 정보 저장", notes = "API 설명 부분 : 사원 한명 저장 또는 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생, Not Found !")
    })
    @PostMapping("/employee")
    public String addOneEmployee(@RequestBody Employee emp, @ApiIgnore HttpSession session) {
    	return "한명의 사원 저장 성공";
    }
     */
}