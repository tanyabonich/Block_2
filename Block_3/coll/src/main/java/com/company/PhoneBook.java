package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Таня on 04.07.2017.
 */
public class PhoneBook {
    private HashMap<Human, ArrayList<String>> numbers;


    public PhoneBook() {

        numbers = new HashMap<>();
    }


    public void add(Human h, String number) {
        if (numbers.containsKey(h) && !numbers.get(h).contains(number)) {
            numbers.get(h).add(number);
        } else if (!numbers.containsKey(h)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(number);
            numbers.put(h, list);
        }
    }



    public ArrayList<String> get(Human h) {
        if (numbers.containsKey(h)) {
            return numbers.get(h);
        } else {
            return null;
        }
    }


    public void remove(Human h, String number) {
        if (numbers.containsKey(h)) {
            numbers.get(h).remove(number);
        }
    }


    public void remove(Human h) {
        numbers.remove(h);
    }


    public Human find(String number) {
        for (Map.Entry<Human, ArrayList<String>> entry : numbers.entrySet()) {
            if (entry.getValue().contains(number)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean contains(String number) {
        for (Map.Entry<Human, ArrayList<String>> entry : numbers.entrySet()) {
            if (entry.getValue().contains(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Human h) {
        return numbers.containsKey(h);
    }
}
