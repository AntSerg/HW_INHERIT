package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TasksTest {
    @ParameterizedTest
    @CsvSource({
            "Помыть посуду, Погулять с собакой, false",
            "Сделать домашку, Сделать домашку, true"
    })
    public void MethodMatchesForCLassSimpleTask(String title, String query, boolean expected) {
        SimpleTask simpleTask = new SimpleTask(13, title);
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Наследование, Java для тестировщиков, Наследование, true",
            "Автоматизированное тестирование, Java для разработчиков, Java для разработчиков, true",
            "Система контроля версий GIT, GIT, Абра-кадабра, false"
    })
    public void methodMatchesForCLassMeeting(String topic, String project, String query, boolean expected) {
        Meeting meeting = new Meeting(666, topic, project, "29 февраля в полночь");
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "бутылка кефира, Полбатона, А я сегодня дома, А я сегодня дома, true",
            "Районы, Кварталы, Жилые массивы, Я ухожу красиво, false"
    })
    public void methodMatchesForCLassEpic(String case1, String case2, String case3, String query, boolean expected) {
        String[] epicArray = {case1, case2, case3};
        Epic epic = new Epic(404, epicArray);
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }


}
