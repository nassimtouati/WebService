<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
  <br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />
  <br />
  <div>
   
    <table>
    <input type="hidden" id="user_id">
     <tr>
      <td>First Name :</td>
      <td><input type="text" id="name" required="required" name="first_name"></td>
     </tr>

	<tr>
      <td>Last Name :</td>
      <td><input type="text" id="lastname" required="required" name="last_name"></td>
     </tr>
     
     <tr>
      <td>Email :</td>
      <td><input type="email" id="email" required="required" name="email"></td>
     </tr>
     
     <tr>
      <td>Biography :</td>
      <td><input type="biography" id="biography" required="required" name="biography"></td>
     </tr>


     <tr>
      <td> </td>
      <td><input type="submit" value="Save" /></td>
     </tr>
     <tr>
      <td colspan="2"><a href="getList">Click Here to See User List</a></td>
     </tr>
    </table>
   
  </div>
 </center>
 
 
 
 <script type="text/javascript">
    
    
    
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{user_id:$("#user_id").val(),first_name:$('#name').val(),last_name:$('#lastname').val(),email:$('#email').val(),biography:$('#biography').val(),groups:$('#groups').val()},
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
            data:{user_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#user_id").val(data[index].user_id);
        $("#name").val(data[index].first_name);
		$("#lastname").val(data[index].last_name);
        $("#email").val(data[index].email);
        $("#biography").val(data[index].biography);
        $("#groups").val(data[index].groups);
         
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].first_name+" </td> <td> "+response.data[i].groups+" </td> <td> "+response.data[i].biography+" </td> <td> "+response.data[i].last_name+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
        
    </script>
       <a href="Accueil">MENU</a> 
</body>
</html>