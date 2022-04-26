package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){


        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
       // ac.getBean()
    }

    static class TestBean{

        @Autowired(required = false) // 기본 값이 true  // 메서드 자체가 호출이 안됨
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired // 호출은 되나, 널로 들어옴
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired // 자바8에서 제공하는 문법
        public void setNoBean(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    //        @Nullable , Optional 은 스프링 전반에 걸쳐서 지원 된다. 예를 등러 생성자 자동주입에서 특정 필드에만  사용 해도 된다.

    }


}
