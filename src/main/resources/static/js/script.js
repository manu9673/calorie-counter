document.getElementById("logFoodForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const date = document.getElementById("date").value;
    const foodName = document.getElementById("foodName").value;
    const quantity = document.getElementById("quantity").value;

    if (!date || !foodName || !quantity) {
        displayToast("Please fill in all fields", "error");
        return;
    }

    const response = await fetch("/addFood", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `date=${date}&foodName=${foodName}&quantity=${quantity}`,
    });

    const message = await response.text();
    displayToast(message, "success");
});

document.getElementById("viewLogButton").addEventListener("click", async () => {
    const date = document.getElementById("logDate").value;

    if (!date) {
        displayToast("Please select a date", "error");
        return;
    }

    const response = await fetch(`/getLog?date=${date}`);
    const logEntries = await response.json();

    const resultsDiv = document.getElementById("logResults");
    resultsDiv.innerHTML = "<h3>Food Log</h3>";

    if (logEntries.length === 0) {
        resultsDiv.innerHTML += "<p>No entries found for this date.</p>";
        return;
    }

    resultsDiv.innerHTML += `
        <table>
            <thead>
                <tr>
                    <th>Food</th>
                    <th>Quantity (g)</th>
                    <th>Calories</th>
                </tr>
            </thead>
            <tbody>
                ${logEntries.map(entry => `
                    <tr>
                        <td>${entry.foodName}</td>
                        <td>${entry.quantity}</td>
                        <td>${entry.calories}</td>
                    </tr>
                `).join("")}
            </tbody>
        </table>
    `;
});

function displayToast(message, type) {
    const toast = document.createElement("div");
    toast.className = `toast ${type}`;
    toast.innerText = message;

    document.body.appendChild(toast);

    setTimeout(() => {
        toast.remove();
    }, 3000);
}
// Chart.js Example for Displaying Calorie Breakdown
function renderChart(foodEntries) {
    const ctx = document.getElementById("calorieChart").getContext("2d");
    const foodNames = foodEntries.map(entry => entry.foodName);
    const calorieValues = foodEntries.map(entry => entry.calories);

    new Chart(ctx, {
        type: "bar",
        data: {
            labels: foodNames,
            datasets: [{
                label: "Calories",
                data: calorieValues,
                backgroundColor: "rgba(75, 192, 192, 0.6)",
                borderColor: "rgba(75, 192, 192, 1)",
                borderWidth: 1,
            }],
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                },
            },
        },
    });
}
