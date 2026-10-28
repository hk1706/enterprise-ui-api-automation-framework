# Daily Progress

---

## Day 1
Date: 25-Sep-2026

### Completed
- Java Verification
- Maven Setup
- VS Code Setup
- Selenium Dependency
- TestNG Dependency
- Maven Project Creation
- BaseTest Creation
- LoginPage Creation
- LoginTest Creation
- Explicit Wait Implementation
- Successful OrangeHRM Login Automation

### Issues Faced

#### TestNG Annotation Issue

Resolution:
Moved BaseTest into src/test/java

#### Username Locator Issue

Resolution:
Fixed locator and implemented Explicit Wait

### Learnings

- Maven Lifecycle
- POM Framework Structure
- Explicit Wait
- TestNG Basics

### Status

Phase 1 Completed

---

## Day 2
Date: 26-Sep-2026

### Completed

#### DriverFactory

- DriverFactory Created
- Browser Initialization Moved to DriverFactory

#### Browser Selection

Added Browser Selection from Properties File
Supported:
- Chrome
- Edge

#### ConfigReader

Created ConfigReader Utility
Features:
- Reads Config File
- Returns Property Values

#### URL Management

Removed Hardcoded URL
Implemented:
ConfigReader.getProperty("url")

#### Environment Management

Created:
- qa.properties
- sit.properties
- uat.properties

Implemented:
env=qa

Framework automatically loads environment-specific file

#### ThreadLocal Driver

Converted DriverFactory to ThreadLocal implementation
Benefits:
- Thread Safe
- Parallel Execution Ready

#### WaitUtils

Created reusable Explicit Wait Utility
Methods:
- waitForVisibility()
- waitForClickable()

#### ScreenshotUtils

Created Screenshot Utility
Features:
- Capture Screenshot
- Create Folder Automatically
- Return Screenshot Path

#### TestListener

Created TestNG Listener
Implemented:
onTestFailure()

#### Automatic Screenshot Capture

Integrated Screenshot Utility with Listener

Flow:
Test Failure
→ Listener
→ Screenshot Capture

### Learnings

#### DriverFactory
Centralizes WebDriver Creation

#### ThreadLocal
Provides Separate Driver Instance Per Thread

#### ConfigReader
Externalizes Configuration

#### Environment Management
Supports Multiple Environments Without Code Changes

#### Listener
Captures Test Events

#### Screenshot Utility
Captures Failure State For Debugging

### Current Status

Phase 2 Completed
Phase 3 In Progress

### Next Task

- CommonActions
- Helper Utilities
- Framework Code Cleanup

## Day 3
Date: 30-Sep-2026

#### Completed

##### CommonActions

Implemented:
- enterText()
- click()
- getText()
- isDisplayed()
- clearText()

##### DateUtils

Implemented:
- getTimeStamp()

Verified timestamp generation.

##### RandomDataUtils

Implemented:
- getRandomEmail()
- getRandomUsername()
- getRandomMobileNumber()

Verified random data generation.

##### Utility Enhancements

CommonActions enhanced with reusable methods.

#### Learnings

##### CommonActions
Centralized common user actions across pages.

##### DateUtils
Provides reusable timestamp generation for reports, screenshots and logs.

##### RandomDataUtils
Generates runtime test data and avoids hardcoded values.

##### Screenshot Debugging

Issue:
- Blank screenshot was being captured.

Resolution:
- Verified ScreenshotUtils.
- Verified TestListener.
- Identified page rendering timing issue.
- Screenshot capture working correctly after page rendering.

#### Current Status

Phase 3 Completed

---

## Day 4
Date: 01-Oct-2026

#### Completed

##### Extent Reports

Implemented:
- Extent Report Dependency
- ExtentManager
- ExtentSparkReporter
- ExtentManager
- ExtentSparkReporter
- Listener Integration
- Pass Status Reporting
- Fail Status Reporting
- HTML Report Generation

##### Screenshot Attachment

Implemented:
- Screenshot Attachment in Extent Report
- Failure Evidence Reporting

##### Report Configuration

Implemented:
- Report Name
- Document Title
- Tester Information
- Environment Information
- Framework Information

#### Issues Faced

##### Screenshot Not Visible In Report

Issue:
- Screenshot icon visible
- Image not loading

Resolution:
- Identified relative path issue
- Returned absolute path from ScreenshotUtils
- Screenshot displayed successfully inside report

#### Learnings

##### Extent Reports
Provides professional HTML reporting for automated test execution.

##### ExtentManager
Centralizes report creation and configuration.

##### Listener Integration
Automatically updates report based on test execution results.

##### extent.flush()
Writes execution data from memory into the final HTML report.

## Day 5
Date: 03-Oct-2026

##### Completed

###### Log4j2 Integration

Implemented:
- Log4j2 Dependency
- log4j2.xml Configuration
- Console Logging
- File Logging

###### LoggerUtility

Implemented:
- Centralized Logger Creation
- Reusable Logger Utility

###### BaseTest Logging

Implemented:
- Test Setup Logs
- Browser Launch Logs
- URL Logs
- Browser Close Logs

###### LoginTest Logging

Implemented:
- Test Start Logs
- Random Data Logs
- Login Execution Logs
- Test Completion Logs

###### TestListener Logging

Implemented:
- onTestStart()
- onTestSuccess()
- onTestFailure()

###### Framework Log File

Implemented:
- logs/framework.log
- Test Execution Tracking

##### Learnings

###### Log4j2
Provides centralized logging for framework execution.

###### LoggerUtility
Avoids repeated logger creation code across classes.

##### Test Execution Logs
Helps trace complete execution flow for debugging.

##### Listener
Listener captures and logs test execution events automatically.

#### Current Status

Phase 4 Completed ✅

#### Next Task

- Advanced Listener Framework
- Retry Mechanism
- Custom Listener Enhancements

---

### Day 6
Date: 07-Oct-2026

##### Completed

###### RetryAnalyzer

Implemented:
- Retry Mechanism
- Retry Count Tracking
- Retry Validation

###### Retry Logging

Implemented:
- Log4j Integration in RetryAnalyzer
- Retry Attempt Logging

###### Retry Reporting

Implemented:
- Retry Visibility in Extent Report
- Retrying Test Message in Report

##### Learnings

###### IRetryAnalyzer
Controls failed test re-execution.

###### Retry Flow

return true
→ Retry Test

return false
→ Stop Retry

###### Retry Validation
Feature validation should be done through execution, not only successful compilation.

###### Retry Logging
Retry attempts can be tracked using Log4j logs and Extent Reports.

##### Current Status

Phase 5 Completed ✅

##### Next Task

- Apache POI
- Excel Reader Utility
- DataProvider
- Data Driven Framework

---

## Day 7
Date: 09-Oct-2026

###### Completed

####### Apache POI Integration

Implemented:
- Apache POI Dependency
- Excel File Reading
- Sheet Reading
- Row and Column Iteration
- Object[][] Data Conversion
- Generic Excel Data Retrieval

####### DataProvider Utility

Implemented:
- TestNG DataProvider
- ExcelReader Integration
- Data Driven Data Supply

####### LoginData.xlsx

Implemented:
- Externalized Test Data
- Username Column
- Password Column
- Execute Flag Column

####### Data Driven Login Framework

Implemented:
- Parameterized Login Test
- Multiple Dataset Execution
- Excel Driven Test Execution

####### Execute Flag Support

Implemented:
- Y → Execute
- N → Skip
- Dataset Filtering Before Execution

####### Login Validation Enhancement

Implemented:
- Dashboard Validation
- CommonActions Reusability
- Business Validation Using UI Element
- Removed Dependency On URL Validation

###### Issues Faced

####### DataProvider Compilation Issue

Issue:
- DataProviderUtils.java was created under src/main/java
- TestNG annotations were not resolved during compilation

Root Cause:
- TestNG dependency available only in test scope
- Test layer class was incorrectly placed in framework layer

Resolution:
- Moved DataProviderUtils.java to src/test/java

####### Login Validation Failure

Issue:
- Login was successful
- Assertion was failing intermittently

Observation:
- URL validation was not reliable

Resolution:
- Implemented dashboard element validation
- Reused CommonActions.isDisplayed()
- Added business-level validation

###### Learnings

####### Apache POI
Apache POI is used for reading and writing Excel files in Java-based automation frameworks.

####### ExcelReader Design
Excel handling should be centralized in a reusable utility instead of being implemented directly inside test classes.

####### DataProvider Architecture

Excel
- ExcelReader
- DataProvider
- TestNG Test
- Page Object

####### Execute Flag
Execution can be controlled directly from Excel without modifying test code.

Y - Execute
N - Skip

####### Validation Strategy
Business element validation is more reliable than URL-based validation.

####### Framework Layer vs Test Layer

Framework Layer:
- ExcelReader
- ConfigReader
- WaitUtils
- CommonActions

Test Layer:
- DataProvider
- Test Classes
- Listeners
- Retry Logic

###### Verification

Execution Result:

Tests Run: 2
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS

###### Current Status

Phase 6 Completed ✅

###### Next Task

Phase 7 - Advanced POM

Planned:
- BasePage
- PageFactory
- Reusable Page Methods
- Cleaner Page Design

### Day 8
Date: 13-Oct-2026

##### Completed

###### Advanced POM

Implemented:
- BasePage
- LoginPage Inheritance
- DashboardPage Inheritance
- AdminPage Inheritance
- Component Based Architecture
- LeftMenuComponent
- Navigation Chaining
- Dashboard To Admin Navigation

###### Admin Test Creation

Implemented:
- AdminTest
- Dashboard Validation
- Admin Navigation Validation
- Admin Header Validation

###### Parallel Execution

Implemented:
- testng.xml Configuration
- Maven Surefire Plugin Configuration
- Parallel Suite Execution
- TestNG Thread Count Configuration
- LoginTest Parallel Execution
- AdminTest Parallel Execution
- ThreadLocal Validation

##### Learnings

###### BasePage

Provide a common foundation for all page classes and reduces code duplication.

##### Component Based Architecture
Reusable page sections should be designed as components instead of duplicating locators and actions across page classes.

##### Navigation Chaining
Page methods can return the next page object, making test flows cleaner and easier to maintain.

Example:
- LoginPage
- DashboardPage
- LeftMenuComponent
- AdminPage

##### Parallel Execution
TestNG supports parallel execution through suite configuration and thread management.

##### ThreadLocal
ThreadLocal provides a separate WebDriver instance for each thread, preventing browser session conflicts during parallel execution.

#### Verification

Execution Result:
Tests Run: 4
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS

##### Current Status

Phase 7 Completed ✅
Phase 8 Completed ✅

##### Next Task

Phase 9 - Selenium Grid

Planned:
- Selenium Grid Architecture
- Hub And Node Concept
- RemoteWebDriver
- Local Grid Setup
- Grid Based Test Execution

### Day 9
Date: 13-Oct-2026

#### Completed

##### Selenium Grid

Implemented:
- Selenium Grid Standalone Setup
- Selenium Grid Dashboard Verification
- Selenium Server Configuration
- RemoteWebDriver Integration
- Grid Based Test Execution

##### DriverFactory Enhancement

Implemented:
- RemoteWebDriver Support
- Local Execution Support
- Grid Execution Support
- Configuration Driven Execution

##### Configuration Management

Implemented:
- executionMode Property
- Local And Grid Execution Switching
- ConfigReader Enhancement

##### Cross Browser Execution

Implemented:
- Chrome Execution Validation
- Edge Execution Validation
- Local Execution Validation
- Grid Execution Validation

##### Parallel Execution On Grid

Implemented:
- Parallel Session Execution
- Selenium Grid Session Validation
- ThreadLocal Validation On Grid

#### Learnings

##### Selenium Grid
Selenium Grid allows test execution on different browsers and machines using RemoteWebDriver.

##### RemoteWebDriver
RemoteWebDriver sends Selenium commands to Selenium Grid, which executes them on the requested browser.

##### Standalone Grid
In Standalone mode, Grid Server and browser nodes run on the same machine.

##### Configuration Driven Framework
Framework behavior can be controlled through configuration files without modifying test code.

##### Cross Browser Execution
The same test suite can run on multiple browsers by changing configuration values.

##### ThreadLocal In Grid
ThreadLocal ensures each parallel thread gets its own WebDriver instance and prevents browser session conflicts.

##### Local vs Grid Execution

executionMode=local
- Local Browser Execution

executionMode=grid
- RemoteWebDriver
- Selenium Grid
- Browser Execution

#### Verification

Execution Result:

Tests Run: 4
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS

#### Current Status

Phase 9 Completed ✅

#### Next Task

Phase 10 - API Integration

Planned:
- REST API Fundamentals
- Rest Assured Setup
- GET Request Validation
- POST Request Validation
- Response Assertions
- JSON Parsing
- API Framework Design

#### Day 10

Date: 25-Oct-2026

##### Completed

###### API Framework Foundation

Implemented:
- Rest Assured Dependency
- Jackson Dependency
- API Framework Package Structure
- BaseApiTest
- ApiClient
- ApiEndpoints
- ApiUtils

###### API Framework Structure

Created:

- api/client
- api/endpoints
- api/models
- api/managers
- api/utils

###### GET API Automation

Implemented:
- First GET API Execution
- Status Code Validation
- Response Body Validation
- JsonPath Assertions

Validated:
- Status Code = 200
- Page Number
- User Data Validation

###### Request Specification

Implemented:
- Centralized RequestSpecification
- Application JSON Content Type
- Reusable API Request Configuration

###### POST API Automation

Implemented:
- Reusable POST Method In ApiClient
- Request Payload Handling
- Response Validation
- Status Code Validation

Validated:
- Status Code = 201
- Created User Response
- Business Data Validation

###### API Logging

Implemented:
- Request Logging
- Response Logging
- URI Logging
- Header Logging
- Payload Logging
- Response Body Logging

###### POJO Implementation

Created:
- CreateUserRequest
- CreateUserResponse

Implemented:
- Request Payload Modeling
- Response Payload Modeling

###### Serialization

Implemented:
- Java Object To JSON Conversion Using Rest Assured And Jackson

###### Deserialization

Implemented:
- JSON Response To Java Object Conversion
- Response Mapping Using POJO Classes

###### Response Mapping Enhancement

Implemented:
- @JsonIgnoreProperties(ignoreUnknown = true)

Resolved:
- UnrecognizedPropertyException
- Unknown Response Field Handling

##### Issues Faced

###### Response Deserialization Failure

Issue:
- Response POJO Mapping Failed
- Jackson Threw UnrecognizedPropertyException

Root Cause:
- API Response Contained Additional Fields
- support
- _meta

Resolution:
- Added @JsonIgnoreProperties(ignoreUnknown = true)
- Ignored Unmapped Response Fields
- Successful POJO Deserialization

##### Learnings

###### API Framework Architecture

Test Class
→ ApiClient
→ RequestSpecification
→ REST API
→ Response
→ POJO Mapping

###### RequestSpecification

Provides a centralized and reusable request configuration for:
- Content Type
- Headers
- Authentication
- Logging

###### POJO

POJO is a simple Java class used to represent request and response payloads.

###### Serialization

Java Object
→ JSON

Request POJO:
- CreateUserRequest

###### Deserialization

JSON
→ Java Object

Response POJO:
- CreateUserResponse

###### POJO Advantages

- Better Readability
- Better Maintainability
- Reusability
- Type Safety
- Industry Standard Payload Handling

###### JsonIgnoreProperties

Used to ignore unknown response fields and avoid deserialization failures when APIs return additional attributes.

##### Interview Topics Covered

- REST API Fundamentals
- HTTP Methods
- Status Codes
- API Framework Design
- RequestSpecification
- POJO
- Serialization
- Deserialization
- JsonPath
- JsonIgnoreProperties
- Why POJO Over HashMap
- API Logging Strategy

##### Verification

Execution Result:

GET API:
- PASS

POST API:
- PASS

POJO Serialization:
- PASS

POJO Deserialization:
- PASS

BUILD SUCCESS

##### Current Status

Phase 10 In Progress ✅

##### Next Task

- ResponseSpecification
- Common Headers
- Token Management
- Authentication Handling
- PUT API Automation
- DELETE API Automation

### Day 11

Date: 26-Oct-2026

#### Completed

##### GitHub Integration

Implemented:
- GitHub Repository Creation
- Framework Baseline Commit
- Feature Branch Workflow
- feature/api-authentication Branch Creation
- Repository Cleanup
- .gitignore Enhancements

##### ResponseSpecification

Implemented:
- ResponseSpecBuilderUtil
- Reusable Response Validation
- Status Code Validation
- Content Type Validation

Integrated:
- UserApiTest
- CreateUserApiTest
- LoginApiTest

##### Common Headers

Implemented:
- Accept Header
- Content-Type Header

Centralized Through:
- ApiUtils
- RequestSpecification

##### TokenManager

Created:
- TokenManager.java

Implemented:
- Token Storage
- Token Retrieval
- Centralized Authentication Handling

Methods:
- setToken()
- getToken()

##### Authorization Header Integration

Implemented:

Authorization:
Bearer <token>

Flow:

TokenManager
→ RequestSpecification
→ Authorization Header
→ API Request

##### Authentication Concepts

Covered:
- Basic Authentication
- Bearer Token Authentication
- JWT
- OAuth 2.0 (High Level)

##### Authentication API Automation

Created:
- LoginRequest.java
- LoginResponse.java
- LoginApiTest.java

Implemented:
- Login API Execution
- Request Serialization
- Response Deserialization
- Dynamic Token Extraction
- TokenManager Integration

##### Dynamic Token Handling

Implemented:

Login API
→ Extract Token
→ Store In TokenManager
→ Reuse Across Framework

#### Learnings

##### ResponseSpecification

Reusable response validation layer for:
- Status Codes
- Content Types
- Common Response Checks

##### Common Headers

Content-Type:
Defines request payload format.

Accept:
Defines expected response format.

##### TokenManager

Centralized authentication token handling.

Purpose:
- Avoid Hardcoded Tokens
- Improve Reusability
- Support Framework Scalability

##### Authentication Flow

Login API
→ Receive Token
→ Store Token
→ Reuse Token
→ Authenticated APIs

##### Dynamic Token Management

Tokens should be generated during execution and should not be hardcoded inside tests.

#### Interview Topics Covered

- ResponseSpecification
- Common Headers
- Content-Type vs Accept
- TokenManager
- Bearer Token Authentication
- JWT
- OAuth 2.0
- Dynamic Token Handling
- Login API Automation
- Authentication Framework Design

#### Verification

Execution Result:

- ResponseSpecification Validation : PASS
- Common Header Validation : PASS
- TokenManager Validation : PASS
- Authorization Header Validation : PASS
- Login API Automation : PASS
- Dynamic Token Extraction : PASS

Token Extracted Successfully:
- QpwL5tke4Pnpja7X4

BUILD SUCCESS

#### Current Status

Phase 10 In Progress ✅

#### Next Task

- PUT API Automation
- DELETE API Automation
- PATCH API Automation
- Authenticated API Flow
- Framework Enhancements

### Day 12

Date: 27-Oct-2026

#### Completed

##### ApiClient Enhancement

Implemented:
- PUT Method Logging
- PATCH Method Support
- PATCH Method Logging
- DELETE Method Logging
- Centralized CRUD Request Handling

##### PUT API Automation

Implemented:
- PutUserApiTest
- Request Payload Reuse
- Status Code Validation
- ResponseSpecification Integration
- Business Data Validation

Validated:
- Status Code = 200
- Updated Name Validation
- Updated Job Validation
- updatedAt Validation

##### PATCH API Automation

Implemented:
- PatchUserApiTest
- Partial Update Validation
- Response Validation

Validated:
- Status Code = 200
- Job Update Validation
- updatedAt Validation

##### DELETE API Automation

Implemented:
- DeleteUserApiTest
- Resource Deletion Validation

Validated:
- Status Code = 204 No Content

##### AuthService

Created:
- AuthService.java

Implemented:
- Login API Centralization
- Token Retrieval Service
- Token Management Abstraction
- Authentication Reusability

##### Token Caching

Implemented:

AuthService
→ TokenManager
→ Cached Token Reuse

Validation:
- First Call → Login API Execution
- Subsequent Calls → Reuse Stored Token

##### Login Framework Refactoring

Refactored:
- LoginApiTest

Removed:
- Direct Login Logic Duplication

Delegated To:
- AuthService

##### API Negative Testing

Implemented:

400 Bad Request Scenario
- Login Without Password

Validated:
- Status Code = 400
- Error Message Validation

401 Unauthorized Scenario

Validated:
- Invalid Endpoint Request Result
- API Authentication Failure Handling
- Unauthorized Response Validation

#### Key Observations

##### PUT vs PATCH

PUT:
- Complete Resource Update

PATCH:
- Partial Resource Update

Observation:
ReqRes demo APIs echo request data instead of persisting updates. Framework implementation and validation were completed successfully, but actual database persistence validation will be covered later using a real CRUD backend.

##### Negative Testing Insight

Expected:
- Invalid Endpoint → 404

Actual:
- Invalid Endpoint → 401

Reason:
Authentication validation occurred before endpoint validation.

Learning:
Server processing order may impact final response codes.

#### Learnings

##### AuthService

Authentication logic should be placed in a dedicated service layer instead of test classes.

Benefits:
- Better Reusability
- Better Maintainability
- Cleaner Tests

##### Token Caching

Tokens should be generated once and reused across framework execution instead of repeatedly hitting the login API.

##### Negative Testing

Negative scenarios often uncover more defects than positive scenarios.

Common Categories:
- Missing Fields
- Invalid Payload
- Invalid Endpoint
- Authentication Failures
- Authorization Failures

##### Framework Design Evolution

API Test
→ AuthService
→ ApiClient
→ RequestSpecification
→ REST API
→ ResponseSpecification
→ POJO Mapping
→ TokenManager

#### Interview Topics Covered

- PUT API Validation
- PATCH API Validation
- DELETE API Validation
- PUT vs PATCH
- AuthService Design
- Token Caching
- Negative Testing Strategy
- 400 Bad Request
- 401 Unauthorized
- Authentication Service Layer
- Enterprise API Framework Architecture

#### Verification

Execution Result:

PUT API:
- PASS

PATCH API:
- PASS

DELETE API:
- PASS

AuthService:
- PASS

Token Caching:
- PASS

400 Negative Test:
- PASS

401 Negative Test:
- PASS

BUILD SUCCESS

#### Current Status

Phase 10 Completed ✅

#### Next Phase

Phase 10A - Real API CRUD Validation

Planned:
- Local JSON Server Setup
- Persistent CRUD Operations
- POST Validation Through GET
- PUT Validation Through GET
- DELETE Validation Through GET
- Actual Resource Persistence Verification
- Real CRUD Lifecycle Testing

#### Day 13

Date: 28-Oct-2026

##### Completed

###### JSON Server Setup

Implemented:
- JSON Server Installation
- db.json Creation
- Local API Backend Setup
- Port 3000 Configuration
- Persistent CRUD Endpoint Setup

###### Framework Integration

Implemented:
- baseApiUrl Configuration
- Local API Endpoint Integration
- ApiEndpoints Enhancement
- Local CRUD Test Setup

###### Configuration Debugging

Investigated:
- ConfigReader Property Resolution
- config.properties Loading
- Environment Specific Property Loading
- ApiUtils Configuration Dependency

Resolved:
- Property Source Identification
- Environment Configuration Mapping
- Framework Configuration Validation

###### Local GET API Validation

Implemented:
- LocalUserGetApiTest
- GET All Users Validation
- Persistent Data Retrieval
- Response Verification

Validated:
- Status Code = 200
- User List Retrieval
- Local Backend Connectivity

###### Local POST API Automation

Created:
- LocalUser POJO
- LocalUserPostApiTest

Implemented:
- User Creation Request
- Request Serialization
- Response Validation
- Dynamic ID Capture

Validated:
- Status Code = 201
- Resource Creation
- Generated ID Retrieval
- Persistent Data Storage

###### GET By ID Validation

Created:
- verifyCreatedUser Test

Implemented:
- Resource Retrieval By ID
- Business Data Validation
- TestNG Assertions

Validated:
- User Name Validation
- User Job Validation
- Persisted Data Verification

##### Issues Faced

###### baseApiUrl Property Resolution Failure

Issue:
- Missing required property 'baseApiUrl'

Root Cause:
- ConfigReader.getProperty() loads environment specific properties
- baseApiUrl was configured in config.properties

Resolution:
- Analyzed ConfigReader architecture
- Traced stack flow through ApiUtils and ApiClient
- Corrected property resolution approach

###### Assertion Import Conflict

Issue:
- Duplicate Assert imports

Resolution:
- Removed ExtentReports Assert import
- Retained TestNG Assert import

##### Learnings

###### Mock API vs Persistent API

Mock API:
- Contract Validation
- Response Validation

Persistent API:
- Actual Data Storage
- Resource Lifecycle Validation
- CRUD Persistence Verification

###### Persistence Validation Strategy

POST
→ Capture ID
→ GET By ID
→ Verify Business Data

Business validation is more reliable than validating only POST response data.

###### Configuration Design

Framework Configuration:
- env
- executionMode

Environment Configuration:
- url
- baseApiUrl

###### Stack Trace Analysis

Framework issues should be debugged by tracing execution flow layer by layer instead of relying only on exception messages.

##### Interview Topics Covered

- JSON Server
- Persistent CRUD Validation
- Mock API vs Real API
- Dynamic ID Capture
- Persistence Validation
- POST Validation Strategy
- GET By ID Validation
- Resource Lifecycle Testing
- Configuration Management
- Stack Trace Debugging
- Root Cause Analysis
- Business Assertions

##### Verification

Execution Result:

JSON Server:
- PASS

GET Users API:
- PASS

POST User API:
- PASS

Dynamic ID Capture:
- PASS

GET User By ID:
- PASS

Business Assertions:
- PASS

POST → GET Persistence Validation:
- PASS

BUILD SUCCESS

##### Current Status

Phase 10A In Progress ✅

##### Next Task

- PUT Validation Through GET
- DELETE Validation Through GET
- Complete Resource Lifecycle Validation
- End-To-End CRUD Workflow