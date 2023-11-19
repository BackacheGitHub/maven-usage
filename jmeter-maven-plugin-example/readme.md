```shell
# 构建项目，jmeter 中配置了 testPlanLibraries，其依赖 test-code，需要先将 test-code 安装至本地仓库
# 修改 test-code 的代码后，也需要进行 install，因为 jmeter-maven-plugin 会在 target 下生成临时目录，
# 会将 test-code-1.0-SNAPSHOT.jar 复制临时目录的 lib 中，如果不进行 install，则使用旧版本的 test-code，修改不会生效
mvn clean install -DskipTests=true

# 运行 GUI，-pl 指定使用 jmeter 子模块
mvn clean -pl jmeter jmeter:configure jmeter:gui

# 运行 GUI，指定测试计划文件，在GUI中可以对该文件进行编辑和保存
mvn clean -pl jmeter jmeter:configure jmeter:gui -DguiTestFile=src/test/jmeter/test.jmx

# 运行测试，测试执行完成后，可以在 target/jmeter/reports 查看测试报告
mvn clean -pl jmeter jmeter:configure verify
```