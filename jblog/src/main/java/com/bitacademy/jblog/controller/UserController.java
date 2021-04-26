package com.bitacademy.jblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.repository.UserDaoImpl;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.UserVo;


@Controller
@RequestMapping("/usr")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogServiceImpl;
	
	// 가입 폼
	@RequestMapping(value= {"", "/", "/join"},
			method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo uservo) {
		return "usr/joinform";
	}
	
	// 가입 처리
	@RequestMapping(value="/join",
			method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid UserVo userVo,
			@ModelAttribute BlogVo blogVo,
			BindingResult result,
			Model model
			) {
		logger.debug("Form 전송된 데이터:" + userVo);
		
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e: errors) {
				logger.error("Valid Error:" + e);
			}
			logger.debug("result:" + result.getModel());
			model.addAllAttributes(result.getModel());
			return "usr/joinform";
		}
		
		boolean success = userService.join(userVo);
		blogVo.setBlogTitle(userVo.getUserName());
		blogVo.setLogoFile("defaultvalue");
		System.out.println(blogVo);
		
		boolean blogSuccess = blogServiceImpl.insert(blogVo);
		
		if(success & blogSuccess) {
			logger.debug("가입 성공");
			return "redirect:/usr/joinsuccess";
		} else {
			logger.error("가입 실패");
			return "redirect:/usr/";
		}
	}
	
	// 성공 화면
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "usr/joinsuccess";
	}
	
	// 중복 이메일 체크
	@RequestMapping("/idcheck")
	@ResponseBody
	public Object existsId(
			@RequestParam(value="id", required=false, defaultValue="") String id) {
		UserVo vo = userService.getUser(id);
		boolean exists = vo != null ? true : false;	// vo 객체가 null -> 이미 존재하는 사용자
		
		// 결과 MAP -> 컨버터 -> JSON 변환 
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
	
	// 로그인 폼 처리
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "usr/loginform";
	}
	
	// 로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(
			@RequestParam String id,
			@RequestParam String password,
			HttpSession session) {	//사용자 세션 저장을 위한 세션 객체
		
		UserVo authUser = userService.getUser(id, password);
		
		// 만약에 찾는 유저가 없으면 login 폼으로 되돌려보냄
		if (authUser != null) {
			// 세션에 추가
			session.setAttribute("authUser", authUser);
			// 홈페이지로 리다이렉트
			return "redirect:/";
		} else {
			// 로그인 실패
			return "redirect:/usr/login";
		}
		
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		// 세션 지우기
		session.removeAttribute("authUser");
		// 세션 무효화
		session.invalidate();
		return "redirect:/";
	}	
	
}
