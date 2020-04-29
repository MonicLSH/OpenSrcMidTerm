package ku.opensrcsw;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import midterm.problem2.RegularExpression;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	String keyword;
    	try {
			FileReader reader = new FileReader("midterm.json");
	    	JSONParser parser = new JSONParser();
	    	RegularExpression re = new RegularExpression();
	    	JSONObject object = (JSONObject) parser.parse(reader);
	    	JSONArray array = (JSONArray) object.get("poem");
	    	System.out.print("Enter the keyword you are looking for : ");
			keyword = scan.next();
			for(int i = 0; i<array.size(); i++) {
				JSONObject arrayObj = (JSONObject) array.get(i);
				if(re.check(array.get(i).toString(), keyword)) {
					System.out.println("item "+i+" : "+arrayObj.values());
				}else {
					continue;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
