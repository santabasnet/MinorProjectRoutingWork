package edu.eec.pathwork;

import org.apache.lucene.util.SloppyMath;

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
public class Coordinate {
    /**
     * Parameters.
     */
    private final double latitude;
    private final double longitude;

    /**
     * Default Constructor.
     */
    public Coordinate() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    /**
     * Overloaded constructor.
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * With Latitude.
     */
    public Coordinate withLatitude(double latitude) {
        return new Coordinate(latitude, this.longitude);
    }

    /**
     * With Longitude.
     */
    public Coordinate withLongitude(double longitude) {
        return new Coordinate(this.latitude, longitude);
    }

    /**
     * Copy the object.
     */
    public Coordinate copy() {
        return new Coordinate(this.latitude, this.longitude);
    }

    /**
     * Calculates the haversine distance with the given coordinate.
     */
    public double distanceWith(Coordinate coordinate) {
        return SloppyMath
                .haversinMeters(this.getLatitude(), this.getLongitude(), coordinate.getLatitude(), coordinate.getLongitude())
                * Literals.kilometerFactor;
    }

    /**
     * Access the latitude.
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Access the longitude.
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Factory of empty object.
     */
    public static Coordinate empty() {
        return new Coordinate();
    }

    /**
     * Returns the string key for hash map utility.
     */
    public String getKey() {
        return String.format("%s_%s", getLatitude(), getLongitude());
    }

    /**
     * To Json Representation.
     */
    @Override
    public String toString() {
        return Literals.gson.toJson(this);
    }
}
