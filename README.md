# Chat App Using WebSocket

A real-time **Chat Application** built with **Spring Boot** and **WebSocket**.  
This project demonstrates how to create a simple and effective chat system where users can send and receive messages instantly without page reloads.

---

## ✨ Features

- 🔥 Real-time messaging using WebSocket
- 🛠️ Backend powered by Spring Boot
- 🧠 Easy-to-understand code structure
- 🎯 Lightweight and fast performance
- 🎨 Simple, clean frontend

---

## 🚀 Tech Stack

- **Backend:** Java, Spring Boot, WebSocket (STOMP over SockJS)
- **Frontend:** HTML, JavaScript
- **Build Tool:** Maven

---

## 🛠️ Project Structure

```plaintext
├── src/main/java/com/example/websocket
│   ├── config
│   │   └── WebSocketConfig.java         # WebSocket configuration
│   ├── controller
│   │   └── ChatController.java           # Controller to handle chat messages
│   ├── model
│   │   └── Message.java                  # Model for messages
│   └── WebSocketApplication.java         # Main Spring Boot application
│
├── src/main/resources/static
│   └── index.html                        # Frontend HTML page
│
└── pom.xml                               # Maven dependencies
```
---

## 🏃‍♂️ Getting Started

### Prerequisites

- Java 17+
- Maven

### Run the application

```bash
git clone https://github.com/Nibid/Chat_App_Using_WebSocket.git
cd Chat_App_Using_WebSocket
mvn spring-boot:run
```
Then, open your browser and navigate to:
http://localhost:8080

## 📚 How it Works

- **WebSocketConfig:** Sets up the WebSocket endpoints and message broker.
- **ChatController:** Receives messages from clients and broadcasts them to subscribed users.
- **Frontend (index.html):** Connects to WebSocket server using SockJS and STOMP to send/receive chat messages.

---

## 📌 To-Do (Improvements)

- [ ] Add multiple chat rooms
- [ ] Try Frontend and UI/UX with better styling

---

## ❤️ Acknowledgements

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [WebSocket Basics](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API)
- [SockJS and STOMP.js Documentation](https://stomp-js.github.io/stomp-websocket/codo/sockjs.html)
