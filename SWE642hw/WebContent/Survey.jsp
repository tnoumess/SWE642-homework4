<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
<script src="javascript/jquery.js">  </script>
<script src="javascript/jquery-ui.js">  </script>
<script  src="javascript/myscript.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

$( document ).ready(function() {
 $("#zipp").blur(function() {
          
 $.ajax({
                    url: "javascript/data.json",
                    dataType: "text",
                    error:function(){alert();},
                    success: function(data) {                
                        var json = $.parseJSON(data);
                     callback(json);}});    
});
});

function callback(data){
var items=data.zipcodes;
var zip=document.getElementById("zipp").value.trim();  
var list=[];

var found=false;
var i=0;
var city;
var state;
while(found==false&&i!=items.length){
if(zip==items[i].zip){ found=true; city=items[i].city; state=items[i].state;}
i++;
}
if(found==true){document.getElementById("city").value=city;
               document.getElementById("statee").value=state;
               // document.getElementById("idzipp").innerHTML="";
                }else{
                	document.getElementById("city").value="";
                    document.getElementById("statee").value="";
                	alert("bad zip code");
            //   document.getElementById("cityy").value="";
             //  document.getElementById("statee").value="";
             //  document.getElementById("idzipp").innerHTML="invalid zip";
}

}

</script>
</head>
<body>
<div id="mydialog" title="Warning">
  <div id="message"></div>
</div>
<div>Survey Form</div><p><p>
<form action="process" method="get">

<div class="survey">
<div>
<div>Student ID <Strong><BLINK><span style="color:red ;text-decoration: blink"> ${message}</span></BLINK></Strong></div>
         <div>     <input type = "text" id = "studentId" name="studentid"
                  placeholder = "Student Id"  autofocus /> </div>
            
              <p>
<div>User Name</div>
         <div>     <input type = "text" id = "Name" name="name"
                  placeholder = "User name"  /> </div>
             
              <p>
             <div>Address Street</div>
               <div><input type = "text" id = "AddressStreet" name="street"
                 placeholder = "Address Street" /> 
              
            <div> Zip</div>
              <div> <input  id = "zipp" name="zip"
                 placeholder = "zip code" /> 
            
               
          </div> <p> <div>  City</div> 
              <div> <input type = "text" id = "city" name="city" placeholder = "City" /> 
               
         </div>  <p>  <div>  State</div>
                <div><input type = "text" id = "statee" name="state" placeholder = "State" /> </div>
               


       <p>        
      <div>  Tel</div>
            <div> <input type="text"  name="telephone" placeholder = "(###) ###-####"
                      /> 
                                                   
               
       </div>.</div><div>.</div> <p> </p><div>   <div>   Email</div>
             <div>  <input  id = "email" name="email"
                 placeholder = "email@address.com" /> 
                  
        </div>  <p><div>     Url</div>
             <div>  <input type = "url" id = "url" name="url"
                 placeholder = "http://mason.gmu.edu/~tnoumess" /> 
        </div>  <p>
        <div>     Date of survey</div>
             <div>  <input type = "date" id = "date" name="date"
                 placeholder = "yyy-mm-dd" /> </div><p>
            
             <div>   What did you like the most?</div>
             <div>   students
              <input name="liked" type = "checkbox" id="student" 
                  value = "students" />location
              <input name="liked" type = "checkbox" id="location"
                  value = "location" /> campus
             <input name="liked" type = "checkbox" id="campus"
                  value = "campus" />atmosphere
              <input name="liked" type = "checkbox" id="atmos"
                  value = "atmostphere" />dorm rooms
               <input name="liked" type = "checkbox" id="dorm"
                  value = "dormrooms" />sports
              <input name="liked" type = "checkbox" id="sport"
                  value = "sports" /> 
          </div><p><div>     How did you find out about Gmu?</div><p><div>.</div>
               Friends
              <div> <input name  = "how"  type  = "radio" id="friend"  
                     value  = "friends"  ></div>
               Television
              <div>   <input name = "how" type = "radio"  id="television"
                     value = "television"></div>
               Internet
               <div>   <input name = "how" type = "radio"  id="internet"
                     value = "internet"></div>
               Other
             <div>    <input name = "how" type = "radio"   id="other"
                    value = "other">  </div>           
<p></div>
      
<div> High school graduation month</div>
 <div>  <input list="gradMonths" name="month"></div>
<datalist id="gradMonths">
  <option value="January">
  <option value="February">
  <option value="March">
  <option value="April">
  <option value="May">
  <option value="June">
  <option value="July">
  <option value="August">
  <option value="September">
  <option value="October">
  <option value="November">
  <option value="December">
</datalist><p><div>Year</div>
<div><input type="number" name="year"  >
 
 </div><p><div>How likely would you recommend Gmu</div>
<div><select name="recommend">
  <option value="verylikely">Very likely</option>
  <option value="likely">Likely</option>
  <option value="unlikely">Unlikely</option>
</select></div><p><div>Comments</div>
               <div><textarea name="comment"                              
             rows = "10" cols = "36"> Other Comments </textarea>
           
</div><p><div>Data</div>
<div><input type="text" name="data" id="data"/></div>




 
</div><p> <div>
       <input type="submit" value="Submit" onclick="return checkform()">
       <input type="reset" value="Reset" onreset="reset_f()">
 </div> 




</div>

</form>

</body>
</html>