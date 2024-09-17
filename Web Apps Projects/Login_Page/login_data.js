function login_data(){
    var name = document.getElementById("name").value;
    
    var gender;
    var male = document.getElementById("male");
    var female = document.getElementById("female");
    
    var practiced_sports = "";
    var football = document.getElementById("football");
    var basketball = document.getElementById("basketball");
    var tennis = document.getElementById("tennis");
    var fencing = document.getElementById("fencing");
    var archery = document.getElementById("archery");

    var email = document.getElementById("email").value;

    if(male.checked){
        gender = male.value;
    }
    else if(female.checked){
        gender = female.value;
    }
    else{
        gender = "Unspecified";
    }

    if(football.checked){
        practiced_sports += football.value + "; ";
    }
    if(basketball.checked){
        practiced_sports += basketball.value+ "; ";
    }
    if(tennis.checked){
        practiced_sports += tennis.value+ "; ";
    }
    if(fencing.checked){
        practiced_sports += fencing.value+ "; ";
    }
    if(archery.checked){
        practiced_sports += archery.value+ "; ";
    }

    var data = "<br>Name: " + name + "<br><br>" 
    + "Gender: " + gender + "<br><br>" 
    + "Practiced sports: " + practiced_sports + "<br><br>" 
    + "Gmail: " + email + "<br><br>";

    document.getElementById("data-reporting").innerHTML = data;
}