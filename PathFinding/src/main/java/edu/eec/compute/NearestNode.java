package edu.eec.compute;

import edu.eec.pathwork.Coordinate;
import edu.eec.pathwork.CustomerBucket;
import edu.eec.pathwork.Station;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class NearestNode {
    /**
     * All clustered customer and their associated bases.
     */
    private final List<CustomerBucket> allBuckets;

    /**
     * Default constructor.
     */
    public NearestNode() {
        this.allBuckets = new ArrayList<>();
    }

    /**
     * Overloaded constructor with given list of customer cluster with
     * their associated bases.
     */
    public NearestNode(List<CustomerBucket> allBuckets) {
        this.allBuckets = allBuckets;
    }

    /**
     * Build with list of customers cluster.
     */
    public NearestNode withCluster(List<CustomerBucket> allBuckets) {
        return new NearestNode(allBuckets);
    }

    /**
     * Returns the list of all order pair of the coordinates.
     *
     * @param allPoints
     * @return listOfAllOrderPairs.
     */
    private List<Map.Entry<Coordinate, Coordinate>> orderPairsOf(List<Coordinate> allPoints) {
        List<Map.Entry<Coordinate, Coordinate>> results = new ArrayList<>();
        for (int i = 0; i < allPoints.size(); i++)
            for (int j = 0; j < allPoints.size(); j++)
                if (i != j) results.add(new AbstractMap.SimpleEntry<>(allPoints.get(i), allPoints.get(j)));
        return results;
    }

    /**
     * Generates a path for the given cluster.
     *
     * @param bucket, a cluster of a base and customer.
     * @return path for a bucket.
     */
    private DeliveryPath computePath(CustomerBucket bucket) {
        DeliveryPath path = DeliveryPath.empty().withBase(bucket.getBaseStation());

        List<Station> allCustomers = bucket.getAllCustomers();
        Coordinate cBase = bucket.getBaseStation().getCoordinate();
        while (!allCustomers.isEmpty()) {
            final Coordinate finalCBase = cBase.copy();
            final List<Station> finalStations = allCustomers;
            /**
             * Identify the nearest station and assign as the index to be processed.
             */
            final int index = IntStream.range(0, allCustomers.size())
                    .mapToObj(i -> {
                        double distance = DistanceCache.distanceOf(finalCBase, finalStations.get(i).getCoordinate()).getValue();
                        return new AbstractMap.SimpleEntry<>(i, distance);
                    }).min(Map.Entry.comparingByValue()).get().getKey();

            /**
             * Assign the new base to compute the nearest delivery.
             */
            cBase = allCustomers.get(index).getCoordinate();
            /**
             * Update in the path.
             */
            path.updateDelivery(allCustomers.get(index));
            /**
             * Filter the indexed item.
             */
            allCustomers = IntStream.range(0, finalStations.size())
                    .mapToObj(i -> new AbstractMap.SimpleEntry<Integer, Station>(i, finalStations.get(i)))
                    .filter(entry -> entry.getKey() != index)
                    .map(AbstractMap.SimpleEntry::getValue)
                    .collect(Collectors.toList());
        }

        return path;
    }

    /**
     * Compute paths for the given list of clusters.
     *
     * @return listOfPath
     */
    public List<DeliveryPath> computePaths() {
        return this.allBuckets.stream().map(this::computePath).collect(Collectors.toList());
    }

    /**
     * Empty instance.
     */
    public static NearestNode empty() {
        return new NearestNode();
    }

}
