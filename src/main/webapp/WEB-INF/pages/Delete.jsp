<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<title>Being Java Guys | Spring DI Hello World</title>
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
<body onload="load();">
 
  <center>
  <br /> <br /> <br /> <b>Do you really want to delete your account?</b> <br />
  <br />
  <div>
   
    <table>
           
     
      
 <td></td>
        <table id="table" >
         
        </table>
             
     
    <script type="text/javascript">
   
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{user_id:$("#user_id").val(),first_name:$('#name').val(),last_name:$('#lastname').val(),email:$('#email').val(),biography:$('#biography').val(),},
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
     
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{USER_ID:id},
            success: function(response){
            	window.location = 'DELETE';
            }              
        });
}
     
 
    edit = function (index){
        $("#user_id").val(data[index].user_id);
        $("#name").val(data[index].first_name);
		$("#lastname").val(data[index].last_name);
        $("#email").val(data[index].email);
        $("#biography").val(data[index].biography);
        
         
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> <button href='#' onclick='delete_("+response.data[i].USER_ID+");'> Delete </button>  </td>  </tr>");
                        
                    }          
            }              
        });
         
    }
        
    </script>
     <a href="Accueil">MENU</a> 
</body>
</html>