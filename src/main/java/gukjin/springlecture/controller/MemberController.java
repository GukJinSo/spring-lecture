package gukjin.springlecture.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import gukjin.springlecture.domain.Member;
import gukjin.springlecture.domain.MemberForm;
import gukjin.springlecture.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("member/new")
	private String memberForm() {
		return "member/memberForm";
	}
	
	@PostMapping("member/new")
	private String create(MemberForm form) {
		Member member = new Member();
		memberService.join(member);
		return "";  
	}
	
	@GetMapping("member/memberList")
	private String memberList(Model model) {
		
		//List<Member> members = memberService.
		//model.addAttribute("members", member)
		return "member/memberList";
	}

}
