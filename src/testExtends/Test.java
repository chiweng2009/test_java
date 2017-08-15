/**
 * Created by liuchong on 2017/5/9.
 */
public class Test {
  public static void main(String[] args) {
    B b = new B();
    b.printA();
  }
}

class A {

  public void printA() {
    System.out.println("printA");
    printWord();
  }

  void printWord() {
    System.out.println("printWord of A");
  }


}

class B extends A {

  void printWord() {
    // TODO Auto-generated method stub
    System.out.println("printWord of B");
  }
}
