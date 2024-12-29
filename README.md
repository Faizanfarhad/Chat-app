# Chat Application
A simple chat application built using Java and JavaFX . 
This application allows users to register, log in, and send real-time messages to other users.

## Features
- User registration and login
- Real-time messaging using sockets
- User-friendly interface with JavaFX
- User authentication with MySQL database


## Tech Stack
- **Language**: Java
- **GUI Framework**: JavaFX
- **Database**: MySQL
- **Networking**: Sockets


## Setup and Installation

### Prerequisites
- Install Java JDK (version 8 or higher)
- Install MySQL (if using MySQL for database)

### Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/Faizanfarhad/Chat-app.git
cd Chat-app

## Setup Database (if using MySQL)
##  Create the database and tables:

CREATE DATABASE chatapp;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    message TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


## Usage

1. Launch the application.
2. Register a new user with a unique username and password.
3. Log in with your credentials.
4. Start chatting with other users in real time.


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


