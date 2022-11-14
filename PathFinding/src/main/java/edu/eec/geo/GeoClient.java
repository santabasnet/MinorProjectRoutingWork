package edu.eec.geo;

import edu.eec.pathwork.Coordinate;
import edu.eec.pathwork.Literals;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;
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
public class GeoClient {

    /**
     * Build http client for the local request.
     */
    private static CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }

    /**
     * Returns the Http GET request.
     */
    private static HttpGet httpRequest(Coordinate c1, Coordinate c2) {
        return new HttpGet(buildURL(c1.getLatitude(), c1.getLongitude(), c2.getLatitude(), c2.getLongitude()));
    }

    /**
     * Build request parameters with given lat/lon data.
     */
    public static String buildURL(double lat1, double lon1, double lat2, double lon2) {
        String params = String.format(GeoServerLiterals.parameters, lat1, lon1, lat2, lon2);
        return GeoServerLiterals.URL + params;
    }

    /**
     * Make Request for the distance calculation.
     */
    private static String makeRequest(Coordinate c1, Coordinate c2) {
        try {
            return EntityUtils.toString(httpClient().execute(httpRequest(c1, c2)).getEntity());
        } catch (Exception e) {
            return Literals.EMPTY_JSON;
        }
    }

    /**
     * Parse JSON.
     */
    private static Map<String, Object> parse(String json) {
        return Literals.gson.fromJson(json, GeoServerLiterals.RequestType);
    }

    /**
     * Extract Distance.
     */
    public static double extractDistance(Coordinate from, Coordinate to) {
        try {
            List<Map<String, Object>> innerMap = (List<Map<String, Object>>) parse(makeRequest(from, to)).get(GeoServerLiterals.PATHS_FIELD);
            return Double.parseDouble(innerMap.get(0).get(GeoServerLiterals.DISTANCE_FIELD).toString()) * GeoServerLiterals.KM_FACTOR;
        } catch (Exception ee) {
            return -1.0d;
        }
    }


}
