package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다") // junit5   부터 지원
    void vid_o(){
        //given
        Member member = new Member(1L, "memberVIP" , Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000); // 옵션+엔터  스태틱에 올려서 사용하는게 좋은
    }


    @Test
    @DisplayName("VIP가 아닌경우 할인 적용되면 안됨")
    void vid_x(){
        //given
        Member member = new Member(1L, "memberVIP" , Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }



}