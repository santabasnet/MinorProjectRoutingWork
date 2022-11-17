package edu.eec.compute;

import com.google.gson.GsonBuilder;
import edu.eec.pathwork.Station;

import java.util.ArrayList;
import java.util.List;

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
public class DeliveryPath {
    Station base;
    List<Station> deliveries;

    /**
     * Default constructor.
     */
    public DeliveryPath() {
        this.base = Station.empty();
        this.deliveries = new ArrayList<>();
    }

    /**
     * Overloaded constructor.
     */
    public DeliveryPath(Station base, List<Station> deliveries) {
        this.base = base;
        this.deliveries = deliveries;
    }

    /**
     * Update with base.
     */
    public DeliveryPath withBase(Station base) {
        return new DeliveryPath(base, this.deliveries);
    }

    /**
     * Update with a single delivery station.
     */
    public DeliveryPath updateDelivery(Station delivery) {
        this.deliveries.add(delivery);
        return this;
    }

    /**
     * An empty instance.
     */
    public static DeliveryPath empty() {
        return new DeliveryPath();
    }

    /**
     * Json representation of the delivery path.
     */
    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
