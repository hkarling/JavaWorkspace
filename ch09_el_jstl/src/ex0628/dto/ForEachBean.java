package ex0628.dto;

import java.util.List;
import java.util.ArrayList;

public class ForEachBean {

    private String menus[] = {"짜장", "짬뽕", "탕수육", "짬짜면", "팔보채"};
    private List<String> fruitList = new ArrayList<>();

    private List<Member> memberList = new ArrayList<>();

    public ForEachBean() {
        fruitList.add("사과");
        fruitList.add("배");
        fruitList.add("오렌지");
        fruitList.add("자두");
        fruitList.add("참외");
        fruitList.add("수박");
        fruitList.add("딸기");
        fruitList.add("바나나");
        fruitList.add("포도");
        fruitList.add("체리");
        fruitList.add("감");

        memberList.add(new Member("AAA", "가가가", 20, "서울"));
        memberList.add(new Member("BBB", "나나나", 30, "대전"));
        memberList.add(new Member("CCC", "다다다", 40, "대구"));
        memberList.add(new Member("DDD", "라라라", 50, "부산"));
        memberList.add(new Member("EEE", "마마마", 60, "광주"));
        memberList.add(new Member("FFF", "바바바", 70, "울산"));
    }

    public String[] getMenus() {
        return menus;
    }

    public List<String> getFruitList() {
        return fruitList;
    }

    public List<Member> getMemberList() {
        return memberList;
    }
}
