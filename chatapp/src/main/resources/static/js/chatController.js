function autoResize(textarea) {
    textarea.style.height = 'auto';
    const maxHeight = window.innerHeight - textarea.getBoundingClientRect().top - 10; // 10px for padding
    if (textarea.scrollHeight > maxHeight) {
        textarea.style.height = maxHeight + 'px';
    } else {
        textarea.style.height = textarea.scrollHeight + 'px';
    }
}
//darkmode
function darkMode() {
    document.getElementById("msgbox").style.background = "black";
    msgbox = document.getElementById("msgbox");
    msgbox.classList.add("placeHolderText");
    msgbox.style.borderColor = "white";
    areabox = document.getElementById("areabox");
    areabox.style.borderColor = "white";
    areabox.style.backgroundColor = "black";
    document.body.style.background = "black";
    header = document.getElementById("header");
    header.style.color = "white";
    msgbox.style.color = "#ffffff";
}

function sendMessage() {
    // Implement the message sending logic here
    const message = document.querySelector('.userInputMessage').value;
    console.log("Message sent: ", message);
    // Clear the textarea after sending the message
    document.querySelector('.userInputMessage').value = '';
    autoResize(document.querySelector('.userInputMessage'));
    //notifies a message was sent, then resets the placeholder
    document.getElementById("msgbox").placeholder = "sent!"
    setTimeout(() =>{
        document.getElementById("msgbox").placeholder = "Type your message here..."
    }, 1000)
    

}

