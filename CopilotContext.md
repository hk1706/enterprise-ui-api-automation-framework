## Project

Industry Standard Selenium Java Automation Framework

## Developer

Himanshu Kesharwani

## IDE

VS Code

## Tech Stack

- Java 11
- Maven
- Selenium WebDriver
- TestNG

## Learning Style

- Simple Hinglish
- Interview-oriented explanation
- Real project examples
- Step-by-step learning
- One concept at a time
- Short and relevant responses

## Project Goal

Build an enterprise-grade Selenium Automation Framework from scratch and understand every component deeply instead of copying code.

## Current Progress

### Phase 0 Completed

- Java Installation
- Maven Installation
- VS Code Setup
- Git Installation

### Phase 1 Completed

- Maven Project Setup
- Selenium Dependency
- TestNG Dependency
- POM Structure
- BaseTest
- LoginPage
- LoginTest
- Explicit Wait
- OrangeHRM Login Automation

### Phase 2 Completed

- DriverFactory
- Browser Selection
- ConfigReader
- config.properties
- URL Management
- Environment Management
- ThreadLocal Driver Initialization

### Phase 3 Completed

Completed:
- WaitUtils
- ScreenshotUtils
- TestListener
- Auto Screenshot Capture on Failure
- CommonActions
- DateUtils
- RandomDataUtils
- Utility Enhancements

### Phase 4 Completed

Completed:
- Extent Reports
- ExtentManager
- ExtentSparkReporter
- Report Configuration
- Screenshot Attachment in Report
- Pass/Fail Reporting
- Log4j2
- Framework Logs
- Test Execution Logs

### Phase 5 Completed

Completed:
- TestNG Listener
- Failure Listener
- Screenshot Capture on Failure
- RetryAnalyzer
- RetryListener
- Retry Logic
- Extent Report Attachment
- Failure Handling Framework

### Phase 6 Completed

Completed:
- Apache POI Integration
- ExcelReader Utility
- DataProvider Utility
- LoginData.xlsx
- Parameterized Test Execution
- Multiple Test Data Sets
- Execute Flag (Y/N)
- Data Driven Login Testing
- Dashboard Validation
- CommonActions Reusability

### Current Phase

Phase 7 - Advanced POM

## Current Framework Structure

src/main/java
- driver
  - DriverFactory.java
- pages
  - BasePage.java
  - LoginPage.java
- utils
  - ConfigReader.java
  - WaitUtils.java
  - ScreenshotUtils.java
  - CommonActions.java
  - DateUtils.java
  - RandomDataUtils.java
  - LoggerUtility.java

src/test/java

- base
  - BaseTest.java

- listeners
  - TestListener.java

- tests
  - LoginTest.java

src/test/resources

- config.properties
- qa.properties
- sit.properties
- uat.properties
- log4j2.xml

---

## Important Learnings

### DriverFactory
Centralized Driver Creation

### ThreadLocal
One Driver per Thread

### ConfigReader
Externalized Configuration

### Environment Management
Single Framework
Multiple Environments
- QA
- SIT
- UAT

### Listener
Captures failure events

### Screenshot Utility
Captures screenshots automatically on test failure

### Data Driven Framework
Excel
↓
ExcelReader
↓
DataProvider
↓
TestNG Test
↓
Page Object

Externalized test data from code to Excel.

### Execute Flag

Execution controlled through Excel.

Y → Execute

N → Skip

### Validation Strategy

Business element validation is preferred over URL validation.
Dashboard visibility validation implemented using CommonActions.
---

## Current Phase

Phase 6 - Data Driven Framework ✅ Completed

Key Learnings
Apache POI Integration
Excel Data Reading
DataProvider Design
Execute Flag Filtering
Data Driven Testing
Parameterized Test Execution
Business Validation Using Page Objects

## Next Phase
Phase 7 - Advanced POM

Phase 3 - Reusable Utilities
Phase 4 - Reporting & Logging
Phase 5 - Listener Framework
Phase 6 - Data Driven Framework
Phase 7 - Advanced POM
Phase 8 - Parallel Execution
Phase 9 - Selenium Grid
Phase 10 - API Integration
Phase 11 - Database Validation
Phase 12 - BDD Framework
Phase 13 - Version Control
Phase 14 - Jenkins CI/CD
Phase 15 - Enterprise Level

## Important Notes

- Locator strategy is working properly.
- Login flow is working successfully.
- Explicit Wait implementation added.
- Thread.sleep currently used only for observation during learning/debugging.
- Final framework should avoid unnecessary Thread.sleep.

### Phase 7 Completed ✅

Completed:
- BasePage
- LoginPage Inheritance
- DashboardPage Inheritance
- AdminPage Inheritance
- Component Based Architecture
- LeftMenuComponent
- Navigation Chaining
- Dashboard To Admin Navigation
- AdminTest Implementation

### Phase 8 Completed ✅

Completed:
- TestNG Suite Configuration
- Maven Surefire Plugin Integration
- Parallel Suite Execution
- TestNG Thread Count Configuration
- LoginTest Parallel Execution
- AdminTest Parallel Execution
- ThreadLocal Validation
- Parallel Browser Sessions

### Framework Architecture Update

Component Based Design:
DashboardPage
↓
LeftMenuComponent
↓
AdminPage

Navigation Chaining:
LoginPage
→ DashboardPage
→ LeftMenuComponent
→ AdminPage

### Current Framework Structure

src/main/java

- components
  - LeftMenuComponent.java

- driver
  - DriverFactory.java

- pages
  - BasePage.java
  - LoginPage.java
  - DashboardPage.java
  - AdminPage.java

- utils
  - CommonActions.java
  - ConfigReader.java
  - WaitUtils

### Phase 9 Completed ✅

Completed:
- Selenium Grid Standalone Setup
- Selenium Grid Dashboard Verification
- RemoteWebDriver Integration
- DriverFactory Grid Enhancement
- Local Execution Support
- Grid Execution Support
- executionMode Configuration
- Configuration Driven Execution
- Chrome Execution Validation
- Edge Execution Validation
- Cross Browser Execution
- Grid Session Validation

### Framework Architecture Update

Execution Flow:
config.properties
↓
executionMode
↓
DriverFactory
↓
Local Driver OR RemoteWebDriver
↓
Selenium Grid
↓
Chrome / Edge

### Key Learnings

Selenium Grid:
- Centralized Browser Execution
- RemoteWebDriver Based Architecture
- Cross Browser Execution
- Parallel Session Execution

Configuration Driven Framework:
- Local Execution Through Configuration
- Grid Execution Through Configuration
- No Test Code Changes Required

### Current Phase

Phase 10 - API Integration

Planned:
- REST API Fundamentals
- Rest Assured Setup
- GET Request Validation
- POST Request Validation
- Response Validation
- JSON Parsing
- API Utility Design
- API And UI Validation


#### Phase 10 Progress Update ✅

Completed:

- Rest Assured Integration
- Jackson Integration
- API Framework Package Structure
- BaseApiTest
- ApiClient
- ApiEndpoints
- ApiUtils
- RequestSpecification
- GET API Automation
- POST API Automation
- Request Validation
- Response Validation
- JsonPath Assertions
- Request Logging
- Response Logging
- Request POJO
- Response POJO
- Serialization
- Deserialization
- JsonIgnoreProperties Implementation

#### API Framework Structure

src/main/java

api
- client
  - ApiClient.java
- endpoints
  - ApiEndpoints.java
- managers
  - TokenManager.java
- models
  - CreateUserRequest.java
  - CreateUserResponse.java
- utils
  - ApiUtils.java

src/test/java

base
- BaseApiTest.java

tests
- api
  - UserApiTest.java
  - CreateUserApiTest.java

#### API Framework Architecture

API Test
↓
ApiClient
↓
RequestSpecification
↓
REST API
↓
Response
↓
POJO Mapping

#### Key Learnings

##### POJO

POJO is a simple Java class used to represent request and response payloads.

Examples:
- CreateUserRequest
- CreateUserResponse

##### Serialization

Java Object
↓
JSON

Handled automatically by:
- Rest Assured
- Jackson

##### Deserialization

JSON
↓
Java Object

Implemented using:

response.as(CreateUserResponse.class)

##### JsonIgnoreProperties

Implemented:

@JsonIgnoreProperties(ignoreUnknown = true)

Purpose:
- Ignore unmapped response fields
- Prevent deserialization failures
- Support API response changes

##### RequestSpecification

Centralized reusable API request configuration.

Current Usage:
- Content Type Management
- Framework Level API Configuration

##### API Logging

Centralized logging implemented inside ApiClient.

Captures:
- Request URI
- Headers
- Payload
- Response Headers
- Response Body
- Status Code

#### Current Phase

Phase 10 - API Integration 🚧

Completed:
- REST API Fundamentals
- Rest Assured Setup
- API Framework Design
- GET Request Validation
- POST Request Validation
- JSON Parsing
- POJO Based Payload Handling

In Progress:
- ResponseSpecification
- Common Headers
- Token Management
- Authentication Handling
- PUT Request Validation
- DELETE Request Validation
- API + UI Validation

#### Interview Topics Covered

- REST API Fundamentals
- GET vs POST
- RequestSpecification
- POJO
- Serialization
- Deserialization
- JsonPath
- JsonIgnoreProperties
- API Logging
- Why POJO Over HashMap
- API Framework Architecture

#### Phase 10 Progress Update - Authentication Module ✅

##### Completed

- ResponseSpecification
- ResponseSpecBuilderUtil
- Common Headers
- Accept Header Handling
- TokenManager
- Authorization Header Integration
- Authentication Framework Design
- LoginRequest POJO
- LoginResponse POJO
- Login API Automation
- Dynamic Token Extraction
- Token Storage And Reuse

##### API Framework Structure Update

src/main/java

api
- client
  - ApiClient.java
- endpoints
  - ApiEndpoints.java
- managers
  - TokenManager.java
- models
  - CreateUserRequest.java
  - CreateUserResponse.java
  - LoginRequest.java
  - LoginResponse.java
- utils
  - ApiUtils.java
  - ResponseSpecBuilderUtil.java

##### Authentication Framework Architecture

Login API
↓
LoginRequest POJO
↓
Serialization
↓
API Request
↓
Login Response
↓
Deserialization
↓
LoginResponse POJO
↓
Token Extraction
↓
TokenManager
↓
Authorization Header
↓
Authenticated APIs

##### Token Handling Strategy

Token Generation:
- Login API

Token Storage:
- TokenManager.setToken()

Token Retrieval:
- TokenManager.getToken()

Authorization Injection:
- RequestSpecification
- ApiUtils

##### ResponseSpecification

Implemented:

response.then()
    .spec(
        ResponseSpecBuilderUtil
            .getSuccessResponseSpec(statusCode));

Purpose:
- Reusable Status Code Validation
- Reusable Content Type Validation
- Reduced Assertion Duplication

##### Common Headers

Implemented:
- Content-Type
- Accept

Managed Through:
- RequestSpecification
- ApiUtils

##### Authentication Concepts Covered

- Basic Authentication
- Bearer Token Authentication
- JWT
- OAuth 2.0 (High Level)

##### Key Learnings

TokenManager:
- Centralized Token Handling
- Eliminates Hardcoded Tokens
- Supports Enterprise Authentication Flow

ResponseSpecification:
- Centralized Response Validation
- Reduces Duplicate Validation Logic

Authentication Flow:
Login API
↓
Extract Token
↓
Store Token
↓
Use Across Framework

##### Current Phase

Phase 10 - API Integration 🚧

Completed:
- RequestSpecification
- ResponseSpecification
- Common Headers
- POJO Payload Design
- Serialization
- Deserialization
- TokenManager
- Login API Automation
- Dynamic Token Extraction
- Authentication Framework Design

Next:
- PUT API Automation
- DELETE API Automation
- PATCH API Automation
- Authenticated API Flow
- API + UI Validation

##### GitHub Workflow

Repository:
- enterprise-ui-api-automation-framework

Branching Strategy:
- main
- feature/api-authentication

Current Working Branch:
- feature/api-authentication


#### Phase 10 Completed ✅

##### Additional Implementations Completed

- PUT API Automation
- PATCH API Automation
- DELETE API Automation
- AuthService
- Token Caching
- Login Framework Refactoring
- Negative API Testing
- 400 Bad Request Validation
- 401 Unauthorized Validation
- CRUD API Coverage

##### API Framework Structure Update

src/main/java

api
- client
  - ApiClient.java
- endpoints
  - ApiEndpoints.java
- services
  - AuthService.java
- managers
  - TokenManager.java
- models
  - CreateUserRequest.java
  - CreateUserResponse.java
  - LoginRequest.java
  - LoginResponse.java
- utils
  - ApiUtils.java
  - ResponseSpecBuilderUtil.java

##### Updated API Framework Architecture

API Test
↓
AuthService
↓
ApiClient
↓
RequestSpecification
↓
REST API
↓
ResponseSpecification
↓
POJO Mapping
↓
TokenManager

##### CRUD Coverage

GET
- Resource Retrieval

POST
- Resource Creation

PUT
- Complete Resource Update

PATCH
- Partial Resource Update

DELETE
- Resource Deletion

##### Service Layer Design

Implemented:
- AuthService

Purpose:
- Centralize Login Logic
- Avoid Test Duplication
- Improve Reusability
- Support Authentication Scaling

Usage:

AuthService
↓
Login API
↓
Token Extraction
↓
TokenManager

##### Token Caching

Implemented:

if(TokenManager.getToken() != null)

Behavior:
- First Call → Login API Execution
- Subsequent Calls → Reuse Existing Token

Benefit:
- Reduced Authentication Requests
- Faster Framework Execution
- Improved Design

##### Negative Testing Implemented

400 Bad Request

Scenario:
- Login Without Password

Validated:
- Status Code
- Error Message

401 Unauthorized

Scenario:
- Invalid Request Authentication

Validated:
- Unauthorized Response Handling
- Error Response Validation

##### Key Learnings

PUT:
- Complete Resource Update

PATCH:
- Partial Resource Update

DELETE:
- Resource Removal

AuthService:
- Service Layer Should Handle Authentication Logic

TokenManager:
- Store Once
- Reuse Everywhere

Negative Testing:
- Real defects are frequently found in invalid inputs and invalid authentication scenarios.

##### Enterprise API Framework Overview

Implemented:

- ApiClient
- ApiEndpoints
- ApiUtils
- RequestSpecification
- ResponseSpecification
- POJO Based Payload Handling
- Serialization
- Deserialization
- TokenManager
- AuthService
- Authentication Framework
- CRUD Automation
- Positive Testing
- Negative Testing

##### Current Phase

Phase 10 - API Integration ✅ COMPLETED

Completed:
- REST API Fundamentals
- Framework Design
- CRUD Automation
- Authentication Framework
- Token Management
- Service Layer Design
- Positive Testing
- Negative Testing

##### Next Phase

Phase 10A - Real CRUD Validation Project 🚧

Planned:

- JSON Server Setup
- Persistent CRUD Operations
- POST → GET Validation
- PUT → GET Validation
- DELETE → GET Validation
- Resource Lifecycle Validation
- Real Data Persistence Verification

Purpose:

Move from mock/demo API validation to actual persistent CRUD validation before entering Database Validation (JDBC) phase.

##### Phase 10A Progress Update ✅

###### Completed
- JSON Server Setup
- db.json Configuration
- Local API Backend Setup
- baseApiUrl Configuration
- Local GET API Validation
- Local POST API Automation
- LocalUser POJO
- Dynamic ID Capture
- GET User By ID Validation
- TestNG Assertion Based Validation
- POST → GET Persistence Validation

###### Real CRUD Validation Architecture

POST User
↓
JSON Server
↓
db.json Persistence
↓
Generated ID
↓
GET User By ID
↓
Business Assertions
↓
Persistence Validation

###### Local API Framework Structure

src/main/java
api
- client
- ApiClient.java
- endpoints
- ApiEndpoints.java
- models
- LocalUser.java
- utils
- ApiUtils.java

src/test/java
tests
- api
- LocalUserGetApiTest.java
- LocalUserPostApiTest.java
- verifyCreatedUser.java

###### Key Learnings

Persistence Validation:
- POST Response Validation Alone Is Not Sufficient
- Resource Must Be Retrieved Again For Verification
- Business Data Should Be Validated After Persistence

JSON Server:
- Provides Persistent CRUD Operations
- Uses db.json As Backend Storage
- Suitable For Real CRUD Lifecycle Testing

Configuration Design:
Framework Configuration
- env
- executionMode

Environment Configuration
- url
- baseApiUrl

Debugging Strategy:
- Follow Stack Trace
- Trace Execution Layer By Layer
- Verify Configuration Resolution Flow

###### Interview Topics Covered

- JSON Server
- Persistent CRUD Testing
- Mock API vs Real API
- Dynamic Resource IDs
- POST Validation Strategy
- Persistence Validation
- Business Assertions
- GET By ID Validation
- Configuration Resolution
- Root Cause Analysis
- Stack Trace Debugging

###### Current Phase

Phase 10A - Real CRUD Validation Project 🚧

Completed:
- JSON Server Setup
- Local API Backend
- POST → GET Validation
- Real Data Persistence Verification

Next:
- PUT → GET Validation
- DELETE → GET Validation
- Resource Lifecycle Validation
- End-To-End CRUD Workflow


## Instruction For Copilot

Whenever this context is provided:

1. Continue from the current phase.
2. Do not repeat previous completed phases.
3. Explain concepts in simple Hinglish.
4. Focus on industry-standard implementation.
5. Explain WHY before coding.
6. Track phase completion.
7. Suggest next milestone after every completed phase.

### Documentation Rules

For DailyProgress.md:
- Always provide ready-to-append blocks.
- Do not suggest line-by-line edits.
- Preserve existing history.
- Continue from latest day number.

For FrameworkRoadmap.md:
- Update completion status only after successful implementation and validation.

For CopilotContext.md:
- Add only major milestones and framework architecture updates.