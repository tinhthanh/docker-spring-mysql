package com.pal.intern.config.security.method;

import com.pal.intern.service.PermissionCheckerService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    
    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    private ApplicationContext applicationContext;
    
    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
            MethodInvocation invocation) {
        CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(this.trustResolver);
        root.setRoleHierarchy(getRoleHierarchy());
        root.setPermissionCheckerService(applicationContext.getBean(PermissionCheckerService.class));
        return root;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
    
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
}
