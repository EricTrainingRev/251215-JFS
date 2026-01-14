const scheme = window.location.protocol;
const host = window.location.hostname;


async function sendGreetingRequest() {
    const input = document.getElementById('greetingInput');
    const name = input.value.trim();
    if (!name) {
        alert('Please enter a name.');
        return;
    }
    try {
        const response = await fetch(`${scheme}//${host}:8080/greet/${name}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const text = await response.text();
        alert(text);
    } catch (error) {
        alert('Error: ' + error.message);
    }
}
document.getElementById('greetingButton').addEventListener('click', sendGreetingRequest);