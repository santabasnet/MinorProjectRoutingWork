package edu.eec.pathwork;

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
public class OrderPair {

    private int index;
    private double value;

    public OrderPair(int index, double value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
