# Environment Quick Start & Stop Script

## Description

This script (`run.sh`) automates the quick initialization and teardown of the entire local development ecosystem (Docker infrastructure, Backend, and Frontend). It manages execution flows asynchronously in the background to keep your terminal free and unblocked.

The script is highly optimized for **Windows** environments using **Git Bash** or **PowerShell**, ensuring seamless compatibility with `cmd.exe` processes.

---

## Prerequisites

Before running the script, ensure you have the following installed and configured on your system:

* **Java JDK 17** (Verify your global path or adjust the hardcoded path inside the script if needed)
* **Maven** or the project's internal wrapper (`mvnw`)
* **Docker Desktop** (with `docker compose` support)
* **Node.js & npm** (Angular CLI installed globally is highly recommended)
* **Git Bash** (The recommended execution terminal for Windows users)

---

## Expected Project Structure

For the script to resolve paths correctly, it should be placed at the root level of your workspace with the following folder naming convention:

```text
project-root/
│
├── run.sh                  <- Placed at the main project root
├── docker/
│   └── docker-compose.yml
├── backend/                <- Backend codebase directory (e.g., BE or backend)
│   └── pom.xml
└── frontend/               <- Frontend codebase directory (e.g., FE or frontend)
    └── package.json