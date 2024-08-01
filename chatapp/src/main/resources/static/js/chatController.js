function autoResize(textarea) {
    textarea.style.height = 'auto';
    const maxHeight = window.innerHeight - textarea.getBoundingClientRect().top - 10; // 10px for padding
    if (textarea.scrollHeight > maxHeight) {
        textarea.style.height = maxHeight + 'px';
    } else {
        textarea.style.height = textarea.scrollHeight + 'px';
    }
}

function sendMessage() {
    // Implement the message sending logic here
    const message = document.querySelector('.userInputMessage').value;
    console.log("Message sent: ", message);
    // Clear the textarea after sending the message
    document.querySelector('.userInputMessage').value = '';
    autoResize(document.querySelector('.userInputMessage'));
}