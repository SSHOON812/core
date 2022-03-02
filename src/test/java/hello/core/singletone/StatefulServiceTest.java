package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingltone(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        //Thread A:  A 사용자 10000원 주문
        int userAPrice = statefulService.order("userA",10000);

        //Thread B: B  사용자 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //Thread A: 사용자 A 주문 금액 조회
      //  int price = statefulService.getPrice();

        System.out.println("price = " + userAPrice);


        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }
    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }



    }


}