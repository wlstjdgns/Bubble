package test.lom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor//모든 생성자를 만들어주는것
@Getter @Setter
class Dog{
    private String name;
    private int age;
}

public class LomTest {
    public static void main(String[] args) {
        //Dog d = new Dog();//빨간줄 생기는 이유는 생성자가 하나라도 만들어져있으면 안되잖아
        Dog d = new Dog("강아지", 10);
       d.getName(); 
       d.setName("갱얼쥐");
    System.out.println(d.getName());
    }
}
