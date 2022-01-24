function checkmatch(){
    let password = document.getElementById("password").value;
    let repassword = document.getElementById("re-password").value;
    if(password !== repassword){
        document.getElementById("loginalert").classList.add("showalert");
        setTimeout(hidealert, 5000);
        document.getElementById('submit-btn').disabled = true; 
    } else{
        document.getElementById('submit-btn').disabled = false; 
    }
}

function hidealert(){
    document.getElementById("loginalert").classList.remove("showalert")
}

function clickregister(){
   let email =  document.getElementById("email").value;
    document.getElementById("email-verify").innerHTML = email;
    
}