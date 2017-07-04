package com.company;

import org.junit.Test;

import static com.company.JSON.isEqual;
import static org.junit.Assert.*;

/**
 * Created by Таня on 04.07.2017.
 */
public class JSONTest {
@Test
    public void testObjectEqual() throws WrongTypeOfValueException {
    String name="Имя",
    secondName="Фамилия";
    JSON jsonObjEq= new JSON(name,"Таня");
    jsonObjEq.setValue(secondName,"Бонич");
    JSON jsonObj= new JSON(name,"Таня");
    jsonObj.setValue(secondName,"Бонич");
    assertEquals(true,isEqual(jsonObj,jsonObjEq));

}
    @Test
    public void testObjectNotEqual() throws WrongTypeOfValueException {
        String name="Имя",
                secondName="Фамилия";
        JSON jsonObjEq= new JSON(name,"Таня");
        jsonObjEq.setValue(secondName,"Бонич");
        JSON jsonObj= new JSON(name,"Таня");
        jsonObj.setValue(secondName,"Иванова");
        assertEquals(false,isEqual(jsonObj,jsonObjEq));
    }
    @Test
    public void testObjectNotEmpty() throws WrongTypeOfValueException {
        String name="Имя",
                secondName="Фамилия";
        JSON jsonObj= new JSON(name,"Таня");
        jsonObj.setValue(secondName,"Бонич");
        assertEquals(false,jsonObj.isEmpty());

    }

}