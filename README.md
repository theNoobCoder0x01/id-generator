# id-generator

A simple unique id generator service inspired by Twitter's Snowflake.

To know more about Snowflake IDs, check [Wikipedia: Snoflake ID](https://en.wikipedia.org/wiki/Snowflake_ID).


## Usage:

1. Install maven if not installed.
2. Clone the repo and cd into the directory.
3. Execute command "mvn spring-boot:run".


## id format:

- Generated id is 64-bits long. (But it is returned in **decimal format**)
- First bit in the id is left unused. (the sign bit)
- Next 41 bits stores the `timestamp` in milliseconds. (from **custom epoch** of **1st January 2022 00:00:00 UTC**)
- Next 10 bits are the `nodeId` bits.
- As `nodeId` is 10 bits long, allowing for 1024 nodes.
- Next 12 bits are the `counter` bits.
- `counter` is incremented if there are multiple requests at the same millisecond.
- As there are 12 bits for `counter`, the id generator supports upto 4096 ids per millisecond.


> Note: To use this id generator on multiple machines, need to modify the code for assigning unique id (12-bit) to the machine.


### Reference

I used this article on medium to create this id generator. [Medium: Scalable Unique Id Generator](https://medium.com/double-pointer/system-design-interview-scalable-unique-id-generator-twitter-snowflake-or-a-similar-service-18af22d74343)
