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

        <!-- THEME STYLES - Include these on every page. -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/plugins.css" rel="stylesheet">

        <!-- THEME DEMO STYLES - Use these styles for reference if needed. Otherwise they can be deleted. -->
        <link href="css/demo.css" rel="stylesheet">
</head>

<body>

    <div id="wrapper">
        <!-- begin MAIN PAGE CONTENT -->
        <div id="page-wrapper">

            <div class="page-content">

                <!-- begin PAGE TITLE ROW -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-title">
                            <h1>TagBank
                                <small>Form of add tag/excel file of tags</small>
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
                                            <h4>Tag to enter in database</h4>
                                        </div>
                                        <div class="portlet-widgets">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div id="basicFormExample" class="panel-collapse collapse in">
                                        <div class="portlet-body">
                                            <!-- form action post the form parameter to the database using webservice -->
                                            <form action="http://localhost:8082/messanger/webapi/tagbanktags" method="post">

                                                <div class="form-group">
                                                    <label for="exampleInputFile">Tag input</label><br>
                                                    <input type="text" id="tagbanktextbox" name="tag_Id">

                                                </div>

                                                <button type="submit" class="btn btn-default">Submit</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.portlet -->
                            </div>
                            <!-- /.col-lg-12 (nested) -->
                            <!-- End Basic Form Example -->


                            <!-- Basic Form Example -->
                            <div class="col-lg-12">

                                <div class="portlet portlet-default">
                                    <div class="portlet-heading">
                                        <div class="portlet-title">
                                            <h4>file to enter in database</h4>
                                        </div>
                                        <div class="portlet-widgets">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div id="basicFormExample" class="panel-collapse collapse in">
                                        <div class="portlet-body">
                                            <form action="tagBank_table.jsp">

                                                <div class="form-group">
                                                    <label for="exampleInputFile">File input</label>
                                                    <input type="file" id="exampleInputFile">

                                                </div>

                                                <button type="submit" class="btn btn-default">Submit</button>
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


                </div>
                <!-- /.row (nested) -->

            </div>
            <!-- /.col-lg-6 -->
            <!-- end RIGHT COLUMN -->

        </div>
        <!-- /.row -->
        <!-- end MAIN PAGE ROW -->

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

</body>


<!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/basic-form-elements.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:10 GMT -->
</html>
