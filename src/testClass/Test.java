package testClass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/8/11.
 */
public class Test {

  public static void main(String[] args) {
    List<String> s = new ArrayList<>();
    List<Integer> vm = new ArrayList<>();
    System.out.println(s.getClass());
    System.out.println(s.getClass().getClass());
    System.out.println(s.getClass().getClass() == vm.getClass().getClass());

    vm.add(22);
    try {
      Method method = vm.getClass().getDeclaredMethod("add", Object.class);
      method.invoke(vm, "qqq");
      method.invoke(vm, 222.334f);
    } catch (Exception e) {
      e.printStackTrace();
    }

    for(int i=0; i<vm.size(); i++) {
      System.out.println(vm.get(i));
    }

    for(Integer i : vm) {
      System.out.println(i);
    }
  }
}
