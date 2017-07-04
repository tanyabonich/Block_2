package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Таня on 29.06.2017.
 */
public class ListDemoTest {
    //1
    @Test
    public void testSameFirstSymbol1() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("elephant");
        list.add("dog");
        list.add("cow");
        assertEquals(2, ListDemo.sameFirstSymbol(list, 'c'));

    }

    //1
    @Test
    public void testSameFirstSymbol2() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("elephant");
        list.add("dog");
        list.add("cow");
        assertEquals(0, ListDemo.sameFirstSymbol(list, 'a'));

    }

    //1
    @Test (expected = NullPointerException.class)
    public void testSameFirstSymbol3() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        list.add("elephant");
        list.add("dog");
        list.add("cow");
        assertEquals(0, ListDemo.sameFirstSymbol(list, 'a'));
        fail();
    }

    //2
    @Test
    public void testSameSecondName1() throws Exception {
        Human specialPerson = new Human("", "special", "", 1);

        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("1", "special", "sth", 1));
        people.add(new Human("2", "not_special", "sth", 1));
        people.add(new Human("3", "not_special", "sth", 1));
        people.add(new Human("4", "special", "sth", 1));
        people.add(new Human("5", "not_special", "sth", 1));
        people.add(new Human("6", "special", "sth", 1));

        ArrayList<Human> specialPeople = new ArrayList<>();
        specialPeople.add(new Human("1", "special", "sth", 1));
        specialPeople.add(new Human("4", "special", "sth", 1));
        specialPeople.add(new Human("6", "special", "sth", 1));

        assertEquals(specialPeople, ListDemo.sameSecondName(people, specialPerson));

    }

    //2
    @Test
    public void testSameSecondName2() throws Exception {
        Human specialPerson = new Human("", "special", "", 1);

        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("1", "not_special", "sth", 1));
        people.add(new Human("2", "not_special", "sth", 1));
        people.add(new Human("3", "not_special", "sth", 1));
        people.add(new Human("4", "not_special", "sth", 1));
        people.add(new Human("5", "not_special", "sth", 1));
        people.add(new Human("6", "not_special", "sth", 1));
        ArrayList<Human> specialPeople = new ArrayList<>();
        assertEquals(specialPeople, ListDemo.sameSecondName(people, specialPerson));
    }

    //3
    @Test
    public void testWithoutPerson1() throws Exception {
        Human specialPerson = new Human("1", "special", "", 1);

        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("1", "special", "", 1));
        people.add(new Human("2", "not_special", "", 1));
        people.add(new Human("3", "not_special", "", 1));
        people.add(new Human("1", "special", "", 1));
        people.add(new Human("5", "not_special", "", 1));
        people.add(new Human("1", "special", "", 1));

        ArrayList<Human> result = new ArrayList<>();
        result.add(new Human("2", "not_special", "", 1));
        result.add(new Human("3", "not_special", "", 1));
        result.add(new Human("5", "not_special", "", 1));

        assertEquals(result, ListDemo.withoutPerson(people, specialPerson));

    }

    //3
    public void testWithoutPerson2() throws Exception {
        Human specialPerson = new Human("", "special", "", 1);

        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("1", "not_special", "", 1));
        people.add(new Human("2", "not_special", "", 1));
        people.add(new Human("3", "not_special", "", 1));
        people.add(new Human("4", "not_special", "", 1));
        people.add(new Human("5", "not_special", "", 1));
        people.add(new Human("6", "not_special", "", 1));

        ArrayList<Human> result = new ArrayList<>();
        result.add(new Human("1", "not_special", "", 1));
        result.add(new Human("2", "not_special", "", 1));
        result.add(new Human("3", "not_special", "", 1));
        result.add(new Human("4", "not_special", "", 1));
        result.add(new Human("5", "not_special", "", 1));
        result.add(new Human("6", "not_special", "", 1));

        assertEquals(result, ListDemo.withoutPerson(people, specialPerson));
    }

    //4
    @Test
    public void testDoNotIntersect1() throws Exception {
        HashSet<Integer> special = new HashSet<>();
        special.add(1);
        special.add(4);
        special.add(8);
        ArrayList<Set<Integer>> result = new ArrayList<>(3);
        ArrayList<Set<Integer>> list = new ArrayList<>(3);
        HashSet<Integer> tmp1 = new HashSet<>();
        tmp1.add(1);
        tmp1.add(2);
        tmp1.add(3);
        list.add(new HashSet<>(tmp1));
        HashSet<Integer> tmp2 = new HashSet<>();
        tmp2.add(2);
        tmp2.add(3);
        tmp2.add(8);
        list.add(new HashSet<>(tmp2));
        HashSet<Integer> tmp3 = new HashSet<>();
        tmp3.add(2);
        tmp3.add(4);
        tmp3.add(1);
        list.add(new HashSet<>(tmp3));
        assertEquals(result, ListDemo.doNotIntersect(list, special));

    }

    //4
    @Test
    public void testDoNotIntersect2() throws Exception {
        HashSet<Integer> special = new HashSet<>();
        special.add(1);
        special.add(2);
        special.add(3);
        ArrayList<Set<Integer>> result = new ArrayList<>(3);
        ArrayList<Set<Integer>> list = new ArrayList<>(3);
        HashSet<Integer> tmp1 = new HashSet<>();
        tmp1.add(1);
        tmp1.add(2);
        tmp1.add(3);
        list.add(new HashSet<>(tmp1));
        HashSet<Integer> tmp2 = new HashSet<>();
        tmp2.add(2);
        tmp2.add(3);
        tmp2.add(4);
        list.add(new HashSet<>(tmp2));
        HashSet<Integer> tmp3 = new HashSet<>();
        tmp3.add(3);
        tmp3.add(4);
        tmp3.add(5);
        list.add(new HashSet<>(tmp3));
        HashSet<Integer> tmp4 = new HashSet<>();
        tmp4.add(4);
        tmp4.add(5);
        tmp4.add(6);
        list.add(new HashSet<>(tmp4));
        HashSet<Integer> tmp5 = new HashSet<>();
        tmp5.add(4);
        tmp5.add(5);
        tmp5.add(6);
        result.add(new HashSet<>(tmp5));
        assertEquals(result, ListDemo.doNotIntersect(list, special));

    }

    //5
    @Test
    public void testPeopleWithMaxAge() {
        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("1", "", "", 9));
        people.add(new Student("2", "", "", 25, "k"));
        people.add(new Human("3", "", "", 26));
        people.add(new Human("4", "", "", 11));
        people.add(new Student("5", "", "", 26, "l"));
        people.add(new Human("6", "", "", 19));

        HashSet<Human> result = new HashSet<>();
        result.add(new Human("3", "", "", 26));
        result.add(new Student("5", "", "", 26, "l"));

        assertEquals(result, ListDemo.getPeopleWithMaxAge(people));
    }

    //6
    @Test
    public void testOrdered() {
        HashSet<Human> people = new HashSet<>();
        people.add(new Human("1", "", "", 9));
        people.add(new Human("4", "", "", 11));
        people.add(new Student("5", "", "", 26, "l"));
        people.add(new Student("2", "", "", 25, "k"));
        people.add(new Human("3", "", "", 26));
        people.add(new Human("6", "", "", 19));

        ArrayList<Human> expected = new ArrayList<>();
        expected.add(new Human("1", "", "", 9));
        expected.add(new Student("2", "", "", 25, "k"));
        expected.add(new Human("3", "", "", 26));
        expected.add(new Human("4", "", "", 11));
        expected.add(new Student("5", "", "", 26, "l"));
        expected.add(new Human("6", "", "", 19));

        assertEquals(expected, ListDemo.buildSortedList(people));
    }


    //7
    @Test
    public void testHumanFromMap() throws Exception {
        HashMap<Integer, Human> indexation = new HashMap<>();
        indexation.put(1, new Human("1", "", "", 9));
        indexation.put(2, new Human("2", "", "", 25));
        indexation.put(3, new Human("3", "", "", 26));
        indexation.put(4, new Human("4", "", "", 11));
        indexation.put(5, new Human("5", "", "", 26));
        indexation.put(6, new Human("6", "", "", 19));

        HashSet<Integer> indexes = new HashSet<>();
        indexes.add(3);
        indexes.add(6);

        HashSet<Human> result = new HashSet<>();
        result.add(new Human("3", "", "", 26));
        result.add(new Human("6", "", "", 19));

        assertEquals(result, ListDemo.humanFromMap(indexation, indexes));

    }

    //8
    @Test
    public void humanOlder18() throws Exception {
        HashMap<Integer, Human> indexation = new HashMap<>();
        indexation.put(1, new Human("1", "", "", 9));
        indexation.put(2, new Human("2", "", "", 25));
        indexation.put(3, new Human("3", "", "", 26));
        indexation.put(4, new Human("4", "", "", 11));
        indexation.put(5, new Human("5", "", "", 26));
        indexation.put(6, new Human("6", "", "", 19));

        ArrayList<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(3);
        result.add(5);
        result.add(6);

        assertEquals(result, ListDemo.humanOlder18(indexation));
    }

}