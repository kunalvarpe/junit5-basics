package io.kpsoft.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.kpsoft.test.model.People;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class ListOpsTest {

    List<People> list = testData();

    @Test
    void testAddPeopleShouldSuccess() {
        int sizeBefore = list.size();
        list.add(new People("fname", "lname", 21, 20000, "Pune"));
        int sizeAfter = list.size();
        assertNotEquals(sizeAfter, sizeBefore);
    }

    @Test
    void testGetPeopleAbove25AgeShouldSuccess() {
        List<People> peopleList = list.stream()
                                      .filter(people -> people.age() > 25)
                                      .toList();
        assertEquals(2, peopleList.size());

    }

    @Test
    void testGroupPeopleByCityShouldSuccess() {
        Map<String, List<People>> groupByCity = list.stream()
                                                    .collect(groupingBy(People::city));
        assertEquals(6, groupByCity.size());
    }

    @Test
    void testAvgSalOfEmpByCityShouldSuccess() {
        Map<String, Double> averageSalaryByCity = list.stream()
                                                      .collect(groupingBy(People::city, averagingDouble(People::salary)));

        assertEquals(averageSalaryByCity.get("Pune"), (10000 + 0.0 + 100000) / 3);

    }

    private List<People> testData() {
        return new ArrayList<>(Arrays.asList(
                new People("User1FN", "User1LN", 23, 10000, "Pune"),
                new People("User2FN", "User2LN", 20, 8000, "Delhi"),
                new People("User3FN", "User3LN", 21, 9000, "Kolkata"),
                new People("User4FN", "User4LN", 30, 80000, "Mumbai"),
                new People("User5FN", "User5LN", 12, 0.0, "Mumbai"),
                new People("User6FN", "User6LN", 13, 0.0, "Pune"),
                new People("User7FN", "User7LN", 11, 0.0, "Bengaluru"),
                new People("User8FN", "User8LN", 18, 5000, "Chennai"),
                new People("User9FN", "User9LN", 22, 50000, "Delhi"),
                new People("User10FN", "User10LN", 28, 100000, "Pune")
        ));
    }
}
