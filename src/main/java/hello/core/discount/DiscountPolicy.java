package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return  정액할인
     **/

    int discount (Member member , int price);

}
