maven命令行创建项目：
1) 非web项目：mvn archetype:generate -DgroupId=com.dj -DartifactId=backend-test -DpackageName=com.dj -Dversion=1.0
2）web项目：  mvn archetype:generate -DgroupId=com.dj -DartifactId=mywebapps  -DarchetypeArtifactId=maven-archetype-webapp -Dversion=1.0 
spring4MVC配置
1. 首先在web.xml文件中注册DispatcherServlet控制器
2. 在创建spring-mvc.xml文件设置在哪个包里寻找控制层Java文件