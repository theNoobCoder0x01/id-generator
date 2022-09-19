# id-generator
A simple unique id generator service inspired by Twitter's Snowflake

## Usage:
1. Install maven if not installed.
2. Clone the repo and cd into the directory.
3. Execute command "mvn spring-boot:run".

## Id format:
- Generated id is 64-bits long. (But it is returned in decimal form)
- First bit in the id is left unused. (the sign bit)
- Next 41 bits stores the timestamp in millisecond. (from custom epoch of 1st January 2022 00:00:00 UTC)
- Next 12 bits are the machine id bits.
- Next 10 bits are the `counter` bits.
- `counter` is incremented if there are multiple requests at the same millisecond. (As there are 10 bits for `counter`, the id generator supports upto 4095 ids per millisecond.)

### Note:
To use this id generator on multiple machines, need to modify the code for assigning unique id (12-bit) to the machine.
