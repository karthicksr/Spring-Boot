# Spring-Boot
Spring Boot Asepect Oriented Programming Concepts
•	Aspect – An aspect is a class that implements enterprise applications concerns that cut across multiple classes, such as transaction management, Logging, Security. 
•	Aspects are implemented regular classes using Spring XML configuration
•	Regular classes annotated with @Aspect annotation (@AspectJ style)
•	Join Point: a point during the execution of a program, such as the execution of a method or the handling of an exception. 
•	In Spring AOP a join point is always the execution of a method. 
•	Pointcut: A predicate that matches join points. Advice is associated with pointcut expression and runs at any point matched by the pointcut. 
•	Spring framework uses the AspectJ pointcut expression language. 
•	(for example, the execution of a method with a certain name).
•	Advice: Advice are actions taken for a particular join point. 
•	Before Advice: Advice that executes before a join point. 
•	After returning advice: Advice to be executed after a joint point completes normally. For example, if a method returns without throwing an exception. 
•	After throwing advice: Advice to be executed if a method exists by throwing an exception. 
•	After (finally) advice: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
•	Around advice: Advice that surround a joint point such as method invocation. This is the most powerful kind of advice.  

**Different types of Pointcut**
@Pointcut("execution(* com.example.aop.controller.*.*(..))")
@Pointcut("within(com.example.aop..*)")
@Pointcut("this(com.example.aop.service.DepartmentService)")
@Pointcut("@annotation(com.example.aop.annotation.CustomAnnotation)")
