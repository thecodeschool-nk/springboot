### How It Works
##### Redis Key: 
Each user or client is assigned a unique key in Redis, often based on their user ID, API key, or IP address.
##### TTL (Time-to-Live): 
The key is set with an expiration time to define the time window for the rate limit (e.g., 1 second, 1 minute).
##### Counter: 
Redis increments a counter for each request, and the system checks if the counter exceeds the limit.
##### Actions:
Allow the request if the counter is below the limit.
Reject the request if the counter exceeds the limit.


#### Explanation of Code
* Redis Key Structure:
Keys like rate_limit:testUser ensure isolation for different users or clients.

* Increment Operation:
Redis INCR ensures atomic increments, which is crucial in a distributed system.

* Expire Key:
The TTL (expiration) ensures that the count resets after the defined time window.

* Service Logic:
If the incremented value exceeds the limit, further requests are blocked.