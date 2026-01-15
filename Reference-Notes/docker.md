
# Docker Quick Reference Guide

## Introduction
Docker is a platform for developing, shipping, and running applications in lightweight, portable containers. Containers package code and dependencies together, ensuring consistency across environments and simplifying deployment. Docker is widely used for microservices, CI/CD, and scalable cloud-native applications.

## Containers vs Virtual Machines (VMs)
Both containers and VMs provide isolated environments for running applications, but differ fundamentally:
- **VMs**: Virtualize hardware, run full OS per instance, heavier resource usage, slower startup.
- **Containers**: Virtualize at OS level, share host kernel, lightweight, fast startup, efficient resource use.
Containers are ideal for rapid deployment, scaling, and portability, while VMs are suited for full OS isolation and legacy workloads.

## Docker Architecture
Docker uses a client-server architecture:
- **Docker Client**: CLI or GUI that sends commands to the Docker daemon.
- **Docker Daemon (`dockerd`)**: Background service that builds, runs, and manages containers, images, networks, and volumes.
- **Docker Registries**: Repositories for storing and distributing images (e.g., Docker Hub, private registries).
- **REST API**: Enables integration with other tools and automation.

## Installing Docker
Docker can be installed on Windows, macOS, and Linux:
- **Docker Desktop**: Recommended for Windows/macOS, includes GUI and CLI.
- **Linux**: Install via package manager (e.g., `apt`, `yum`).
After installation, verify with `docker --version` and test with `docker run hello-world`.

## Docker Images
Images are read-only templates for containers. Each image contains:
- Application code
- Runtime (e.g., Python, Node.js)
- Libraries and dependencies
- Environment variables
- Configuration files
Images are built from Dockerfiles, versioned, and shared via registries.

### Image Registries
- **Docker Hub**: Default public registry.
- **Private Registries**: For internal sharing and security.
Registries enable collaboration and automated deployments.

## Dockerfile
A Dockerfile is a script of instructions for building an image. Each instruction creates a layer:
- `FROM`: Base image
- `RUN`: Execute commands
- `COPY`/`ADD`: Add files
- `CMD`/`ENTRYPOINT`: Default command/entry point
- `ENV`: Set environment variables
- `EXPOSE`: Open ports
Example:
```Dockerfile
FROM python:3.10
WORKDIR /app
COPY . /app
RUN pip install -r requirements.txt
EXPOSE 5000
CMD ["python", "app.py"]
```

## Building Images
Use `docker build -t <image-name> .` to build an image from a Dockerfile. Tag images for versioning. Push images to a registry with `docker push <image-name>`.

## Containers
Containers are runnable instances of images. They encapsulate the application and its environment, providing isolation and portability.

### Creating Containers
Use `docker run <options> <image>` to start a container. Common options:
- `-p`: Map ports (e.g., `-p 8080:80`)
- `-v`: Mount volumes (e.g., `-v /host:/container`)
- `-e`: Set environment variables
- `--name`: Assign a name

### Managing Containers
Commands for lifecycle management:
- `docker ps`: List running containers
- `docker stop <container>`: Stop container
- `docker start <container>`: Start container
- `docker rm <container>`: Remove container
- `docker logs <container>`: View logs
- `docker exec -it <container> <cmd>`: Run command in container

## Volumes

Volumes provide persistent storage for containers, surviving container removal and enabling data sharing.

- **Types:**
	- **Named Volumes:**
		- Created and managed by Docker with a specific name.
		- Useful for sharing data between containers and persisting data beyond container lifecycle.
		- Example: `docker volume create mydata` and `docker run -v mydata:/app/data ...`
	- **Anonymous Volumes:**
		- Created without a name, often by specifying only the mount path in `docker run`.
		- Docker assigns a random name; useful for temporary storage when the name is not important.
		- Example: `docker run -v /app/data ...` (no volume name specified)
	- **Bind Mounts:**
		- Link a specific directory or file on the host to a path in the container.
		- Useful for development, sharing source code, or accessing host files directly.
		- Example: `docker run -v /host/path:/container/path ...`

- **Usage:** `docker volume create`, `docker run -v <volume>:/path`, `docker volume ls`

## Networking
Docker provides several networking options:
- **Bridge**: Default network for containers on a single host
- **Host**: Container shares host network stack
- **Overlay**: Multi-host networking for Docker Swarm
- **Custom networks**: User-defined for isolation and communication
Use `docker network create` and `docker network ls` to manage networks.

## Best Practices
- Use minimal base images for security and efficiency
- Keep Dockerfiles simple and readable
- Use multi-stage builds to reduce image size
- Tag images with meaningful versions
- Regularly update images and dependencies
- Limit container privileges (use non-root user)
- Clean up unused images, containers, and volumes

## Common Docker Commands
- `docker build -t <name> .`: Build image
- `docker run -d -p 80:80 <image>`: Run container detached
- `docker ps -a`: List all containers
- `docker images`: List images
- `docker exec -it <container> bash`: Open shell in container
- `docker logs <container>`: View container logs
- `docker stop <container>`: Stop container
- `docker rm <container>`: Remove container
- `docker volume ls`: List volumes

## Troubleshooting
- Use `docker logs` to diagnose container issues
- Inspect containers with `docker inspect <container>`
- Remove unused resources with `docker system prune`
- Check Docker daemon status with `systemctl status docker` (Linux)
