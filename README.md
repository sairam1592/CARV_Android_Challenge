# Carv Android Challenge
 A Android Coding Challenge provided by Carly


## Problem 1: Dynamic Circle Visualization

A dynamic view in Jetpack Compose renders a list of circles based on a set of coordinates, simulating a connection signal's visual representation.

### Features
- Dynamic generation of circle views.
- Customizable coordinates and radius for each circle.
- Built with Jetpack Compose for seamless UI integration.

## Problem 2: Pub-Sub Messaging System

A type-safe messaging system for publishing events and subscribing to them within the app. It includes an example with string and float data events.

### Features
- Type-safe API for event publishing and subscribing.
- Support for multiple event types with associated data.
- Clean architecture with MVVM pattern using Kotlin Coroutines, StateFlow, SharedFlow and HILT.

## Problem 3: Connection Status Monitor

Monitors the connection status of an unreliable peripheral sensor, alerting users when the connection is lost for an extended period.

### Features
- Emulates a sequence of connection statuses with coroutines.
- Detects disconnection periods longer than a predefined threshold.
- MVVM architecture with Clean practices, utilizing HILT for dependency injection.
- Status is connected with the Composable function written for Problem 1

## Installation and Usage

Clone the repository and import the project into Android Studio. Ensure you have the latest version of Android Studio and the Kotlin plugin installed. Build and run the application on an emulator or a physical device.
