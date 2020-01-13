function validateMenuItemForm(){
    var name = document.forms["MenuItemForm"]["name"].value;
    if(name == ""){
      alert("Name is required");
      return false;
}
var nameLength = name.length;

if(nameLength<2 || nameLength>65){
    alert("Name should have 2 to 65 characters");
    return false;
}
var price=document.forms["editMenuItemForm"]["price"].value;
if(isNaN(price)){
    alert("Price has to be a number");
    return false;
}
if (price== ""){
    alert("Price is required");
    return false;
}

var dateOfLaunch = document.forms["editMenuItemform"]["dateOfLaunch"].value;
if(dateOfLaunch == ""){
    alert("Date of launch is required");
    return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
alert("Incorrect date format.Expected format (dd/mm/yy)");
return false;
}
var category=document.forms["editMenuItemForm"]["category"].value;
if(category=="0"){
      alert("Category is required");
      return false;
}
}