package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTaskOn1PositiveCase() {

        SimpleTask simpleTask = new SimpleTask(1408, "Покушать картошку");
        Meeting meeting = new Meeting(777, "Сделать домашку", "Тестировщик ПО", "после дождичка в четверг");
        String[] epicArray = {"Погулять", "Выпить кофе", "Почитать книгу"};
        Epic epic = new Epic(2605, epicArray);

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] actual = todos.search("Выпить кофе");
        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTaskOn2PositiveCase() {

        SimpleTask simpleTask = new SimpleTask(1408, "Сделать домашку");
        Meeting meeting = new Meeting(777, "Сделать домашку", "Тестировщик ПО", "после дождичка в четверг");
        String[] epicArray = {"Погулять", "Выпить кофе", "Почитать книгу"};
        Epic epic = new Epic(2605, epicArray);

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] actual = todos.search("Сделать домашку");
        Task[] expected = {simpleTask, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTaskOnNegativeCase() {

        SimpleTask simpleTask = new SimpleTask(1408, "Сделать зарядку");
        Meeting meeting = new Meeting(777, "Посмотреть вебинер", "Тестировщик ПО", "через час");
        String[] epicArray = {"Пробежаться", "Выпить чай", "Послушать музыку"};
        Epic epic = new Epic(2605, epicArray);

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] actual = todos.search("Поспать");
        Task[] expected = new Task[0];

        Assertions.assertArrayEquals(expected, actual);
    }
}
