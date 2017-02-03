<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: left;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
</head>
<body>
<center>
<h2>${title}</h2>
<br/>

       <div id="registrationForm" />
       <div id="result" style="color:#ff0000"></div>
       <TABLE border="0" cellspacing="5" cellpadding="3">
       <TR>
                   <th> UserId </th>
                   <td><input type="text" id="userId" name="userId" placeholder="UserId"  /></td>
              </TR>
       
           <input type="text" id="email" hidden="enabled" name="email" placeholder="EmailId" value="mail" />
     
            <input type="text" id="firstName" hidden="enabled" name="firstName" placeholder="FirstName" value="User" />
       
            <input type="text" id="lastName" hidden="enabled" name="lastName" placeholder="LastName" value="User"  />
       
            <input type="text" id="phoneno" hidden="enabled" name="phoneno" placeholder="Phone Number" value="ok"  />
       
       <TR>
            <th> Password  </th>
            <td><input type="password" id="password" name="password" placeholder="Password" /></td>
       </TR>
       <TR>
            <th> Confirm Password </th>
            <td><input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" /></td>
       </TR>
       <TR>
            <th>
                <input type="hidden" id="socialProvider" name="socialProvider" value="NONE" />
                <button type="button" id="doRegister" onclick="proceed()">Submit</button>
            </th>
       </TR>
       </TABLE>
       </div>
       </center>
<script>

       function proceed(){

       var userIdVar = $("#registrationForm #userId").val();
       var emailVar = $("#registrationForm #email").val();
       var phonenoVar = $("#registrationForm #phoneno").val();
       var passwordVar =  $("#registrationForm #password").val();
       var conformPasswordVar =  $("#registrationForm #confirmpassword").val();
       var div = document.getElementById('result');
       if(!userIdVar)
       {
          div.innerHTML = "User Id can not be empty";
       }
       else if(!emailVar)
       {
          div.innerHTML = "email Id can not be empty";
       }
       else if(!phonenoVar)
       {
          div.innerHTML = "phone no can not be empty";
       }
       else if(!passwordVar || !conformPasswordVar)
       {
          div.innerHTML = "password or confirm password can not be empty";
       }
       else if(passwordVar !== conformPasswordVar)
       {
          div.innerHTML = "make sure password and confirm password are same";
       }
       else {
       div.innerHTML = "";
       var person = {
                        userId: userIdVar,
                        email:emailVar,
                        firstName:$("#registrationForm #firstName").val(),
                        lastName: $("#registrationForm #lastName").val(),
                        phoneno:phonenoVar,
                        password: passwordVar,
                        socialProvider:$("#registrationForm #socialProvider").val()
                    }


            $.ajax({
                          type: "POST",
                          url: '../services/user/register',
                          data: JSON.stringify(person),
                          contentType: "application/json",
                          success: function(data) {
                            if(data == "success")
                            {
                            div.innerHTML = "User "+ userIdVar + " registered successfully,click <a href='../login'>here </a> to login!!!";
                            }else {
                              div.innerHTML = "Failed to register user,please check logs!!!";
                            }
                          }

                        });

        }
        }

</script>


</body>
</html>