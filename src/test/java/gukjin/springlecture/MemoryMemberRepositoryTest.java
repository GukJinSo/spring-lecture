package gukjin.springlecture;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gukjin.springlecture.domain.Member;
import gukjin.springlecture.repo.MemoryMemberRepository;

class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository memberRepo = new MemoryMemberRepository();
	
	@BeforeEach
	private void beforeEach() {
		memberRepo.clear();
	}
	
	
	@Test
	public void save() {
		Member member = new Member();
		member.setId(0);
		member.setName("guckjin");
		memberRepo.save(member);
		
		Member result = memberRepo.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		
		Member member1 = new Member();
		Member member2 = new Member();
		member1.setName("guckjin");
		member2.setName("danmi");
		
		memberRepo.save(member1);
		memberRepo.save(member2);
		
		Member result = memberRepo.findByName(member1.getName()).get();
		assertThat(result).isEqualTo(member1);
		
	}
	
	@Test
	public void findAll() {
	
		Member member1 = new Member();
		member1.setName("guckjin");
		Member member2 = new Member();
		member2.setName("danmi");
		
		memberRepo.save(member1);
		memberRepo.save(member2);
			
		List<Member> result = memberRepo.findAll();
		assertThat(result.size()).isEqualTo(2);
	}

}
