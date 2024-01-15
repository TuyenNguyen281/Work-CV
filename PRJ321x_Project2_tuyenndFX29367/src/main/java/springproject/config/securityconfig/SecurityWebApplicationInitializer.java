package springproject.config.securityconfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {


//    @Override
//    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//        insertFilters(servletContext, new MultipartFilter());
//    }
}
