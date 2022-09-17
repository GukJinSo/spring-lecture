package gukjin.springlecture.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gukjin.springlecture.repo.JdbcMemberRepository;
import gukjin.springlecture.repo.MemberRepository;
import gukjin.springlecture.repo.MemoryMemberRepository;
import gukjin.springlecture.service.MemberService;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new JdbcMemberRepository(dataSource);
		// return new MemoryMemberRepository();
	}
	
}
