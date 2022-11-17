package edu.eec.pathapp;

import edu.eec.compute.Compute;
import edu.eec.compute.DeliveryPath;
import edu.eec.compute.NearestNode;
import edu.eec.ioutils.IOUtils;
import edu.eec.pathwork.CustomerBucket;
import edu.eec.pathwork.CustomerCluster;
import edu.eec.pathwork.Station;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class is a part of the package edu.eec.pathapp and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-12.
 */
public class PathFindingApp {

    /**
     * Program Starts here.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the EEC route finding app ...");

        /**
         * 1. Assign all the base stations.
         */
        List<Station> allBasesData = IOUtils.readAllBases();
        IntStream.range(0, allBasesData.size() - 1)
                .forEach(i -> CustomerCluster.updateBaseStation(i, allBasesData.get(i)));
        CustomerCluster.allBases().forEach(System.out::println);

        /**
         * 2. Build all the clusters based on the haversine distance and update to its cluster member.
         */
        List<Station> allBases = CustomerCluster.allBases();
        IOUtils.readAllCustomers()
                .forEach(customer -> CustomerCluster.updateCustomerBucket(Compute.clusterOf(customer, allBases), customer));

        System.out.println("All cluster sizes: ");
        List<Integer> sizes = CustomerCluster.allBuckets().stream().map(CustomerBucket::customerCount).collect(Collectors.toList());
        //System.out.println(sizes);

        /**
         * Apply The Nearest first algorithm to generate the path.
         */
        System.out.println("Path constructed from Nearest Node :");
        List<DeliveryPath> paths = NearestNode.empty().withCluster(CustomerCluster.allBuckets()).computePaths();
        paths.forEach(System.out::println);

        /**
         * Apply Dijkstra's algorithm.
         */

    }

}
