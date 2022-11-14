package edu.eec.pathwork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
public class Literals {

    /**
     * Empty String.
     */
    public static String EMPTY = "";

    /**
     * Empty JSON
     */
    public static String EMPTY_JSON = "{}";

    /**
     * Gson pretty printer.
     */
    public static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Gson without pretty formats.
     */
    public static final Gson gson = new GsonBuilder().create();

    /**
     * Number of clusters.
     */
    public static final int NO_OF_CLUSTERS = 5;

    /**
     * NUMBER constant ONE.
     */
    public static final int ONE = 0;

    /**
     * NUMBER constant TWO.
     */
    public static final int TWO = 1;

    /**
     * NUMBER constant THREE.
     */
    public static final int THREE = 2;

    /**
     * NUMBER constant FOUR.
     */
    public static final int FOUR = 3;

    /**
     * NUMBER constant FIVE.
     */
    public static final int FIVE = 4;

    /**
     * Station ONE.
     */
    public enum BaseStation {
        ONE, TWO, THREE, FOUR, FIVE
    }

    /**
     * Delimiters of CSV inputs.
     */
    public static final String CSV_DELIMITER = ",";

    /**
     * Kilometer factor.
     */
    public static final double kilometerFactor = 0.001;

}
