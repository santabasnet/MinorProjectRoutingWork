package edu.eec.compute;

import edu.eec.geo.GeoClient;
import edu.eec.pathwork.Coordinate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is a part of the package edu.eec.compute and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-17.
 */
public class DistanceCache {

    /**
     * Map of distance key and the value, key is generated by the pair of coordinate.
     */
    private static HashMap<String, Double> distanceCache = new HashMap<>();

    /**
     * Generate key from the lat/lon items.
     */
    private static String keyOf(List<Coordinate> items) {
        return items.stream().map(Coordinate::getKey).collect(Collectors.joining("_"));
    }

    /**
     * Generate key from the given coordinates.
     */
    private static String keyOf(Coordinate c1, Coordinate c2) {
        return keyOf(Arrays.asList(c1, c2));
    }


    /**
     * Update Cache.
     */
    private static void updateCache(String key, double distance) {
        distanceCache.put(key, distance);
    }

    /**
     * Calculate and update the distance.
     */
    private static double calculateDistance(String key, Coordinate c1, Coordinate c2) {
        double distance = GeoClient.extractDistance(c1, c2);
        updateCache(key, distance);
        return distance;
    }

    /**
     * Get distance value from cache.
     */
    public static Map.Entry<String, Double> distanceOf(Coordinate c1, Coordinate c2) {
        String key = keyOf(c1, c2);
        return new AbstractMap.SimpleEntry<>(key, distanceCache.getOrDefault(key, calculateDistance(key, c1, c2)));
    }

}
