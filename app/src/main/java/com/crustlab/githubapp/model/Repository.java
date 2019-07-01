package com.crustlab.githubapp.model;

public class Repository {

    private final String name;
    private final String owner;
    private final String url;
    private final String created;

    public Repository(String name, String owner, String url, String created) {
        this.name = name;
        this.owner = owner;
        this.url = url;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
