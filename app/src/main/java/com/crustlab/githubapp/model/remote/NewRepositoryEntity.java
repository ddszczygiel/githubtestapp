package com.crustlab.githubapp.model.remote;

import com.google.gson.annotations.SerializedName;

public class
NewRepositoryEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("private")
    private Boolean _private;

    @SerializedName("has_issues")
    private Boolean hasIssues;

    @SerializedName("has_wiki")
    private Boolean hasWiki;

    @SerializedName("has_downloads")
    private Boolean hasDownloads;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }
}