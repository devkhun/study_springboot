package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 스프링컨테이너가 controller 어노테이션이 있으면 memberController 객체를 생성

    private final MemberService memberService; // 순수 자바 클래스(어노테이션 없이 선언된 자바클래스) -> 어노테이션 추가로 해결

    @Autowired // 생성자에서 해당 어노테이션을 쓰면 의존성 주입이 됨
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
