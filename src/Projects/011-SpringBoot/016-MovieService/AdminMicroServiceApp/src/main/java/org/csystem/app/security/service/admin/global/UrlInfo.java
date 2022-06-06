package org.csystem.app.security.service.admin.global;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlInfo {
    @Value("${admin.service.url.find.year}")
    public String findUserByYearUrl;

    @Value("${admin.service.url.find.date}")
    public String findUserByRegisterDateUrl;

    @Value("${admin.service.url.find.enabled}")
    public String findUserByEnabledUrl;
}
