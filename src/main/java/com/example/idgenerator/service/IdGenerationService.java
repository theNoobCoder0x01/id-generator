package com.example.idgenerator.service;

import java.time.Instant;
// import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IdGenerationService {

    // static Random random = new Random(6969L);

    final static long NODE_ID_BITS = 12;
    final static long COUNTER_BITS = 10;
    final static long MAX_COUNTER = (int) (Math.pow(2, COUNTER_BITS) - 1);;

    final static long CUSTOM_EPOCH = 1640995200000L;
    static long lastTimeStamp = -1L;
    static long counter = 0L;

    public static synchronized long nextId() {
        long currentTimeStamp = timestamp();
        long id = (currentTimeStamp << (NODE_ID_BITS + COUNTER_BITS));

        id |= (nodeId() << COUNTER_BITS);

        id |= counter(currentTimeStamp);

        return id;
    }

    private static long counter(long currentTimeStamp) {
        if (currentTimeStamp == lastTimeStamp) {
            counter = (counter + 1) & MAX_COUNTER;
            if (counter == 0) {
                // MAX_COUNTER reached, wait until next millisecond
                wait(1);
            }
        } else {
            // reset counter to 0 for each new millisecond
            counter = 0;
        }
        lastTimeStamp = currentTimeStamp;
        return counter;
    }

    private static long nodeId() {
        // TODO: Create unique node id.
        // SOLn: Use Zookeeper. (Need to learn how to do that.)
        return 1000L;//random.nextLong(1L << (NODE_ID_BITS-1));
    }

    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    public static void wait(int milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
