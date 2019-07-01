package com.crustlab.githubapp.model.remote;

import com.google.gson.annotations.SerializedName;

public class RepositoryEntity {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("owner")
    private UserEntity owner;

    @SerializedName("private")
    private Boolean _private;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("fork")
    private Boolean fork;

    @SerializedName("url")
    private String url;

    @SerializedName("forks_url")
    private String forksUrl;

    @SerializedName("keys_url")
    private String keysUrl;

    @SerializedName("collaborators_url")
    private String collaboratorsUrl;

    @SerializedName("teams_url")
    private String teamsUrl;

    @SerializedName("hooks_url")
    private String hooksUrl;

    @SerializedName("issue_events_url")
    private String issueEventsUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("assignees_url")
    private String assigneesUrl;

    @SerializedName("branches_url")
    private String branchesUrl;

    @SerializedName("tags_url")
    private String tagsUrl;

    @SerializedName("blobs_url")
    private String blobsUrl;

    @SerializedName("git_tags_url")
    private String gitTagsUrl;

    @SerializedName("git_refs_url")
    private String gitRefsUrl;

    @SerializedName("trees_url")
    private String treesUrl;

    @SerializedName("statuses_url")
    private String statusesUrl;

    @SerializedName("languages_url")
    private String languagesUrl;

    @SerializedName("stargazers_url")
    private String stargazersUrl;

    @SerializedName("contributors_url")
    private String contributorsUrl;

    @SerializedName("subscribers_url")
    private String subscribersUrl;

    @SerializedName("subscription_url")
    private String subscriptionUrl;

    @SerializedName("commits_url")
    private String commitsUrl;

    @SerializedName("git_commits_url")
    private String gitCommitsUrl;

    @SerializedName("comments_url")
    private String commentsUrl;

    @SerializedName("issue_comment_url")
    private String issueCommentUrl;

    @SerializedName("contents_url")
    private String contentsUrl;

    @SerializedName("compare_url")
    private String compareUrl;

    @SerializedName("merges_url")
    private String mergesUrl;

    @SerializedName("archive_url")
    private String archiveUrl;

    @SerializedName("downloads_url")
    private String downloadsUrl;

    @SerializedName("issues_url")
    private String issuesUrl;

    @SerializedName("pulls_url")
    private String pullsUrl;

    @SerializedName("milestones_url")
    private String milestonesUrl;

    @SerializedName("notifications_url")
    private String notificationsUrl;

    @SerializedName("labels_url")
    private String labelsUrl;

    @SerializedName("releases_url")
    private String releasesUrl;

    @SerializedName("deployments_url")
    private String deploymentsUrl;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("pushed_at")
    private String pushedAt;

    @SerializedName("git_url")
    private String gitUrl;

    @SerializedName("ssh_url")
    private String sshUrl;

    @SerializedName("clone_url")
    private String cloneUrl;

    @SerializedName("svn_url")
    private String svnUrl;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("size")
    private Integer size;

    @SerializedName("stargazers_count")
    private Integer stargazersCount;

    @SerializedName("watchers_count")
    private Integer watchersCount;

    @SerializedName("language")
    private String language;

    @SerializedName("has_issues")
    private Boolean hasIssues;

    @SerializedName("has_downloads")
    private Boolean hasDownloads;

    @SerializedName("has_wiki")
    private Boolean hasWiki;

    @SerializedName("has_pages")
    private Boolean hasPages;

    @SerializedName("forks_count")
    private Integer forksCount;

    @SerializedName("mirror_url")
    private String mirrorUrl;

    @SerializedName("open_issues_count")
    private Integer openIssuesCount;

    @SerializedName("forks")
    private Integer forks;

    @SerializedName("open_issues")
    private Integer openIssues;

    @SerializedName("watchers")
    private Integer watchers;

    @SerializedName("default_branch")
    private String defaultBranch;

    @SerializedName("score")
    private Double score;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public Boolean get_private() {
        return _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFork() {
        return fork;
    }

    public String getUrl() {
        return url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public Integer getWatchersCount() {
        return watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public Boolean getHasPages() {
        return hasPages;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public String getMirrorUrl() {
        return mirrorUrl;
    }

    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    public Integer getForks() {
        return forks;
    }

    public Integer getOpenIssues() {
        return openIssues;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public Double getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public void set_private(Boolean _private) {
        this._private = _private;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public void setHasPages(Boolean hasPages) {
        this.hasPages = hasPages;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public void setOpenIssues(Integer openIssues) {
        this.openIssues = openIssues;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
