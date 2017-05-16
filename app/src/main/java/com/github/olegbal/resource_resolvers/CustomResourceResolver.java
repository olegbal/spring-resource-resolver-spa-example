package com.github.olegbal.resource_resolvers;

import com.github.olegbal.versionproviders.ClientVersionProvider;
import com.github.olegbal.versionproviders.CookieClientVersionProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class CustomResourceResolver extends PathResourceResolver {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    protected Resource resolveResourceInternal(HttpServletRequest httpServletRequest, String s, List<? extends Resource> list, ResourceResolverChain resourceResolverChain) {


        Resource resource;
        ClientVersionProvider versionProvider = new CookieClientVersionProvider(httpServletRequest, list);
        try {
            logger.info("Trying to get resource " + s);
            resource = getResource(s, versionProvider.provideClient());
        } catch (IOException e) {
            logger.info("Unable to get resource " + s + "by provided path");
            return null;
        } logger.info("Resolving resource " + resource.getDescription().split(" ")[3]);

        return resource;
    }

    @Override
    protected String resolveUrlPathInternal(String s, List<? extends Resource> list, ResourceResolverChain resourceResolverChain) {
        return null;
    }
}
