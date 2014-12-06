

 
function isvalidnumber(num){
var number=parseInt(num);

if(isNaN(number))
  {//exit=true; error=true;

  return false;
  }
   else{
    return true;
  }
 
}
function isvalid_range(val){
if(val<1 || val>100)
return false;
return true;
}
function istotalelementvalid(val){
if(val<10)
return false;
return true;
}
function within_hundred(val){ if(val<=100) return true; return false;}
function setmessage(val){
message=val;
}
function compute(){
document.getElementById("output2").value="";
document.getElementById("output1").value="";
document.getElementById("err").innerHTML="";
var number=document.getElementById("data").value;
var tokens=number.split(",");
var ave=0;
var elt_num=0;
var error=false;
var maxi=0;
var exit=false ;
var total=0;
var i=0;
var message="";
var err_range=false;
if(istotalelementvalid(tokens.length)==true){
    
 do{
        
        if(!isNaN(tokens[i])){
        //alert(tokens[i]);
                  if(isvalid_range(parseInt(tokens[i]))){
                       if(parseInt(tokens[i])>maxi){ 
                       maxi=parseInt(tokens[i])
                       }
                       total=total+parseInt(tokens[i]);
          
                       elt_num++;
                       i++;
                   }else{  err_range=true; exit=true; error=true; 
                        }
                  
         
           }else{
                  exit=true; error=true;              
                }         
           
      }while(exit==false && i<tokens.length);
           if(error==false){
           ave=parseInt(total/elt_num);
           document.getElementById("output1").value=ave; 
           document.getElementById("output2").value=maxi; 
                }
         if((error==true) && (err_range==true)){
                                            document.getElementById("output1").value=""; 
                                            document.getElementById("output2").value="";
                                            document.getElementById("err").innerHTML="incorrect range [1-100]";
                                           }
                                             if((error==true) && (err_range==false)){
                                                  document.getElementById("output1").value=""; 
                                                  document.getElementById("output2").value="";
                                                  document.getElementById("err").innerHTML="invalid number";
                                                 }
 }else{        
        document.getElementById("err").innerHTML="enter at least 10 numbers \t separated by a comma";    }

}

////////////////////form
function checkform(){
	document.getElementById("message").innerHTML = "";
	/*
document.getElementById("idname").innerHTML="";
document.getElementById("idaddress").innerHTML="";
//document.getElementById("idcity").innerHTML="";
document.getElementById("idzip").innerHTML="";
document.getElementById("idemail").innerHTML="";
document.getElementById("idliked").innerHTML="";
document.getElementById("idfind").innerHTML="";*/
	
	if(!checkstudentId())
	{
		
		document.getElementById("message").innerHTML ="Bad ID Format";
		$( "#mydialog" ).dialog({
		      height: 150,
		      width: 300,
		      modal: true
		    });
	//document.getElementById("idname").innerHTML="bad name";
	return false;	
	}
	
if(!checkname())
{
	
	document.getElementById("message").innerHTML ="Bad Name";
	$( "#mydialog" ).dialog({
	      height: 150,
	      width: 300,
	      modal: true
	    });
//document.getElementById("idname").innerHTML="bad name";
return false;	
}
if(!checkaddress()){
	document.getElementById("message").innerHTML ="Bad address";
	$( "#mydialog" ).dialog({
	      height: 150,
	      width: 300,
	      modal: true
	    });

return false;	
}


if(!checkzip()){alert("zip required");
document.getElementById("message").innerHTML ="bad zip format";
$( "#mydialog" ).dialog({
      height: 150,
      width: 300,
      modal: true
    });
return false;
}
if(!checkemail()){
	document.getElementById("message").innerHTML ="Bad email";
	$( "#mydialog" ).dialog({
	      height: 150,
	      width: 300,
	      modal: true
	    });
return false;
}
if(!checkliked()){
	
	document.getElementById("message").innerHTML ="Check at least 2 boxes";
	$( "#mydialog" ).dialog({
	      height: 150,
	      width: 300,
	      modal: true
	    });
return false;
}
if(!checkfind()){
	document.getElementById("message").innerHTML ="Select 1 option ";
	$( "#mydialog" ).dialog({
	      height: 150,
	      width: 300,
	      modal: true
	    });
return false;
}
return true;
}


function checkstudentId(){
	
	var name=document.getElementById("studentId").value;
	var reg=/^[a-zA-Z][0-9]{6}$/;
	return reg.test(name);    

	}

function checkname(){
	
var name=document.getElementById("Name").value;
var reg=/^[a-zA-Z]+$/;
return reg.test(name);    

}
function checkaddress(){
var address=document.getElementById("AddressStreet").value;
var reg=/^[0-9]+[\s][a-zA-Z\s]+$/;
return reg.test(address);   
}

function checkcity(){
var city=document.getElementById("City").value;
var reg=/^[a-zA-Z\s]+$/;
return reg.test(city);   

}

function checkzip(){
var zip=document.getElementById("zipp").value;
var reg=/^[\s]*[0-9]+[\s]*$/;
return reg.test(zip);   

}

function checkemail(){
var email=document.getElementById("email").value;
var reg=/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
return reg.test(email);   

}

function checkliked(){
var student=document.getElementById("student").checked;
var location=document.getElementById("location").checked
var campus=document.getElementById("campus").checked
var atmos=document.getElementById("atmos").checked
var dorm=document.getElementById("dorm").checked
var sport=document.getElementById("sport").checked
var count=0;
if(student)
count++;
if(location)
count++;
if(campus)
count++;
if(atmos)
count++;
if(dorm)
count++;
if(sport)
count++;

if(count<2)
return false;
return true;
}

function checkfind(){

if(document.getElementById("friend").checked)
return true;
if(document.getElementById("television").checked)
return true;
if(document.getElementById("internet").checked)
return true;
if(document.getElementById("other").checked)
return true;
return false;
}

function reset_f(){
alert();
document.getElementById("survey").reset();
}


function onLoad(){

/*
 var now=new Date();
var hour=now.getHours();
var name="";*/
/*
if(document.cookie){
var mycookie=unescape(document.cookie);
var cookietokens=mycookie.split("=");
name=cookietokens[1];
}else{
do{
name=window.prompt("please enter your name! At leaast 5 characters.");
}while(name.length<5);

setcookie(cname
document.cookie="name="+escape(name);

}

document.getElementById("round").innerHTML =name +"<h2> WELCOME TO OUR SURVEY PAGE!</h2>";
*/
checkCookie()

}

function setCookie(cname, cvalue,exday){
  //  alert(cvalue);
    var d = new Date();
    d.setTime(d.getTime() + (exday*24*60*60*1000));
    var expires = "expires="+d.toUTCString();

    document.cookie =cname+"="+cvalue+";"+expires; 
    document.getElementById("round").innerHTML =salute()+"<h2>" +unescape(cvalue)+ "</h2>  welcome to our survey page! Not  " + unescape(cvalue)+"? click <a href='javascript:reset()'>here</a>";
    document.getElementById("round2").innerHTML =salute()+"<h2>" +unescape(cvalue)+ "</h2>  welcome to our survey page! Not  " + unescape(cvalue)+"? click <a href='javascript:reset()'>here</a>";
    document.getElementById("round3").innerHTML =salute()+"<h2>" +unescape(cvalue)+ "</h2>  welcome to our survey page! Not  " + unescape(cvalue)+"? click <a href='javascript:reset()'>here</a>";
    document.getElementById("round4").innerHTML =salute()+"<h2>" +unescape(cvalue)+ "</h2>  welcome to our survey page! Not  " + unescape(cvalue)+"? click <a href='javascript:reset()'>here</a>";
    document.getElementById("round5").innerHTML =salute()+"<h2>" +unescape(cvalue)+ "</h2>  welcome to our survey page! Not  " + unescape(cvalue)+"? click <a href='javascript:reset()'>here</a>";

}
function getCookie(cname) {
//alert(document.cookie);
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var user = getCookie("username");

    if (user != "") {
 
      document.getElementById("round").innerHTML =salute()+"  "+unescape(user)+"! WELCOME  TO THE HOMEWORK PAGE!Not  " +unescape(user)+"?   click <a href='javascript:reset()'>here</a>";
      document.getElementById("round2").innerHTML =salute()+"  "+unescape(user)+"! WELCOME  TO THE HOMEWORK PAGE!Not  " +unescape(user)+"?   click <a href='javascript:reset()'>here</a>";
      document.getElementById("round3").innerHTML =salute()+"  "+unescape(user)+"! WELCOME  TO THE HOMEWORK PAGE!Not  " +unescape(user)+"?   click <a href='javascript:reset()'>here</a>";
      document.getElementById("round4").innerHTML =salute()+"  "+unescape(user)+"! WELCOME  TO THE HOMEWORK PAGE!Not  " +unescape(user)+"?   click <a href='javascript:reset()'>here</a>";
      document.getElementById("round5").innerHTML =salute()+"  "+unescape(user)+"! WELCOME  TO THE HOMEWORK PAGE!Not  " +unescape(user)+"?   click <a href='javascript:reset()'>here</a>";
        //alert("Welcome again " + user);
    } else {

         do{
             user=escape(window.prompt("please enter your name! At least 5 characters."));
           }while((user.length<5)||(user==null));
//alert(user);
       // if (user != "" && user != null) {
            setCookie("username", user, 365);
      //  }
    }
} 
function reset(){

//alert();
 var d = new Date();
    d.setTime(d.getTime());
   var cvalue="";
   var cname="username";
    var expires = "expires="+d.toUTCString();
    document.cookie =cname+"="+cvalue+";"+expires; 
document.getElementById("round").innerHTML ="";
document.getElementById("round2").innerHTML ="";
document.getElementById("round3").innerHTML ="";
document.getElementById("round4").innerHTML ="";
document.getElementById("round5").innerHTML ="";

 location.reload(); 

} 

function salute(){

var now=new Date();
var hour=now.getHours();
if(hour<12)return "Good Morning";
else{
hour=hour-12;
if(hour<6)return "Good Afternoon";
return "Good Evening";
}
}
/*
$( document ).ready(function() {
 $("input").mouseover(function() {
     alert("good ajax");});
                                });

$( document ).ready(function() {
 $("#zip").mouseover(function() {
         /*    $.ajax({
                     url:"data.json",
                     dataType:"json",
                     success:callback(text){
                             alert(JSON.parse(text));},
                     error: function(){alert("error");}
    // statusCode:{ 404: function() {alert( "page not found" );}}
});*//*
alert("good ajax");
});
});*/



$( document ).ready(function() {
 $("#zip").blur(function() {
          //   $.getJSON("data.json",function(data){callback(data);});
 $.ajax({
                    url: "script/data.json",
                    dataType: "text",
                    error:function(){alert();},
                    success: function(data) {                
                        var json = $.parseJSON(data);
                     callback(json);}});
    
});
});

function callback(data){
var items=data.zipcodes;
var zip=document.getElementById("zip").value.trim();  
var list=[];
//var exit=false;
var found=false;
var i=0;
var city;
var state;
while(found==false&&i!=items.length){
if(zip==items[i].zip){ found=true; city=items[i].city; state=items[i].state;}
i++;
}
if(found==true){document.getElementById("city").innerHTML=city;
               document.getElementById("state").innerHTML=state;
                document.getElementById("idzip").innerHTML="";}else{
               document.getElementById("city").innerHTML="";
               document.getElementById("state").innerHTML="";
               document.getElementById("idzip").innerHTML="invalid zip";
}

}



 $(function() {
$( "#homework" ).tabs();
});

 $(function(){
    $("#logo").tooltip();
  });

$(function() {
     var state = true;
    $( "button" ).click(function() {
      if ( state ) {
        $( "button" ).animate({
          backgroundColor: "#aa0000",
          color: "#fff",
          width: 500
        }, 1000 );
      } else {
        $( "button" ).animate({
          backgroundColor: "yellow",
          color: "#000",
          width: 500
        }, 1000 );
      }
      state = !state;
    });
  });


