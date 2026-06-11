#!/bin/bash

# ==============================================================================
# Quick Start/Stop Orchestration Script for Local Development Environment
# Optimized for Windows environments (Git Bash / WSL / PowerShell)
# ==============================================================================

set -e

# Resolve and navigate to the project root directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
cd "$ROOT_DIR"

TARGET_COMMAND=$1

# ==============================================================================
# ENVIRONMENT CONFIGURATION
# ==============================================================================

DIR_DOCKER="docker"
DIR_BACKEND="backend"
DIR_FRONTEND="frontend"

START_CMD_BE="mvn spring-boot:run"
START_CMD_FE="npm start"

DB_CONTAINER_NAME="dev-mysql"

# ==============================================================================
# STOP MODE (Environment Teardown)
# ==============================================================================
if [ "$TARGET_COMMAND" == "stop" ]; then
  echo "[INFO] [TEARDOWN] Initiating development environment shutdown..."

  if [ -d "$DIR_DOCKER" ]; then
    cd "$DIR_DOCKER"
    docker compose down || true
    cd ..
  fi

  echo "[INFO] [CLEANUP] Terminating dangling Java and Node processes to free network ports..."
  taskkill.exe /F /IM java.exe 2>/dev/null || true
  taskkill.exe /F /IM node.exe 2>/dev/null || true

  echo "[SUCCESS] Environment teardown completed. All resources released."
  exit 0
fi

# ==============================================================================
# COMMAND VALIDATION
# ==============================================================================

if [ "$TARGET_COMMAND" != "start" ]; then
  echo "[ERROR] Invalid usage."
  echo "Usage syntax: bash run.sh start|stop"
  exit 1
fi

# ==============================================================================
# 1. INFRASTRUCTURE INITIALIZATION (DOCKER)
# ==============================================================================

if [ -d "$DIR_DOCKER" ]; then
  echo "[INFO] [DOCKER] Launching Docker Compose infrastructure..."
  cd "$DIR_DOCKER"
  docker compose up -d
  cd ..
  echo "[SUCCESS] Docker infrastructure services are running."
fi

# ==============================================================================
# 2. DATABASE HEALTHCHECK POLLING
# ==============================================================================

if docker ps -a --format '{{.Names}}' | grep -Eq "^${DB_CONTAINER_NAME}$"; then
  echo "[INFO] [DATABASE] Polling database service health status..."
  until [ "$(docker inspect -f '{{.State.Health.Status}}' "$DB_CONTAINER_NAME" 2>/dev/null)" = "healthy" ]; do
    printf "."
    sleep 2
  done
  echo -e "\n[SUCCESS] Database service reported healthy. Ready for connections."
fi

# ==============================================================================
# 3. BACKEND SERVICE STARTUP
# ==============================================================================

if [ -d "$DIR_BACKEND" ]; then
  echo "[INFO] [BACKEND] Launching Backend application service..."
  cd "$DIR_BACKEND"

  # Normalize Windows-style carriage return line endings (CRLF) for the Maven wrapper
  if [ -f mvnw ]; then sed -i 's/\r$//' mvnw || true; fi

  # Execute asynchronously on Windows to prevent terminal locking (logs routed to file)
  cmd.exe /c "$START_CMD_BE" > ../backend.log 2>&1 &
  cd ..
  echo "[SUCCESS] Backend service process detached. Logs routed to: backend.log"
fi

# ==============================================================================
# 4. FRONTEND APPLICATION STARTUP
# ==============================================================================

if [ -d "$DIR_FRONTEND" ]; then
  echo "[INFO] [FRONTEND] Launching Frontend application service..."
  cd "$DIR_FRONTEND"

  # Execute asynchronously on Windows to keep the current terminal session free
  cmd.exe /c "$START_CMD_FE" > ../frontend.log 2>&1 &
  cd ..
  echo "[SUCCESS] Frontend application process detached. Logs routed to: frontend.log"
fi

# ==============================================================================
# SUMMARY & SERVICE MONITORING DETAILS
# ==============================================================================

echo "========================================================================"
echo " [SUCCESS] All application services have been successfully initialized."
echo "           Please allow a brief window for runtime compilation."
echo " "
echo " [INFO] To inspect active log streams in real-time, execute:"
echo "        -> tail -f backend.log"
echo "        -> tail -f frontend.log"
echo "========================================================================"