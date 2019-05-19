package superEx;

class Parent {
    public int i = 1923;

    // Parent() {
    // System.out.println(1);
    // }
    Parent(int i) {
        System.out.println(2);
    }

    Parent(String str) {
        System.out.println(3);
    }
}

class Child extends Parent {
    public int i = 999;

    Child() {
        this(5);
        System.out.println(4);
    }

    Child(int i) {
        super(i);
        System.out.println(5);
    }

    Child(boolean b) {
        super("Hello");
        System.out.println(6);
    }
}

public class SuperConstructorExam {

    public static void main(String[] args) {
        // new Child();
        // new Child(50);
        // new Child(true);

        /**
         * 만약 1,2,3이 없다면?
         */
        // new Child();
        // new Child(50);
        // new Child(true);

        /**
         * 만약 1이 없고 2, 3만 있다면.
         */

        Parent p = new Child();
        System.out.println(p.i);
    }
}