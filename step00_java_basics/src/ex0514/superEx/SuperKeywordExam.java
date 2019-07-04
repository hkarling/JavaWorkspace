package ex0514.superEx;

class Super {
    int a = 10;
    int b = 5;

    public void aa() {
        System.out.println("Super의 aa()호출됨");
    }

    public void bb() {
        System.out.println("Super의 bb()호출됨");
    }
}

///////////////////////////////////////////////////////
class Sub extends Super {
    int a = 7;
    int c = 20;

    @Override
    public void aa() {
        System.out.println("Sub의 aa()호출됨");
    }

    public void cc() {
        System.out.println("Sub의 cc()호출됨");
    }

    public void test() {
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
        System.out.println("--------------------------");
        System.out.println(b);
        System.out.println(this.b);
        System.out.println(super.b);
        System.out.println("--------------------------");
        System.out.println(c);
        System.out.println(this.c);
        // System.out.println(super.c); // 자식에게만 있는 필드. super로 접근불가.
        System.out.println("--------- 메소드 호출해보자 ---------");
        aa();
        this.aa();
        super.aa();
        System.out.println("--------------------------");
        bb();
        this.bb();
        super.bb();
        System.out.println("--------------------------");
        cc();
        this.cc();
        // super.cc(); // 자식에게만 있는 메소드. super로 접근불가.
        System.out.println("--------------------------");
    }
}

///////////////////////////////////////////////////////
public class SuperKeywordExam {
    public static void main(String[] args) {
        // new Sub().test();

        Sub sub = new Sub();
        System.out.println(sub.a); // 7
        System.out.println(sub.b); // 5
        System.out.println(sub.c); // 20
        System.out.println("-------------------------------");
        sub.aa();
        sub.bb();
        sub.cc();
        System.out.println("-------------------------------");
        Super superSub = new Sub(); // 다형성
        System.out.println(superSub.a); // 10
        System.out.println(superSub.b); // 5
        // System.out.println(superSub.c); // 부모타입은 자식부분 접근불가
        System.out.println("-------------------------------");
        superSub.aa(); // 재정의된 메소드는 부모타입이더라도 자식부분 호출.
        superSub.bb();
        // superSub.cc(); // 자식부분 접근불가
        System.out.println("-------------------------------");

        // 부모타입 변수가 접군되지 않는 자식부분에 접근하기 위해서 ObjectDownCasting이 필요하다.
        if (superSub instanceof Sub) { // ClassCastException 발생을 방지한다.
            Sub sub2 = (Sub) superSub;
            System.out.println("superSub = " + superSub);
            System.out.println("sub2 =     " + sub2);

            System.out.println(sub2.c);
            sub2.cc();
        }
    }
}