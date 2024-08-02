document.getElementById('petshopForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const dateInput = document.getElementById('date').value;
    const smallDogs = document.getElementById('smallDogs').value;
    const bigDogs = document.getElementById('bigDogs').value;

    if (!isValidYear(dateInput)) {
        alert("The year must have exactly 4 digits.");
        return;
    }

    const date = formatDate(dateInput);

    const requestData = {
        date: date,
        smallDogs: parseInt(smallDogs),
        largeDogs: parseInt(bigDogs)
    };

    try {
        const response = await fetch(`http://localhost:8080/petshops/best?date=${encodeURIComponent(date)}&smallDogs=${encodeURIComponent(smallDogs)}&largeDogs=${encodeURIComponent(bigDogs)}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Network response was not ok: ${errorText}`);
        }

        const result = await response.text();
        document.getElementById('form-container').style.display = 'none';
        document.getElementById('result-container').style.display = 'block';
        document.getElementById('result').innerText = result;
    } catch (error) {
        document.getElementById('form-container').style.display = 'none';
        document.getElementById('result-container').style.display = 'block';
        document.getElementById('result').innerText = `Error fetching data: ${error.message}`;
    }
});

document.getElementById('retryButton').addEventListener('click', function () {
    document.getElementById('form-container').style.display = 'block';
    document.getElementById('result-container').style.display = 'none';
    document.getElementById('petshopForm').reset();
    document.getElementById('result').innerText = '';
});

function formatDate(inputDate) {
    const date = new Date(inputDate);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
}

function isValidYear(dateString) {
    const year = new Date(dateString).getFullYear();
    return year.toString().length === 4;
}
