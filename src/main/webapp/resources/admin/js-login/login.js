function validateLogin(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if(username== "" || password == ""){
        document.getElementById("loginalert").classList.add("showalert");
        setTimeout(hidealert, 5000);
    }
}

function hidealert(){
    document.getElementById("loginalert").classList.remove("showalert")
}