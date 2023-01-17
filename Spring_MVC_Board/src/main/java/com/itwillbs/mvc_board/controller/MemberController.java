package com.itwillbs.mvc_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwillbs.mvc_board.service.MemberService;
import com.itwillbs.mvc_board.vo.MemberVO;

@Controller
public class MemberController {
		//컨트롤러 클래스가 서비스에 의존적일 때
		//Service 객체를 직접 생성하지 않고, 자동 주입 기능을 위한 어노테이션 사용 가능
		//@Inject (자바-플랫폼공용) 또는 @Authwired(스프링 전용) 어노테이션 사용
		//->
	@Autowired
	private MemberService service;
	
	// "/MemberJoinForm.me" 요청에 대해 member/member_join_form.jsp 페이지 포워딩 
	//-> Dispatch 방식 포워딩
	
	@GetMapping(value = "/MemberJoinForm.me")
	public String join() {
		
		return "member/member_join_form";
	}
	
	@PostMapping(value = "/MemberJoinPro.me")
	public String joinPro(@ModelAttribute MemberVO member,Model model) {
		
		//--BCryptPasswordEncoder객체 활용한 해싱--
		//입력받은 패스워드는 암호화(해싱) 필요 -> 해싱 후 MemberVO 객체 패스워드에 덮어쓰기 
		//-> Spring에서 암호화는 BCryptPasswordEncoder 객체 사용 (spring-security-web라이브러리)
		// 동일한 평문(원본 암호)이라도 매번 다른 결과값을 갖는 해싱이 가능하다!
		//BCryptPasswordEncoder 객체생성
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//2.BCryptPasswordEncoder 객체의 encoder() 메서드를 호출하여 해싱 결과 리턴
		//-> 파라미터: 평문암호 리턴타입 :String (해싱된 암호문)
		String securePasswd = passwordEncoder.encode(member.getPasswd());
//		System.out.println("평문 : "+ member.getPasswd());
//		System.out.println("평문 : "+ member.getPasswd());
		member.setPasswd(securePasswd);
		//------------------------------------
		//MemberService 객체의 joinMember() 메서드 호출
		// 파라미터 : MemberVO 객체 리턴타입 : int(insertCount)
//		MemberService service = new MemberService(); 
		//-> 인스턴스를 직접생성하여 사용해도 되지만 
		//@Auto
		int insertCount = service.joinmember(member);
		if(insertCount>0) {
			
			return "redirect:/";
		}else {
			//오류 메시지 출력 및 이전페이지로 돌아가는 기능을 공통으로 수행할 
			//fail.back.jsp 페이지로 포워딩
			//출력할 메세지를 해당 페이지로 전달
			//Model 객체를 통해 msg 속성명으로 가입실패 메세지 전달
			model.addAttribute("msg","가입실패");
			return "fail_back";
		}
	}
	
	@GetMapping(value = "/MemberLoginForm.me")
	public String login() {
		return "member/member_login_form";
	}
}
