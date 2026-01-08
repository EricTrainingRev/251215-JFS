# Sprint 2: Testing & DevOps

You and your team are now focused on strengthening the RevaIssue application through comprehensive testing and preparing for cloud deployment. The goal of this sprint is to ensure reliability, maintainability, and scalability of the core features built in Sprint 1, while laying the groundwork for future automation and advanced DevOps practices.

## Application Features

### Client-Side (Angular)
- No major new UI features
- Focus on testing existing components:
    - Login/Logout
    - Dashboard
    - Project Management
    - Issue Management

### Server-Side (Spring Boot)
- No major new APIs
- Focus on testing existing endpoints:
    - `/users` (authentication, project assignment)
    - `/projects` (CRUD)
    - `/issues` (CRUD, workflow transitions)

## Testing MVP

- **Unit Tests**: Validate service layer logic for users, projects, and issues.
- **Integration Tests**: Ensure custom repository methods and API endpoints function as expected.
- **System Tests**: Simulate user story workflows for Admin, Tester, and Developer roles via End to End testing
- **Acceptance Tests**: Basic UI validation for core user flows.

## DevOps MVP (Stretch Goals)

- **Containerization**: Dockerize both frontend and backend applications.
- **CI/CD Pipeline**: Set up automated build, test, and deployment processes.
- **Cloud Deployment**: Prepare for deployment to a cloud environment.
- **Database Integration**: Integrate PostgreSQL for production/cloud use.

## Entities (Testing Focus)

- **Users**: Test role-based access and project assignments.
- **Projects**: Validate CRUD operations and user assignments.
- **Issues**: Test workflow transitions, comments, severity, and priority ratings.

## Deliverables

- Comprehensive test coverage for all Sprint 1 features
- Documented test cases and results
- Progress on DevOps pipeline setup and cloud readiness
- Containerized application artifacts (Docker images)
- Initial cloud deployment scripts/configurations
