## 项目说明
- 自己实现的简化版SpringBoot，通过造轮子来让自己对工具的理解更加深刻。
项目分为framework和test两个模块，framework负责实现spring的核心功能，并且使用包名对各个功能进行了划分；test模块则负责对framework模块代码的正确性进行验证。
- SpringBoot启动
实现了Spring Boot入口启动程序，Application通过调用MiniApplication的入口run方法启动整个程序，并在程序启动成功后输出相应的结果。 项目中framework模块为test模块提供了支撑，test模块则反过来为framework模块提供验证。

- 集成Tomcat服务器
对Tomcat做了简化实现

- 实现MVC请求拦截和响应
对SpringMVC的核心功能进行了实现，test模块的Application向framework模块的MiniApplication传递类信息，MiniApplication调用ClassScanner进行包扫描，通过类加载器扫描包中的类路径（其中对jar包的信息做了进一步处理），并返回classList类列表至MiniApplication；进而使用HandlerManagger获取类信息，并通过HandlerManager进行组装。 TomcatServer则更改其拦截的请求uri路径为/，以拦截所有通过tomcat的请求，并转发至DispatcherServlet，DispatcherServlet的service方法进行uri匹配，匹配成功则调用Handler的resolveMappingHandler方法,实例化并返回响应信息。

- Bean管理（IOC与DI）
实现了控制翻转和依赖注入，增加了Bean注解用于标记一个类是否是需要管理的Bean，Autowired注解用于注解在何处注入实例化后的Bean。以及核心的实现类BeanFactory工厂，对外提供了获取bean的getBean方法和初始化工厂的initBean的方法。

- 实现的注解：`@Bean`，`@Controller`，`@ResponseBody`，`@RequestMapping`，`@RequestParam`，`@Autowired`

## 开发环境
- 语言：Java8
- IDE：IDEA
- 依赖管理与项目构建：Gradle

## 项目运行与测试
- 构建：`gradle build`
- 项目根目录下，命令行执行`java -jar test/build/libs/test-1.0-SNAPSHOT.jar`运行项目
- 在项目输入`localhost:9999\test`进行测试，可以看到Simplify-Spring-Boot返回的信息
