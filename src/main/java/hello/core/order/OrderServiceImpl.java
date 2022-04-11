package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //정적인 의존관계 import 코드만 보고 의존 관계를 확인 할 수 있음 , 앱을 실행하지 않고도 확인 할 수 있다.

    // 동적인 의존관계 앱 실행 시점에 실제 생성된 인스턴스 객체 인스턴스 참조가 연결된 의존 관계

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  -- 추상과 구현체 모두 의존 DIP 위반 소스코드 변경으로 ocp위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // 윗줄 복사 옵션+D

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존 구현체에는 의존 하지 않는다. 누군가가 클라인트인 OrderServiceImpl에 DiscountPolicy 구현 객체를 대신 생성하고 주입해주어야 한다.


    //필드주입 수정을 하려면  setter 필요 -> 수정자 인젝션  :: 사용하지 말자! //테스트 코드에서나 쓰자.
    //@Autowired private  MemberRepository memberRepository;

    /*
    //private  MemberRepository memberRepository;
    //private  DiscountPolicy discountPolicy;

    @Autowired(required = false)   // 수정자 수입 // 선택 변경이 가능한 관계에 사용
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

     */

    @Autowired // 생성자 주입 불변, 필수 의존관계에 생성  !!! 생성자가 1개만 존재하면 @Autowired 생략해도 가능 하다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member, itemPrice);

            return new Order(memberId, itemName , itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
