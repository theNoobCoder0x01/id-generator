# id-generator

A simple unique id generator service inspired by Twitter's Snowflake.

To know more about Snowflake IDs, check [Wikipedia: Snowflake ID](https://en.wikipedia.org/wiki/Snowflake_ID).


## Usage:

1. Install maven if not installed.
2. Clone the repo and cd into the directory.
3. Execute command "mvn spring-boot:run".
4. New id is available at "/new-id" endpoint.


## id format:

- Generated id is 64-bits long. (But it is returned in **decimal format** as a **string**)
- First bit in the id is left unused. (the sign bit)
- Next 41 bits stores the `timestamp` in milliseconds. (from **custom epoch** of **1st January 2022 00:00:00 UTC**)
- Next 10 bits are the `nodeId` bits.
- As `nodeId` is 10 bits long, allowing for 1024 nodes.
- Next 12 bits are the `counter` bits.
- `counter` is incremented if there are multiple requests at the same millisecond.
- As there are 12 bits for `counter`, the id generator supports upto 4096 ids per millisecond.


> Note: To use this id generator on multiple machines, need to modify the code for assigning unique id (12-bit) to the machine.
> I would appreciate any thoughts and help on making this work on multiple nodes.


### Want to add:
- Currently only generates id in one format, want to add support for other formats.
- Also, want to add support for other customizations (Haven't thought of any... Ideas are most welcomed.)

### Reference

[Medium: Scalable Unique Id Generator](https://medium.com/double-pointer/system-design-interview-scalable-unique-id-generator-twitter-snowflake-or-a-similar-service-18af22d74343)
