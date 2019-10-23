package com.example.demoenum;

import org.assertj.core.api.AssertDelegateTarget;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class HashMapTest {

    @Test
    public void testInitialiseHashMap() {
        Map<String, Garden> gardenMap = new HashMap<>();

        Assert.notNull(gardenMap, "not null");
        Assert.isTrue(gardenMap.isEmpty(),"is empty");
    }

    @Test
    public  void testCollectorsToMap() {

        Map<String, Garden> gardenMap = Stream.of(new Object[][]{
                {"firstGarden", new Garden(1L, "first")},
                {"secondGarden", new Garden(2L, "second")}
        }).collect(Collectors.toMap(data -> (String)data[0], data -> (Garden)data[1]));

        Assert.isTrue(gardenMap.size() == 2,"size is 2");
        Assert.isTrue(gardenMap.get("firstGarden").getName().equals("first"), "first garden name is first");
    }

    Map<String, Garden> map = new HashMap<String, Garden>() {
        {
            put("firstGarden", new Garden(1L, "first"));
            put("secondGarden", new Garden(2L, "second"));
            put("thirdGarden", new Garden(3L, "third"));
        }
    };

    @Test
    public  void testHashMapPutAndGet() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.put("firstGarden", new Garden(1L, "first"));

        final Garden firstGarden = gardenMap.get("firstGarden");

        Assert.isTrue(firstGarden.getId().equals(1L), "first garden id is 1L");
        Assert.isTrue(firstGarden.getName().equals("first"), "first garden name is first");
    }

    @Test
    public  void testHashMapPutIfAbsent() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.putIfAbsent("firstGarden", new Garden(1L, "first"));

        final Garden secondGarden = gardenMap.get("second");
        Assert.isNull(secondGarden, "It does not exists yet");

        Garden defaultGarden = new Garden(0L, "default");
        final Garden second = gardenMap.getOrDefault("second", defaultGarden);

        Assert.isTrue(second.getId().equals(0L), "default garden id is 0L");
        Assert.isTrue(second.getName().equals("default"), "default garden name is default");
    }

    @Test
    public void testHashMapGetOrDefault() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.putIfAbsent("firstGarden", new Garden(1L, "first"));

        final Garden secondGarden = gardenMap.get("second");
        Assert.isNull(secondGarden, "It does not exists yet");

        Garden defaultGarden = new Garden(0L, "default");
        final Garden second = gardenMap.getOrDefault("second", defaultGarden);

        Assert.isTrue(second.getId().equals(0L), "default garden id is 0L");
        Assert.isTrue(second.getName().equals("default"), "default garden name is default");
    }

    @Test
    public void testHashMapRemove() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.put("firstGarden", new Garden(1L, "first"));

        Garden nullGarden = new Garden(2L, "null");
        gardenMap.put(null, nullGarden);

        gardenMap.remove("firstGarden");
        Assert.isTrue(gardenMap.size() == 1, "1 left");

        gardenMap.remove(null); //java.lang.IllegalArgumentException: cannot remove null

        gardenMap.remove(null, nullGarden);
        Assert.isTrue(gardenMap.size() == 0, "finally gone");
    }

    @Test
    public void testHashMapContains() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.put("firstGarden", null);
        final  Garden nullGarden = new Garden(0L , "null");
        gardenMap.put(null, nullGarden);

        Assert.isTrue( gardenMap.containsKey("firstGarden"), "contains firstGarden key");
        Assert.isTrue( gardenMap.containsValue(nullGarden), "contains nullGarden");
        Assert.isTrue( gardenMap.containsKey(null), "contains null key");
        Assert.isTrue( gardenMap.containsValue(null), "contains null value");
    }
}
