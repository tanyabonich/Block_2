package com.company;

import java.util.*;


/**
 * Created by Таня on 10.05.2017.
 */
public class ListDemo {
    //1
    public static int sameFirstSymbol(List<String> stringList, char symbol) {
        int answer = 0;
        for (String item : stringList) {
            if (item.length() > 0 && item.charAt(0) == symbol) {
                answer++;
            }
        }
        return answer;
    }

    //2
    public static List<Human> sameSecondName(List<Human> humanList, Human person) {
        List<Human> answer = new LinkedList<Human>();
        for (Human item : humanList) {
            if (item.getSecondName().equals(person.getSecondName())) {
                answer.add(new Human(item));
            }
        }
        return answer;
    }

    //3
    public static List<Human> withoutPerson(List<Human> humanList, Human person) {
        List<Human> answer = new LinkedList<Human>();
        for (Human item : humanList) {
            if (!item.equals(person)) {
                answer.add(item);
            }
        }
        return answer;
    }

    //4
    public static List<Set<Integer>> doNotIntersect(List<Set<Integer>> setList, Set<Integer> set) {
        List<Set<Integer>> answer = new LinkedList<Set<Integer>>();
        for (Set<Integer> item : setList) {
            boolean check = false;
            for (Integer number : item) {
                if (set.contains(number)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                answer.add(item);
            }
        }
        return answer;
    }

    //5
    public static Set<Human> getPeopleWithMaxAge(List<? extends Human> people) {
        int maxAge = people.get(0).getAge();

        for (Human h : people) {
            if (h.getAge() > maxAge) {
                maxAge = h.getAge();
            }
        }

        HashSet<Human> peopleHaveMaxAge = new HashSet<>();
        for (Human h : people) {
            if (h.getAge() == maxAge) {
                peopleHaveMaxAge.add(h);
            }
        }

        return peopleHaveMaxAge;
    }

    //6
    public static List<Human> buildSortedList(Set<Human> people) {
        TreeSet<Human> set = new TreeSet<Human>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return (o1.getSecondName() + " " + o1.getName() + " " + o1.getFathersName()).compareTo(
                        o2.getSecondName() + " " + o2.getName() + " " + o2.getFathersName()
                );
            }
        });
        set.addAll(people);

        ArrayList<Human> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }



    //7
    public static Set<Human> humanFromMap(Map<Integer, Human> map, Set<Integer> set) {
        Set<Human> answer = new HashSet<Human>();
        for (Integer item : set) {
            if(map.containsKey(item)){
                answer.add(map.get(item));
            }
        }
        return answer;
    }

    //8
    public static List<Integer> humanOlder18(Map<Integer, Human> map) {
        ArrayList<Integer> result = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Human> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= 18) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
