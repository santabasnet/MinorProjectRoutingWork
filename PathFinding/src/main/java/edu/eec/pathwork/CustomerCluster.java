package edu.eec.pathwork;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is a part of the package edu.eec.pathwork and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-12.
 */
public class CustomerCluster {

    /**
     * Initialize all the buckets for the customers.
     */
    private static final List<CustomerBucket> allClusters = Arrays.asList(
            CustomerBucket.empty(),
            CustomerBucket.empty(),
            CustomerBucket.empty(),
            CustomerBucket.empty(),
            CustomerBucket.empty()
    );

    /**
     * Returns the list of base stations.
     */
    public static List<Station> allBases() {
        return allClusters.stream().map(CustomerBucket::getBaseStation).collect(Collectors.toList());
    }

    /**
     * Update the Customer bucket.
     */
    public static boolean updateCustomerBucket(int index, Station customer) {
        CustomerBucket bucket = allClusters.get(index);
        if (bucket.isEmpty()) bucket.withId(index).withCustomer(customer);
        else bucket.withCustomer(customer);
        return true;
    }

    /**
     * Update the base station.
     */
    public static boolean updateBaseStation(int index, Station base) {
        CustomerBucket bucket = allClusters.get(index);
        if (bucket.isEmpty()) bucket.withId(index).withBase(base);
        else bucket.withBase(base);
        return true;
    }

    /**
     * Update a customer to the first bucket.
     */
    public static boolean updateFirst(Station customer) {
        return updateCustomerBucket(Literals.ONE, customer);
    }

    /**
     * Update a customer to the second bucket.
     */
    public static boolean updateSecond(Station customer) {
        return updateCustomerBucket(Literals.TWO, customer);
    }

    /**
     * Update a customer to the second bucket.
     */
    public static boolean updateThird(Station customer) {
        return updateCustomerBucket(Literals.THREE, customer);
    }

    /**
     * Update a customer to the second bucket.
     */
    public static boolean updateForth(Station customer) {
        return updateCustomerBucket(Literals.FOUR, customer);
    }

    /**
     * Update a customer to the second bucket.
     */
    public static boolean updateFifth(Station customer) {
        return updateCustomerBucket(Literals.FIVE, customer);
    }

    /**
     * Returns all customers.
     */
    public static List<CustomerBucket> allBuckets() {
        return allClusters;
    }

}
