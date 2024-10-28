# URL Shortener

A simple and efficient URL shortener built with Spring Boot and Java. This project allows users to shorten long URLs and easily redirect to the original URLs using a short key.

## Features

- **Shorten URLs**: Convert long URLs into short, manageable links.
- **Redirection**: Redirect users to the original URL using the generated short key.
- **RESTful APIs**: Simple and intuitive APIs for URL shortening and redirection.

## Technologies Used

- Java 17
- Spring Boot
- Gradle
- MySQL 8

## API Endpoints

### 1. Redirect to Original URL

**Method**: `GET`  
**URL**: `http://localhost:8080/url/{shortUrlKey}`

**Example Request:**
```bash
curl --location --globoff 'http://localhost:8080/url/m2t9mi'
```

**Response:**
- **Status Code**: `302 Found`
- **Location**: The original URL to which the short URL redirects.

---

### 2. Create Short URL

**Method**: `POST`  
**URL**: `http://localhost:8080/url/create`  

**Request Body:**
```json
{
    "url": "https://www.example.com"
}
```

**Example Request:**
```bash
curl --location 'http://localhost:8080/url/create' \
--header 'Content-Type: application/json' \
--data '{
    "url": "https://www.example.com"
}'
```

**Response:**
```json
{
    "url": "https://www.example.com",
    "shortUrl": "http://localhost:8080/m2t9mi"
}
```

### Request Parameters
- **url**: The original long URL that you want to shorten.

## Getting Started

### Prerequisites

- Java 17
- Gradle
- MySQL 8

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/url-shortener.git
   cd url-shortener
   ```

2. Configure your MySQL database:
   - Create a new database.
   - Update the `application.properties` file with your database credentials.

3. Build the project:
   ```bash
   ./gradlew build
   ```

4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

5. Access the application at `http://localhost:8080`.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or create an issue for any enhancements or bugs.

## Acknowledgments

- Inspired by various URL shortening services.
- Thanks to the Spring Boot community for their amazing framework.
