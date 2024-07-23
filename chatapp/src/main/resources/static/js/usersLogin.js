document.addEventListener('DOMContentLoaded', function(){
    document.getElementById("signInButton").addEventListener('click',function(event){
        event.preventDefault();
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        signIn(username, password);
    });

    document.getElementById("signUpButton").addEventListener('click',function(event){
        event.preventDefault();
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let email = document.getElementById('email').value;
        signUp(username, password, email);
    });
});

function formatDate(date) {
    // Extract the year, month, and day from the date object
    const year = date.getFullYear();
    let month = date.getMonth() + 1; // getMonth() returns 0-11, so add 1
    let day = date.getDate();
  
    // Ensure month and day are two digits
    month = month < 10 ? '0' + month : month;
    day = day < 10 ? '0' + day : day;
  
    // Concatenate into the desired format
    return `${year}/${month}/${day}`;
}  

function signUp(username, password, email) {
    const date = new Date();
    fetch("http://localhost:8080/login/addUser", {
        method: "POST",
        body: JSON.stringify({
            username:username,
            password:password,
            email:email,
            created_at:formatDate(date)
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
        .then((response) => response.json())
        .then((json) => console.log(json));
}


function signIn(username, password) {
    const date = new Date();
    fetch("http://localhost:8080/login/addUser", {
        method: "POST",
        body: JSON.stringify({
            username:username,
            password:password,
            email:email,
            created_at:formatDate(date)
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
        .then((response) => response.json())
        .then((json) => console.log(json));

}
