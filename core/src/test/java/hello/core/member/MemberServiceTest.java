package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given(주어졌을 때)
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when (이걸로 이런 실행을 했을 때)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then(그에 대한 결과가?)
        Assertions.assertThat(member).isEqualTo(findMember);
//        member에 들어간 객체가 findMember와 동일할 경우 Tests passed가 뜹니다.
    }
}
