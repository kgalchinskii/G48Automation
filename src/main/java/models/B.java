package models;

import java.util.Collections;
import java.util.List;

public class B extends Parent {

    private int number;

    public void sortList(List<String> list) {
        log.info("Сортируем список ArrayList<>");
        Collections.sort(list);
        for (String i : list) {
            log.debug(i);
        }
    }

    public B() {
        log.info("Новый пустой экземпляр класса <models.B>");
    }

    public B(String name, int number) {
        super(name);
        this.name = name;
        this.number = number;
    }

}