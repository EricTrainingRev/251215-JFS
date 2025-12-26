# Event Driven Architecture Quick Reference Guide

## What is Event Driven Architecture?

Event Driven Architecture (EDA) is a software design pattern in which decoupled components communicate by producing and consuming events. Instead of direct calls, systems react to events as they occur, enabling asynchronous, scalable, and flexible solutions.

**Key Points:**
- Components interact by emitting and responding to events
- Promotes loose coupling and scalability
- Enables real-time data processing and responsiveness
- Common in microservices, IoT, and distributed systems

**Example:**
An order service emits an `OrderCreated` event. Inventory and notification services listen for this event and react independently.

---

## Events

An event is a significant change in state or an occurrence within a system. Events are immutable facts, often represented as messages.

**Key Points:**
- Describe something that has happened (e.g., "UserRegistered", "PaymentProcessed")
- Typically include metadata (timestamp, source, payload)
- Can be simple (single action) or complex (aggregate multiple actions)

**Example Event:**
```json
{
	"type": "OrderCreated",
	"timestamp": "2025-12-26T10:00:00Z",
	"data": {
		"orderId": 123,
		"userId": 456
	}
}
```

---

## Producer/Consumer

**Producer:** A component or service that generates and emits events when something of interest happens.

**Consumer:** A component or service that listens for and reacts to specific events.

**Key Points:**
- Producers and consumers are decoupled (do not need to know about each other)
- Multiple consumers can react to the same event
- A service can be both a producer and a consumer

**Example:**
- Order Service (Producer) emits `OrderCreated`
- Inventory Service (Consumer) updates stock
- Email Service (Consumer) sends confirmation

---

## Event Bus/Broker

An event bus or broker is the middleware that routes events from producers to consumers.

**Key Points:**
- Decouples event producers from consumers
- Handles event delivery, buffering, and sometimes persistence
- Examples: Apache Kafka, RabbitMQ, AWS EventBridge

**Example Flow:**
1. Producer emits event to the event bus
2. Event bus delivers event to all interested consumers

---

## Apache Kafka

Apache Kafka is a distributed event streaming platform used to build real-time data pipelines and streaming applications.

**Key Points:**
- High-throughput, fault-tolerant, and scalable
- Stores streams of records in topics
- Supports publish-subscribe and message queue patterns
- Widely used for event-driven microservices

**Basic Concepts:**
- **Producer:** Sends records to Kafka topics
- **Consumer:** Reads records from topics
- **Broker:** Kafka server that stores and serves data
- **Topic:** Named stream of records

---

## Apache Kafka Event Streams

Kafka event streams are continuous flows of events (records) organized by topics.

**Key Points:**
- Events are written to topics and retained for a configurable period
- Consumers can read events at their own pace
- Supports replaying and reprocessing events

**Example:**
1. Producer writes `OrderCreated` event to `orders` topic
2. Multiple consumers (inventory, analytics, notifications) read from the `orders` topic