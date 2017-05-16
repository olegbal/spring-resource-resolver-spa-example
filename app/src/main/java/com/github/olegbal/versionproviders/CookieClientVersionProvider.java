package com.github.olegbal.versionproviders;

import com.github.olegbal.enums.ClientResourceLocationList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CookieClientVersionProvider implements ClientVersionProvider {

    protected final Log logger = LogFactory.getLog(this.getClass());

    public CookieClientVersionProvider(HttpServletRequest httpServletRequest, List<? extends Resource> locationList) {
        this.httpServletRequest = httpServletRequest;
        this.locationList = locationList;
    }

    private HttpServletRequest httpServletRequest;

    private List<? extends Resource> locationList;

    @Override
    public Resource provideClient() {
        return provideCookieClient();
    }

    public Resource provideCookieClient() {
        List<Cookie> cookieList;
        try {
            logger.info("Getting cookie list");
            cookieList = Arrays.asList(httpServletRequest.getCookies());
        } catch (NullPointerException ex) {
            logger.info("There is no cookies in cookie list");
            return null;
        }
        logger.info("Trying to get cookie by key 'client' ");
        Optional<Cookie> cookie = cookieList.stream().filter(x -> x.getName().equals("client")).findFirst();
        if (cookie.isPresent()) {

            logger.info("Cookie of key 'client' exists. Providing client version");
            return locationList.get(ClientResourceLocationList.valueOf(cookie.get().getValue()).id);
        }

        return null;
    }
}
