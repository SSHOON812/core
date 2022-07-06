package hello.core.scope;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletoneBeanFind(){
       AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

       SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
       SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        assertThat(singletonBean1).isSameAs(singletonBean2);




        ac.close();

    }

    @Scope("Singletone")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletoneBean.destroy");
        }

    }

}
