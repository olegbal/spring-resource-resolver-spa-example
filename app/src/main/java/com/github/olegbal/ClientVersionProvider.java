package com.github.olegbal;

import org.springframework.core.io.Resource;

public interface ClientVersionProvider {
    Resource provideClient();
}
