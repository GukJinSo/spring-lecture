package gukjin.springlecture.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gukjin.springlecture.domain.Member;
import gukjin.springlecture.repo.MemoryMemberRepository;

class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepo;
	
	@BeforeEach
	void beforeEach() {
		memberRepo = new MemoryMemberRepository();
		memberService = new MemberService(memberRepo);
	}
	
	@AfterEach
	void afterEach() {
		memberRepo.clear();
	}
	
	@Test
	void testJoin() {
		Member member = new Member();
		member.setName("spring");
		memberService.join(member);
	}
	
	@Test
	void testJoinErrorExpect() {
		Member member = new Member();
		member.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");
		memberService.join(member);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
	}

	@Test
	void testFindMembers() {
		//전체회원조회
	}

	@Test
	void testFindByOne() {
		//회원조회
	}

}
