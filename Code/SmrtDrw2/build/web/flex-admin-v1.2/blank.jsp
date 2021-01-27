<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/blank.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:50 GMT -->
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Smart Drawer Admin</title>

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

            <!-- begin TOP NAVIGATION -->
            <nav class="navbar-top" role="navigation">

                <!-- begin BRAND HEADING -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".sidebar-collapse">
                        <i class="fa fa-bars"></i> Menu
                    </button>
                    <div class="navbar-brand">
                        <a href="Transaction.jsp">
                            <h4 class="responsive" ; style="color:white;"><B>&nbsp; &nbsp; &nbsp; Smart Drawer </B></h4>
                            <!--<img src="img/SDlogo.jpg" class="img-responsive" alt=""> -->
                        </a>
                    </div>
                </div>
                <!-- end BRAND HEADING -->

                <div class="nav-top">

                    <!-- begin LEFT SIDE WIDGETS -->
                    <ul class="nav navbar-left">
                        <li class="tooltip-sidebar-toggle">
                            <a href="#" id="sidebar-toggle" data-toggle="tooltip" data-placement="right" title="Sidebar Toggle">
                                <i class="fa fa-bars"></i>
                            </a>
                        </li>
                        <!-- You may add more widgets here using <li> -->
                    </ul>
                    <!-- end LEFT SIDE WIDGETS -->

                    <!-- begin MESSAGES/ALERTS/TASKS/USER ACTIONS DROPDOWNS -->
                    <ul class="nav navbar-right">


                        <!-- begin USER ACTIONS DROPDOWN -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <a href="profile.html">
                                        <i class="fa fa-user"></i> My Profile
                                    </a>
                                </li>
                                
                                <li class="divider"></li>
                                
                                <li>
                                    <a class="logout_open" href="#logout">
                                        <a href="http://localhost:8082/SmrtDrw2/flex-admin-v1.2/login.jsp"><i class="fa fa-sign-out"></i> Logout</a>
                                        
                                    </a>
                                </li>
                            </ul>
                            <!-- /.dropdown-menu -->
                        </li>
                        <!-- /.dropdown -->
                        <!-- end USER ACTIONS DROPDOWN -->

                    </ul>
                    <!-- /.nav -->
                    <!-- end MESSAGES/ALERTS/TASKS/USER ACTIONS DROPDOWNS -->

                </div>
                <!-- /.nav-top -->
            </nav>
            <!-- /.navbar-top -->
            <!-- end TOP NAVIGATION -->

            <!-- begin SIDE NAVIGATION -->
            <nav class="navbar-side" role="navigation">
                <div class="navbar-collapse sidebar-collapse collapse">
                    <ul id="side" class="nav navbar-nav side-nav">
                        <!-- begin SIDE NAV USER PANEL -->
                        <li class="side-user hidden-xs">
                            <img class="img-circle" src="img/eiTRAlogo2.jpg" alt="">
                            <p class="welcome">
                                <i class="fa fa-key"></i> Logged in as
                            </p>
                            <p class="name tooltip-sidebar-logout">
                                Dhyan
                                <span class="last-name">Patel</span> <a style="color: inherit" class="logout_open" href="login.jsp" data-toggle="tooltip" data-placement="top" title="Logout"><i class="fa fa-sign-out"></i></a>
                            </p>
                            <div class="clearfix"></div>
                        </li>
                        <!-- end SIDE NAV USER PANEL -->
                        <!-- begin SIDE NAV SEARCH -->
                        <li class="nav-search">
                            <form role="form">
                                <input type="search" class="form-control" placeholder="Search...">
                                <button class="btn">
                                    <i class="fa fa-search"></i>
                                </button>
                            </form>
                        </li>
                        <!-- end SIDE NAV SEARCH -->
                        <!-- begin DASHBOARD LINK -->
                        <li>
                            <a href="Transaction.jsp">
                                <i class="fa fa-dashboard"></i> Transaction Log
                            </a>
                        </li>
                        <!-- end DASHBOARD LINK -->

                        <!-- begin Drawer LINK -->
                        <li>
                            <a href="drawer.jsp">
                                <i class="fa fa-edit"></i> Drawer
                            </a>
                        </li>
                        <!-- end Drawer LINK -->

                        <!-- begin Person LINK -->
                        <li>
                            <a href="person_table.jsp">
                                <i class="fa fa-edit"></i> Person
                            </a>
                        </li>
                        <!-- end Person LINK -->

                        <!-- begin Item LINK -->
                        <li>
                            <a href="View-items.jsp">
                                <i class="fa fa-edit"></i> Item
                            </a>
                        </li>
                        <!-- end Item LINK -->

                        <!-- begin Tag Bank LINK -->
                        <li>
                            <a href="tagBank_table.jsp">
                                <i class="fa fa-edit"></i> Tag Bank
                            </a>
                        </li>
                        <!-- end Tag Bank LINK -->

                        <!-- begin Map Tag LINK -->
                        <li>
                            <a href="tag_map_item.jsp">
                                <i class="fa fa-edit"></i> Map Item Tag
                            </a>
                        </li>

                        <li>
                            <a href="tag_map_person.jsp">
                                <i class="fa fa-edit"></i> Map Person Tag
                            </a>
                        </li>

                        <!-- end Map Tag LINK -->
                    </ul>
                    <!-- /.side-nav -->
                </div>
                <!-- /.navbar-collapse -->
            </nav>
            <!-- /.navbar-side -->
            <!-- end SIDE NAVIGATION -->
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


    <!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/blank.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 02 Mar 2017 06:10:50 GMT -->
</html>
