package hello.core.member;

public interface MemberRepository {
//    멤버 저장하기
    void save(Member member);

    Member findById(Long memberId);
}
