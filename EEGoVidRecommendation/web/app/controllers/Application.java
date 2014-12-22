package controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

//import com.eegovid.net.recommendation.EEGVideoEvaluator;

import models.Videos;
import play.*;
import play.mvc.*;
import play.db.ebean.*;

import views.html.*;

public class Application extends Controller {

    public static Result upload() {
        return ok(upload.render());
    }
    
    public static Result lobby()
    {
		// Get videos 
    	ArrayList<String> theList = new ArrayList<String>();
        List<models.Videos> videos = new Model.Finder(Long.class, models.Videos.class).all();
        //System.out.println("Got Here 1");
       // System.out.println("Got Here 1");
        ArrayList<ArrayList<String>> superList = new ArrayList<ArrayList<String>>();
        try{
	        File thePath = Play.application().getFile("/conf/ratings.csv");
	        DataModel dataModel = InterestLevelDataModel.generateDataModel(1, thePath);
			//System.out.println("Extracted the File");
			theList = EEGVideoEvaluator.runUserBasedRecommender(dataModel);
	        //theList = EEGVideoEvaluator.main(tempHolder);
			
			for(int i=0; i< theList.size()-2; i++){
				//System.out.println("The Array at: "+i);
				String tempString[] = theList.get(i).split(",");
				ArrayList tempList = new ArrayList<String>();
				for(int j=0; j<tempString.length; j++){
					//System.out.println("The inside array at: "+i+" "+j);
					tempList.add(tempString[j]);
				}
				superList.add(tempList);
			}
        }
      
        catch (Exception e){
        	System.out.println(Play.application().path().getAbsolutePath());
        }
        String jsonname="System.out.println(Play.application().path().getAbsolutePath())"+"/tmp/rating.json";
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        ArrayList<String>tempList = new ArrayList<String>();
        boolean found = false;
        for (int i = 0; i < superList.size(); i++){
        	found = false;
        	String tempString = superList.get(i).get(1);
        	for (int j = 0; j< tempList.size(); j++){
        		if(tempList.get(j).equalsIgnoreCase(superList.get(i).get(1)))
        		{
        			found=true;
        		}
        	}
        	if(found == false){
        		tempList.add(superList.get(i).get(1));
        	}
        }
        ArrayList<String> indexer = new ArrayList<String>();
       // System.out.println(tempList.toString());
        JSONArray jsonArray2 = new JSONArray();
        for (int i = 0; i < tempList.size(); i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("name", tempList.get(i));
            formDetailsJson.put("group", 3);
            indexer.add(tempList.get(i));
            jsonArray2.add(formDetailsJson);
        }
        for (int i = 0; i < superList.size(); i++){
        	 JSONObject formDetailsJson = new JSONObject();
             formDetailsJson.put("name", superList.get(i).get(0));
             formDetailsJson.put("group", 1);
             indexer.add(superList.get(i).get(0));
             jsonArray2.add(formDetailsJson);
        }
        for (int i = 0; i < superList.size(); i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("source", i);
            int finder = 0;
            for(int j=0; j< indexer.size(); j++){
            	if(superList.get(i).get(1).equalsIgnoreCase(indexer.get(j))){
            		finder=j;
            	}
            }
            formDetailsJson.put("target", finder);
            formDetailsJson.put("value", (int)Double.parseDouble(superList.get(i).get(2)));
           
            jsonArray.add(formDetailsJson);
        }
        responseDetailsJson.put("nodes", jsonArray2);
        responseDetailsJson.put("links", jsonArray);
        
    	try {
     
    		FileWriter file = new FileWriter("jsonname");
    		file.write(responseDetailsJson.toJSONString());
    		file.flush();
    		file.close();
     
    	} catch (Exception e) {
    		System.out.println("COULD NOT WRITE FILE");
    	}
     
    	
    	return ok(lobby.render(videos, superList, jsonname));
    }
    public static Result lobby2(String fname)
    {
		// Get videos 
    	ArrayList<String> theList = new ArrayList<String>();
        List<models.Videos> videos = new Model.Finder(Long.class, models.Videos.class).all();
        //System.out.println("Got Here 1");
       // System.out.println("Got Here 1");
        ArrayList<ArrayList<String>> superList = new ArrayList<ArrayList<String>>();
        
        try{
	        File thePath = Play.application().getFile("/conf/"+fname+".csv");
	        DataModel dataModel = InterestLevelDataModel.generateDataModel(1, thePath);
			//System.out.println("Extracted the File");
			theList = EEGVideoEvaluator.runUserBasedRecommender(dataModel);
	        //theList = EEGVideoEvaluator.main(tempHolder);
			
			for(int i=0; i< theList.size()-2; i++){
				//System.out.println("The Array at: "+i);
				String tempString[] = theList.get(i).split(",");
				ArrayList tempList = new ArrayList<String>();
				for(int j=0; j<tempString.length; j++){
					//System.out.println("The inside array at: "+i+" "+j);
					tempList.add(tempString[j]);
				}
				superList.add(tempList);
			}
			
        }
      
        catch (Exception e){
        	System.out.println(Play.application().path().getAbsolutePath());
        }
        String jsonname="System.out.println(Play.application().path().getAbsolutePath())"+"/tmp/rating.json";
        
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        ArrayList<String>tempList = new ArrayList<String>();
        boolean found = false;
        for (int i = 0; i < superList.size(); i++){
        	found = false;
        	String tempString = superList.get(i).get(1);
        	for (int j = 0; j< tempList.size(); j++){
        		if(tempList.get(j).equalsIgnoreCase(superList.get(i).get(1)))
        		{
        			found=true;
        		}
        	}
        	if(found == false){
        		tempList.add(superList.get(i).get(1));
        	}
        }
        ArrayList<String> indexer = new ArrayList<String>();
        //System.out.println(tempList.toString());
        JSONArray jsonArray2 = new JSONArray();
        for (int i = 0; i < tempList.size(); i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("name", tempList.get(i));
            formDetailsJson.put("group", 3);
            indexer.add(tempList.get(i));
            jsonArray2.add(formDetailsJson);
        }
        for (int i = 0; i < superList.size(); i++){
        	 JSONObject formDetailsJson = new JSONObject();
             formDetailsJson.put("name", superList.get(i).get(0));
             formDetailsJson.put("group", 1);
             indexer.add(superList.get(i).get(0));
             jsonArray2.add(formDetailsJson);
        }
        for (int i = 0; i < superList.size(); i++) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("source", i);
            int finder = 0;
            for(int j=0; j< indexer.size(); j++){
            	if(superList.get(i).get(1).equalsIgnoreCase(indexer.get(j))){
            		finder=j;
            	}
            }
            formDetailsJson.put("target", finder);
            formDetailsJson.put("value", (int)Double.parseDouble(superList.get(i).get(2)));
           
            jsonArray.add(formDetailsJson);
        }
        responseDetailsJson.put("nodes", jsonArray2);
        responseDetailsJson.put("links", jsonArray);
        /*
    	JSONObject obj = new JSONObject();
    	obj.put("name", "mkyong.com");
    	obj.put("age", new Integer(100));
     
    	JSONArray list = new JSONArray();
    	list.add("msg 1");
    	list.add("msg 2");
    	list.add("msg 3");
     
    	obj.put("messages", list);
         */
    	try {
     
    		FileWriter file = new FileWriter(jsonname);
    		file.write(responseDetailsJson.toJSONString());
    		file.flush();
    		file.close();
     
    	} catch (Exception e) {
    		System.out.println("COULD NOT WRITE FILE");
    	}
     
    	//System.out.print(responseDetailsJson);
        
    	return ok(lobby.render(videos, superList, jsonname));

    }
    public static Result go(long videoID)
    {
		// Get video 
    	models.Videos theVideo = Videos.find.where().eq("id", videoID).findUnique();
		/*try{
	        File thePath = Play.application().getFile("/public/ratings3.csv");
	        DataModel dataModel = InterestLevelDataModel.generateDataModel(1, thePath);
			System.out.println("Got Here 1");
			theList = EEGVideoEvaluator.runUserBasedRecommender(dataModel);
	        //theList = EEGVideoEvaluator.main(tempHolder);
			TestMashApp.main(null);
        }
		
        catch (Exception e){
        	System.out.println(Play.application().path().getAbsolutePath());
        }
        */
    		String extractedImage = Long.toString(theVideo.id)+"img1.jpg";
        	return ok(videopage.render(theVideo, extractedImage));
    }
    public static Result extractFeature(long videoID)
    {
		// Get video 
    	models.Videos theVideo = Videos.find.where().eq("id", videoID).findUnique();
		/*try{
	        File thePath = Play.application().getFile("/public/ratings3.csv");
	        DataModel dataModel = InterestLevelDataModel.generateDataModel(1, thePath);
			System.out.println("Got Here 1");
			theList = EEGVideoEvaluator.runUserBasedRecommender(dataModel);
	        //theList = EEGVideoEvaluator.main(tempHolder);
			TestMashApp.main(null);
        }
		
        catch (Exception e){
        	System.out.println(Play.application().path().getAbsolutePath());
        }
        */
    	String theFeature = theVideo.feature;
    	
    	if(theVideo.feature.equalsIgnoreCase("") && !theVideo.featureImage.equalsIgnoreCase("noimage")){
    		
    		System.out.println("FEATURE BLANK");
    		String arg1[] = {""};
    		arg1[0]=Long.toString(theVideo.id);
    		theFeature = TestMashApp.main(arg1).trim();
    		//theVideo.feature=theFeature;
    		theVideo.setFeature(theFeature);
    		theVideo.update();
    		//theVideo.save();
    		/*
    		YouTubeService service = new YouTubeService(clientID, "");
    		YouTubeQuery query = new YouTubeQuery(new URL("http://gdata.youtube.com/feeds/api/videos"));
    		// order results by the number of views (most viewed first)
    		query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);

    		// search for puppies and include restricted content in the search results
    		query.setFullTextQuery("puppy");
    		query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);

    		VideoFeed videoFeed = service.query(query, VideoFeed.class);
    		printVideoFeed(videoFeed, true);
    		*/
    		
    	}
    	theVideo.update();
		theVideo.save();
    	String newString = theFeature.replaceAll(" ", "+");
    	String newString2 = "https://www.youtube.com/results?search_query="+newString;
    	if(theVideo.featureImage.equalsIgnoreCase("noimage") || theVideo.featureImage==null){
    		theFeature="There is no EEG data for this videop";
    	}
    	String extractedImage = Long.toString(theVideo.id)+"img1.jpg";
    	return ok(videopage2.render(theVideo, theFeature, newString2, extractedImage));
    }
}
