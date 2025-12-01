# Spring Boot Idempotency Payment Demo

This project shows how to implement **Idempotency Keys** in a payment API using **Spring Boot (Java 8+)**.  
Idempotency ensures that **multiple clicks or retry requests** do NOT create duplicate payments.

---

##  Features

- Prevent double payments  
- Idempotency-Key support  
- Same key returns same response  

---

##  How Idempotency Works (Simple English)

1. Frontend generates an **Idempotency Key** only once.  
2. Sends it in request header:
3. Server checks DB:
- If key exists → return old payment result  
- If not exists → create new payment, store key  
4. Same key = same result  
5. No more double payment issues
