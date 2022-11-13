package edu.eec.pathwork;

import java.util.ArrayList;
import java.util.List;

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
public class CustomerBucket {
    private int id;
    private Station baseStation;
    private List<Station> allCustomers;

    /**
     * Default constructor.
     */
    public CustomerBucket() {
        this.id = -1;
        this.baseStation = Station.empty();
        this.allCustomers = new ArrayList<>();
    }

    /**
     * Overloaded customers.
     */
    public CustomerBucket(int id, Station baseStation, List<Station> allCustomers) {
        this.id = id;
        this.baseStation = baseStation;
        this.allCustomers = allCustomers;
    }

    /**
     * Returns the base station.
     */
    public Station getBaseStation() {
        return this.baseStation;
    }

    /**
     * Returns all the customers.
     */
    public List<Station> getAllCustomers(){
        return this.allCustomers;
    }

    /**
     * Initialize the customers.
     */
    public CustomerBucket withCustomers(List<Station> allCustomers) {
        this.allCustomers = allCustomers;
        return this;
    }

    /**
     * Initialize the bucket id.
     */
    public CustomerBucket withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Initialize base.
     */
    public CustomerBucket withBase(Station baseStation) {
        this.baseStation = baseStation;
        return this;
    }

    /**
     * Update the customer.
     */
    public CustomerBucket withCustomer(Station customer) {
        this.allCustomers.add(customer);
        return this;
    }

    /**
     * Returns the customer count.
     */
    public int customerCount() {
        return this.allCustomers.size();
    }

    /**
     * Check if the bucket is empty.
     */
    public boolean isEmpty() {
        return this.id == -1 || this.allCustomers.isEmpty();
    }

    /**
     * Json representation of the customer bucket.
     */
    @Override
    public String toString() {
        return Literals.gsonPretty.toJson(this);
    }

    /**
     * Object factory for the empty cluster.
     */
    public static CustomerBucket empty() {
        return new CustomerBucket();
    }
}
