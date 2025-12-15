# JDK 21 Quick Reference Guide
NOTE: these are a curated collection of changes to be aware of, this list is not exhaustive

## Virtual Threads

Virtual threads (finalized) provide lightweight, user-mode threads that make concurrent code simpler and scale to large numbers of concurrent tasks.

**Key Points:**
- Use `Thread.startVirtualThread(...)` or virtual-thread executors for short-lived tasks.
- Virtual threads behave like normal `Thread`s but are cheaper to create and schedule.

```java
// Start a single virtual thread
Thread.startVirtualThread(() -> {
    System.out.println("running on a virtual thread");
});

// Or use an executor that creates virtual threads per task
try (var ex = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
    ex.submit(() -> doWork());
}
```

**Benefits:**
- Much simpler concurrency model for I/O-bound workloads
- High throughput with low thread-management overhead

## Pattern Matching Changes Finalized

Pattern matching for `switch` and record patterns are finalized in JDK 21, making type-based deconstruction and exhaustive switching first-class language features.

**Key Points:**
- `switch` can match patterns (types, record patterns) instead of only constants.
- Record patterns let you deconstruct `record` values directly in `instanceof` and `switch`.

```java
record Point(int x, int y) {}

static String describe(Object o) {
    return switch (o) {
        case Point(int x, int y) -> "point(" + x + "," + y + ")";
        case String s -> "string: " + s;
        case null -> "null";
        default -> "other";
    };
}
```

**Benefits:**
- Less casting and boilerplate
- Better compiler exhaustiveness checks, especially with sealed types

## Sequenced Collections

Sequenced collections introduce a small set of new interfaces (e.g., `SequencedCollection`, `SequencedSet`, `SequencedMap`) that formalize collections with a defined encounter order and add order-specific operations.

**Key Points:**
- New interfaces provide consistent semantics for first/last element access and order-preserving operations.
- They complement existing `List` and `Deque` APIs by standardizing sequenced behavior across collections.

**Benefits:**
- More predictable APIs when order matters
- Improved expressiveness for ordered data structures

```java
// Example: Using SequencedCollection to access first and last elements
SequencedCollection<String> sc = new ArrayList<>(List.of("a", "b", "c"));
System.out.println(sc.getFirst()); // "a"
System.out.println(sc.getLast());  // "c"

// SequencedMap example
SequencedMap<Integer, String> sm = new LinkedHashMap<>();
sm.put(1, "one");
sm.put(2, "two");
System.out.println(sm.firstEntry()); // 1=one
System.out.println(sm.lastEntry());  // 2=two
```

## String Templates

String templates (preview) provide a safer and more structured way to embed expressions in string-like templates, improving readability and reducing injection risks.

**Key Points:**
- Currently available as a preview feature; syntax and APIs may evolve.
- Designed to separate template structure from embedded expressions and provide safer interpolation.

**Benefits:**
- Cleaner templated string construction
- Safer handling of embedded values (reduced manual concatenation)

```java
// Example: String Templates (preview feature)
String name = "Billy";
int age = 1234;
String message = STR."Hello, my name is {name} and I am {age} years old.";
System.out.println(message); // Hello, my name is Billy and I am 1234 years old.
```
Note: Requires --enable-preview and may require specific IDE/JDK support.

## Unnamed Classes and Instance Main Methods

Unnamed classes and instance main methods (preview) simplify small programs and scripts by reducing boilerplate for single-file programs and allowing instance-level `main` methods.

**Key Points:**
- Lets you write short programs without declaring a named public class.
- Supports instance `main` methods for simpler interactive or educational code samples.

**Benefits:**
- Faster prototyping and simpler examples for learning or scripting

```java
// Example: Unnamed class with instance main method (preview feature)
void main() {
    System.out.println("Hello from an unnamed class!");
}
```
- Save as Hello.java and run: `java --enable-preview Hello.java`
    - No need for public class or static main method.
- Similar to String templates, this feature is currently accessible in preview mode

## Scoped Values

Scoped Values (preview) provide a safer, structured alternative to thread-local variables for sharing immutable data within logical scopes, including across virtual threads.

**Key Points:**
- Create a `ScopedValue` and bind it for a lexical scope using `ScopedValue.where(...)`.
- Values are read with `ScopedValue.get(...)` inside the bound scope.
- Requires enabling preview

```java
var USER = java.lang.ScopedValue.newInstance("user");
try (var scope = java.lang.ScopedValue.where(USER, "alice")) {
    System.out.println(java.lang.ScopedValue.get(USER)); // "alice"
}
```

**Benefits:**
- Safer than mutable thread-locals and integrates well with virtual threads
- Explicit scoping reduces accidental leaks of context
