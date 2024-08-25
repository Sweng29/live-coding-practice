package com.loadbalancer.io;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements LoadBalancingStrategy {

    private final Random random = new Random();

    @Override
    public String selectInstance(List<String> backendInstances) {
        if (backendInstances.isEmpty()) {
            throw new IllegalStateException("No backend instances available");
        }
        int randomIndex = random.nextInt(backendInstances.size());
        return backendInstances.get(randomIndex);
    }
}
