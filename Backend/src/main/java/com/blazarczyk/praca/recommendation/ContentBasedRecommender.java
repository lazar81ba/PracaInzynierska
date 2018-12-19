package com.blazarczyk.praca.recommendation;

import com.blazarczyk.praca.model.databse.Project;
import com.blazarczyk.praca.model.databse.Tag;
import com.blazarczyk.praca.model.databse.User;
import com.blazarczyk.praca.repository.ProjectDAO;
import com.blazarczyk.praca.repository.TagDAO;
import com.blazarczyk.praca.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class ContentBasedRecommender {


    private ProjectDAO projectDAO;
    private UserDAO userDAO;
    private TagDAO tagDAO;

    private LinkedList<Project> projects;
    private LinkedList<Tag> tags;
    private LinkedList<User> users;
    private double[][] marks;
    private int[][] userProjectTable;
    private double[][] userProfiles;
    private int[] df;
    private double[] idf;
    private double[][] userPredictions;
    private int projectsSize;
    private int tagsSize;
    private int userSize;

    @Autowired
    public ContentBasedRecommender(ProjectDAO projectDAO, UserDAO userDAO, TagDAO tagDAO){
        this.projectDAO = projectDAO;
        this.userDAO = userDAO;
        this.tagDAO = tagDAO;
    }

    public List<Project> getUserRecommendation(String email){
        User userToRecommend = userDAO.findByEmail(email);
        double[] predictions = new double[projectsSize];
        int userIndex = users.indexOf(userToRecommend);
        for(int i=0; i<projectsSize;i++){
            predictions[i] = userPredictions[i][userIndex];
        }
        List<Project> response = new LinkedList<>();
        for(int i=0; i<predictions.length; i++){
            if(predictions[i] > 0.70){
                response.add(projects.get(i));
            }
        }
        return response;
    }

    public void prepareRecommendation() {
        projects = new LinkedList<>((Collection<? extends Project>) projectDAO.findAll());
        tags = new LinkedList<>((Collection<? extends Tag>) tagDAO.findAll());
        users = new LinkedList<>((Collection<? extends User>)  userDAO.findAll());
        projectsSize=projects.size();
        tagsSize=tags.size();
        userSize=users.size();
        marks = new double[projectsSize][tagsSize];
        userProjectTable = new int[projectsSize][userSize];
        userProfiles = new double [userSize][tagsSize];
        df = new int[tagsSize];
        idf = new double[tagsSize];
        userPredictions = new double[projectsSize][userSize];
        prepareProjectMarks();
        prepareDFTable();
        prepareIDFTable();
        prepareUserProjectTable();
        prepareUserProfilesTable();
        prepareUserPedictions();
    }

    private double sumProduct(double[] idf, double[] userProfile, double[] projectMarks) {
        double result= 0;
        for(int i=0; i<idf.length; i++){
            result += (idf[i]* userProfile[i] * projectMarks[i]);
        }
        return result;
    }

    private void prepareProjectMarks() {
        int i;
        int j;
        for(Project project : projects){
            i=projects.indexOf(project);
            for(Tag tag: tags){
                j=tags.indexOf(tag);
                if(project.getTags().contains(tag)){
                    marks[i][j] = (double)1/Math.sqrt(project.getTags().size());
                }
                else {
                    marks[i][j]=0;
                }
            }
        }
    }

    private void prepareDFTable() {
        for(int tagIndex=0; tagIndex<tagsSize; tagIndex++){
            int result=0;
            for(int projectIndex=0; projectIndex<projectsSize; projectIndex++){
                if(marks[projectIndex][tagIndex] != 0){
                    result++;
                }
            }
            df[tagIndex] = result;
        }
    }

    private void prepareIDFTable() {
        for(int tagIndex=0; tagIndex<tagsSize; tagIndex++){
            if(df[tagIndex]!=0) {
                double test= (double)projectsSize / (double)df[tagIndex];
                idf[tagIndex] = Math.log10(test);
            } else {
                idf[tagIndex] = 0;
            }
        }
    }

    private void prepareUserProjectTable() {
        int i;
        int j;
        for(Project project : projects) {
            i=projects.indexOf(project);
            for (User user : users) {
                j=users.indexOf(user);
                if (user.getObservedProjects().contains(project)) {
                    userProjectTable[i][j] = 1;
                } else {
                    userProjectTable[i][j] = 0;
                }
            }
        }
    }

    private void prepareUserProfilesTable() {
        for(int tagIndex=0; tagIndex<tagsSize; tagIndex++){
            for(int userIndex=0; userIndex<userSize; userIndex++){
                double result=0;
                for(int projectIndex=0; projectIndex<projectsSize; projectIndex++){
                    if(userProjectTable[projectIndex][userIndex] != 0){
                        result += ((double)userProjectTable[projectIndex][userIndex]) * marks[projectIndex][tagIndex];
                    }
                }
                userProfiles[userIndex][tagIndex] = result;
            }
        }
    }

    private void prepareUserPedictions() {
        for(int userIndex=0; userIndex<userSize; userIndex++){
            for(int projectIndex=0; projectIndex< projectsSize; projectIndex++){
                userPredictions[projectIndex][userIndex] = sumProduct(idf,userProfiles[userIndex],marks[projectIndex]);
            }
        }
    }
}
