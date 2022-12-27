//package com.fxf;
//
//import org.aspectj.lang.reflect.PerClauseKind;
//import org.springframework.aop.Advisor;
//import org.springframework.aop.TargetSource;
//import org.springframework.aop.aspectj.annotation.*;
//import org.springframework.aop.config.AopConfigUtils;
//import org.springframework.beans.factory.BeanCreationException;
//import org.springframework.beans.factory.BeanCurrentlyInCreationException;
//import org.springframework.beans.factory.BeanFactoryUtils;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//import org.springframework.context.annotation.AnnotationConfigUtils;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.AnnotationAttributes;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.type.AnnotationMetadata;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.util.StringUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @Classname AopStudy
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/3/25 22:05
// * @Created by 饭小范
// */
//public class AopStudy {
//
//
//    @Override
//    public void registerBeanDefinitions(
//            AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        //注册一个AOP代理实现的Bean
//        AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
//
//        AnnotationAttributes enableAspectJAutoProxy =
//                AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
//        if (enableAspectJAutoProxy != null) {
//            if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
//                AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
//            }
//            if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
//                AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
//            }
//        }
//    }
//
//    @Nullable
//    private static BeanDefinition registerOrEscalateApcAsRequired(
//            Class<?> cls, BeanDefinitionRegistry registry, @Nullable Object source) {
//
//        Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
//
//        if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
//            BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
//            //判断优先级，如果优先级较高则替换原先的bean
//            if (!cls.getName().equals(apcDefinition.getBeanClassName())) {
//                int currentPriority = findPriorityForClass(apcDefinition.getBeanClassName());
//                int requiredPriority = findPriorityForClass(cls);
//                if (currentPriority < requiredPriority) {
//                    apcDefinition.setBeanClassName(cls.getName());
//                }
//            }
//            return null;
//        }
//        //注册AnnotationAwareAspectJAutoProxyCreator到容器中，此类负责基于注解的AOP动态代理实现
//        RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
//        beanDefinition.setSource(source);
//        beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
//        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
//        registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
//        return beanDefinition;
//    }
//
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
//        Object cacheKey = getCacheKey(beanClass, beanName);
//
//        if (!StringUtils.hasLength(beanName) || !this.targetSourcedBeans.contains(beanName)) {
//            if (this.advisedBeans.containsKey(cacheKey)) {
//                return null;
//            }
//            //加载所有的增强
//            if (isInfrastructureClass(beanClass) || shouldSkip(beanClass, beanName)) {
//                this.advisedBeans.put(cacheKey, Boolean.FALSE);
//                return null;
//            }
//        }
//
//        // Create proxy here if we have a custom TargetSource.
//        // Suppresses unnecessary default instantiation of the target bean:
//        // The TargetSource will handle target instances in a custom fashion.
//        TargetSource targetSource = getCustomTargetSource(beanClass, beanName);
//        if (targetSource != null) {
//            if (StringUtils.hasLength(beanName)) {
//                this.targetSourcedBeans.add(beanName);
//            }
//            Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(beanClass, beanName, targetSource);
//            Object proxy = createProxy(beanClass, beanName, specificInterceptors, targetSource);
//            this.proxyTypes.put(cacheKey, proxy.getClass());
//            return proxy;
//        }
//    }
//
//
//
//
//    /**
//     * Look for AspectJ-annotated aspect beans in the current bean factory,
//     * and return to a list of Spring AOP Advisors representing them.
//     * <p>Creates a Spring Advisor for each AspectJ advice method.
//     * @return the list of {@link org.springframework.aop.Advisor} beans
//     * @see #isEligibleBean
//     */
//    //在当前的bean工厂中查找带有aspectj注释的方面bean，并返回代表它们的Spring AOP advisor的列表。为每个AspectJ通知方法创建一个Spring Advisor。
//    public List<Advisor> buildAspectJAdvisors() {
//        //所有Aspect类的名称集合
//        List<String> aspectNames = this.aspectBeanNames;
//
//        if (aspectNames == null) {
//            synchronized (this) {
//                aspectNames = this.aspectBeanNames;
//                //双重检查
//                if (aspectNames == null) {
//                    List<Advisor> advisors = new ArrayList<>();
//                    aspectNames = new ArrayList<>();
//                    //获取所有bean名称和类型
//                    String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
//                            this.beanFactory, Object.class, true, false);
//                    for (String beanName : beanNames) {
//                        //判断是否符合条件，比如说有时会排除一些类，不让这些类注入进Spring
//                        if (!isEligibleBean(beanName)) {
//                            continue;
//                        }
//                        // We must be careful not to instantiate beans eagerly as in this case they
//                        // would be cached by the Spring container but would not have been weaved.
//                        Class<?> beanType = this.beanFactory.getType(beanName, false);
//                        if (beanType == null) {
//                            continue;
//                        }
//                        //判断Bean的Class上是否标识@Aspect注解
//                        if (this.advisorFactory.isAspect(beanType)) {
//                            aspectNames.add(beanName);
//                            AspectMetadata amd = new AspectMetadata(beanType, beanName);
//                            if (amd.getAjType().getPerClause().getKind() == PerClauseKind.SINGLETON) {
//                                MetadataAwareAspectInstanceFactory factory =
//                                        new BeanFactoryAspectInstanceFactory(this.beanFactory, beanName);
//                                List<Advisor> classAdvisors = this.advisorFactory.getAdvisors(factory);
//                                if (this.beanFactory.isSingleton(beanName)) {
//                                    this.advisorsCache.put(beanName, classAdvisors);
//                                }
//                                else {
//                                    //将解析的Bean名称及类上的增强缓存起来,每个Bean只解析一次
//                                    this.aspectFactoryCache.put(beanName, factory);
//                                }
//                                advisors.addAll(classAdvisors);
//                            }
//                            else {
//                                // Per target or per this.
//                                if (this.beanFactory.isSingleton(beanName)) {
//                                    throw new IllegalArgumentException("Bean with name '" + beanName +
//                                            "' is a singleton, but aspect instantiation model is not singleton");
//                                }
//                                MetadataAwareAspectInstanceFactory factory =

//                                        new PrototypeAspectInstanceFactory(this.beanFactory, beanName);
//                                this.aspectFactoryCache.put(beanName, factory);
//                                advisors.addAll(this.advisorFactory.getAdvisors(factory));
//                            }
//                        }
//                    }
//                    this.aspectBeanNames = aspectNames;
//                    return advisors;
//                }
//            }
//        }
//
//        if (aspectNames.isEmpty()) {
//            return Collections.emptyList();
//        }
//        List<Advisor> advisors = new ArrayList<>();
//        for (String aspectName : aspectNames) {
//            //从缓存中获取当前Bean的切面实例，如果不为空，则指明当前Bean的Class标识了@Aspect，且有切面方法
//            List<Advisor> cachedAdvisors = this.advisorsCache.get(aspectName);
//            if (cachedAdvisors != null) {
//                advisors.addAll(cachedAdvisors);
//            }
//            else {
//                MetadataAwareAspectInstanceFactory factory = this.aspectFactoryCache.get(aspectName);
//                advisors.addAll(this.advisorFactory.getAdvisors(factory));
//            }
//        }
//        return advisors;
//    }
//
//    @Override
//    public List<Advisor> getAdvisors(MetadataAwareAspectInstanceFactory aspectInstanceFactory) {
//        Class<?> aspectClass = aspectInstanceFactory.getAspectMetadata().getAspectClass();
//        String aspectName = aspectInstanceFactory.getAspectMetadata().getAspectName();
//        //校验类的合法性相关
//        validate(aspectClass);
//
//        // We need to wrap the MetadataAwareAspectInstanceFactory with a decorator
//        // so that it will only instantiate once.
//        MetadataAwareAspectInstanceFactory lazySingletonAspectInstanceFactory =
//                new LazySingletonAspectInstanceFactoryDecorator(aspectInstanceFactory);
//
//        List<Advisor> advisors = new ArrayList<>();
//        //获取这个类所有的增强方法
//        for (Method method : getAdvisorMethods(aspectClass)) {
//            // Prior to Spring Framework 5.2.7, advisors.size() was supplied as the declarationOrderInAspect
//            // to getAdvisor(...) to represent the "current position" in the declared methods list.
//            // However, since Java 7 the "current position" is not valid since the JDK no longer
//            // returns declared methods in the order in which they are declared in the source code.
//            // Thus, we now hard code the declarationOrderInAspect to 0 for all advice methods
//            // discovered via reflection in order to support reliable advice ordering across JVM launches.
//            // Specifically, a value of 0 aligns with the default value used in
//            // AspectJPrecedenceComparator.getAspectDeclarationOrder(Advisor).
//            //生成增强实例
//            Advisor advisor = getAdvisor(method, lazySingletonAspectInstanceFactory, 0, aspectName);
//            if (advisor != null) {
//                advisors.add(advisor);
//            }
//        }
//
//        // If it's a per target aspect, emit the dummy instantiating aspect.
//        if (!advisors.isEmpty() && lazySingletonAspectInstanceFactory.getAspectMetadata().isLazilyInstantiated()) {
//            Advisor instantiationAdvisor = new ReflectiveAspectJAdvisorFactory.SyntheticInstantiationAdvisor(lazySingletonAspectInstanceFactory);
//            advisors.add(0, instantiationAdvisor);
//        }
//
//        // Find introduction fields.
//        for (Field field : aspectClass.getDeclaredFields()) {
//            Advisor advisor = getDeclareParentsAdvisor(field);
//            if (advisor != null) {
//                advisors.add(advisor);
//            }
//        }
//
//        return advisors;
//    }
//
//    //获取类的方法
//    private List<Method> getAdvisorMethods(Class<?> aspectClass) {
//        final List<Method> methods = new ArrayList<>();
//        ReflectionUtils.doWithMethods(aspectClass, method -> {
//            // Exclude pointcuts
//            //在@Aspect标识的类内部排除@Pointcut标识之外的所有方法，得到的方法集合包括继承自父类的方法，包括继承自Object的方法
//            if (AnnotationUtils.getAnnotation(method, Pointcut.class) == null) {
//                methods.add(method);
//            }
//        }, ReflectionUtils.USER_DECLARED_METHODS);
//        if (methods.size() > 1) {
//            //对得到的所有方法排序，
//            //如果方法标识了切面注解，则按@Around, @Before, @After, @AfterReturning, @AfterThrowing的顺序排序
//            //如果没有标识这些注解，则按方法名称的字符串排序,
//            //有注解的方法排在无注解的方法之前
//            //最后的排序应该是这样的Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class。。。
//            methods.sort(METHOD_COMPARATOR);
//        }
//        return methods;
//    }
//
//}
