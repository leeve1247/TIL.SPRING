package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//Spring의 스캔을 위한 annotation
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //구현 객체는 appconfig 를 통해 생성한다.
    //생성자가 딱 하나일 때는 Autowired를 사용하지 않아도 빈등록이 수행된다.
    @Autowired // <- 빼도 된다는 말입니다.
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy  DiscountPolicy discountPolicy) {
        System.out.println("memberRepository" + memberRepository);
        System.out.println("discountPolicy" + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
