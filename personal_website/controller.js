document.addEventListener('DOMContentLoaded', (event) => {
    const button = document.getElementById('changeTextButton');
    const message = document.getElementById('message');

    button.addEventListener('click', () => {
        message.textContent = 'Surprise!!';
    });
});