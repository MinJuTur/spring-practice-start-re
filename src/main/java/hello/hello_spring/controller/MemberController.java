package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberSerive;

    @Autowired
    public MemberController(MemberService memberSerive) {
        this.memberSerive = memberSerive;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; //createMemberForm.html 호출
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberSerive.join(member);
        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model) {
        List<Member> members = memberSerive.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
