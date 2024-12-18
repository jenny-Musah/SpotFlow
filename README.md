# Overview:

This Spring Boot API service provides endpoints to calculate the price and tax of services based on a given service code and region. It also includes functionality to list available services in a specific region. The application adheres to SOLID principles, is fully unit-tested, and follows the best code formatting and design practices.


## API Endpoints

### 1. Calculate Tax

**Endpoint:** `POST /api/regional-tax/calculate-tax?region-id=1`

**Description:** Calculates the total price of a service, including taxes, based on the service code and region-id.

**Request Body:**

```json
{
    "serviceCode": 5888
}
```

**Response: successful**

```json
{
    "servicePrice": "$600.0",
    "governmentTax": "$30.0",
    "importDuty": "$0.5",
    "totalPrice": "$630.5"
}
```

**Response: Unsuccessful**

```
 Invalid Input

```


### 2. List Services by Region

**Endpoint:** `GET /api/regional/services?region-id=1`

**Description:** Retrieves a list of services and their information for a specified region.

**request Parameters:**

- `regionId`: The ID of the region (e.g., 1 for Lagos, 2 for Abuja, 3 for Osun).

**Response: Successful**

```json
[
    {
        "serviceName": "Netflix Streaming Subscription ",
        "serviceCode": 5888,
        "servicePrice": "$600.0",
        "regionId": 1
    },
    {
        "serviceName": "Udemy Course Payment",
        "serviceCode": 1000,
        "servicePrice": "$20.0",
        "regionId": 1
    }
]
```



**Response: Unsuccessful**

```
Invalid input,Region not found
```
    

## Data Model

### Regions

| Region Name | Region ID |
| ----------- | --------- |
| Lagos       | 1         |
| Abuja       | 2         |
| Osun        | 3         |

### Services

| Service Name                   | Service Code |
| ------------------------------ | ------------ |
| Netflix Streaming Subscription | 5888         |
| Google App Store Payment       | 6777         |
| Udemy Course Payment           | 1000         |

### Region-Specific Pricing

| Service Code | Region ID | Price    |
| ------------ | --------- | -------- |
| 5888         | 1         | $600.00  |
| 1000         | 1         | $20.00   |
| 5888         | 3         | $15.00   |
| 1000         | 2         | $5.10    |


## Getting Started

### Prerequisites

- Java 17 or later
- Maven or Gradle
- Spring Boot 3.x

### Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```
2. Build the project:
   ```bash
   ./mvnw clean install
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Testing

Run unit tests using Maven:

```bash
./mvnw test
```


