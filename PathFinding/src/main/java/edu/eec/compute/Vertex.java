package edu.eec.compute;

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
 * Created by santa on 2022-11-13.
 */
public class Vertex {

    private String name;
    private double x, y;
    private List<Edge> adjacentEdges;
    private Vertex previous;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void setAdjacentEdges(List<Edge> adjacentEdges) {
        this.adjacentEdges = adjacentEdges;
    }

    /**
     * Default constructor with the given parameters.
     *
     * @param name, the label name given to the vertex.
     * @param x,    lat coordinate.
     * @param y,    lon coordinate.
     */
    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.adjacentEdges = new ArrayList<>();
        this.previous = null;
    }

}
