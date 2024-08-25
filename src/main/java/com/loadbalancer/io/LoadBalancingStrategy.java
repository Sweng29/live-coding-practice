package com.loadbalancer.io;

import java.util.List;

public interface LoadBalancingStrategy {
    String selectInstance(List<String> backendInstances);
}

