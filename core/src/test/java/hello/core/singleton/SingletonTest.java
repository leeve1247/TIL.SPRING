package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호툴할 때마다 객체를 생성1
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호툴할 때마다 객체를 생성2
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 달라지는 가?
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //객체가 지속 생성되는 건 좋지 아니합니다.

        //memberService1 != memberService2 입니다.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}

