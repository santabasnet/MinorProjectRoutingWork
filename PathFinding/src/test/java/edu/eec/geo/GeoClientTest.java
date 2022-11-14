package edu.eec.geo;

import edu.eec.pathwork.Coordinate;

/**
 * This class is a part of the package edu.eec.geo and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-13.
 */
public class GeoClientTest {

    public static void main(String[] args) {
        double lat1 = 27.651395308588995d;
        double lon1 = 85.35452313632192d;
        double lat2 = 27.63776577846707;
        double lon2 = 85.33339899213524;

        String url = GeoClient.buildURL(lat1, lon1, lat2, lon2);
        System.out.println(url);

        double result = GeoClient.extractDistance(new Coordinate(lat1, lon1), new Coordinate(lat2, lon2));
        System.out.println("Distance : " + result + " km.");
    }

}
