
# Calorie Counter Application

A web-based calorie counter application built with **Spring Boot**, **HTML**, **CSS**, and **JavaScript**. This project allows users to log their daily food intake, track calories consumed, and view calorie entries on a daily basis. It also includes enhanced visuals and responsiveness for an improved user experience.

---

## Features

1. **Log Daily Food Intake**:  
   - Input the food name, quantity, and calories.
   - Log entries with corresponding dates.

2. **View Calorie Entries Day-Wise**:  
   - Filter and display calorie logs for specific dates.
   - Data is shown in a user-friendly table.

3. **Responsive Design**:  
   - Fully responsive layout that adapts to all devices (mobile, tablet, and desktop).

4. **Interactive UI Enhancements**:  
   - Background images and styles for a visually appealing interface.
   - Improved buttons and hover effects.

5. **Expandable Design**:  
   - The codebase is modular and allows for adding more features like charts, food categories, or calorie goals.

---

## Technologies Used

1. **Backend**:  
   - Spring Boot (Java)
   - My sql

2. **Frontend**:  
   - HTML5  
   - CSS3 (with background images and responsiveness)  
   - JavaScript (for dynamic interactions)

3. **Build Tool**:  
   - Maven

4. **Tools & Frameworks**:  
   - Thymeleaf for server-side rendering.
   - Chart.js (optional, for visualizing calorie data).

---

## Installation

### Prerequisites

- Java 17+  
- Maven 3.6+  
- A code editor (eclipse Ide)

### Steps to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd calorie-counter-project
   ```

2. **Build the Project**:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**:
   - Open a browser and navigate to:  
     `http://localhost:8080`

---

## Directory Structure

```plaintext
calorie-counter-project
│
├── src/main/java/com/example/caloriecounter
│   ├── CalorieCounterApplication.java  # Main Application Entry Point
│   ├── controller
│   │   └── FoodLogController.java      # Handles HTTP requests
│   ├── model
│   │   └── FoodLog.java                # Data model for food logs
│   └── repository
│       └── FoodLogRepository.java      # Interface for CRUD operations
│
├── src/main/resources
│   ├── static
│   │   ├── css
│   │   │   └── styles.css              # Custom styles for the project
│   │   ├── images
│   │   │   ├── background.jpg          # Background image
│   │   │   └── header.jpg              # Header image
│   │   └── js
│   │       └── script.js               # JavaScript logic
│   └── templates
│       ├── index.html                  # Main page (food log form + table)
│       └── view-log.html               # View logs by date
│
├── src/main/resources/application.properties  # Spring Boot configurations
├── pom.xml                                    # Maven dependencies
└── README.md                                  # Project documentation
```

---

## API Endpoints

1. **Add Food Log**  
   - **Endpoint**: `POST /api/food-log`  
   - **Payload**:
     ```json
     {
       "date": "2024-01-01",
       "foodName": "Apple",
       "quantity": 150,
       "calories": 80
     }
     ```
   - **Response**: Status 201 (Created)

2. **Get Logs By Date**  
   - **Endpoint**: `GET /api/food-log/{date}`  
   - **Response**:  
     ```json
     [
       {
         "date": "2024-01-01",
         "foodName": "Apple",
         "quantity": 150,
         "calories": 80
       }
     ]
     ```

---

## Screenshots

### 1. Home Page (Log Food)
![Home Page](static/images/header.jpg)

### 2. View Logs (Table Layout)
![Logs Page](static/images/background.jpg)

---

## Future Enhancements

- **Charts & Visualizations**:  
  Use Chart.js to display calorie breakdowns in pie or bar charts.
  
- **User Authentication**:  
  Allow users to create accounts and log in to manage personal food logs.

- **Calorie Goal Tracking**:  
  Set daily calorie goals and track progress.

- **API Integration**:  
  Fetch calorie data for foods from external APIs like the USDA FoodData API.

---

## License

This project is licensed under the MIT License. Feel free to use, modify, and distribute this project for personal or commercial purposes.

---

## Contact

For questions, feedback, or collaboration, feel free to reach out:

- **Email**: abhishek9673974706@gmail.com
- **GitHub**: [YourGitHubProfile](https://github.com/manu9673)
