function validateForm(){
    var title = document.forms["editmovie"]["title"].value;
    if(title == ""){
      alert("title is required");
      return false;
}
var titleLength = title.length;

if(titleLength<2 || titleLength>100){
    alert("Title should have 2 to 100 characters");
    return false;
}
var boxOffice=document.forms["editmovie"]["boxOffice"].value;
if(isNaN(boxOffice)){
    alert("Box office has to be a number");
    return false;
}
if (boxOffice== ""){
    alert("Box office is required");
    return false;
}

var dateOfLaunch = document.forms["editmovie"]["dateOfLaunch"].value;
if(dateOfLaunch == ""){
    alert("date of launch is required");
    return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
alert("Incorrect date format.Expected format (dd/mm/yy)");
return false;
}
var genre=document.forms["editmovie"]["genre"].value;
if(genre=="0"){
      alert("Genre is required");
}

}