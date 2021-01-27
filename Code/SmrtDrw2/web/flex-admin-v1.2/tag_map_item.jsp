<!-- import Item, Tagbank, ViewUnmappeditem, ViewUnmappedtag and ViewItem class to use methods -->
<%@page import="Model.Item"%>
<%@page import="Model.Tagbank"%>
<%@page import="View.ViewUnmappeditem"%>
<%@page import="View.ViewUnmappedtag"%>
<%@page import="View.ViewItem"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/basic-form-elements.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:10 GMT -->
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Smart Drawer ADMIN</title>
        <%@include file="blank.jsp" %>
        
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

    <body onload=f()>
        <!-- import packages -->
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.util.ArrayList"%>

        <%-- Use viewUnmappedtag class and create object of that class as 'objtag' --%>
        <%-- Use viewUnmappeditem class and create object of that class as 'objl' --%>
        <%-- Use viewItem class and create object of that class as 'objm' --%>
        <jsp:useBean id="objtag" class= "View.ViewUnmappedtag"/> 
        <jsp:useBean id="objl" class= "View.ViewUnmappeditem"/>
        <jsp:useBean id="objm" class="View.ViewItem"/>
        <%

            //call getallunmappedtag of viewUnmappedtag class and store its return value in List as list
            ArrayList<Tagbank> list = objtag.getallunmappedtag();
            //call getallunmappeditem of viewUnmappeditem class and store its return value in List as listi
            ArrayList<Item> listi = objl.getallunmappeditem();
            //call getMappedItems of viewItem class and store its return value in List as listm
            ArrayList<Item> listm=objm.getMappedItems();
            
        %>

        <div id="wrapper">
            <!-- begin MAIN PAGE CONTENT -->
            <div id="page-wrapper">

                <div class="page-content">

                    <!-- begin PAGE TITLE ROW -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="page-title">
                                <h1>Mapping

                                </h1>

                            </div>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <!-- end PAGE TITLE ROW -->

                    <!-- begin MAIN PAGE ROW -->
                    <div class="row">

                        <!-- begin LEFT COLUMN -->
                        <div class="col-lg-6">

                            <div class="row">

                                <!-- Basic Form Example -->
                                <div class="col-lg-12">

                                    <div class="portlet portlet-default">
                                        <div class="portlet-heading">
                                            <div class="portlet-title">
                                                <h4>Mapping of Item</h4>
                                            </div>
                                            <div class="portlet-widgets">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div id="basicFormExample" class="panel-collapse collapse in">
                                            <div class="portlet-body">
                                                <!-- form action post the form parameter to the database using webservice -->
                                                <form role="form" action="http://localhost:8082/messanger/webapi/mapitemtag" method="post">
                                                    <div class="dropzone">
                                                        Tag No &nbsp

                                                        <select name="tagNo">
                                                            <!-- for loop to display the data into select option --> 
                                                            <%
                                                                for (int i = 0; i < list.size(); i++) {
                                                            %>
                                                            <option value="<%= list.get(i).getTagid()%>"><%= list.get(i).getTagid()%></option>
                                                            <%  }%>
                                                        </select>
                                                        <br>
                                                        <br>

                                                    </div>

                                                    <div class="dropzone">
                                                        Item Name:
                                                        &nbsp;
                                                        <select name="itemid">
                                                            <!-- for loop to display the data into select option  --> 
                                                            <%
                                                                for (int i = 0; i < listi.size(); i++) {
                                                            %>
                                                            <option value="<%= listi.get(i).getItem_ID()%>"><%= listi.get(i).getItem_Name()%></option>
                                                            <%  }%>
                                                        </select>

                                                        <br>
                                                        <br>

                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button type="submit" class="btn btn-default">Submit</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.portlet -->
                                </div>
                                <!-- /.col-lg-12 (nested) -->
                                <!-- End Basic Form Example -->
                            </div>
                            <!-- /.row (nested) -->

                        </div>
                        <!-- /.col-lg-6 -->
                        <!-- end LEFT COLUMN -->

                        <!-- begin RIGHT COLUMN -->
                        <div class="col-lg-6">

                            <div class="row">



                            </div>
                            <!-- /.col-lg-12 (nested) -->
                            <!-- End Form Controls -->

                        </div>
                        <!-- /.row (nested) -->

                    </div>
                    <!-- /.col-lg-6 -->
                    <!-- end RIGHT COLUMN -->

                </div>
                <!-- /.row -->
                <!-- end MAIN PAGE ROW -->



                <div class="x_content">
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>ItemID</th>
                                <th>Item Name</th>
                                <th>Item Description</th>
                                <th>Batch N0</th>
                                <th>Time Stamp</th>
                                <th>Modification</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- for loop to display the data into table --> 
                            <%

                                for (int i = 0; i < listm.size(); i++) {
                            %>
                            <tr>
                                <td><%= listm.get(i).getItem_ID()%></td>
                                <td><%= listm.get(i).getItem_Name()%></td>
                                <td><%= listm.get(i).getItem_Description()%></td>
                                <td><%= listm.get(i).getBatch_No()%></td>
                                <td><%= listm.get(i).getTime()%></td>


                                <td> <a href=<%= "http://localhost:8082/messanger/webapi/mapitemtag/deletemappeditem/" + listm.get(i).getItem_ID() + ""%>>Delete</b></a>						  
                            </tr>
                            <%    }%>




                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.page-content -->

        </div>
        <!-- /#page-wrapper -->
        <!-- end MAIN PAGE CONTENT -->

    </div>
    <!-- /#wrapper -->

    <!-- GLOBAL SCRIPTS -->
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

    <!-- THEME SCRIPTS -->
    <script src="js/flex.js"></script>

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

    <!-- THEME SCRIPTS -->
    <script src="js/flex.js"></script>
    
    <!-- GLOBAL SCRIPTS -->
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


<!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/basic-form-elements.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:10 GMT -->
</html>
