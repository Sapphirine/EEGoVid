
import play.*;
import play.libs.*;

import com.avaje.ebean.Ebean;

import models.*;

import java.util.*;

public class Global extends GlobalSettings {
  
   // Initializes some tables and users to play the game.
    
    @Override
    public void onStart(Application app) {
/*

    		models.Videos tempVideo1 = new models.Videos(1,"Audi Big Game Commercial Doberhuahua", 60, "1.png");
    		models.Videos tempVideo2 = new models.Videos(2,"AXE PEACE Make Love Not War 30", 30, "2.png");
    		models.Videos tempVideo3 = new models.Videos(3,"Big Game Ad Starring Terry Crews and the Muppets Toyota Highlander", 62, "3.png");
    		models.Videos tempVideo4 = new models.Videos(4,"Bud Light Platinum Equalizer w Zedd Extended Version", 32, "4.png", "noimage");
    		models.Videos tempVideo5 = new models.Videos(5,"Budweiser Super Bowl XLVIII Commercial A Heros Welcome", 60, "5.png");
    		models.Videos tempVideo6 = new models.Videos(6,"Budweiser Super Bowl XLVIII Commercial Puppy Love", 60, "6.png");
    		models.Videos tempVideo7 = new models.Videos(7,"Butterfinger Cups Big Game Commercial 2014", 30, "7.png");
    		models.Videos tempVideo8 = new models.Videos(8,"Cheerios Game Day Ad Gracie", 30, "8.png");
    		models.Videos tempVideo9 = new models.Videos(9,"Chevy Super Bowl Commercial Life", 60, "9.png");
    		models.Videos tempVideo10 = new models.Videos(10,"Chevy Super Bowl Commercial Romance Silverado HD Chevrolet", 60, "10.png");
    		models.Videos tempVideo11 = new models.Videos(11,"Chobani Bear Game Day Commercial", 60, "11.png");
    		models.Videos tempVideo12 = new models.Videos(12,"Coca Cola Going All The Way Official 60", 60, "12.png");
    		models.Videos tempVideo13 = new models.Videos(13,"Coca Cola Its Beautiful Official 60", 60, "13.png");
    		models.Videos tempVideo14 = new models.Videos(14,"Cool Twist Super Bowl XLVIII Commercial Bud Light", 32, "14.png");
    		models.Videos tempVideo15 = new models.Videos(15,"Cowboy Kid", 30, "15.png");
    		models.Videos tempVideo16 = new models.Videos(16,"Dannon Oikos Greek Yogurt The Spill", 30, "16.png");
    		models.Videos tempVideo17 = new models.Videos(17,"David Beckham for H", 30, "17.png");
    		models.Videos tempVideo18 = new models.Videos(18,"Delivery M", 45, "18.png");
    		models.Videos tempVideo19 = new models.Videos(19,"Doritos Time Machine Crash the Super Bowl Top Finalist", 30, "19.png");
    		models.Videos tempVideo20 = new models.Videos(20,"Duracell Trust Your Power NFLs Derrick Coleman Seattle Seahawks", 60, "20.png", "noimage");
    		
    		models.Videos tempVideo21 = new models.Videos(21,"Ellen Features in The Right Music for Beats Music and AT", 62, "21.png");
    		models.Videos tempVideo22 = new models.Videos(22,"Ford Nearly Double Big Game Ad Rob Riggle", 90, "22.png");
    		models.Videos tempVideo23 = new models.Videos(23,"GEICO DMV Commercial Maxwell", 15, "23.png");
    		models.Videos tempVideo24 = new models.Videos(24,"GoDaddy Bodybuilder", 30, "24.png");
    		models.Videos tempVideo25 = new models.Videos(25,"GoDaddy Puppet Master", 30, "25.png");
    		models.Videos tempVideo26 = new models.Videos(26,"GoPro Red Bull Stratos Super Bowl Commercial 2014", 30, "26.png", "noimage");
    		models.Videos tempVideo27 = new models.Videos(27,"Grandmas House Enjoy Better Time Warner Cable", 60, "27.png", "noimage");
    		models.Videos tempVideo28 = new models.Videos(28,"Heinz Ketchup Big Game Commercial Hum", 30, "28.png");
    		models.Videos tempVideo29 = new models.Videos(29,"Honda Big Game", 67,"29.png");
    		models.Videos tempVideo30 = new models.Videos(30,"Hyundai Elantra Big Game Ad Nice", 31, "30.png");
    		models.Videos tempVideo31 = new models.Videos(31,"Hyundai Genesis Big Game Ad Dads Sixth Sense", 30, "31.png");
    		models.Videos tempVideo32 = new models.Videos(32,"Ian Up For Whatever TV Super Bowl XLVIII Commercial Bud Light", 61, "32.png");
    		models.Videos tempVideo33 = new models.Videos(33,"Introducing the Sprint Framily Plan", 30,"33.png");
    		models.Videos tempVideo34 = new models.Videos(34,"Intuit QuickBooks Presents GoldieBlox Come On Bring The Toys", 30, "34.png");
    		models.Videos tempVideo35 = new models.Videos(35,"Its Crunch Time", 30, "35.png");
    		models.Videos tempVideo36 = new models.Videos(36,"Jaguar Big Game Commercial British Villains Rendezvous Jaguar USA", 62, "36.png");
    		models.Videos tempVideo37 = new models.Videos(37,"Jeep Restless SUPER BOWL OFFICIAL COMMERCIAL", 60, "37.png");
    		models.Videos tempVideo38 = new models.Videos(38,"Jerry Ricecake Superbowl Commercial", 30, "38.png");
    		models.Videos tempVideo39 = new models.Videos(39,"Labatt Blue Big Game XLVIII Commercial Undomesticated Snowboarding", 30, "39.png", "noimage");
    		models.Videos tempVideo40 = new models.Videos(40,"Long Live Dreams atAmFam", 60, "40.png", "noimage");
    		models.Videos tempVideo41 = new models.Videos(41,"Love Hurts TurboTax Big Game Commercial", 60, "41.png");
    		models.Videos tempVideo42 = new models.Videos(42,"Microsoft Super Bowl Commercial Empowering", 60, "42.png");
    		models.Videos tempVideo43 = new models.Videos(43,"Need for Speed Movie Pulse Big Game Spot", 31, "43.png");
    		models.Videos tempVideo44 = new models.Videos(44,"Negotiator Rises Priceline Commercial", 31, "44.png", "noimage");
    		models.Videos tempVideo45 = new models.Videos(45,"OFFICIAL Chrysler and Bob Dylan Super Bowl Commercial Americas Import", 120, "45.png");
    		models.Videos tempVideo46 = new models.Videos(46,"Official Maserati Super Bowl Spot Ghibli Strike", 90, "46.png");
    		models.Videos tempVideo47 = new models.Videos(47,"Pepsi Super Bowl Pepsi", 32, "47.png");
    		models.Videos tempVideo48 = new models.Videos(48,"Pepsi There Since the First", 30, "48.png", "noimage");
    		models.Videos tempVideo49 = new models.Videos(49,"Slow Clap CarMax Big Game Commercial 2014", 31, "49.png");
    		models.Videos tempVideo50 = new models.Videos(50,"smart electric drive Offroading smart USA", 32, "50.png", "noimage");
    		models.Videos tempVideo51 = new models.Videos(51,"SONOS Face Off", 60, "51.png");
    		models.Videos tempVideo52 = new models.Videos(52,"Sorry Coke and Pepsi Uncensored", 32, "52.png");
    		models.Videos tempVideo53 = new models.Videos(53,"Squarespace A Better Web Awaits Big Game Commercial 30", 30, "53.png");
    		models.Videos tempVideo54 = new models.Videos(54,"The Amazing Spider Man Super Bowl Ad Part 2", 33, "54.png");
    		models.Videos tempVideo55 = new models.Videos(55,"The Phone Call RadioShack Commercial version", 30, "55.png");
    		models.Videos tempVideo56 = new models.Videos(56,"The Truth Official Kia KMorpheus Big Game Commercial 2014", 62, "56.png");
    		models.Videos tempVideo57 = new models.Videos(57,"Tim Tebow shows you what you can do with", 30, "57.png");
    		models.Videos tempVideo58 = new models.Videos(58,"Transformers Age of Extinction Big Game Spot", 33, "58.png");
    		models.Videos tempVideo59 = new models.Videos(59,"UInvisible Bank of America in support of RED", 60, "59.png");
    		models.Videos tempVideo60 = new models.Videos(60,"Volkswagen Game Day Commercial Wings", 60, "60.png");
    		models.Videos tempVideo61 = new models.Videos(61,"WeatherTech You Cant Do That Big Game Commercial", 31, "61.png");
    		models.Videos tempVideo62 = new models.Videos(62,"We Killed the Long Term Contract T Mobile Commercial", 30, "62.png");
    		models.Videos tempVideo63 = new models.Videos(63,"What can you do with", 30, "63.png");
    		models.Videos tempVideo64 = new models.Videos(64,"Wonderful Pistachios Stephen Colbert Super Bowl Commercial Part 1", 15, "64.png");
    		models.Videos tempVideo65 = new models.Videos(65,"Wonderful Pistachios Stephen Colbert Super Bowl Commercial Part 2", 15, "65.png");
    		
    		
    		tempVideo1.save();
    		tempVideo2.save();
    		tempVideo3.save();
    		tempVideo4.save();
    		tempVideo5.save();
    		tempVideo6.save();
    		tempVideo7.save();
    		tempVideo8.save();
    		tempVideo9.save();
    		tempVideo10.save();
    		tempVideo11.save();
    		tempVideo12.save();
    		tempVideo13.save();
    		tempVideo14.save();
    		tempVideo15.save();
    		tempVideo16.save();
    		tempVideo17.save();
    		tempVideo18.save();
    		tempVideo19.save();
    		tempVideo20.save();
    		tempVideo21.save();
    		tempVideo22.save();
    		tempVideo23.save();
    		tempVideo24.save();
    		tempVideo25.save();
    		tempVideo26.save();
    		tempVideo27.save();
    		tempVideo28.save();
    		tempVideo29.save();
    		tempVideo30.save();
    		tempVideo31.save();
    		tempVideo32.save();
    		tempVideo33.save();
    		tempVideo34.save();
    		tempVideo35.save();
    		tempVideo36.save();
    		tempVideo37.save();
    		tempVideo38.save();
    		tempVideo39.save();
    		tempVideo40.save();
    		tempVideo41.save();
    		tempVideo42.save();
    		tempVideo43.save();
    		tempVideo44.save();
    		tempVideo45.save();
    		tempVideo46.save();
    		tempVideo47.save();
    		tempVideo48.save();
    		tempVideo49.save();
    		tempVideo50.save();
    		tempVideo51.save();
    		tempVideo52.save();
    		tempVideo53.save();
    		tempVideo54.save();
    		tempVideo55.save();
    		tempVideo56.save();
    		tempVideo57.save();
    		tempVideo58.save();
    		tempVideo59.save();
    		tempVideo60.save();
    		tempVideo61.save();
    		tempVideo62.save();
    		tempVideo63.save();
    		tempVideo64.save();
    		tempVideo65.save();
    	
    		
    		*/
    		
    		
    		
    		/*
    	//long someLong = 3;
    	//List<models.Videos> infoList = Videos.find.where().eq("id", 1).findList();
    	//	if (infoList == null){
    			models.Videos tempVideo = new models.Videos("Video number"+i, 35, "Someimage.jpg");
    			tempVideo.save();
    			models.Videos tempVideo2 = new models.Videos("First Video", 60, "Someimage.jpg");
    			tempVideo2.save();
    		
    	//}*/
    
    }
}

