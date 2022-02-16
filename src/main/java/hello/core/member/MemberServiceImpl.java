package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 의존 관계에 대한 고민은 외부에 맞기고 실행에만 집중하면 된다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


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
}
