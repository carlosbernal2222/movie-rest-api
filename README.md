# Movie REST API

## Overview
The Movie REST API is a Spring Boot application designed to manage movie data and reviews. It provides a set of RESTful endpoints for creating, retrieving, and managing movie and review information.

## Dependencies
- **Spring Boot**: For building stand-alone, production-grade Spring-based applications.
- **Spring Data MongoDB**: For MongoDB integration.
- **Lombok**: To reduce boilerplate code for model objects.
- **Spring Boot DevTools**: For development-time features.
- **Spring Boot Starter Test**: For testing Spring Boot applications.
- **Spring Dotenv**: For managing environment variables.

## Project Structure
- `MoviesApplication.java`: The main class that runs the Spring Boot application.
- `MovieController.java`: REST controller for handling movie-related requests.
- `ReviewController.java`: REST controller for handling review-related requests.
- `Movie.java`: Model class representing a movie.
- `Review.java`: Model class representing a review.
- `MovieRepository.java`: Repository interface for movie data operations.
- `ReviewRepository.java`: Repository interface for review data operations.
- `MovieService.java`: Service class for movie-related business logic.
- `ReviewService.java`: Service class for review-related business logic.
- `application.properties`: Configuration properties for the application.

## Functionality
- **Movie Management**: Add and retrieve movie information.
- **Review Management**: Add reviews to movies.
- **Data Storage**: MongoDB is used for persisting data.

## Running the Application
Ensure you have Maven and Java 17 installed. Run the following command in the root directory of the project:
```bash
mvn spring-boot:run

##API Endpoints
GET /api/v1/movies: Retrieve all movies.
GET /api/v1/movies/{imdbId}: Retrieve a single movie by its IMDb ID.
POST /api/v1/reviews: Create a new review for a movie.

