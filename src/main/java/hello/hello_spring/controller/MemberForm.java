package hello.hello_spring.controller;

public class MemberForm {

    private String name; //createMembers.html의 name과 매칭

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
