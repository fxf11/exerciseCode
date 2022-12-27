//package com.fxf;
//
//import org.springframework.beans.*;
//import org.springframework.beans.factory.*;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.beans.factory.config.Scope;
//import org.springframework.beans.factory.support.*;
//import org.springframework.core.metrics.StartupStep;
//import org.springframework.lang.Nullable;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.StringUtils;
//
//import java.beans.PropertyDescriptor;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
///**
// * @Classname BeanStudy
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/3/20 11:43
// * @Created by 饭小范
// */
//public class BeanStudy {
//    @Override
//    public void refresh() throws BeansException, IllegalStateException {
//        synchronized (this.startupShutdownMonitor) {
//            StartupStep contextRefresh = this.applicationStartup.start("spring.context.refresh");
//
//            //准备用于刷新的上下文。记录容器等启动时间、标记容器状态、检查环境变量等等
//            prepareRefresh();
//
//            // 告诉子类取刷新bean工厂，负责BeanFactory的初始化、bean的加载和注册
//            ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
//
//            // 对bean工厂进行准备工作，配置一些ClassLoader和post-processor后置处理器，向beanFactory注册ApplicationContextAwareProcessor
//            //注入一些可被依赖注入的容器对象
//            prepareBeanFactory(beanFactory);
//
//            try {
//                // bean工厂的后期处理扩展
//                postProcessBeanFactory(beanFactory);
//
//                StartupStep beanPostProcess = this.applicationStartup.start("spring.context.beans.post-process");
//                //调用以bean配置方式指定的BeanFactory注册BeanPostProcessor
//                /**
//                 * 实例化和调用所有已注册的BeanFactoryPostProcessor bean
//                 */
//                invokeBeanFactoryPostProcessors(beanFactory);
//
//                //向beanFactory注册BeanPostProcessors BeanPostProcessors 用于bean注册的后置处理
//                registerBeanPostProcessors(beanFactory);
//                beanPostProcess.end();
//
//                // 初始化国际化资源
//                initMessageSource();
//
//                // 初始化应用时间广播器
//                initApplicationEventMulticaster();
//
//                // 在特定的上下文子类中初始化其他特殊bean
//                onRefresh();
//
//                // 检查监听器bean并注册他们
//                registerListeners();
//
//                // 实例化所有剩余的非单例的bean，完成beanFactory的bean实例化
//                finishBeanFactoryInitialization(beanFactory);
//                //完成刷新的后处理
//                // Last step: publish corresponding event.
//                finishRefresh();
//            }
//
//            catch (BeansException ex) {
//                if (logger.isWarnEnabled()) {
//                    logger.warn("Exception encountered during context initialization - " +
//                            "cancelling refresh attempt: " + ex);
//                }
//
//                // Destroy already created singletons to avoid dangling resources.
//                destroyBeans();
//
//                // Reset 'active' flag.
//                cancelRefresh(ex);
//
//                // Propagate exception to caller.
//                throw ex;
//            }
//
//            finally {
//                //充值清理缓存
//                // Reset common introspection caches in Spring's core, since we
//                // might not ever need metadata for singleton beans anymore...
//                resetCommonCaches();
//                contextRefresh.end();
//            }
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    protected <T> T doGetBean(
//            String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly)
//            throws BeansException {
//        //获取标准的beanName的名称
//        String beanName = transformedBeanName(name);
//        Object bean;
//        //检查单例bean缓存中是否存在手动注册的单例bean 如果存在就直接获取
//        // Eagerly check singleton cache for manually registered singletons.
//        Object sharedInstance = getSingleton(beanName);
//        if (sharedInstance != null && args == null) {
//            if (logger.isTraceEnabled()) {
//                if (isSingletonCurrentlyInCreation(beanName)) {
//                    logger.trace("Returning eagerly cached instance of singleton bean '" + beanName +
//                            "' that is not fully initialized yet - a consequence of a circular reference");
//                }
//                else {
//                    logger.trace("Returning cached instance of singleton bean '" + beanName + "'");
//                }
//            }
//            bean = getObjectForBeanInstance(sharedInstance, name, beanName, null);
//        }
//
//        else {
//            //单例bean不存在，检查是否有循环依赖，存在循环依赖则抛出异常
//            // Fail if we're already creating this bean instance:
//            // We're assumably within a circular reference.
//            if (isPrototypeCurrentlyInCreation(beanName)) {
//                throw new BeanCurrentlyInCreationException(beanName);
//            }
//            //检查bean工厂中是否有这个bean实例
//            // Check if bean definition exists in this factory.
//            BeanFactory parentBeanFactory = getParentBeanFactory();
//            if (parentBeanFactory != null && !containsBeanDefinition(beanName)) {
//                // Not found -> check parent.
//                String nameToLookup = originalBeanName(name);
//                if (parentBeanFactory instanceof AbstractBeanFactory) {
//                    return ((AbstractBeanFactory) parentBeanFactory).doGetBean(
//                            nameToLookup, requiredType, args, typeCheckOnly);
//                }
//                else if (args != null) {
//                    // Delegation to parent with explicit args.
//                    return (T) parentBeanFactory.getBean(nameToLookup, args);
//                }
//                else if (requiredType != null) {
//                    // No args -> delegate to standard getBean method.
//                    return parentBeanFactory.getBean(nameToLookup, requiredType);
//                }
//                else {
//                    return (T) parentBeanFactory.getBean(nameToLookup);
//                }
//            }
//            //如果不是类型检查就标记bean实例已经被创建了
//            if (!typeCheckOnly) {
//                markBeanAsCreated(beanName);
//            }
//
//            try {
//                RootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);
//                //检查合并bean定义
//                checkMergedBeanDefinition(mbd, beanName, args);
//                //保证当前bean所依赖的bean的初始化。如果当前bean有依赖的bean 则先创建依赖bean实例，否则就会抛出异常
//                // Guarantee initialization of beans that the current bean depends on.
//                String[] dependsOn = mbd.getDependsOn();
//                if (dependsOn != null) {
//                    for (String dep : dependsOn) {
//                        if (isDependent(beanName, dep)) {
//                            throw new BeanCreationException(mbd.getResourceDescription(), beanName,
//                                    "Circular depends-on relationship between '" + beanName + "' and '" + dep + "'");
//                        }
//                        registerDependentBean(dep, beanName);
//                        try {
//                            getBean(dep);
//                        }
//                        catch (NoSuchBeanDefinitionException ex) {
//                            throw new BeanCreationException(mbd.getResourceDescription(), beanName,
//                                    "'" + beanName + "' depends on missing bean '" + dep + "'", ex);
//                        }
//                    }
//                }
//                //创建bean实例
//                // Create bean instance.
//                if (mbd.isSingleton()) {
//                    sharedInstance = getSingleton(beanName, () -> {
//                        try {
//                            return createBean(beanName, mbd, args);
//                        }
//                        catch (BeansException ex) {
//                            // Explicitly remove instance from singleton cache: It might have been put there
//                            // eagerly by the creation process, to allow for circular reference resolution.
//                            // Also remove any beans that received a temporary reference to the bean.
//                            destroySingleton(beanName);
//                            throw ex;
//                        }
//                    });
//                    bean = getObjectForBeanInstance(sharedInstance, name, beanName, mbd);
//                }
//
//                else if (mbd.isPrototype()) {
//                    //如果是原型则创建原型bean
//                    // It's a prototype -> create a new instance.
//                    Object prototypeInstance = null;
//                    try {
//                        //标记循环依赖
//                        beforePrototypeCreation(beanName);
//                        prototypeInstance = createBean(beanName, mbd, args);
//                    }
//                    finally {
//                        //移除循环依赖
//                        afterPrototypeCreation(beanName);
//                    }
//                    //创建原型bean
//                    bean = getObjectForBeanInstance(prototypeInstance, name, beanName, mbd);
//                }
//
//                else {
//                    String scopeName = mbd.getScope();
//                    if (!StringUtils.hasLength(scopeName)) {
//                        throw new IllegalStateException("No scope name defined for bean ´" + beanName + "'");
//                    }
//                    Scope scope = this.scopes.get(scopeName);
//                    if (scope == null) {
//                        throw new IllegalStateException("No Scope registered for scope name '" + scopeName + "'");
//                    }
//                    try {
//                        Object scopedInstance = scope.get(beanName, () -> {
//                            //标记循环依赖
//                            beforePrototypeCreation(beanName);
//                            try {
//                                return createBean(beanName, mbd, args);
//                            }
//                            finally {
//                                //移除循环依赖
//                                afterPrototypeCreation(beanName);
//                            }
//                        });
//                        //船舰socpe bean实例
//                        bean = getObjectForBeanInstance(scopedInstance, name, beanName, mbd);
//                    }
//                    catch (IllegalStateException ex) {
//                        throw new BeanCreationException(beanName,
//                                "Scope '" + scopeName + "' is not active for the current thread; consider " +
//                                        "defining a scoped proxy for this bean if you intend to refer to it from a singleton",
//                                ex);
//                    }
//                }
//            }
//            catch (BeansException ex) {
//                cleanupAfterBeanCreationFailure(beanName);
//                throw ex;
//            }
//        }
//
//        // Check if required type matches the type of the actual bean instance.
//        if (requiredType != null && !requiredType.isInstance(bean)) {
//            try {
//                T convertedBean = getTypeConverter().convertIfNecessary(bean, requiredType);
//                if (convertedBean == null) {
//                    throw new BeanNotOfRequiredTypeException(name, requiredType, bean.getClass());
//                }
//                return convertedBean;
//            }
//            catch (TypeMismatchException ex) {
//                if (logger.isTraceEnabled()) {
//                    logger.trace("Failed to convert bean '" + name + "' to required type '" +
//                            ClassUtils.getQualifiedName(requiredType) + "'", ex);
//                }
//                throw new BeanNotOfRequiredTypeException(name, requiredType, bean.getClass());
//            }
//        }
//        return (T) bean;
//    }
//
//    @Override
//    protected Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
//            throws BeanCreationException {
//
//        if (logger.isTraceEnabled()) {
//            logger.trace("Creating instance of bean '" + beanName + "'");
//        }
//        RootBeanDefinition mbdToUse = mbd;
//
//        // Make sure bean class is actually resolved at this point, and
//        // clone the bean definition in case of a dynamically resolved Class
//        // which cannot be stored in the shared merged bean definition.
//        //获取到bean定义里的class字节码
//        Class<?> resolvedClass = resolveBeanClass(mbd, beanName);
//
//        //获取到bean定义的class然后设置到bean定义里面
//        if (resolvedClass != null && !mbd.hasBeanClass() && mbd.getBeanClassName() != null) {
//            mbdToUse = new RootBeanDefinition(mbd);
//            mbdToUse.setBeanClass(resolvedClass);
//        }
//
//        //准备方法覆盖
//        // Prepare method overrides.
//        try {
//            mbdToUse.prepareMethodOverrides();
//        }
//        catch (BeanDefinitionValidationException ex) {
//            throw new BeanDefinitionStoreException(mbdToUse.getResourceDescription(),
//                    beanName, "Validation of method overrides failed", ex);
//        }
//
//        try {
//            //让BeanPostProcessors有机会返回一个代理而不是目标bean实例。
//            // Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
//            Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
//            if (bean != null) {
//                return bean;
//            }
//        }
//        catch (Throwable ex) {
//            throw new BeanCreationException(mbdToUse.getResourceDescription(), beanName,
//                    "BeanPostProcessor before instantiation of bean failed", ex);
//        }
//
//        try {
//            //调用doCreateBean方法创建bean实例
//            Object beanInstance = doCreateBean(beanName, mbdToUse, args);
//            if (logger.isTraceEnabled()) {
//                logger.trace("Finished creating instance of bean '" + beanName + "'");
//            }
//            return beanInstance;
//        }
//        catch (BeanCreationException | ImplicitlyAppearedSingletonException ex) {
//            // A previously detected exception with proper bean creation context already,
//            // or illegal singleton state to be communicated up to DefaultSingletonBeanRegistry.
//            throw ex;
//        }
//        catch (Throwable ex) {
//            throw new BeanCreationException(
//                    mbdToUse.getResourceDescription(), beanName, "Unexpected exception during bean creation", ex);
//        }
//
//
//
//    }
//
//    /**
//     * 实际创建指定的bean。创建前的处理已经在这一点上发生了，例如检查postProcessBeforeInstantiation回调。
//     *
//     * 区分默认bean实例化、工厂方法的使用和构造函数的自动装配。
//     * @param beanName
//     * @param mbd
//     * @param args
//     * @return
//     * @throws BeanCreationException
//     */
//    protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
//            throws BeanCreationException {
//        //实例化bean
//        // Instantiate the bean.
//        BeanWrapper instanceWrapper = null;
//        //如果是单例bean则删除掉缓存中的bean实例
//        if (mbd.isSingleton()) {
//            instanceWrapper = this.factoryBeanInstanceCache.remove(beanName);
//        }
//        if (instanceWrapper == null) {
//            //创建bean实例的包装类
//            instanceWrapper = createBeanInstance(beanName, mbd, args);
//        }
//        //在bean实例的包装类中获取bean对象和bean实例的class，然后设置bean实例的class到一解析的目标对象
//        Object bean = instanceWrapper.getWrappedInstance();
//        Class<?> beanType = instanceWrapper.getWrappedClass();
//        if (beanType != NullBean.class) {
//            mbd.resolvedTargetType = beanType;
//        }
//
//        // Allow post-processors to modify the merged bean definition.
//        synchronized (mbd.postProcessingLock) {
//            if (!mbd.postProcessed) {
//                try {
//                    applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
//                }
//                catch (Throwable ex) {
//                    throw new BeanCreationException(mbd.getResourceDescription(), beanName,
//                            "Post-processing of merged bean definition failed", ex);
//                }
//                mbd.postProcessed = true;
//            }
//        }
//        //实例化bean依赖
//        // Eagerly cache singletons to be able to resolve circular references
//        // even when triggered by lifecycle interfaces like BeanFactoryAware.
//        boolean earlySingletonExposure = (mbd.isSingleton() && this.allowCircularReferences &&
//                isSingletonCurrentlyInCreation(beanName));
//        if (earlySingletonExposure) {
//            if (logger.isTraceEnabled()) {
//                logger.trace("Eagerly caching bean '" + beanName +
//                        "' to allow for resolving potential circular references");
//            }
//            addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
//        }
//
//        // Initialize the bean instance.
//        Object exposedObject = bean;
//        try {
//            //调用populateBean来进行bean实例化
//            populateBean(beanName, mbd, instanceWrapper);
//            exposedObject = initializeBean(beanName, exposedObject, mbd);
//        }
//        catch (Throwable ex) {
//            if (ex instanceof BeanCreationException && beanName.equals(((BeanCreationException) ex).getBeanName())) {
//                throw (BeanCreationException) ex;
//            }
//            else {
//                throw new BeanCreationException(
//                        mbd.getResourceDescription(), beanName, "Initialization of bean failed", ex);
//            }
//        }
//
//        if (earlySingletonExposure) {
//            Object earlySingletonReference = getSingleton(beanName, false);
//            if (earlySingletonReference != null) {
//                if (exposedObject == bean) {
//                    exposedObject = earlySingletonReference;
//                }
//                else if (!this.allowRawInjectionDespiteWrapping && hasDependentBean(beanName)) {
//                    String[] dependentBeans = getDependentBeans(beanName);
//                    Set<String> actualDependentBeans = new LinkedHashSet<>(dependentBeans.length);
//                    for (String dependentBean : dependentBeans) {
//                        if (!removeSingletonIfCreatedForTypeCheckOnly(dependentBean)) {
//                            actualDependentBeans.add(dependentBean);
//                        }
//                    }
//                    if (!actualDependentBeans.isEmpty()) {
//                        throw new BeanCurrentlyInCreationException(beanName,
//                                "Bean with name '" + beanName + "' has been injected into other beans [" +
//                                        StringUtils.collectionToCommaDelimitedString(actualDependentBeans) +
//                                        "] in its raw version as part of a circular reference, but has eventually been " +
//                                        "wrapped. This means that said other beans do not use the final version of the " +
//                                        "bean. This is often the result of over-eager type matching - consider using " +
//                                        "'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.");
//                    }
//                }
//            }
//        }
//
//        // Register bean as disposable.
//        try {
//            registerDisposableBeanIfNecessary(beanName, bean, mbd);
//        }
//        catch (BeanDefinitionValidationException ex) {
//            throw new BeanCreationException(
//                    mbd.getResourceDescription(), beanName, "Invalid destruction signature", ex);
//        }
//
//        return exposedObject;
//    }
//
//
//    /**
//     *
//     * 应用实例化前的后处理程序，解决指定bean是否存在实例化前的快捷方式。
//     */
//    @Nullable
//    protected Object resolveBeforeInstantiation(String beanName, RootBeanDefinition mbd) {
//        Object bean = null;
//        if (!Boolean.FALSE.equals(mbd.beforeInstantiationResolved)) {
//            // Make sure bean class is actually resolved at this point.
//            if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
//                Class<?> targetType = determineTargetType(beanName, mbd);
//                if (targetType != null) {
//                    //applyBeanPostProcessorsBeforeInstantiation方法可以在bean实例化前后进行增强处理
//                    bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
//                    if (bean != null) {
//                        bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
//                    }
//                }
//            }
//            mbd.beforeInstantiationResolved = (bean != null);
//        }
//        return bean;
//    }
//
//    @SuppressWarnings("deprecation")  // for postProcessPropertyValues
//    protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable BeanWrapper bw) {
//        if (bw == null) {
//            if (mbd.hasPropertyValues()) {
//                throw new BeanCreationException(
//                        mbd.getResourceDescription(), beanName, "Cannot apply property values to null instance");
//            }
//            else {
//                // Skip property population phase for null instance.
//                return;
//            }
//        }
//
//        // Give any InstantiationAwareBeanPostProcessors the opportunity to modify the
//        // state of the bean before properties are set. This can be used, for example,
//        // to support styles of field injection.
//        //这里可以在创建bean前后进行增强
//        if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
//            for (BeanPostProcessor bp : getBeanPostProcessors()) {
//                if (bp instanceof InstantiationAwareBeanPostProcessor) {
//                    InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
//                    if (!ibp.postProcessAfterInstantiation(bw.getWrappedInstance(), beanName)) {
//                        return;
//                    }
//                }
//            }
//        }
//        //如果有hasPropertyValues设置属性值就去获取属性值
//        PropertyValues pvs = (mbd.hasPropertyValues() ? mbd.getPropertyValues() : null);
//
//        int resolvedAutowireMode = mbd.getResolvedAutowireMode();
//        //注入bean 的方式
//        if (resolvedAutowireMode == AUTOWIRE_BY_NAME || resolvedAutowireMode == AUTOWIRE_BY_TYPE) {
//            MutablePropertyValues newPvs = new MutablePropertyValues(pvs);
//            // Add property values based on autowire by name if applicable.
//            if (resolvedAutowireMode == AUTOWIRE_BY_NAME) {
//                autowireByName(beanName, mbd, bw, newPvs);
//            }
//            // Add property values based on autowire by type if applicable.
//            if (resolvedAutowireMode == AUTOWIRE_BY_TYPE) {
//                autowireByType(beanName, mbd, bw, newPvs);
//            }
//            pvs = newPvs;
//        }
//
//        boolean hasInstAwareBpps = hasInstantiationAwareBeanPostProcessors();
//        boolean needsDepCheck = (mbd.getDependencyCheck() != AbstractBeanDefinition.DEPENDENCY_CHECK_NONE);
//        //处理bean 的一些属性
//        PropertyDescriptor[] filteredPds = null;
//        if (hasInstAwareBpps) {
//            if (pvs == null) {
//                pvs = mbd.getPropertyValues();
//            }
//            for (BeanPostProcessor bp : getBeanPostProcessors()) {
//                if (bp instanceof InstantiationAwareBeanPostProcessor) {
//                    InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
//                    PropertyValues pvsToUse = ibp.postProcessProperties(pvs, bw.getWrappedInstance(), beanName);
//                    if (pvsToUse == null) {
//                        if (filteredPds == null) {
//                            filteredPds = filterPropertyDescriptorsForDependencyCheck(bw, mbd.allowCaching);
//                        }
//                        pvsToUse = ibp.postProcessPropertyValues(pvs, filteredPds, bw.getWrappedInstance(), beanName);
//                        if (pvsToUse == null) {
//                            return;
//                        }
//                    }
//                    pvs = pvsToUse;
//                }
//            }
//        }
//        if (needsDepCheck) {
//            if (filteredPds == null) {
//                filteredPds = filterPropertyDescriptorsForDependencyCheck(bw, mbd.allowCaching);
//            }
//            checkDependencies(beanName, mbd, filteredPds, pvs);
//        }
//
//        if (pvs != null) {
//            applyPropertyValues(beanName, mbd, bw, pvs);
//        }
//    }
//
//}
