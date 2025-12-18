# Taskmanager Example Application

This is an example application showcasing core Spring functionality and how to implement it
for the purposes of building an application. This Taskmanager application has a few core
features and users

## Users
This application supports two types of users:
- Admin
  - Manage adding Clients to the application
- Clients
  - Users that want to utilize the Taskmanager application

## Functionality
- Admin can create new clients
- Clients can log in and log out
- Clients can create tasks and subtasks
- Clients can update the completion status of subtasks and tasks

## Application Design
This application has three primary layers:
1. API
2. Service
3. Repository

The API handles incoming HTTP requests and returns responses. The Service Layer handles
enforcing all business rules and formatting response data. The Repository layer handles
interacting with the database

## Entities

### User Entities
- Admin
  - AdminId (identifier)
  - Username
  - Password
- Client
  - email (identifier)
  - password

### Task Entities
- Task
  - TaskId (identifier)
  - TaskTitle
  - TaskDescription
  - TaskComplete
- SubTask
  - SubTaskId (identifier)
  - SubTaskTitle
  - SubTaskDescription
  - SubTaskComplete