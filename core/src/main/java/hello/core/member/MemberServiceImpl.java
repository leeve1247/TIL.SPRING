package hello.core.member;

//인터페이스에 대한 구현체가 하나만 있을 경우에는 관례상 Impl 로 표시를 한다.
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
//    commmand shift enter시 세미콜론까지 자동완성 단축키인 거신 데스웅


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
