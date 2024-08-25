package com.loadbalancer.io;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinStrategy implements LoadBalancingStrategy{
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    @Override
    public String selectInstance(List<String> backendInstances) {
        if (backendInstances.isEmpty()) {
            throw new IllegalStateException("No backend instances available");
        }
        int index = currentIndex.getAndUpdate(i -> (i + 1) % backendInstances.size());
        return backendInstances.get(index);
    }
}
