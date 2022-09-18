package gukjin.springlecture.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import gukjin.springlecture.domain.Member;
import gukjin.springlecture.repo.JdbcMemberRepository;
import gukjin.springlecture.repo.MemberRepository;
import gukjin.springlecture.repo.MemoryMemberRepository;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepo;
	
	@Test
	void testJoin() {
		Member member = new Member();
		member.setName("spring");
		Long saveId = memberService.join(member);
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void testJoinErrorExpect() {
		Member member = new Member();
		member.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");
		memberService.join(member);
		
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다1");			
	}

}
