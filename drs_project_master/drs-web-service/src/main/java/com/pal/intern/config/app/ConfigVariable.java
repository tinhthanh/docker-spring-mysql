package com.pal.intern.config.app;

public enum ConfigVariable {
    JWT_APP_NAM("jwt.app.name"),
    JWT_COOKIE_NAME("jwt.cookie.name"),
    JWT_EXPIRATION_MOBILE("jwt.expiration.mobile"),
    JWT_EXPIRATION_NORMAL("jwt.expiration.normal"),
    JWT_PREFIX("jwt.prefix"),
    JWT_REQUEST_HEADER("jwt.request.header"),
    JWT_ROUTE_AUTHENTICATION_PATH("jwt.route.authentication.path"),
    JWT_ROUTE_AUTHENTICATION_REFRESH("jwt.route.authentication.refresh"),
    JWT_SECRET("jwt.secret"),
    SERVER_MAIL_PASSWORD("server.mail.password"),
    SERVER_MAIL_USERNAME("server.mail.username"),
    MAIL_EXCHANGE_SERVICE_URL("mail.exchange.service.url"),
    REDMINE_SERVER_URL("redmine.server.url"),
    REDMINE_USERNAME("redmine.username"),
    REDMINE_API_KEY("redmine.api_key"),
    REDMINE_PASSWORD("redmine.password");

    private final String name;

    private ConfigVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
