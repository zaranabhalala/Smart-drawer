<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="controller.DatabaseClass"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
        
<!DOCTYPE html>
<html>

<head>
    <%@include file="blank.jsp" %>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Form With Labels On Top</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-labels-on-top.css">
        <%String PhoneNumber="";%>
</head>

<body background="assets/img/img/back_7.jpg" style="background-repeat: no-repeat;">
    <%
        PhoneNumber=request.getParameter("fnumber");
        System.out.println("SMS ON phone number:- "+PhoneNumber);
        String User="";
        String pass="";
        try {
             DatabaseClass dbc = new DatabaseClass();
         Connection con = dbc.getconnection();
        Statement stmt;
            stmt = con.createStatement();
            String sql="SELECT `email`,`password` FROM `registration` WHERE `contact`='"+PhoneNumber+"'";
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {        
                    User=rs.getString(1);
                    pass=rs.getString(2);
            }
           
             
          }
        catch(Exception e){
            System.out.println("Stuck in catch forget_pass_send_email");
        }
        
                        
                        
                        
                        String Password="Dear%20ETender%20User%20Your%20UserID%20is:-%20\""+User+"\"%20Password%20is:-%20\""+pass+"\"%20Confidential%20Do%20not%20share";

                         try {
                            URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=7984981872&Password=A6434A&Message="+Password+"&To="+PhoneNumber+"&Key=dhyanZDAHEdTiPp82JItj1K");
                            System.out.println("URL is"+url);
                            URLConnection urlcon = url.openConnection();
                            InputStream stream = urlcon.getInputStream();
                            int i;
                            String responsee="";
                            while ((i = stream.read()) != -1) {
                                responsee+=(char)i;
                            }
                            if(responsee.contains("success")){
                                System.out.println("Successfully send SMS");
                                //your code when message send success
                            }else{
                                System.out.println(responsee);
                                //your code when message not send
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
    
    %>
    <div class="etmain-content">

        <!-- You only need this form and the form-labels-on-top.css -->

        <form class="etform-labels-on-top" method="post"  style="margin-top: 121px;margin-bottom: 40px;">

            <div class="etform--row">
                <h1>SMS Sent on your Registered Mobile Number : <%=PhoneNumber%> </h1> 
            </div>
            <br>
            <br>
            <br>
        

<br>
            <div class="etform-row">
                <label>
                    <center><span>If you don't get the SMS, Please Retry. </span> </center>
                    
                </label>
            </div>
<br>            
            <div class="form-row">
                <center><button type=button><a href="http://localhost:8084/E_Tender/consult/forget_pass_send_sms.jsp?fnumber=<%=PhoneNumber%>">Retry</a></button></center>
            </div>

        </form>

    </div>

</body>
<%@ include file = "blank_footer.jsp" %>
</html>
