package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


/**
 * @author Mohamed El-Refaey
 *
 */

public class TestMashApp {


	public static String main(String[] args)  {

		
		String imageFeatures = "";
		try {

			String imageUrl = "http://eegovid.herokuapp.com/assets/images/"+args[0]+"img1.jpg";

			HttpResponse<JsonNode> response = imageRequest(imageUrl);
			System.out.println(response.getBody());
			String token = response.getBody().getArray().getJSONObject(0)
					.getString("token");
			System.out.println("token is " + token);
			try{
				Thread.sleep(28000);
			}
			catch(Exception e){}
			imageFeatures = imageFeatureResponse(token);
			System.out.println("The image Feature is: " + imageFeatures);

			Unirest.shutdown();

		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageFeatures;

	}

	public static HttpResponse<JsonNode> imageRequest(String imageUrl)
			throws UnirestException {
		HttpResponse<JsonNode> response = Unirest
				.post("https://camfind.p.mashape.com/image_requests")
				.header("X-Mashape-Key",
						"dLXa5hKfXEmshN5QS1kHNaVfLYz6p1Bvq75jsn5tYpxBdkdr6L")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.field("focus[x]", "480").field("focus[y]", "640")
				.field("image_request[altitude]", "27.912109375")
				.field("image_request[language]", "en")
				.field("image_request[latitude]", "35.8714220766008")
				.field("image_request[locale]", "en_US")
				.field("image_request[longitude]", "14.3583203002251")
				.field("image_request[remote_image_url]", imageUrl).asJson();
		return response;
	}

	public static String imageFeatureResponse(String token)
			throws UnirestException {
		// String token = "VC-pOWGX8A2f_17pm_Affg";
		String url = "https://camfind.p.mashape.com/image_responses/" + token;
		String features = "";

		HttpResponse<JsonNode> response = Unirest
				.get(url)
				.header("X-Mashape-Key",
						"dLXa5hKfXEmshN5QS1kHNaVfLYz6p1Bvq75jsn5tYpxBdkdr6L")
				.asJson();

		System.out.println("inside the feature response and the response is "
				+ response.getBody().getArray().getJSONObject(0).getString("status"));

		System.out.println("Checking if the response completed ");
		// to handle the delay between request and response
		//while (true) {
			//try{
			//Thread.sleep(5000);
		///	}
			//catch(Exception e)
			//{
			//}
			if (response.getBody().getArray().getJSONObject(0).has("name")) {
				System.out.println("it has name");
				features = response.getBody().getArray().getJSONObject(0)
						.getString("name");
				return features;
			}
			else System.out.println("inside the feature response and the response is "
					+ response.getBody().getArray().getJSONObject(0).getString("status"));

		//}

			return features;
	}

}


