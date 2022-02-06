package net.broscorp.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class демонстрирует моменты срабатывания габич-коллектора при создании и удалении большого
 * колличество объектов
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class CatTest {
    private static List<Cat> catList;
    private static final int NUMBER = 500_000;

    @BeforeEach
    void setUp() {
        catList = new ArrayList<>(NUMBER);
    }

    @Test
    public void testCreateManyObjects() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            System.out.println(i + " == START PROGRAM TOTAL MEMORY=" + getTotalMemory());
            createObject(NUMBER);
            System.out.println("11 AFTER CREATE TOTAL MEMORY=" + getTotalMemory());
            loseLinkObject(NUMBER);
            System.out.println("22 AFTER LOSE TOTAL MEMORY=" + getTotalMemory());
            catList.clear();
            System.out.println(i + " SIZE_COLLECTION " + catList.size());
        }

    }

    private static void loseLinkObject(int count) {
        for (int i = 0; i < count; i += 2) {
            catList.add(i, null);
        }
    }

    private static void createObject(int count) {
        for (int i = 1; i < count; i++) {
            Cat cat = new Cat("Vasilij " + i, 1 + i);
            catList.add(cat);
        }
    }

    private static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}