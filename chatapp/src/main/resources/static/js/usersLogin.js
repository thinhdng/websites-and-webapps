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

//functionality with signing up added
//clicking the register button will now show the fields for actually signing up
document.getElementById("registerbutton").addEventListener('click',function(event){
  var fields = document.getElementById("emailField");
  fields.style.display = "block"
  var signbutton = document.getElementById("signup");
  signbutton.style.display = "block";
  var reg = document.getElementById("registerbutton");
  reg.style.display = "none"
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

async function signUp(username, password, email) {
    const date = new Date();
    
    try{
    const response = await fetch("http://localhost:8080/login/addUser", {
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
      });
      if(response.status==409){
        alert(`User already exist`);
      }
      window.location.href='chat';
      alert(`Signed up successfully!`);
    }catch (error){
      console.error(error.message);
    }


}


async function signIn(username, password) {
  try{
    const response = await fetch("http://localhost:8080/login/auth", {
        method: "POST",
        body: JSON.stringify({
            username:username,
            password:password,
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      });

      if(response.status==404){
        alert(`User does not exist - please sign up`);
      }

      if(response.status==401){
        alert(`Incorrect password`);
      }
      window.location.href='chat';
    }catch (error){
      console.error(error.message);
    }

}
