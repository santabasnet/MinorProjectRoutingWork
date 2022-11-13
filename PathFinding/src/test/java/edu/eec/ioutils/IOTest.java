package edu.eec.ioutils;

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
public class IOTest {

    /**
     * Test Main.
     */
    public static void main(String[] args) {

        /**
         * Test print for the base station.
         */
        System.out.println("All the bases : ");
        IOUtils.readAllBases().forEach(System.out::println);
        System.out.println();

        /**
         * Test print for the customer stations.
         */
        System.out.println("All the customers: ");
        IOUtils.readAllCustomers().forEach(System.out::println);

    }

}
