package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Таня on 29.06.2017.
 */
public class ReflectionDemoTest {
    //11
    @Test
    public void testCountOfExtendsHuman1() throws Exception {
        List emptyList = new ArrayList();
        assertEquals(0, ReflectionDemo.countOfExtendsHuman(emptyList));
    }

    //11
    @Test
    public void testCountOfExtendsHuman2() throws Exception {
        ArrayList<Object> list = new ArrayList<>(5);
        list.add(2);
        list.add("2");
        list.add(119L);
        list.add(new Human("2", "1", "1", 21));

        assertEquals(1, ReflectionDemo.countOfExtendsHuman(list));
    }

    //12
    @Test
    public void testGetNamesPublicMethods() throws Exception {
        HashSet<String> names = new HashSet<>(11);
        names.add("getName");
        names.add("getSecondName");
        names.add("getFathersName");
        names.add("getAge");

        names.add("setName");
        names.add("setSecondName");
        names.add("setFathersName");
        names.add("setAge");

        names.add("equals");
        names.add("hashCode");
        names.add("toString");

        names.add("getClass");
        names.add("notify");
        names.add("notifyAll");
        names.add("wait");

        assertEquals(
                names,
                new HashSet<>(ReflectionDemo.getNamesPublicMethods(new Human("", "", "", 0)))
        );
    }

    //13
    @Test
    public void testGetParentsNumbers() {
        ArrayList<String> names = new ArrayList<>(2);
        names.add("Number");
        names.add("Object");
        assertEquals(names, ReflectionDemo.getParents(new Integer(1)));
    }

    //13
    @Test
    public void testGetParentsObject() {
        ArrayList<String> names = new ArrayList<>();


        assertEquals(names, ReflectionDemo.getParents(new Object()));
    }

    //14
    @Test
    public void testNumberOfExecutables() {
        ArrayList<Object> objects = new ArrayList<>(6);
        objects.add((Integer) 1);
        objects.add(null);
        objects.add(new Executable() {
            @Override
            public void execute() { System.out.println("first");}
        });
        objects.add(null);
        objects.add(null);
        objects.add(new Executable() {
            @Override
            public void execute() {}
        });
        assertEquals(2, ReflectionDemo.executeExecutables(objects));
    }

    //15
    @Test
    public void testGetSettersAndGetters() {
        HashSet<String> names = new HashSet<>();
        names.add("getName");
        names.add("getSecondName");
        names.add("getFathersName");
        names.add("getAge");
        names.add("getClass");

        names.add("setName");
        names.add("setSecondName");
        names.add("setFathersName");
        names.add("setAge");

        assertEquals(
                names,
                new HashSet<>(ReflectionDemo.getSettersAndGetters(new Human("", "", "", 0)))
        );
    }

}