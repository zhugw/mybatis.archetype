# mybatis.archetype
spring mybatis junit mockito archetype

基于此`archetype`可以创建一个`spring mybatis`的空白工程， 包含了一个`DemoUser` CRUD的示例， 以及单元测试。

可以通过如下命令来生成一个新的工程
```
mvn archetype:generate -DarchetypeGroupId=com.zhugw  -DarchetypeArtifactId=mybatis.archetype  -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=com.foo -DartifactId=bar -Dpackage=com.foo.bar -DinteractiveMode=false
```
生成的工程结构
```
tree bar
bar
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── foo
    │   │           └── bar
    │   │               ├── dao
    │   │               │   ├── entity
    │   │               │   │   └── DemoUserEntity.java
    │   │               │   └── mapper
    │   │               │       └── DemoUserMapper.java
    │   │               ├── model
    │   │               │   ├── DemoUserModel.java
    │   │               │   └── DemoUserQuery.java
    │   │               └── service
    │   │                   └── DemoUserService.java
    │   └── resources
    │       ├── spring
    │       │   └── bar
    │       │       └── module-bar.xml
    │       └── sql
    │           └── bar
    │               └── DemoUser.xml
    └── test
        ├── java
        │   └── com
        │       └── foo
        │           └── bar
        │               ├── common
        │               │   └── AbstractTest.java
        │               ├── dao
        │               │   └── mapper
        │               │       └── DemoUserMapperTest.java
        │               └── service
        │                   └── DemoUserServiceTest.java
        └── resources
            ├── log4j.xml
            └── spring
                └── ApplicationContextTest.xml
```
####DemoUser建表语句
```
CREATE TABLE `demo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) NOT NULL,
  `nick` varchar(10) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
### 参考文档
https://geekofficedog.blogspot.com/2013/08/creating-maven-archetypes-tutorial.html
http://maven.apache.org/archetype/archetype-models/archetype-descriptor/archetype-descriptor.html
