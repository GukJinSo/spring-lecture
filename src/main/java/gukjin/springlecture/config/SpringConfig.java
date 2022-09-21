package gukjin.springlecture.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import gukjin.springlecture.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gukjin.springlecture.service.MemberService;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//	private EntityManager em;
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}

	// private final DataSource dataSource;
	
	/* @Autowired public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	} */

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
	//@Bean
	//public MemberRepository memberRepository() {
		// return new JpaMemberRepository(em);
		// return new JdbcTemplateMemberRepository(dataSource);
		// return new JdbcMemberRepository(dataSource);
		// return new MemoryMemberRepository();
	//}
	
}
