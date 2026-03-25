# Intent-First Search Engine

Production-grade intent-first search using BM25 + query-time boosts. 

ML suggests. Rules protect. Users decide. 

# Intent-First Search Engine

A production-oriented reference implementation of a modern search system that **enforces user intent first**
using **BM25 + query-time lexical boosts**, before introducing semantic or ML-based ranking.

> **ML suggests. Rules protect. Users decide.**

This repository demonstrates how **real search systems** are built in production:  
deterministic first, intelligent later.

--- 

## 🎯 Core Philosophy

Search failures rarely come from bad algorithms — they come from **broken boundaries**.

This system enforces the following invariant:

> **Intent is enforced deterministically before any ML is allowed to influence ranking.**

---

## 🧠 Architectural Overview

Search is a **funnel**, not a brain.




User Query
↓
Intent Control (BM25 + Query-Time Boosts)
↓
Candidate Retrieval (Elasticsearch)
---

## 🏗 High-Level Design (HLD)

### Responsibilities by Layer
- **API Layer** → input validation, orchestration
- **Query Understanding** → intent extraction & boosts
- **Search Orchestrator** → controls flow & guarantees
- **Elasticsearch** → retrieval + BM25 scoring

<img width="483" height="546" alt="image" src="https://github.com/user-attachments/assets/000d7042-d97b-4fbc-bbbe-3b7a84dc9571" />



🔁 Runtime Flow (Sequence Diagram)

<img width="675" height="408" alt="image" src="https://github.com/user-attachments/assets/c2e41e26-b782-4fd3-b63f-5c4a6de3bf88" />


🔍 Low-Level Design (LLD)

1️⃣ Query Understanding Service

Responsible for:

Tokenization

Stop-word removal

Intent-based boost assignment
(category > material > attribute)


<img width="200" height="288" alt="image" src="https://github.com/user-attachments/assets/b7eb7c4d-d880-4c1c-a376-4e3e5e9d48de" />


2️⃣ Search Orchestrator

Responsible for:

Enforcing architecture rules

Building Elasticsearch queries

Preventing ML/semantic override

<img width="192" height="285" alt="image" src="https://github.com/user-attachments/assets/d138a5da-8f40-4c84-85dd-a29f159812fd" />


3️⃣ Elasticsearch (Logical View)

Elasticsearch is not the brain.

It is a retrieval engine only.

<img width="362" height="136" alt="image" src="https://github.com/user-attachments/assets/f4d1aa7d-e0fd-4451-960f-2961a2f49ec7" />

✅ What This Repo Demonstrates

Intent-first search design

BM25 as the authority

Query-time lexical boosting

Clean architectural boundaries

Explainable, deterministic ranking

Production-real patterns (not toy ML)


🧩 Extension Path (Future Work)

This architecture safely supports:

Hybrid BM25 + vector search

Offline Learning-to-Rank

Feature flags & fallbacks

Multi-region deployment

Caching & performance tuning

All without breaking correctness.



