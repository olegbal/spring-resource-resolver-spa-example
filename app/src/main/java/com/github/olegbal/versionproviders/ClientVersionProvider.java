package com.github.olegbal.versionproviders;

import org.springframework.core.io.Resource;

public interface ClientVersionProvider {
    Resource provideClient();
}
