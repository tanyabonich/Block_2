package com.company;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Таня on 04.07.2017.
 */
public class JSON {
    //отображение имен полей json-объекта (String) в их значения (Object)
    private HashMap<String, Object> map;

    //Конструктор
    public JSON(String field, Object o) {
        this.map = new HashMap<String, Object>();
        this.map.put(field, o);
    }

    private static boolean isValueOK(Object value) {

        String strVal = value.toString();
        List<String> literals = new ArrayList<>();
        literals.add("null");
        literals.add("true");
        literals.add("false");

        if (literals.contains(strVal) || value instanceof Number || value instanceof JSON || value instanceof String) {
            return true;
        }
        if (value.getClass().isArray()) {
            boolean flag = true;
            Object[] arr = objectToArray(value);
            for (Object item : arr) {
                flag &= isValueOK(item);
            }
            return flag;
        }
        return false;
    }


    private static Object[] objectToArray(Object value) {
        Class ofArray = value.getClass().getComponentType();
        if (ofArray.isPrimitive()) {
            List ar = new ArrayList();
            int length = Array.getLength(value);
            for (int i = 0; i < length; i++) {
                ar.add(Array.get(value, i));
            }
            return ar.toArray();
        } else {
            return (Object[]) value;
        }
    }

    //Геттер для значения поля
    public Object getValue(String field) {

        return map.get(field);
    }


    //Сеттер для отображения
    public void setValue(String field, Object value) throws WrongTypeOfValueException {

        if (isValueOK(value)) {
            map.put(field, value);
        } else {
            throw new WrongTypeOfValueException("Wrong type of value");
        }
    }

    //Возвращает отображение
    public HashMap<String, Object> getMap() {
        return map;
    }


    //Метод, удаляющий поле из отображения
    public void deleteField(String field) {
        map.remove(field);
    }

    //Проверка JSON-объекта на пустоту
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    //Возвращает размер объекта
    public int size() {
        return map.size();
    }

    //Проверка двух JSON-объектов на равенство
    public static boolean isEqual(JSON o1, JSON o2) {
        if (o1.size() != o2.size()) {
            return false;
        }
        boolean flag = true;
        HashMap<String, Object> map1 = o1.getMap();
        HashMap<String, Object> map2 = o2.getMap();

        if (!map1.keySet().containsAll(map2.keySet())) {
            return false;
        }

        Iterator<String> it2 = map2.keySet().iterator();
        for (Iterator<String> it1 = map1.keySet().iterator(); it1.hasNext(); ) {
            String key1 = it1.next();
            String key2 = it2.next();
            flag &= key1.equals(key2) & map1.get(key1).equals(map2.get(key2));
        }
        return flag;
    }

    @Override
    public String toString() {
        List<String> literals = new ArrayList<>();
        literals.add("null");
        literals.add("true");
        literals.add("false");

        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Object> item : this.map.entrySet()) {
            result.append("\"" + item.getKey() + "\" : ");
            Object val = item.getValue();

            //если не литерал или не число, вывести в кавычках
            String strVal = val.toString();
            if (literals.contains(strVal)) {
                result.append(literals.get(literals.indexOf(strVal)));
            } else if (val instanceof Number || val instanceof JSON) {
                result.append(val);
            } else if (val.getClass().isArray()) {
                Object[] arr = objectToArray(val);
                result.append("[");
                for (Object elem : arr) {
                    result.append(elem + ", ");
                }
                result.deleteCharAt(result.length() - 2);
                result.append("]");
            } else {
                result.append("\"" + val + "\"");
            }
            result.append(",\n");
        }
        result.deleteCharAt(result.length() - 2);
        result.append("}");
        return result.toString();
    }

}
