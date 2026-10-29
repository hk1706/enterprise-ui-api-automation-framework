# Git Workflow History

## Repository

enterprise-ui-api-automation-framework

## Branch Strategy

main
↓
feature/*
↓
Commit
↓
Push
↓
Pull Request
↓
Merge To Main

---

## Phase 10

Branch:
feature/api-authentication

Status:
✅ Merged

PR:
feat: complete phase 10 api integration

Highlights:
- API Framework
- Authentication
- CRUD APIs
- AuthService
- TokenManager
- Negative Testing

---

## Phase 10A

Branch:
feature/real-crud-validation

Status:
🚧 In Progress

Commit History

### 28-Oct-2026

Commit:
a5a5392

Message:
feat: implement phase 10a real CRUD persistence validation

Implemented:
- JSON Server Setup
- Local CRUD Backend
- LocalUser POJO
- POST API
- Dynamic ID Capture
- GET By ID
- POST → GET Persistence Validation

---

## Git Learnings

### git pull origin main

Purpose:
- Fetch Latest Changes
- Merge Into Local Main
- Synchronize With GitHub

### git stash

Purpose:
- Temporarily Store Uncommitted Changes

Commands:

git stash list

git stash show -p "stash@{0}"

git stash pop

### Real Incident - 28-Oct-2026

Issue:
Files appeared missing after branch switching.

Root Cause:
GitHub Desktop automatically created a stash.

Resolution:
git stash list
git stash pop

Learning:
Always check stash before assuming code is lost.

### Branch Creation

git checkout main

git pull origin main

git checkout -b feature/real-crud-validation