# JDK 17 Quick Reference Guide
NOTE: these are a curated collection of changes to be aware of, this list is not exhaustive

## Sealed Classes

Sealed classes let you control which classes can extend or implement them, making hierarchies safer and more predictable.

**Key Points:**
- Use `sealed` to restrict subclassing.
- List permitted subclasses with `permits`.
- Subclasses must be `final`, `sealed`, or `non-sealed`.

```java
public sealed class Shape permits Circle, Rectangle {}
public final class Circle extends Shape {}
public sealed class Rectangle extends Shape permits Square {}
public final class Square extends Rectangle {}
```

**Benefits:**
- Safer, more maintainable code
- Enables exhaustive pattern matching
- Explicit class hierarchies

## Switch Pattern Matching

Pattern matching for `switch` lets you match on types and values, making code more concise and safer.

**Key Points:**
- Use type patterns in `case` labels.
- Supports null-safe handling.
- Enables exhaustive checks with sealed types.

```java
static String describe(Object obj) {
	return switch (obj) {
		case Integer i -> "int: " + i;
		case String s -> "string: " + s;
		case null -> "null";
		default -> "unknown";
	};
}
```

**Benefits:**
- Less boilerplate, no explicit casting
- Safer, more readable code
- Works well with sealed classes

*Note: Preview feature in JDK 17; enable with `--enable-preview`.*

## Strong Encapsulation of JDK Internals

JDK 17 strongly encapsulates most internal APIs, making them inaccessible by default for better security and maintainability.

**Key Points:**
- Internal packages (e.g., `sun.*`, `com.sun.*`) are not accessible by default.
- The `--illegal-access` option is removed.
- Use only standard, supported APIs (`java.*`).
- To open internals (not recommended):
	- Use `--add-exports` or `--add-opens` JVM options.

```sh
java --add-exports java.base/sun.security.x509=ALL-UNNAMED ...
```

**Impact:**
- Libraries using internals may break
- Encourages migration to supported APIs
- Improves platform security

## Security Manager Deprecated

The Security Manager is deprecated for removal in JDK 17. It will be removed in a future release.

**Key Points:**
- Security Manager and related APIs are deprecated.
- Use of `-Djava.security.manager` will show warnings.
- No direct replacement; use OS-level or container security.

```sh
java -Djava.security.manager Main
# Warning: Security Manager is deprecated and will be removed
```

**Impact:**
- Applications relying on Security Manager should migrate to other security solutions.
- Plan for removal in future JDK versions.

## New MacOS/AArch64 Support

JDK 17 adds support for Apple Silicon (AArch64) and a new Metal-based rendering pipeline for macOS.

**Key Points:**
- Native support for Apple M1/M2 chips (AArch64 architecture)
- New Metal rendering pipeline replaces deprecated OpenGL
- Improved performance and compatibility on modern Macs

**Benefits:**
- Faster, more efficient Java apps on Apple Silicon
- Future-proof graphics support for macOS

**No code changes required for most developers.**