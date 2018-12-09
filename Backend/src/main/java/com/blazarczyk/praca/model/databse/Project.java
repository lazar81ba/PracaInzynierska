package com.blazarczyk.praca.model.databse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "project", schema = "public")
public class Project {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column(name="image_url")
    private String imageURL;
    @Column(name = "public")
    private boolean publicProject;

    @OneToMany(mappedBy = "project")
    private Set<ProjectDetail> projectDetails;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "project_link",
            joinColumns = { @JoinColumn(name = "id_project") },
            inverseJoinColumns = { @JoinColumn(name = "id_link") }
    )
    private Set<Link> links;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "project_tag",
            joinColumns = { @JoinColumn(name = "id_project") },
            inverseJoinColumns = { @JoinColumn(name = "id_tag") }
    )
    private Set<Tag> tags;

    @ManyToMany(mappedBy = "participatedProjects")
    private Set<User> projectParticipants;

    @ManyToMany(mappedBy = "observedProjects")
    private Set<User> usersWhichObserveProject;

    public void removeTag(Tag tag){
        if(tags.contains(tag)) {
            tags.remove(tag);
        }
    }

    public void addTag(Tag tag){
        if(!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isPublicProject() {
        return publicProject;
    }

    public void setPublicProject(boolean publicProject) {
        this.publicProject = publicProject;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<User> getProjectParticipants() {
        return projectParticipants;
    }

    public void setProjectParticipants(Set<User> projectParticipants) {
        this.projectParticipants = projectParticipants;
    }

    public Set<User> getUsersWhichObserveProject() {
        return usersWhichObserveProject;
    }

    public void setUsersWhichObserveProject(Set<User> usersWhichObserveProject) {
        this.usersWhichObserveProject = usersWhichObserveProject;
    }

    public Set<ProjectDetail> getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(Set<ProjectDetail> projectDetails) {
        this.projectDetails = projectDetails;
    }
}
