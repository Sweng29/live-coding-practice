package com.loadbalancer.io;
public class LoadBalancerMain {
    public static void main(String[] args) {
        // Random Strategy
        LoadBalancer randomLoadBalancer = new LoadBalancer(new RandomStrategy());
        randomLoadBalancer.registerBackendInstance("http://backend1.com");
        randomLoadBalancer.registerBackendInstance("http://backend2.com");
        randomLoadBalancer.registerBackendInstance("http://backend3.com");

        System.out.println("Using Random Strategy:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Request routed to: " + randomLoadBalancer.getInstance());
        }

        // Round Robin Strategy
        LoadBalancer roundRobinLoadBalancer = new LoadBalancer(new RoundRobinStrategy());
        roundRobinLoadBalancer.registerBackendInstance("http://backend1.com");
        roundRobinLoadBalancer.registerBackendInstance("http://backend2.com");
        roundRobinLoadBalancer.registerBackendInstance("http://backend3.com");

        System.out.println("Using Round Robin Strategy:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Request routed to: " + roundRobinLoadBalancer.getInstance());
        }
    }
}
