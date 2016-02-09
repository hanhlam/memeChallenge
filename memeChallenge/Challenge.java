package memeChallenge;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Challenge {

	   public static void main(String[] args) {
		   	JSONParser parser = new JSONParser();
		
		   	
	        try {     
	        	List<String> sortTitles = new ArrayList<String>();
	        	String title = "";
	        	
	        	
	            Object obj = parser.parse(new FileReader("memes.json"));
	            JSONObject jsonObject = (JSONObject) obj;
	 
	            JSONArray memeList = (JSONArray) jsonObject.get("memes");

	            JSONObject meme = null;
	            for(int i=0; i<memeList.size();i++){
	            	meme = (JSONObject)memeList.get(i);
	            	title = (String)meme.get("title");
	            	sortTitles.add(title);
	            }
	            
	           	            
            Collections.sort(sortTitles);
            	System.out.println("The memes sorted by titles in ascending order.");
				System.out.println(sortTitles);
	        }
			
			catch(Exception e){
				if(e instanceof ParseException){
					System.out.println("json file formatted incorrectly");
				}
				else{
					System.out.println("File not found");
				}
			}
				
	        
	   }
	   
	   public void sortMemes(){
		   
		   
	   }
}
			