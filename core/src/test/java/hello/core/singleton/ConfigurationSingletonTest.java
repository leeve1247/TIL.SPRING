package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository =" + memberRepository1);
        System.out.println("orderService -> memberRepository =" + memberRepository2);
        System.out.println("memberRepository" + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean class type = " + bean.getClass());
        //예상 : bean class = class hello.core.AppConfig
        //결과 : bean class type = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$address
        //순수한 클래스가 아니라 다른게 붙었다? 어떻게 된걸까
        //스프링은 내가 만든 클래스를 CGLIB이라는 바이트코드 조작 라이브러리를 사용해서 다른 클래스를 만들고,
        //그 다른 클래스를 대안 클래스로서 등록함
        //이 대안 클래스가 싱글톤을 보장함(어떻게 생성하고 구성하는지는 매우 복잡함)
        
        //AppConfig$$EnhancerBySpringCGLIB 은 AppConfig의 자식클래스라서 AppConfig로 조회가 가능함
    }
}

