package com.safebear.auto;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Simon Stratton
 */


public class Tool {

    private long id;
    private String name;
    private String use;
    private String website;
    private static final AtomicLong counter = new AtomicLong(100);

    public Tool(String name, String use, String website, long id) {
        this.name = name;
        this.use = use;
        this.website = website;
        this.id = id;
    }
    
    public Tool(String name, String use, String website) {
        this.name = name;
        this.use = use;
        this.website = website;
        this.id = counter.incrementAndGet();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Tool{" + "id=" + id + ", name=" + name +
                ", use=" + use +
                ", website=" + website + '}';
    }

    
}
