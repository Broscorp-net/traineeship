package net.broscorp.oop.solid.srp;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ! REMOVE ME !
 *
 * <p>Solution:
 * Don NOT extract anything.
 *
 * <p>Explanation:
 * This class contains not so many methods and all of them match class name.
 * So the responsibility of this class is fine.
 */
public class MapUtils {

  <T, K> Map<K, List<T>> groupBy(List<T> list, Function<T, K> keyExtractor) {
    return list.stream()
        .collect(Collectors.groupingBy(keyExtractor));
  }

  <T, K> Map<K, T> toMap(List<T> list, Function<T, K> keyExtractor) {
    return list.stream()
        .collect(Collectors.toMap(
            keyExtractor,
            i -> i
        ));
  }

  <T, K, V> Map<K, V> toMap(List<T> list, Function<T, K> keyExtractor,
      Function<T, V> valueExtractor) {
    return list.stream()
        .collect(Collectors.toMap(
            keyExtractor,
            valueExtractor,
            (t, t2) -> {
              throw new IllegalStateException("Duplicate keys are not supported");
            }
        ));
  }

  <T, K, V> Map<K, V> convertValues(Map<K, T> map, Function<T, V> valueMapper) {
    return map.entrySet().stream()
        .collect(Collectors.toMap(
            e -> e.getKey(),
            e -> valueMapper.apply(e.getValue())
        ));
  }

}
