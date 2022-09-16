package gukjin.springlecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gukjin.springlecture.repo.MemberRepository;
import gukjin.springlecture.repo.MemoryMemberRepository;
import gukjin.springlecture.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
}
