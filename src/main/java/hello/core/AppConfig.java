package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    // 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.
    // 구성 담당 사용역역 (인터페이스 , 구현체)은 변경 x 역활과 구현을 명확하게 분리 , 중복제거 , 역할이 잘 들어남


    // 객체를 생성하고 관리하면서 의존관계를 연결 해 주는 것을 DI , IOC 컨테이너 

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),  discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
