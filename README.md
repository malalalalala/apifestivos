# API Validar Festivos

The **API Validar Festivos** is a RESTful API that provides information about holidays. It offers endpoints to retrieve a list of holidays and to verify if a specific date is a holiday.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [List Holidays](#list-holidays)
  - [Verify Holiday](#verify-holiday)
- [Endpoints](#endpoints)
- [Response Formats](#response-formats)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before running the API, make sure you have the following installed:

- Java 
- Maven 
- Your preferred IDE (e.g., IntelliJ, Eclipse)

### Installation

  Clone the repository:

   ```
   git clone https://github.com/malalalalala/apifestivos.git
   ```

## Usage

The API will be accessible at http://localhost:8080.

### List Holidays

**Endpoint:** `GET /festivos/listar/{year}`

Retrieve a list of holidays for a specific year.

**Example:**
```
curl http://localhost:8080/festivos/listar/2023
```

## Verify Holiday

**Endpoint:** `GET /festivos/verificar/{year}/{month}/{day}`

Verify if a specific date is a holiday.

```
curl http://localhost:8080/festivos/verificar/2023/11/25
```

## Response Formats
The API returns JSON-formatted responses.

**Example:**

```
{
  "nombre": "Navidad",
  "fecha": 1987/12/25"
}
```
```
Es festivo.
```
