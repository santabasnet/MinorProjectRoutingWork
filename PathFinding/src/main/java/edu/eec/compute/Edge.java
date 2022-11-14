package edu.eec.compute;

import edu.eec.pathwork.Literals;

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
public class Edge {

    private final double distance;
    private final Vertex from;
    private final Vertex to;

    public Edge(Vertex from, Vertex to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return Literals.gsonPretty.toJson(this);
    }
}
