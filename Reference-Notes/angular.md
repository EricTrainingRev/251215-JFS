# Angular Quick Reference Notes


## Angular Introduction

Angular is a TypeScript-based open-source framework for building single page web applications. It provides a component-based architecture, powerful data binding, and dependency injection.

---

## Angular Setup

- Install Node.js and npm
- Install Angular CLI: `npm install -g @angular/cli`
- Create a project: `ng new my-app`
- Run app: `ng serve`

---

## Angular CLI

Command-line tool for Angular development.


- `ng new app-name` — Create new project
- `ng serve` — Run dev server
- `ng build` — Build app for production

### Generate application parts:
- `ng generate component my-comp` — Component
- `ng generate directive my-dir` — Directive
- `ng generate service my-svc` — Service
- `ng generate module my-mod` — Module
- `ng generate pipe my-pipe` — Pipe
- `ng generate guard my-guard` — Route Guard
- `ng generate class my-class` — Class
- `ng generate interface my-intf` — Interface
- `ng generate enum my-enum` — Enum

Short form: `ng g c`, `ng g d`, `ng g s`, etc.

---

## Webpack

Webpack is a powerful module bundler used by Angular CLI to bundle, optimize, and serve application code.

- Handles JS, CSS, images, assets, etc.
- Supports code splitting, lazy loading, and tree shaking
- Angular CLI manages Webpack config automatically (no manual config needed for most apps)
- Advanced users can customize via `ng eject` (deprecated) or builders

### Builders
- Builders are tools that perform tasks like build, serve, test, lint, etc.
- Configured in `angular.json` (e.g., `@angular-devkit/build-angular:browser`)
- Custom builders can extend or replace default CLI behavior

## Components

Components are the building blocks of Angular apps. Each component has:
- A TypeScript class (logic)
- An HTML template (view)
- Optional CSS styles

### Lifecycle hooks
- `ngOnChanges`: called on input property changes
- `ngOnInit`: after first ngOnChanges, component init
- `ngDoCheck`: custom change detection (**can be expensive if overused**)
- `ngAfterContentInit`: after content (ng-content) projected
- `ngAfterContentChecked`: after every check of projected content (**can be expensive if logic is heavy**)
- `ngAfterViewInit`: after component's view (and child views) init
- `ngAfterViewChecked`: after every check of component's view (**can be expensive if logic is heavy**)
- `ngOnDestroy`: just before component is destroyed (cleanup)

## Templates

Define the view for a component using HTML with Angular syntax.
- Bind data: `{{ value }}`
- Bind properties: `[prop]="value"`
- Bind events: `(event)="handler()"`
Structural directives: `*ngIf`, `*ngFor`
	- New block syntax (Angular 17+):
		- `@if (condition) { ... } @else { ... }`
		- `@for (item of items; track item.id) { ... }`
		- `@switch (value) { @case (x) { ... } @default { ... } }`
```html
@if (isLoggedIn) { ... } @else { ... }
@for (item of items) { ... }
@switch (status) {
    @case ('active') { ... }
    @case ('pending') { ... }
    @default { ... }
}
```

## Template Statements

Expressions in templates that respond to user actions, e.g.:
- `(click)="doSomething()"`
- `(input)="onInput($event)"`


## Component Styling

Angular components support multiple ways to add styles:
- Inline styles: `styles: [`.my-class { ... }']`
- External styles: `styleUrls: ['./my-comp.component.css']`
- Global styles: `styles.css` or `styles.scss` in project root

### View Encapsulation
- Default: Emulated (scopes styles to component)
- None: Styles are global
- ShadowDom: Uses native Shadow DOM

### CSS Inheritance
- Styles in parent components do not inherit to child components if encapsulation is enabled (Emulated/ShadowDom)
- Use `:host`, `:host-context`, or set encapsulation to None for inheritance
- Global styles always apply

## Modules

NgModules group related components, directives, pipes, and services.
- Declared in `@NgModule` decorator
- Used to organize features and enable lazy loading
- `AppModule` is the root module in classic Angular apps
- **Deprecated in new standalone applications (Angular 15+)**
	- Use standalone components/services instead

## Dependency Injection

Angular uses DI to provide services to components and other services.
- Services are registered with providers (in modules or `@Injectable`)
- Use constructor injection: `constructor(private svc: MyService) {}`
- Tree-shakable providers: `providedIn: 'root'` (recommended)
- Standalone components/services use DI without NgModules

## Routing

Enables navigation between views/components.
- Define routes with `RouterModule.forRoot(routes)` (classic) or `provideRouter(routes)` (standalone)
- Route config: `{ path: 'home', component: HomeComponent }`
- Use `<a routerLink="/home">` for navigation
- `<router-outlet>` displays routed components
- Standalone router API (Angular 15+): no NgModule needed

## Route Guards

Protect routes by controlling access.
- Implement as injectable classes returning `boolean`/`UrlTree`/`Observable`/`Promise`
- Types: `CanActivate`, `CanDeactivate`, `CanLoad`, `CanActivateChild`, `CanMatch`
- Add guards in route config: `{ path: 'admin', canActivate: [AdminGuard] }`
- Useful for auth, permissions, unsaved changes, etc.

## Directives

Directives add behavior to elements in templates.
- Attribute directives: change appearance/behavior (e.g., `ngClass`, `ngStyle`)
- Structural directives: change DOM layout (e.g., `*ngIf`, `*ngFor`, `@if`, `@for`)
- Create custom directives with `@Directive()`

## Pipes

Transform data in templates.
- Built-in: `date`, `uppercase`, `lowercase`, `currency`, `async`, etc.
- Use with `{{ value | pipeName:arg }}`
- Create custom pipes with `@Pipe()`

## Data Binding (1 and 2 way)

Connects component data and the DOM.

### One-way binding
- Interpolation: `{{ value }}` (component → view)
- Property binding: `[prop]="value"` (component → view)
- Event binding: `(event)="handler()"` (view → component)

### Two-way binding
- Combines property & event binding
- Syntax: `[(ngModel)]="value"`
- Requires `FormsModule` (for template-driven forms)

## Signals

Reactive primitives for state management (Angular 16+).
- Create with `signal(initialValue)`
- Read with `mySignal()`; update with `mySignal.set(newValue)`
- Used for fine-grained reactivity in components
- Replace some use cases for RxJS/Observables

## Services

Singleton classes for business logic, data access, and shared state.
- Provided via DI (`providedIn: 'root'` or in providers array)
- Inject into components/other services via constructor
- Use for API calls, state management, utilities, etc.


## Pub Sub Design Pattern

The Publish-Subscribe (Pub/Sub) pattern enables decoupled communication between components or services.

### Concepts
- **Publisher**: Emits events or data updates
- **Subscriber**: Listens for and reacts to those events
- Promotes loose coupling and scalability

### Use Cases in Angular
- Component-to-component communication (siblings, distant)
- Cross-feature or cross-module messaging
- Global event handling (notifications, user actions)

### Implementation Approaches
- **RxJS Subjects**: Most common; a Subject acts as both an Observable (subscribe) and Observer (next)
	- Create a Subject in a service, inject the service where needed
- **Services with EventEmitter**: For simple parent-child or tightly coupled cases
- **Signals**: Angular 16+; can be used for fine-grained reactivity and state sharing
- **Third-party libraries**: e.g., NgRx for large-scale state/event management

### Best Practices
- Always unsubscribe from Subjects/Observables to avoid memory leaks
- Prefer Subjects for multi-cast, EventEmitter for single-cast
- Use services as the communication hub


## RxJS

Reactive Extensions for JavaScript; core to Angular's async programming.
- Provides Observables, operators, Subjects, and more
- Used for HTTP, events, forms, state, and more
- Operators: `map`, `filter`, `switchMap`, `mergeMap`, `debounceTime`, etc.
- Use `pipe()` to chain operators
- Unsubscribe to avoid memory leaks (use `async` pipe or `takeUntil`)



## Observables

Represent async data streams (events, HTTP, etc.)
- Created with `new Observable()`, `of()`, `from()`, etc.
- Subscribe to receive data: `obs$.subscribe(val => ... )`
- Can be cancelled/unsubscribed
- Use `async` pipe in templates for auto-subscription



## Subjects

Special type of Observable that is also an Observer
- Multicast: emit to many subscribers
- Use for event buses, shared state, pub/sub
- Types: `Subject`, `BehaviorSubject` (holds latest value), `ReplaySubject` (replays old values), `AsyncSubject` (emits last value on complete)


## HttpClient

Service for making HTTP requests (GET, POST, etc.).
- Import `HttpClientModule` in your app (or use `provideHttpClient()` for standalone)
- Inject `HttpClient` into services/components
- Methods: `get<T>()`, `post<T>()`, `put<T>()`, `delete<T>()`, etc.
- Returns Observables (use `subscribe()` or `async` pipe)
- Supports interceptors for auth, logging, error handling
- Use RxJS operators for response transformation
- Always unsubscribe or use `async` pipe to avoid memory leaks


## Sharing Data Between Parent & Child Components

### Parent to Child
- Use `@Input()` in child to receive data from parent
	```typescript
	// parent template: <child [data]="parentData"></child>
	@Input() data: any;
	```

### Child to Parent
- Use `@Output()` and `EventEmitter` in child to emit events to parent
	```typescript
	// child component
	@Output() notify = new EventEmitter<string>();
	// parent template: <child (notify)="onNotify($event)"></child>
	```

### Two-way Binding
- Combine `@Input()` and `@Output()` with the same property name
- Use `[(property)]` syntax in parent template

### ViewChild/ViewChildren
- Access child component instance(s) from parent using `@ViewChild()`/`@ViewChildren()`

### Service-Based Sharing
- Use a shared service (with RxJS Subject/BehaviorSubject or Signals) for cross-component communication



## Karma

Test runner for Angular unit tests
- Runs tests in real browsers
- Integrates with Jasmine
- Configured via `karma.conf.js`



## Jasmine

Behavior-driven testing framework
- Used for writing unit tests/specs in Angular
- Syntax: `describe`, `it`, `expect`, `beforeEach`, etc.