package View;

/*
 java code for getting data from webservice and view in table format in View_item.jsp page
 */
/**
 *
 * @author Administrator
 */
import Model.Item;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViewItem {

    String res;

    //method shows details of all the items
    public ArrayList<Item> getAllItems() {

        //stringbuffer stores the result which is returned from web service
        StringBuffer result = new StringBuffer();
        //convert string buffer into list to get the data in appropriate format
        ArrayList<Item> list = new ArrayList<Item>();

        try {

            String url = "http://localhost:8082/messanger/webapi/item/getallitems";
            //create object of HttpClient class
            HttpClient client = new DefaultHttpClient();

            //create object of HttpPost to pass the url of webservice
            HttpPost post = new HttpPost(url);

            //get the response from webservice using HttpResponse object
            HttpResponse response = client.execute(post);

            //create bufferedreader object to store the return value of web service
            //we get return value of web service using getEntity().getContent() method of HttpResponse class 
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            //append the data into the stringbuffer
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            //convert the string buffer into the string
            res = result.toString();

            //convert string into the JSONArray
            JSONArray arr = new JSONArray(res);
            Item item;

            //invert the loop upto end of the Json array
            for (int i = 0; i < arr.length(); i++) {

                //create object of json using getJSONObject called by JSONArray object
                JSONObject c = arr.getJSONObject(i);

                //separate key value pair from json object and store only values 
                int Item_ID = c.getInt("item_ID");
                String Item_Name = c.getString("item_Name");
                String Item_Description = c.getString("item_Description");
                String Batch_No = c.getString("batchno");
                String Time = c.getString("created");

                //create new object of Item Class
                item = new Item(Item_ID, Item_Name, Item_Description, Batch_No, Time);
                //append the object of item to the list
                list.add(item);

            }
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
        //return created list
        return list;
    }

    //method shows details of all the Unmapped items
    public ArrayList<Item> getMappedItems() {

        //stringbuffer stores the result which is returned from web service
        StringBuffer result = new StringBuffer();
        //convert string buffer into list to get the data in appropriate format
        ArrayList<Item> list = new ArrayList<Item>();

        try {

            String url = "http://localhost:8082/messanger/webapi/item/MappedItem";
            //create object of HttpClient class
            HttpClient client = new DefaultHttpClient();

            //create object of HttpPost to pass the url of webservice
            HttpPost post = new HttpPost(url);

            //get the response from webservice using HttpResponse object
            HttpResponse response = client.execute(post);

            //create bufferedreader object to store the return value of web service
            //we get return value of web service using getEntity().getContent() method of HttpResponse class 
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            //append the data into the stringbuffer
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            //convert the string buffer into the string
            res = result.toString();

            //convert string into the JSONArray
            JSONArray arr = new JSONArray(res);
            Item item;

            //invert the loop upto end of the Json array
            for (int i = 0; i < arr.length(); i++) {

                //create object of json using getJSONObject called by JSONArray object
                JSONObject c = arr.getJSONObject(i);

                //separate key value pair from json object and store only values 
                int Item_ID = c.getInt("item_ID");
                String Item_Name = c.getString("item_Name");
                String Item_Description = c.getString("item_Description");
                String Batch_No = c.getString("batchno");
                String Time = c.getString("created");

                //create new object of Item Class
                item = new Item(Item_ID, Item_Name, Item_Description, Batch_No, Time);
                //append the object of item to the list
                list.add(item);

            }
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
        //return created list
        return list;
    }

}
