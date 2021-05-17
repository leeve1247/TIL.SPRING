package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 스프링 컨테이너 객체를 생성하고, 해당 객체에서 AppConfig의 구현체를 불러와서 사용할 준비를 합니다.
        // ApplicationContext -> 스프링 컨테이너이며, 인터페이스이다.
        // AnnotationConfigApplicationContext -> Annotaion 기반(자바 설정)의 인터페이스에 연결된 구현체이다.
        // AppConfig.class -> 구현체 내부의 매개변수이다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // appConfig.memberService로 불러오는게 아니고 위에것 처럼 불러오게 됨


        Member member = new Member(1L, "memberA", Grade.VIP);
//        ctrl + alt + v 하면 좌측 변수명 선언이 알아서 됩니다.
//        1L 인 이유는 long type이라, 그냥 1 넣으면 wrongtype error 발생
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
