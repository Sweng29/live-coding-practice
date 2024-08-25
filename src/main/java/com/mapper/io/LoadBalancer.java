package com.mapper.io;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {
    // TODO: Have a register method
    String instructions = """
            Create a LoadBalancerTest class that has a method to register backend instances
            	Each backend instance address should be unique, it should not be possible to register the same address two times
            	Load balancer should accept up to 10 backend instances
            	The code should be production ready
            	The Loadbalancer will be released as a library
            """;

    private Map<String, String> instances = new ConcurrentHashMap<>(10);
    private int count;

    public LoadBalancer(){
        this.count = 1;
    }

    public String register(){
        if (instances.size() > 10)
            throw new InstanceOverFlowException("Can not have more than 10 instances");
        // Get unique id;
        // register it
        instances.put("mmm" + count, "instance " + count);
        count++;
        return "mm";
    }

    public String getInstance(){
        return instances.get("");
    }
}
