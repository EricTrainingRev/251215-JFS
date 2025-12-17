# Project 0
You and your team have been tasked with building a new issue tracking application called RevaIssue. This application should support three types of users: Admin in charge of creating projects, Testers that create issues when they find defects in a project, and Developers that update issues as they deploy fixes. Since you are building this application from the ground up there is flexibility in many design choices, as long as the core MVP requirements are met

## Application Features

### Client-Side MVP
Implement **Angular** components for:
- Login/Logout feature
- Dashboard to view projects and issues
- Project Management
    - create, update, view
- Issue management
    - create, update, view

### Server-Side MVP
Implement **Spring Boot** for the following:
- API
    - `/users` 
        - authentication (JWT)
        - adding testers/developers to projects
    - `/projects` 
        - create, update, view
    - `/issues`
        - create, update, view
- Business Rules
    - **Admin** can create projects and add **Testers/Developers** to projects
    - **Testers** can **open** new issues in a project
    - **Developers** can move issues to **in progress** and **resolved** when they finish their work
    - **Testers** can **close** issues or move them back to **open** if needed
    - All project and issue actions should be logged for auditing purposes

## Persistence
An SQLite database should be used for persistence in this first sprint

## Entities MVP
**Users** represent the users of the management software
- can be **Admin**, **Tester**, **Developer**

**Projects** represent software applications managed by the team for testing and development
- created by **Admin**
- can be assigned **Issues**
- can be assigned **Testers** and **Developers**

**Issues** represent defects discovered in a project
- Created by **Testers**
- Start in the **Open** state
- Moved to **In Progress** and **Resolved** by **Developers**
- Moved to **Closed** or returned to **Open** by **Testers**
- Support comment chains, severity rating, and priority rating