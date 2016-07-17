# mybatis.archetype
spring mybatis junit archetype

基于此archetype可以创建一个spring mybatis的空白工程， 包含了一个DemoUser CRUD的示例， 以及单元测试。

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
### 参考文档
https://geekofficedog.blogspot.com/2013/08/creating-maven-archetypes-tutorial.html
http://maven.apache.org/archetype/archetype-models/archetype-descriptor/archetype-descriptor.html
