package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

// 클래스 레벨에서 테스트 가능
// 메소드 단위로 테스트 가능
// 단위 테스트가 하나 끝나면 리포지토리를 깔끔하게 지워줘야함 -> 그래야 정확한 테스트가 가능
// 테스트는 의존관계 없이 설계되어야함
class MemoryRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 메서드가 끝나고 실행되는 콜백메소드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
        System.out.println("clearStore");
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

        // 만약에 다르면 오류를 띄움
        // 성공하면 아무 메세지도 안뜨고 빌드 성공
        assertEquals(member, result);

        // Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        System.out.println("result = " + result.getName());
        System.out.println("member1 = " + member1.getName());
        System.out.println("result = " + (result == member1));
        assertEquals(member1, result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        System.out.println("result = " + result.size());
        assertEquals(2, result.size());
    }
}
