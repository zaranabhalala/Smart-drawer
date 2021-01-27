/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/*
 java code for getting data from webservice and view in table format in tagBank_table.jsp page
 */
import Model.Tagbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author zarana
 */
public class ViewTagbank {

    String res;

    //method shows details of Mappedtag in tagbank
    public ArrayList<Tagbank> getMappedTag() {

        //stringbuffer stores the result which is returned from web service
        StringBuffer result = new StringBuffer();
        //convert string buffer into list to get the data in appropriate format
        ArrayList<Tagbank> list = new ArrayList<Tagbank>();

        try {

            String url = "http://localhost:8082/messanger/webapi/tagbanktags/mappedtag";
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
            Tagbank tagbank;

            //invert the loop upto end of the Json array
            for (int i = 0; i < arr.length(); i++) {

                //create object of json using getJSONObject called by JSONArray object
                JSONObject c = arr.getJSONObject(i);

                //separate key value pair from json object and store only values 
                String Tag_Id = c.getString("tagid");

                //create new object of Tagbank Class
                tagbank = new Tagbank(Tag_Id);
                //apoend the object of tagbank to the list
                list.add(tagbank);

            }
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
        //return created list
        return list;
    }

    //method shows details of Unmappedtag in tagbank
    public ArrayList<Tagbank> getUnMappedTag() {

        //stringbuffer stores the result which is returned from web service
        StringBuffer result = new StringBuffer();
        //convert string buffer into list to get the data in appropriate format
        ArrayList<Tagbank> list = new ArrayList<Tagbank>();

        try {

            String url = "http://localhost:8082/messanger/webapi/tagbanktags/unmappedtag";
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
            Tagbank unMappedTag;

            //invert the loop upto end of the Json array
            for (int i = 0; i < arr.length(); i++) {

                //create object of json using getJSONObject called by JSONArray object
                JSONObject c = arr.getJSONObject(i);

                //separate key value pair from json object and store only values into string
                String Tag_Id = c.getString("tagid");

                //create new object of Tagbank class
                unMappedTag = new Tagbank(Tag_Id);
                //apeend the object of tagbank to the list
                list.add(unMappedTag);

            }
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
        //return created list
        return list;
    }

}
