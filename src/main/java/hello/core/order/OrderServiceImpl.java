package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;



public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  -- 추상과 구현체 모두 의존 DIP 위반 소스코드 변경으로 ocp위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // 윗줄 복사 옵션+D

    private  DiscountPolicy discountPolicy; // 인터페이스에만 의존 구현체에는 의존 하지 않는다. 누군가가 클라인트인 OrderServiceImpl에 DiscountPolicy 구현 객체를 대신 생성하고 주입해주어야 한다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member, itemPrice);

            return new Order(memberId, itemName , itemPrice, discountPrice);

    }
}
