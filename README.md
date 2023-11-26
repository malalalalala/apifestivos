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

## List Holidays

**Endpoint:** `GET /festivos/listar/{year}`

Retrieve a list of holidays for a specific year.

**Example:**
```
curl http://localhost:8080/festivos/listar/2023
```

### Response Formats

```
[
    {
        "nombre": "Año nuevo",
        "fecha": "2023/01/01"
    },
    {
        "nombre": "Santos Reyes",
        "fecha": "2023/01/09"
    },
    {
        "nombre": "San José",
        "fecha": "2023/03/20"
    },
    {
        "nombre": "Jueves Santo",
        "fecha": "2023/04/06"
    },
    {
        "nombre": "Viernes Santo",
        "fecha": "2023/04/07"
    },
    {
        "nombre": "Domingo de Pascua",
        "fecha": "2023/04/09"
    },
    {
        "nombre": "Día del Trabajo",
        "fecha": "2023/05/01"
    },
    {
        "nombre": "Ascensión del Señor",
        "fecha": "2023/05/22"
    },
    {
        "nombre": "Corpus Christi",
        "fecha": "2023/06/12"
    },
    {
        "nombre": "Sagrado Corazón de Jesús",
        "fecha": "2023/06/19"
    },
    {
        "nombre": "San Pedro y San Pablo",
        "fecha": "2023/07/03"
    },
    {
        "nombre": "Independencia Colombia",
        "fecha": "2023/07/20"
    },
    {
        "nombre": "Batalla de Boyacá",
        "fecha": "2023/08/07"
    },
    {
        "nombre": "Asunción de la Virgen",
        "fecha": "2023/08/21"
    },
    {
        "nombre": "Día de la Raza",
        "fecha": "2023/10/16"
    },
    {
        "nombre": "Todos los santos",
        "fecha": "2023/11/06"
    },
    {
        "nombre": "Independencia de Cartagena",
        "fecha": "2023/11/13"
    },
    {
        "nombre": "Inmaculada Concepción",
        "fecha": "2023/12/08"
    },
    {
        "nombre": "Navidad",
        "fecha": "2023/12/25"
    }
]
```


## Verify Holiday

**Endpoint:** `GET /festivos/verificar/{year}/{month}/{day}`

Verify if a specific date is a holiday.

**Example:**

```
curl http://localhost:8080/festivos/verificar/2023/11/25
```

### Response Formats
The API returns a String

```
Es festivo.
```
