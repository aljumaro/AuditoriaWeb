package com.aljumaro.auditoria.configuration;

import static com.aljumaro.auditoria.configuration.Constants.Path.Resource.*;

/**
 * @Date 24/06/2016
 * @Time 17:10
 * @Author Juanma
 */
public final class Constants {

    private Constants() {
    }

    public static final class Path {

        public static final String[] IGNORE_SECURITY_RESOURCES = new String[]{Path.ROOT,
                FAVICON,
                INDEX_HTML,
                ERROR_HTML,
                withAllSubPath(RESOURCES),
                withAllSubPath(TEMPLATES),
                withAllSubPath(ERROR),
                withAllSubPath(WEBJARS),
                withAllSubPath(CSS),
                withAllSubPath(IMG),
                withAllSubPath(JS)};

        public static final String ROOT = "/";
        public static final String ALL_SUB_PATH = "/**";

        public static final String AUTHENTICATE = "/authenticate";
        public static final String LOGOUT = "/logout";
        public static final String USER = "/user";
        public static final String FAILURE = "/failure";

        public static String withAllSubPath(String path) {
            return path + ALL_SUB_PATH;
        }

        public static final class Resource {
            public static final String INDEX_HTML = "/index.html";
            public static final String ERROR_HTML = "/error.html";
            public static final String FAVICON = "/favicon.ico";

            public static final String RESOURCES = "/resources";
            public static final String TEMPLATES = "/templates";
            public static final String ERROR = "/error";
            public static final String WEBJARS = "/webjars";
            public static final String CSS = "/css";
            public static final String IMG = "/img";
            public static final String JS = "/js";
        }

    }

    public static final class Authority {
        public static final String ADMIN = "admin";
        public static final String CLIENT = "client";
        public static final String AUDITOR = "auditor";
    }

}
