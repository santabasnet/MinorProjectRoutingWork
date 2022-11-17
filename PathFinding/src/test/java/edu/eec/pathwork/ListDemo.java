package edu.eec.pathwork;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class is a part of the package edu.eec.pathwork and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-17.
 */
public class ListDemo {

    public static void main(String[] args) {

        List<Station> stations = Arrays.asList(
                Station.empty().withId(1),
                Station.empty().withId(4),
                Station.empty().withId(5),
                Station.empty().withId(2)
        );

        int id = 5;

        while(!stations.isEmpty()) {
            final List<Station> finalStations = stations;

            List<Station> newStations = IntStream.range(0, stations.size())
                    .mapToObj(i -> new AbstractMap.SimpleEntry<Integer, Station>(i, finalStations.get(i)))
                    .filter(entry -> entry.getKey() != 0)
                    .map(AbstractMap.SimpleEntry::getValue)
                    .collect(Collectors.toList());

            stations = newStations;
        }

        System.out.println("Removed Completely ! " + stations.size());
    }

}
