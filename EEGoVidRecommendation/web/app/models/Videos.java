package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class Videos extends Model{

    @Id
    public Long id;
    public String name;
    public float length;
    public String coverImage;
    public String featureImage;
    public String feature;
    
    public static Model.Finder<Long, Videos> find = new Model.Finder(Long.class, Videos.class);

    public Videos(Long id, String name, float length, String coverImage){
        
        this.id=id;
    	this.name = name;
        this.length = length;
        this.coverImage = coverImage;
        this.featureImage="";
        this.feature="";
    }
 public Videos(int id, String name, float length, String coverImage){
        
        this.id=(long)id;
    	this.name = name;
        this.length = length;
        this.coverImage = coverImage;
        this.featureImage="";
        this.feature="";
    }
 
 public Videos(int id, String name, float length, String coverImage, String feature){
     
     this.id=(long)id;
 	this.name = name;
     this.length = length;
     this.coverImage = coverImage;
     this.featureImage="";
     this.feature=feature;
 }
 public void setFeature(String theFeature){
	 this.feature=theFeature;
 }
}