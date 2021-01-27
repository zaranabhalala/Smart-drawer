<!-- import Item and ViewDrawer class to use methods -->
<%@page import="Model.Item"%>
<%@page import="View.ViewDrawer"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:08:11 GMT -->
    <head>
        <!---------->

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

    <body onload="myFunction()">

        <div id="wrapper">
            <!-- begin MAIN PAGE CONTENT -->
            <div id="page-wrapper">

                <div class="page-content">
                    <!-- begin PAGE TITLE AREA -->
                    <!-- Use this section for each page's title and breadcrumb layout. In this example a date range picker is included within the breadcrumb. -->
                    <div class="row">


                        <div class="col-lg-12">
                            <div class="page-title">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Drawer Table</h2>
                                            <!-- Call myFunction() on onchange event -->
                                            <h4><b>Select Drawer:-  </b><select id="drawer" onchange="myFunction()"> 
                                                    <option value="0" selected="0">0</option>
                                                    <option value="1" >1</option>
                                                    <option value="2">2</option>
                                                </select></h4>
                                             <ul class="nav navbar-right panel_toolbox">
                                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                </li>
                                            </ul>
                                            <div class="clearfix"></div>
                                        </div>


                                        <span id="spntbl"></span>
                                    </div>
                                </div>
                                <!-- /.col-lg-12 -->
                            </div>
                            <!-- /.row -->
                            <!-- end PAGE TITLE AREA -->


                        </div>
                        <!-- /#page-wrapper -->
                        <!-- end MAIN PAGE CONTENT -->

                    </div>

                    <script>

                        function myFunction()
                        {
                            var id = document.getElementById("drawer").value;
                            var http_request = new XMLHttpRequest();
                            http_request.onreadystatechange = function ()
                            {
                                if (http_request.readyState == 4)
                                { 
                                    document.getElementById("spntbl").innerHTML = http_request.responseText;

                                }

                            }
                            http_request.open("GET", "controll.jsp?Drawerid=" + id, true);
                            http_request.send();

                        }
                    </script>

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
