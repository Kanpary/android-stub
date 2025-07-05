#!/usr/bin/env bash
# Unix Gradle wrapper launch script
# Copie este arquivo e torne executável (chmod +x gradlew)
WRAPPER_DIR=$(dirname "$0")/gradle/wrapper
java -jar "$WRAPPER_DIR/gradle-wrapper.jar" "$@"
