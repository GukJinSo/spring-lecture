package gukjin.springlecture.service;

import java.util.List;
import java.util.Optional;

import gukjin.springlecture.domain.Member;
import gukjin.springlecture.repo.MemberRepository;

public class MemberService {
	
	private final MemberRepository memberRepo;
	
	public MemberService (MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}
	
	public long join(Member member) {
		validateDuplicateMember(member);
		memberRepo.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepo.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다");
		});
	}
	
	public List<Member> findMembers(){
		return memberRepo.findAll();
	}
	
	public Optional<Member> findByOne(Long memberId){
		return memberRepo.findById(memberId);
	}
	

}
