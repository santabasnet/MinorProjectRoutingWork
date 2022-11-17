package edu.eec.compute;

import edu.eec.pathwork.OrderPair;
import edu.eec.pathwork.Station;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class is a part of the package edu.eec.compute and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-12.
 */
public class Compute {

    /**
     * Perform the identification of cluster id against the given list of base stations.
     */
    public static int clusterOf(Station customer, List<Station> allBases) {
        return IntStream.range(0, allBases.size() - 1).mapToObj(index -> {
            double distance = allBases.get(index).distanceWith(customer);
            return new OrderPair(index, distance);
        }).min(Comparator.comparingDouble(OrderPair::getValue)).get().getIndex();
    }

    /**
     * Compute the nearest first from the base to construct the route.
     */
}
