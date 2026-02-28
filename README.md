<div align="center">
  <h1>🚀 YouTube Tools Pro</h1>
  <p>A comprehensive Spring Boot application designed to streamline YouTube content creation through advanced automation, metadata extraction, and AI-powered insights.</p>

  <!-- Badges -->
  <p>
    <img src="https://img.shields.io/badge/Java-21-orange.svg" alt="Java 21" />
    <img src="https://img.shields.io/badge/Spring_Boot-4.0.3-brightgreen.svg" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/Thymeleaf-Template-blue.svg" alt="Thymeleaf" />
    <img src="https://img.shields.io/badge/Maven-Build-yellow.svg" alt="Maven" />
  </p>
</div>

## 🌟 Overview

**YouTube Tools Pro** is a powerful web-based application built with **Java** and **Spring Boot 4.0.3** to assist YouTube creators in optimizing their workflows. With its robust backend and modern frontend, the platform provides tools for video metadata extraction, SEO optimization, and thumbnail analysis.

Designed with best practices in mind—such as scalable MVC architecture, responsive UI design, and modular backend integration—this application demonstrates my strong proficiency in full-stack Java development. This project is **ready and live** for production-level scaling.

---

## 📸 Screenshots

*(To make the project shine for recruiters, add screenshots of your live application here)*

| 🏠 Dashboard | 📊 Video Details & Tag Extraction |
| :---: | :---: |
| <img src="[Placeholder: Add Dashboard Screenshot Here]" width="400" alt="Dashboard View"> | <img src="[Placeholder: Add Video Details Screenshot Here]" width="400" alt="Video Details View"> |

| 🖼️ Thumbnail Tools | 🔍 SEO Analysis |
| :---: | :---: |
| <img src="[Placeholder: Add Thumbnail Tools Screenshot Here]" width="400" alt="Thumbnail View"> | <img src="[Placeholder: Add SEO Tools Screenshot Here]" width="400" alt="SEO Analysis View"> |

> **Note:** Replace the `[Placeholder: Add ...]` links above with actual cropped screenshots of your running application to maximize impact for recruiters.

---

## 🔥 Key Features

- **🎥 Video Detail Extraction**: Paste a YouTube URL to instantly retrieve video tags, titles, and high-quality thumbnails. Data fetching simulated between frontend/backend via REST models.
- **🖼️ High-Res Thumbnail Downloader**: View, organize, and download video thumbnails in multiple resolutions directly from the portal.
- **📈 SEO Analyzer (SEO Tags)**: Designed to help optimize video reach with tailored tag extraction and analysis systems.
- **🤖 AI-Thumbnail Generator Ready**: Integrates views and workflows prepared for AI-driven custom thumbnail generation.
- **📱 Responsive UI/UX**: Fully responsive Thymeleaf templates ensuring fluid user experience across mobile, tablet, and desktop devices.
- **⚙️ Robust Backend Design**: Implements MVC design patterns for optimal separation of concerns, utilizing Spring Web controllers, services, and models.

---

## 🛠️ Tech Stack & Architecture

### Backend:
- **Java 21**: Leveraging the newest language features and performance benefits.
- **Spring Boot (v4.0.3)**: Core framework for extremely fast configuration, development, and application deployment.
- **Spring Boot MVC**: To manage application routes, controllers, and RESTful principles.
- **Maven**: Robust dependency management and build automation.
- **Lombok**: To reduce boilerplate code, ensuring perfectly clean classes.

### Frontend:
- **Thymeleaf**: Server-side Java template engine used to dynamically render HTML.
- **HTML5 & Modern CSS**: Modern UI design, utilizing flexbox/grid for interactive and aesthetic web interfaces.
- **JavaScript**: For client-side interactions and dynamic UI updates.

---

## 📂 Project Structure

```text
com.YoutubeTools/
├── src/
│   ├── main/
│   │   ├── java/com/YoutubeTools/
│   │   │   ├── YoutubeToolsApplication.java   # Main App Entry Point
│   │   │   ├── controller/                    # Handles HTTP Requests
│   │   │   │   ├── PageController.java
│   │   │   │   ├── ThumbnailController.java
│   │   │   │   └── VideoDetailsController.java
│   │   │   ├── service/                       # Business Logic
│   │   │   │   └── ThumbnailService.java
│   │   ├── resources/
│   │   │   ├── application.properties         # App Configs
│   │   │   ├── templates/                     # Thymeleaf HTML Views
│   │   │   │   ├── home.html
│   │   │   │   ├── video-details.html
│   │   │   │   ├── thumbnails.html
│   │   │   │   ├── seo.html
│   │   │   │   └── ai-thumbnail.html
└── pom.xml                                    # Maven Dependencies
```

---

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java JDK 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- An IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/YoutubeTools.git
   cd YoutubeTools
   ```

2. **Build the project:**
   Using the Maven wrapper to clean and install dependencies:
   ```bash
   ./mvnw clean install
   ```
   *(Or simply `mvn clean install` if Maven is installed globally)*

3. **Run the application:**
   You can start the Spring Boot application using the below command:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application:**
   Open your browser and navigate to:
   [http://localhost:8080](http://localhost:8080)

---

## 🎯 Why This Project Stands Out

- **Complete End-to-End Implementation:** Demonstrates the ability to handle both robust frontend templating and structured backend mechanics, proving elite full-stack awareness.
- **Modern Standards:** Uses the latest Java 21, coupled with the newest Spring Boot, displaying an active understanding of cutting-edge enterprise standards.
- **Clean Code Practices:** Employs precise MVC patterns, keeping controllers lean and separating logic layer into designated services.
- **Product-Driven Focus:** Built with a beautiful, user-friendly interface instead of just raw API endpoints, proving skills in delivering complete, highly-scalable software products.

---

<div align="center">
  <b>Developed by <a href="https://github.com/your-username">Priyanshu Singh</a></b>
  <br>
  <i>"Passionate about building scalable backend systems, robust architectures, and solving complex problems."</i>
</div>
