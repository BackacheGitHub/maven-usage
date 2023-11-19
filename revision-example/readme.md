打包

```shell
mvn clean package
```

打包完成后，可以看到 target/module-a-0.0.1-SNAPSHOT.jar!/META-INF/maven/org.example/module-a/pom.xml，
中的版本号，已被 properties.revision 替换。

打包，指定版本号

```shell
mvn clean package -Drevision=1.0.0
```

再次观察包中的 pom.xml，发现版本号被替换成 1.0.0