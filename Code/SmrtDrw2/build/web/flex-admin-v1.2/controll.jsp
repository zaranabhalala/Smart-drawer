<%-- 
    Document   : controll
    Created on : Jun 5, 2017, 5:32:43 PM
    Author     : zarana
--%>
<!-- import packeges -->
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.http.client.methods.HttpPost"%>
<%@page import="org.apache.http.HttpResponse"%>
<%@page import="org.apache.http.impl.client.DefaultHttpClient"%>
<%@page import="org.apache.http.client.HttpClient"%>
<%@page import="Model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:08:11 GMT -->
    <head>
        <!---------->

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Smart Drawer ADMIN</title>
        <!-- PACE LOAD BAR PLUGIN - This creates the subtle load bar effect at the top of the page. -->
        <link href="css/plugins/pace/pace.css" rel="stylesheet">
        <script src="js/plugins/pace/pace.js"></script>

        <!-- GLOBAL STYLES - Include these on every page. -->
        <link href="css/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href='../../fonts.googleapis.com/css3ef8.css?family=Ubuntu:300,400,500,700,300italic,400italic,500italic,700italic' rel="stylesheet" type="text/css">
        <link href='../../fonts.googleapis.com/css5c84.css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel="stylesheet" type="text/css">
        <link href="icons/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- PAGE LEVEL PLUGIN STYLES -->
        <link href="css/plugins/messenger/messenger.css" rel="stylesheet">
        <link href="css/plugins/messenger/messenger-theme-flat.css" rel="stylesheet">
        <link href="css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
        <link href="css/plugins/morris/morris.css" rel="stylesheet">
        <link href="css/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet">
        <link href="css/plugins/datatables/datatables.css" rel="stylesheet">

        <!-- THEME STYLES - Include these on every page. -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/plugins.css" rel="stylesheet">

        <!-- THEME DEMO STYLES - Use these styles for reference if needed. Otherwise they can be deleted. -->
        <link href="css/demo.css" rel="stylesheet">

    </head>

    <body>
        <%
            String drawer_id = request.getParameter("Drawerid");
            StringBuffer result = new StringBuffer();
            //convert string buffer into list to get the data in appropriate format
            ArrayList<Item> list = new ArrayList<Item>();

            try {

                String url = "http://localhost:8082/messanger/webapi/item/DrawerItem/" + drawer_id;
                //create object of HttpClient class
                HttpClient client = new DefaultHttpClient();

                //create object of HttpPost to pass the url of webservice
                HttpPost post = new HttpPost(url);

                //get the response from webservice using HttpResponse object
                HttpResponse response1 = client.execute(post);

                //create bufferedreader object to store the return value of web service
                //we get return value of web service using getEntity().getContent() method of HttpResponse class 
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response1.getEntity().getContent()));

                //append the data into the stringbuffer
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                //convert the string buffer into the string
                String res = result.toString();

                //convert string into the JSONArray
                JSONArray arr = new JSONArray(res);
                Item item;
                
                out.print("<div class=" + '"' + "x_content" + '"' + ">");
                out.print("<table id=" + '"' + "datatable-Drawer" + '"' + " class=" + '"' + "table table-striped table-bordered" + '"' + ">");

                out.print("<thead><tr> <th>ItemID</th><th>Item Name</th><th>Item Description</th><th>Batch N0</th> <th>Time Stamp</th></tr></thead><tbody> ");

                //invert the loop upto end of the Json array
                for (int i = 0; i < arr.length(); i++) {

                    //create object of json using getJSONObject called by JSONArray object
                    JSONObject c = arr.getJSONObject(i);

                    //separate key value pair from json object and store only values into string
                    int Item_ID = c.getInt("item_ID");
                    String Item_Name = c.getString("item_Name");
                    String Item_Description = c.getString("item_Description");
                    String Batch_No = c.getString("batchno");
                    String Time = c.getString("created");

                    out.print("<tr><td>" + Item_ID + "</td>");
                    out.print("<td>" + Item_Name + "</td>");
                    out.print("<td>" + Item_Description + "</td>");
                    out.print("<td>" + Batch_No + "</td>");
                    out.print("<td>" + Time + "</td></tr>");
                    //append all this values to the list
                    item = new Item(Item_ID, Item_Name, Item_Description, Batch_No, Time);
                    //apeend the object of item to the list
                    list.add(item);

                }
                out.print("</tbody></table></div>");

            } catch (Exception e) {
                System.out.println("exception:" + e);
             }%>
        <script src="../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="js/plugins/popupoverlay/jquery.popupoverlay.js"></script>
        <script src="js/plugins/popupoverlay/defaults.js"></script>

        <!-- Logout Notification jQuery -->
        <script src="js/plugins/popupoverlay/logout.js"></script>
        <!-- HISRC Retina Images -->
        <script src="js/plugins/hisrc/hisrc.js"></script>

        <!-- PAGE LEVEL PLUGIN SCRIPTS -->
        <!-- HubSpot Messenger -->
        <script src="js/plugins/messenger/messenger.min.js"></script>
        <script src="js/plugins/messenger/messenger-theme-flat.js"></script>
        <!-- Date Range Picker -->
        <script src="js/plugins/daterangepicker/moment.js"></script>
        <script src="js/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- Morris Charts -->
        <script src="js/plugins/morris/raphael-2.1.0.min.js"></script>
        <script src="js/plugins/morris/morris.js"></script>
        <!-- Flot Charts -->
        <script src="js/plugins/flot/jquery.flot.js"></script>
        <script src="js/plugins/flot/jquery.flot.resize.js"></script>
        <!-- Sparkline Charts -->
        <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>
        <!-- Moment.js -->
        <script src="js/plugins/moment/moment.min.js"></script>
        <!-- jQuery Vector Map -->
        <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="js/plugins/jvectormap/maps/jquery-jvectormap-world-mill-en.js"></script>
        <script src="js/demo/map-demo-data.js"></script>
        <!-- Easy Pie Chart -->
        <script src="js/plugins/easypiechart/jquery.easypiechart.min.js"></script>
        <!-- DataTables -->
        <script src="js/plugins/datatables/jquery.dataTables.js"></script>
        <script src="js/plugins/datatables/datatables-bs3.js"></script>

        <!-- THEME SCRIPTS -->
        <script src="js/flex.js"></script>
        <script src="js/demo/dashboard-demo.js"></script>

        <!---  -->

        <%@include file="advancetablejs.jsp" %>
    </body>
</html>