package com.bitacademy.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.repository.UserDaoImpl;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.FileUploadService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CateVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping(value="/{id}", method=RequestMethod.GET)
public class BlogController {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	BlogService blogServiceImpl;
	@Autowired
	CategoryService categoryServiceImpl;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	PostService postServiceImpl;
	@Autowired
	UserService	userServiceImpl;
	
	@RequestMapping({"", "/"})
	public String blogmain(Model model, HttpSession session,
			@PathVariable String id) {
		UserVo user = userServiceImpl.getUser(id);
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogServiceImpl.getContent(user.getUserNo());
		PostVo latePostVo = postServiceImpl.getLateContent(user.getUserNo());
		List<CateVo> list = categoryServiceImpl.getList(user.getUserNo());
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("latePostVo", latePostVo);
		model.addAttribute("urlImage", vo.getLogoFile());
		System.out.println("----------");
		System.out.println(latePostVo);
		return "/blog/blogmain";
	}	
	
	// 기본설정
	@RequestMapping("/admin/basic")
	public String basic(Model model, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		BlogVo vo = blogServiceImpl.getContent(authUser.getUserNo());
		model.addAttribute("vo", vo);

		return "/blog/admin/basic";
	}
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String basic(@RequestParam("newImage") MultipartFile newImage,
			@RequestParam("blogTitle") String blogTitle,
			@ModelAttribute BlogVo updatedVo,
			Model model) {		
		String saveFilename = fileUploadService.store(newImage);
		String urlImage = "upload-images/" + saveFilename;
		
		BlogVo vo = blogServiceImpl.getContent(updatedVo.getUserNo());
		vo.setBlogTitle(blogTitle);
		vo.setLogoFile(urlImage);
		
		boolean success = blogServiceImpl.update(vo);
		logger.debug("게시물 업데이트:" + success);
		
		model.addAttribute("urlImage", urlImage);
		model.addAttribute("vo", vo);
		return "redirect:/{id}";
	}
	
		
	// 카테고리
	@RequestMapping("/admin/category")
	public String category(HttpSession session, Model model) {
		// 카테고리 목록 받아오기
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogServiceImpl.getContent(authUser.getUserNo());
		List<CateVo> list = categoryServiceImpl.getList(authUser.getUserNo());
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		return "/category/category";
	}
	
	// 카테고리 삽입
	@RequestMapping(value="/admin/category/write",
			method=RequestMethod.POST)
	public String categoryWrite(@ModelAttribute CateVo vo,
			HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		vo.setUserNo(authUser.getUserNo());

		boolean success = categoryServiceImpl.writeCategory(vo);
		logger.debug("write Result:" + success);
		return "redirect:/{id}/admin/category";
	}	
	
	// 카테고리 삭제
	@RequestMapping(value="/admin/category/delete/{cateNo}",
			method=RequestMethod.GET)
	public String categoryDelete(@PathVariable Long cateNo,
			Model model) {
		boolean success = categoryServiceImpl.deleteCategory(cateNo);
		logger.debug("Delete Result:" + success);
		return "redirect:/{id}/admin/category";
	}
	
	// 글 작성
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String write(HttpSession session, Model model) {
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		List<CateVo> list = categoryServiceImpl.getList(authUser.getUserNo());
		BlogVo vo = blogServiceImpl.getContent(authUser.getUserNo());
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);	
		
		return "/post/write";
	}
	
	@RequestMapping(value="/admin/writeForm", method=RequestMethod.POST)
	public String writeForm(@ModelAttribute PostVo postVo,
			@RequestParam("cateList") Long cateNo,
			HttpSession session,
			Model model) {		
		postVo.setCateNo(cateNo);
		boolean success = postServiceImpl.insert(postVo);
		
		UserVo user = (UserVo)session.getAttribute("authUser");
		System.out.println("------------");
		System.out.println(user);
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogServiceImpl.getContent(user.getUserNo());
		PostVo latePostVo = postServiceImpl.getLateContent(user.getUserNo());
		List<CateVo> list = categoryServiceImpl.getList(user.getUserNo());
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("latePostVo", latePostVo);
		model.addAttribute("urlImage", vo.getLogoFile());
		System.out.println("----------");
		System.out.println(latePostVo);
		return "blog/blogmain";
	}
	
	@RequestMapping(value="post/{cateNo}", method=RequestMethod.GET)
	public String postList(Model model,
			HttpSession session,
			@PathVariable Long cateNo,
			@PathVariable String id) {

//		UserVo authUser = (UserVo)session.getAttribute("authUser");
		UserVo user = userServiceImpl.getUser(id);
		BlogVo blogVo = blogServiceImpl.getContent(user.getUserNo());
		List<CateVo> list = categoryServiceImpl.getList(user.getUserNo());
		List<PostVo> postList = postServiceImpl.getList(cateNo);
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);
		model.addAttribute("vo", blogVo);
		model.addAttribute("urlImage", blogVo.getLogoFile());
		
		return "blog/blogmain";
	}
	
	@RequestMapping(value="post/{cateNo}/{postNo}", method=RequestMethod.GET)
	public String postContent(Model model,
			HttpSession session,
			@PathVariable Long cateNo,
			@PathVariable Long postNo,
			@PathVariable String id) {

//		UserVo authUser = (UserVo)session.getAttribute("authUser");
		UserVo user = userServiceImpl.getUser(id);
		BlogVo vo = blogServiceImpl.getContent(user.getUserNo());
		PostVo getPostVo = postServiceImpl.getContent(postNo);
		List<CateVo> list = categoryServiceImpl.getList(user.getUserNo());
		List<PostVo> postList = postServiceImpl.getList(cateNo);
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("postList", postList);
		model.addAttribute("vo", vo);
		model.addAttribute("urlImage", vo.getLogoFile());
		model.addAttribute("getPostVo", getPostVo);
		
		return "blog/blogmain";
	}
	
}
