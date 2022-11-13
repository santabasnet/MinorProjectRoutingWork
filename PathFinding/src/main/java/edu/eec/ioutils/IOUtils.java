package edu.eec.ioutils;

import edu.eec.pathwork.Station;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is a part of the package edu.eec.ioutils and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-12.
 */
public class IOUtils {

    /**
     * Reads the CSV file line by line and returns the list of String.
     * Useful for reading the customer csv data line by line.
     */
    private static List<String> readAllLines(String fileName) {
        List<String> allLines = new ArrayList<>();
        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {
            allLines = fileStream.collect(Collectors.toList());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return allLines;
    }

    /**
     * Load the base/customer data from the given file name.
     */
    private static List<Station> readStations(String fileName) {
        return readAllLines(fileName).stream().map(Station::of).collect(Collectors.toList());
    }

    /**
     * Load all the base stations from the file.
     */
    public static List<Station> readAllBases() {
        return readStations(IOLiterals.BASE_STATION_FILE);
    }

    /**
     * Load all the customer stations from the file.
     */
    /**
     * Load all the base stations from the file.
     */
    public static List<Station> readAllCustomers() {
        return readStations(IOLiterals.DATA_FILE);
    }
}
