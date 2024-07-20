document.addEventListener('DOMContentLoaded', function(){
    document.getElementById("signInButton").addEventListener('click',function(event){
        event.preventDefault();
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        signIn(username, password);
    });

    document.getElementById("signUpButton").addEventListener('click',function(event){
        event.preventDefault();
        unhideElement();
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let email = document.getElementById('email').value;
        signUp(username, password, email);
    });
});

function signIn(username, password) {
    alert(`you have signed in as ${username} password ${password}`);
}

function signUp(username, password, email) {
    
}

function unhideElement() {
    document.getElementById("emailField").style.display = "block";
}