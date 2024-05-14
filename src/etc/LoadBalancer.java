package etc;

import java.util.*;

public class LoadBalancer {
    private int serverCount;
    private boolean sticky;
    private Map<Integer, Integer> stickyMap;
    private int roundRobinIndex;
    private Map<Integer, List<Integer>> serverRequests;

    public LoadBalancer(int serverCount, boolean sticky) {
        this.serverCount = serverCount;
        this.sticky = sticky;
        this.stickyMap = new HashMap<>();
        this.roundRobinIndex = 0;
        this.serverRequests = new HashMap<>();
        for (int i = 0; i < serverCount; i++) {
            serverRequests.put(i, new ArrayList<>());
        }
    }

    public void distributeRequests(int[] requests) {
        for (int request : requests) {
            int server = getNextServer(request);
            serverRequests.get(server).add(request);
        }
    }

    private int getNextServer(int request) {
        if (sticky) {
            return getStickyServer(request);
        } else {
            return getRoundRobinServer();
        }
    }

    private int getStickyServer(int request) {
        return stickyMap.computeIfAbsent(request, k -> roundRobinIndex++ % serverCount);
    }

    private int getRoundRobinServer() {
        int server = roundRobinIndex % serverCount;
        roundRobinIndex++;
        return server;
    }

    public void printServerRequests() {
        for (int i = 0; i < serverCount; i++) {
            System.out.println("Server " + i + " received requests: " + serverRequests.get(i));
        }
    }

    public static void main(String[] args) {
        int[] requests = {1, 2, 2, 3, 4};
        int serverCount = 3;

        // Sticky = true인 경우
        LoadBalancer lbSticky = new LoadBalancer(serverCount, true);
        System.out.println("Sticky Load Balancing:");
        lbSticky.distributeRequests(requests);
        lbSticky.printServerRequests();

        // Sticky = false인 경우
        LoadBalancer lbRoundRobin = new LoadBalancer(serverCount, false);
        System.out.println("\nRound Robin Load Balancing:");
        lbRoundRobin.distributeRequests(requests);
        lbRoundRobin.printServerRequests();
    }
}
