package it.gebhard.qa.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapSortUtil {

	// Orders the map by values depending on boolean ascendingValues. If values are equal the keys are sorted in ascending order.
	public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, final boolean ascendingValues) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				// If value is equal compare the keys
				int value = (ascendingValues ? o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue())); 
				if (value == 0) {
					value = o1.getKey().compareTo(o2.getKey());
				}
				return value;
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
