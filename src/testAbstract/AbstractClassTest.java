package testAbstract;

/**
 * Created by liuchong on 2017/5/9.
 */
abstract class Parent {

  public Parent() {
    print();
  }

  abstract void print();
}


class A extends Parent {

  int i = 1;

  public A() {
    System.out.println("A() " + i);
  }

  @Override
  void print() {
    System.out.println("print() " + i);
  }
}


public class AbstractClassTest {

  public static void main(String[] args) {
    A a = new A();
    a.print();
  }
}