import demo.Garden;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HashMapTest {

    @Test
    public void testInitialiseHashMap() {

        Map<String, Garden> gardenMap = new HashMap<>();

        assertTrue(gardenMap.isEmpty(), "map is empty");
    }

    @Test
    public  void testCollectorsToMap() {

        Map<String, Garden> gardenMap = Stream.of(new Object[][]{
                {"firstGarden", new Garden(1L, "first")},
                {"secondGarden", new Garden(2L, "second")}
        }).collect(Collectors.toMap(data -> (String)data[0], data -> (Garden)data[1]));

        assertTrue(gardenMap.size() == 2,"size is 2");
        assertTrue(gardenMap.get("firstGarden").getName().equals("first"), "first garden name is first");
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

        assertTrue(firstGarden.getId().equals(1L), "first garden id is 1L");
        assertTrue(firstGarden.getName().equals("first"), "first garden name is first");
    }

    @Test
    public  void testHashMapPutIfAbsent() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.putIfAbsent("firstGarden", new Garden(1L, "first"));

        final Garden secondGarden = gardenMap.get("second");
        assertNull(secondGarden, "It does not exists yet");

        Garden defaultGarden = new Garden(0L, "default");
        final Garden second = gardenMap.getOrDefault("second", defaultGarden);

        assertTrue(second.getId().equals(0L), "default garden id is 0L");
        assertTrue(second.getName().equals("default"), "default garden name is default");
    }

    @Test
    public void testHashMapGetOrDefault() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.putIfAbsent("firstGarden", new Garden(1L, "first"));

        final Garden secondGarden = gardenMap.get("second");
        assertNull(secondGarden, "It does not exists yet");

        Garden defaultGarden = new Garden(0L, "default");
        final Garden second = gardenMap.getOrDefault("second", defaultGarden);

        assertTrue(second.getId().equals(0L), "default garden id is 0L");
        assertTrue(second.getName().equals("default"), "default garden name is default");
    }

    @Test
    public void testHashMapRemove() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.put("firstGarden", new Garden(1L, "first"));

        Garden nullGarden = new Garden(2L, "null");
        gardenMap.put(null, nullGarden);

        gardenMap.remove("firstGarden");
        assertTrue(gardenMap.size() == 1, "1 left");

        gardenMap.remove(null); //java.lang.IllegalArgumentException: cannot remove null

        gardenMap.remove(null, nullGarden);
        assertTrue(gardenMap.size() == 0, "finally gone");
    }

    @Test
    public void testHashMapContains() {

        Map<String, Garden> gardenMap = new HashMap<>();
        gardenMap.put("firstGarden", null);
        final  Garden nullGarden = new Garden(0L , "null");
        gardenMap.put(null, nullGarden);

        assertTrue( gardenMap.containsKey("firstGarden"), "contains firstGarden key");
        assertTrue( gardenMap.containsValue(nullGarden), "contains nullGarden");
        assertTrue( gardenMap.containsKey(null), "contains null key");
        assertTrue( gardenMap.containsValue(null), "contains null value");
    }

    @Test
    public void testHashMapIterateKeys() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        for (String key : gardenMap.keySet()) {

            if (key == null) {
                Garden theGarden = gardenMap.get(null);
                assertTrue( theGarden == nullGarden, "got null garden");

                gardenMap.put(null, firstGarden);
            }
        }
        assertTrue( gardenMap.get(null) == firstGarden, "null garden is replaced");
    }

    @Test
    public void testHashMapIterateValues() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        for (Garden garden : gardenMap.values()) {

            if (garden == nullGarden) {
                garden.setId(3L);
            }
        }
        assertTrue( gardenMap.get(null).getId() == 3L, "null garden is updated");
    }

    @Test
    public void testHashMapIterateEntries() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        for (Map.Entry<String, Garden> entry : gardenMap.entrySet()) {

            if (entry.getKey() == null) {
                assertTrue(entry.getValue() == nullGarden, "here is the null garden");
                entry.getValue().setId(3L);
            }
        }
        assertTrue( gardenMap.get(null).getId() == 3L, "null garden is updated");
    }

    @Test
    public void testHashMapIterator() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        Iterator it = gardenMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();

            if (entry.getKey() == null) {
                Garden theGarden = (Garden) entry.getValue();
                assertTrue( theGarden.getId() == 0L, "null garden id is 0");
                it.remove(); // avoids a ConcurrentModificationException
            }
        }
        assertTrue( gardenMap.size() == 2, "null garden is removed");
    }

    @Test
    public void testHashMapConstructorCopy() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        HashMap<String, Garden> shallowCopy = new HashMap<>(gardenMap);
        assertTrue( shallowCopy.size() == 3, "shallow copy has same size");

        nullGarden.setId(3L);
        assertTrue( shallowCopy.get(null).getId() == 3L, "shallow copy is also updated");
    }

    @Test
    public void testHashMapPutCopy() {

        Map<String, Garden> gardenMap = new HashMap<>();
        final  Garden nullGarden = new Garden(0L , "null");
        final  Garden firstGarden = new Garden(1L , "first");
        final  Garden secondGarden = new Garden(2L , "second");
        gardenMap.put(null, nullGarden);
        gardenMap.put("firstGarden", firstGarden);
        gardenMap.put("secondGarden", secondGarden);

        HashMap<String, Garden> shallowCopy = new HashMap<>();

        gardenMap.entrySet()
                .forEach(entry -> shallowCopy.put(entry.getKey(), entry.getValue()));

        assertTrue( shallowCopy.size() == 3, "shallow copy has same size");

        nullGarden.setId(3L);
        assertTrue( shallowCopy.get(null).getId() == 3L, "shallow copy is also updated");
    }

    @Test
    public void testConcurrentHashMapKeyNull() {

        Map<String, Garden> gardenMap = new ConcurrentHashMap<>();

        try {
            gardenMap.put(null, new Garden());
        } catch (NullPointerException ex) {
        }
        assertTrue(gardenMap.size() == 0, "still empty");
    }

    @Test
    public void testConcurrentHashMapRemove() {


        Map<String, Garden> gardenMap = new ConcurrentHashMap<>();
        gardenMap.put("firstGarden", new Garden(1L , "first"));
        gardenMap.put("secondGarden", new Garden(2L , "second"));

        gardenMap.entrySet()
                .forEach(entry -> {
                    if (entry.getKey().equalsIgnoreCase("firstGarden")) {
                        gardenMap.remove("firstGarden");
                    }
                });

        assertTrue( gardenMap.size() == 1, "first garden is gone");
    }

    @Test
    public void testConcurrentHashMapTwoThread() throws Exception {

        Map<String, Garden> gardenMap = new ConcurrentHashMap<>();
        gardenMap.put("firstGarden", new Garden(1L, "first"));
        gardenMap.put("secondGarden", new Garden(2L, "second"));

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                    gardenMap.put("third garden", new Garden());
                } catch (InterruptedException e) {
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(70);
                    assertTrue(gardenMap.size() == 3, "we got one from other theads");
                } catch (InterruptedException e) {
                }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(100);

        assertTrue(gardenMap.size() == 3, "3 now");
    }

}
