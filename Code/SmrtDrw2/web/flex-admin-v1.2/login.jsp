<!DOCTYPE html>
<html lang="en">


    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:50 GMT -->
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Smart Drawer ADMIN</title>

        <!-- GLOBAL STYLES -->
        <link href="css/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href='../../fonts.googleapis.com/css3ef8.css?family=Ubuntu:300,400,500,700,300italic,400italic,500italic,700italic' rel="stylesheet" type="text/css">
        <link href='../../fonts.googleapis.com/css5c84.css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel="stylesheet" type="text/css">
        <link href="icons/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- PAGE LEVEL PLUGIN STYLES -->

        <!-- THEME STYLES -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/plugins.css" rel="stylesheet">

        <!-- THEME DEMO STYLES -->
        <link href="css/demo.css" rel="stylesheet">

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body class="login">

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-banner text-center">
                        <h1><i class="fa fa-gears"></i> Drawer Admin</h1>
                    </div>
                    <div class="portlet portlet-green">
                        <div class="portlet-heading login-heading">
                            <div class="portlet-title">
                                <h4><strong>Login to Smart Drawer!</strong>
                                </h4>
                            </div>

                            <div class="clearfix"></div>
                        </div>
                        <div class="portlet-body">
                            <!-- form action post the form parameter and compare it to the database using webservice -->
                            <form action="http://localhost:8082/messanger/webapi/login/Check" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="abc@gmail.com" name="email" type="email" required>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="" required>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    
                                    <br>
                                    <input type="submit" class="btn btn-lg btn-green btn-block" value="Sign In">
                                <%
                                        String status = request.getParameter("status");
                                        try {
                                            if (status.equalsIgnoreCase("false")) {
                                    %>
                                    <div> <p class="small"> <font color="red"> Incorrect ID or Password </font></p></div>
                                            <%
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            %>
                                </fieldset>
                                <br>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- GLOBAL SCRIPTS -->
        <script src="../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/plugins/bootstrap/bootstrap.min.js"></script>
        <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <!-- HISRC Retina Images -->
        <script src="js/plugins/hisrc/hisrc.js"></script>

        <!-- PAGE LEVEL PLUGIN SCRIPTS -->

        <!-- THEME SCRIPTS -->
        <script src="js/flex.js"></script>

    </body>


    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:50 GMT -->
</html>
