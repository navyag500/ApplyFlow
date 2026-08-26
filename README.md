ApplyFlow

ApplyFlow is a job application tracking system built with Java and Spring Boot.
It is designed to help users organize and keep track of their job applications in one place.

🚧 Project Status

Currently in development

The project is being built incrementally, with new features added and improved over time.

🎯 Planned Features
User management
Add and manage job applications
Track application status
View all applications
Update application details
Delete applications
Search and filter applications
Dashboard with application statistics
REST APIs
Modern responsive frontend
Database persistence
🛠️ Tech Stack
Backend
Java
Spring Boot
Spring Data JPA
Hibernate
Maven
Database
MySQL
Tools
Git & GitHub
Postman
Visual Studio Code
📁 Project Structure
src/
└── main/
    ├── java/
    │   └── com/
    │       └── applyflow/
    │           ├── controller/
    │           ├── entity/
    │           ├── repository/
    │           ├── service/
    │           └── ApplyflowApplication.java
    │
    └── resources/
        └── application.properties
🔌 Current API Endpoints
Method	Endpoint	Description
POST	/users	Create a user
POST	/applications	Create a job application
🗄️ Current Entities
User

Currently contains:

id
name
email
password
JobApplication

Currently contains:

id
companyName
jobRole
status
▶️ Running the Project
Make sure MySQL is running.
Create the applyflow database.
Configure the database credentials.
Set the DB_PASSWORD environment variable.
Run ApplyflowApplication.java.
The application runs on:
http://localhost:8080
📌 Development Approach

ApplyFlow is being developed step by step, with each feature tested and committed separately to GitHub.

The goal is to build a practical full-stack application while learning and applying real-world software development practices.

👨‍💻 Author

Navya Gupta