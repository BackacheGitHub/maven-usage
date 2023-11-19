假设我们开发了一个SDK，需要提供给其他组织使用。

sdk模块依赖了common模块，common模块是我们公司内部的一个通用库。

我们希望将common打包到最终的SDK中。
可以参考 https://maven.apache.org/plugins/maven-shade-plugin/examples/includes-excludes.html 进行配置。

```shell
mvn clean package
```

打包后，target 目录下会有两个jar包，以original开头的，是未经shade插件处理的。
可以看到 sdk-1.0-SNAPSHOT.jar 中包含了 org.example.utils.StringUtils。

也可以配合 flatten-maven-plugin的fatjar模式，将jar包中pom.xml中的依赖信息去掉，只保留jar包中的内容。
打包后，发现pom中的parent和dependency都被去掉了。

