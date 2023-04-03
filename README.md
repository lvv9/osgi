# OSGi Boot

- OSGi框架用Apache Karaf（因为Felix框架需要手工导入一些rt.jar的包）
- Bundle打包用Apache Felix的maven插件

下载Karaf后直接在目录运行
```shell
bin/karaf
bundle:install file:/path/to/the/bundle.jar
bundle:start --help
bundle:update --help
```