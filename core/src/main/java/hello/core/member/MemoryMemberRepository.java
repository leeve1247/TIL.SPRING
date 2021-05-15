package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

//    저장해야 하니까 맵이 필요하겠지요
//    실무에서는 동시성 이슈가 발생할 가능성이 있으나 concurrent 는 이 강좌에서는 제외함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId){
        return store.get(memberId);
    }
}
