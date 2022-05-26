package lt.mif.flowershop.lib;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class ServiceAuditor {

    private static final Logger logger = LoggerFactory.getLogger("audit-logger");

    @Before("execution(* lt.mif.flowershop.service.*.*(..))")
    public void audit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String arguments = Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(","));
        logger.info(String.format("Executing %s.%s with arguments (%s)", className, methodName, arguments));
    }

}
