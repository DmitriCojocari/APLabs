package optional.lab3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Set<Location> nodes = new HashSet<>();

    public void addLocation(Location locationA) {
        nodes.add(locationA);
    }

    public Set<Location> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Location> nodes) {
        this.nodes = nodes;
    }

    private static Location getLowestDistanceLocation(Set<Location> unsettledNodes) {
        Location lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Location location : unsettledNodes) {
            int locationDistance = location.getDistance();
            if (locationDistance < lowestDistance) {
                lowestDistance = locationDistance;
                lowestDistanceNode = location;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Location evaluationNode,
                                                 Integer edgeWeigh, Location sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Location> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Location source) {
        source.setDistance(0);

        Set<Location> settledNodes = new HashSet<>();
        Set<Location> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Location currentNode = getLowestDistanceLocation(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Location, Integer> adjacencyPair : currentNode.getRequiredTimes().entrySet()) {
                Location adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}