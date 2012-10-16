package org.xmpp.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class NamedThreadFactory implements ThreadFactory {
    private final AtomicLong threadNum = new AtomicLong(0);
    private final String mPrefix;

    public NamedThreadFactory(String pPrefix) {
        mPrefix = pPrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, mPrefix + "-" + threadNum.incrementAndGet());
    }
}