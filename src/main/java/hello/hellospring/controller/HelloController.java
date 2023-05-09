package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 응답부 바디에 데이터를 담아서 보내겠다, view 없이 문자열 그대로 리턴
    public String helloString(@RequestParam(value = "name", required = true) String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 기본 반환은 json 형태
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json 형태로 객체 반환
        // json : key, value 로 이루어진 문자열

        // 과거에는 xml이 많이 사용됨 -> 되게 무겁고, 귀찮음
        // json은 단순하면서 간편해서 최근에는 json을 많이 사용함
    }

    static class Hello {
        private String name;

        // getter, setter
        // 프로퍼티 접근 방식
        // java bean 표준 규격

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
