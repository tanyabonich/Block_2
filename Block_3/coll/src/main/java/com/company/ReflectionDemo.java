package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Таня on 24.07.2017.
 */
public class ReflectionDemo {
    //11
    public static int countOfExtendsHuman(List<?> list) {
        int count = 0;
        for (Object item : list) {
            if (item instanceof Human) {
                count++;
            }
        }
        return count;
    }

    //12
    public static List<String> getNamesPublicMethods(Object obj) {
        List<String> names = new ArrayList<String>();
        Method[] methods = obj.getClass().getMethods();
        for (Method item : methods) {
            names.add(item.getName());
        }
        return names;
    }

    //13
    public static List<String> getParents(Object o) {
        ArrayList<String> parents = new ArrayList<>();
        Class currentSuper = o.getClass().getSuperclass();

        while (currentSuper != null) {
            parents.add(currentSuper.getSimpleName());
            currentSuper = currentSuper.getSuperclass();
        }

        return parents;
    }

    //14
    public static int executeExecutables(List<Object> objects) {
        int count = 0;
        for (Object o : objects) {
            if (o instanceof Executable) {
                ((Executable) o).execute();
                count++;
            }
        }
        return count;

    }

    //15
    public static List<String> getSettersAndGetters(Object o) {
        ArrayList<String> result = new ArrayList<>();

        for (Method m : o.getClass().getMethods()) {
            int mod = m.getModifiers();

            if (Modifier.isPublic(mod) && !Modifier.isStatic(mod) &&
                    (isGetter(m) || isSetter(m))) {
                result.add(m.getName());
            }
        }

        return result;
    }

    //15
    private static boolean isGetter(Method m) {
        return m.getName().startsWith("get") &&
                (m.getParameterCount() == 0) &&
                !m.getReturnType().equals(void.class);
    }

    //15
    private static boolean isSetter(Method m) {
        return m.getName().startsWith("set") &&
                (m.getParameterCount() == 1) &&
                m.getReturnType().equals(void.class);
    }



}
