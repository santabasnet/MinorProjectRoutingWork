package edu.eec.pathwork;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
public class Station {
    /**
     * All the member variables.
     */
    private int id;
    private String name;
    private Coordinate coordinate;

    /**
     * Default constructor.
     */
    public Station() {
        this.id = -1;
        this.name = Literals.EMPTY;
        this.coordinate = Coordinate.empty();
    }

    /**
     * Overloaded Constructor for all the parameters.
     */
    public Station(int id, String name, Coordinate coordinate) {
        this.id = -1;
        this.name = Literals.EMPTY;
        this.coordinate = coordinate;
    }

    /**
     * Verify if the customer is empty.
     */
    public boolean isEmpty() {
        return this.id == -1 || Objects.equals(this.name, Literals.EMPTY);
    }

    /**
     * Add the id parameter.
     */
    public Station withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Add the id parameter.
     */
    public Station withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Add the id parameter.
     */
    public Station withCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    /**
     * Calculates the distance between current and the given station.
     */
    public double distanceWith(Station station){
        return this.getCoordinate().distanceWith(station.getCoordinate());
    }

    /**
     * Get Id.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Get Name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get the coordinate.
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * Json representation of the Station.
     */
    @Override
    public String toString() {
        return Literals.gsonPretty.toJson(this);
    }

    /**
     * Creates empty object.
     */
    public static Station empty() {
        return new Station();
    }

    /**
     * Build the station from the line text.
     */
    public static Station of(String lineText) {
        List<String> allParts = Arrays.stream(lineText.split(Literals.CSV_DELIMITER))
                .filter(str -> !str.isEmpty()).map(String::trim).collect(Collectors.toList());

        return Station.empty()
                .withId(Integer.parseInt(allParts.get(0)))
                .withName(cleanText(allParts.get(3)))
                .withCoordinate(coordinateOf(allParts));
    }

    private static Coordinate coordinateOf(List<String> allParts) {
        return Coordinate.empty()
                .withLatitude(Double.parseDouble(allParts.get(1)))
                .withLongitude(Double.parseDouble(allParts.get(2)));
    }

    private static String cleanText(String text) {
        return text.replaceAll("\"", "");
    }
}
