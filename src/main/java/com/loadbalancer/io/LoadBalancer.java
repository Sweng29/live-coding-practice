package com.loadbalancer.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LoadBalancer class that manages backend instances and delegates instance
 * selection to the provided strategy.
 */
public class LoadBalancer {

    private static final int MAX_INSTANCES = 10;
    private final Set<String> backendInstances;  // Encapsulate uniqueness logic
    private final List<String> backendInstanceList;  // Read-only access provided to strategies
    private final LoadBalancingStrategy strategy;  // Strategy for instance selection

    /**
     * Constructs a LoadBalancer with the provided load balancing strategy.
     *
     * @param strategy The load balancing strategy to use for instance selection.
     */
    public LoadBalancer(LoadBalancingStrategy strategy) {
        this.backendInstances = new HashSet<>();
        this.backendInstanceList = new ArrayList<>();
        this.strategy = strategy;
    }

    /**
     * Registers a unique backend instance. Throws exceptions if the maximum number
     * of instances is reached or if the instance is already registered.
     *
     * @param address The address of the backend instance.
     * @throws IllegalStateException If more than 10 instances are registered.
     * @throws IllegalArgumentException If the instance address is already registered.
     */
    public void registerBackendInstance(String address) {
        if (backendInstances.size() >= MAX_INSTANCES) {
            throw new IllegalStateException("Cannot register more than " + MAX_INSTANCES + " backend instances.");
        }

        if (!backendInstances.add(address)) {  // Ensures uniqueness
            throw new IllegalArgumentException("Backend instance address is already registered: " + address);
        }

        backendInstanceList.add(address);  // Maintain the list for strategy use
    }

    /**
     * Retrieves a backend instance using the configured strategy.
     *
     * @return The address of a selected backend instance.
     */
    public String getInstance() {
        return strategy.selectInstance(backendInstanceList);
    }

    /**
     * Returns an unmodifiable list of registered backend instances for viewing purposes.
     *
     * @return Unmodifiable list of registered backend instances.
     */
    public List<String> getRegisteredInstances() {
        return Collections.unmodifiableList(backendInstanceList);
    }
}
