<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${title}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js">
    </script>
</head>
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
<body onload="load();">
<h2>${title}</h2>
<br/>

              <div id="registrationForm" />
       <div id="result" style="color:#ff0000"></div>
       <TABLE border="0" cellspacing="5" cellpadding="3">
       
       <input type="hidden" id="groupe_id">
       <th> Name </th>
       <td><input type="text" id="name" name="name" placeholder="name"  /></td>
       </TR>
       
       <TR>
       <th> Description </th>
       <td><input type="text" id="description" name="description" placeholder="description"  /></td>
       </TR>
       
       <TR>
       <td><input type="hidden" id="admin" name="admin" placeholder="admin" value="Me" /></td>
       </TR>
 		<TR>
       <td><input type="hidden" id="members" name="members" placeholder="members" value="Me" /></td>
       </TR>

        
        <button type="button" onclick="submit();">Submit</button>
     
                 </TABLE>
       </div>
 
        <table id="table" border=1>
            <tr> <th> Name </th> <th> Description </th> <th> Administrator </th> <th> Members </th> <th> Edit </th> <th> Delete </th> </tr>
         
        </table>
             
     
     
     
     
     
     
     
     
     
     
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{groupe_id:$("#groupe_id").val(),name:$('#name').val(),description:$('#description').val(),admin:$('#admin').val(),members:$('#members').val()},
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
    
   
    
    edit = function (index){
        $("#groupe_id").val(data[index].groupe_id);
        $("#name").val(data[index].name);
		$("#description").val(data[index].description);
		$("#admin").val(data[index].admin);
		$("#members").val(data[index].members);
    }
    

    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].name+" </td> <td> "+response.data[i].description+" </td> <td> "+response.data[i].admin+" </td><td> "+response.data[i].members+" </td><td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].groupe_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
 
   
     
    
         
    </script>
     
</body>
</html>