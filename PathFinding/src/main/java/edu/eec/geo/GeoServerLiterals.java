package edu.eec.geo;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * This class is a part of the package edu.eec.geo and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-12.
 */
public class GeoServerLiterals {

    /**
     * Server URL.
     * Local URL for distance calculation.
     */
    public static final String URL = "http://localhost:8989/route?";

    /**
     * Server GET request parameters.
     */
    public static final String parameters = "point=%s,%s&point=%s,%s&type=json&locale=en-US&key=&elevation=false&profile=car";

    /**
     * Gson type.
     */
    public static final Type RequestType = new TypeToken<Map<String, Object>>() {
    }.getType();

    /**
     * Distance Field.
     */
    public static final String DISTANCE_FIELD = "distance";

    /**
     * Paths Field.
     */
    public static final String PATHS_FIELD = "paths";

    /**
     * Kilometer Factor.
     */
    public static final double KM_FACTOR = 0.001d;

}
