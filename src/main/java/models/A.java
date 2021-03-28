package models;

import java.util.ArrayList;
import java.util.List;

public class A extends Parent {

    private int number;

    public String[] testArray = new String[]{"Potato", "Tomato", "Cucumber", "Pepper", "Carrots", "Garlic", "Cabbage"};
    public List<String> testList = new ArrayList<>();

    public List<String> move() {
        log.info("Присваиваем значения масива списку ArrayList<>");
        int i = 0;
        while (i <= 4) {
            testList.add(testArray[i]);
            i++;
        }
        return testList;
    }

    public A() {
        log.info("Новый пустой экземпляр класса <models.A>");
    }

    public A(String name, int number) {
        super(name);
        this.name = name;
        this.number = number;
    }

}
