package hello.servlet.domain.repository;

import hello.servlet.domain.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되지 않고 있다.
 * 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려해야한다.
 */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }

    //저장
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //Id를 통하여 멤버 찾기
    public Member findById(Long id){
        return store.get(id);
    }

    //전체 멤버 조회
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //스토어를 비우기
    public void clearStore(){
        store.clear();
    }
}
