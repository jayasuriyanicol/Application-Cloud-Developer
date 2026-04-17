
// * This file sets up an Axios instance for making HTTP requests to the backend API. The base URL is configured to point to the local server running on port 8080, which is where the backend services are expected to be hosted. By creating a centralized API instance, we can easily manage and reuse the configuration for all our API calls throughout the application, ensuring consistency and simplifying maintenance. This setup allows us to make requests to the backend for various operations such as fetching account details, registering users, and handling transactions without having to repeat the base URL configuration in every component.
import axios from 'axios';

const api = axios.create({
    
    // ? Base URL for the backend API, pointing to the local server where the banking services are hosted. This allows us to make requests to the backend without having to specify the full URL in every request, simplifying our code and ensuring consistency across all API calls.
    baseURL: 'http://localhost:8080', 
});

export default api;

