package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component

public class MemberServiceImpl implements MemberService {
    // 의존 관계에 대한 고민은 외부에 맞기고 실행에만 집중하면 된다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


    @Autowired  // 의존관계 주입  ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 생성자로 객체주입
    }


    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



    // 테스트 용도
       public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
