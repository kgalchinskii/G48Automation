package models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public abstract class Parent {

    protected String name;
    protected final Logger log;

    public Parent(String name) {
        this.log = LogManager.getLogger(name);
        this.name = name;
    }

    public Parent() {
        this.log = LogManager.getLogger(this.getClass().getName());
    }

    public void printName() {
        log.info(this.name + ": Новый экземпляр класса");
    }

    public void splitList(List<String> list) {
        log.info("Вызываем метод splitList");
        try {
            for (String i : list) {
                String[] str = i.split("");
                log.debug(Arrays.toString(str));
            }
        } catch (NullPointerException exNull) {
            log.error("Массив не определён. Пожалуйста проверьте корректность вводимых значений. Ошибка:", exNull);
        } catch (Exception exAll) {
            log.error("Произошла неизвесная ошибка. Подробнее: ", exAll);
        }

    }

}