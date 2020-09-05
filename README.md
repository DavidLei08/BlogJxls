# BlogJxls
## spring-boot快速集成jxls-poi，模板导出excel表格
![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly93d3cuZGxibG9nLmNsdWIvZmlsZS8yMDIwMDQyNS9welBtaUhzay5wbmc?x-oss-process=image/format,png)
##  基于jxls-poi
- 支持本地文件导出
- 支持在线下载文件导出

## 核心依赖
``` xml
		<!-- jxls-api -->
		<dependency>
			<groupId>org.jxls</groupId>
			<artifactId>jxls-poi</artifactId>
			<version>1.0.15</version>
			<exclusions><!-- 去掉默认日志打印 -->
				<exclusion>
					<groupId>ch.qos.logback</groupId>
					<artifactId>logback-classic</artifactId>
				</exclusion>
				<exclusion>
					<groupId>ch.qos.logback</groupId>
					<artifactId>logback-core</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.jxls</groupId>
			<artifactId>jxls</artifactId>
			<version>2.4.6</version>
			<exclusions><!-- 去掉默认日志打印 -->
				<exclusion>
					<groupId>ch.qos.logback</groupId>
					<artifactId>logback-classic</artifactId>
				</exclusion>
				<exclusion>
					<groupId>ch.qos.logback</groupId>
					<artifactId>logback-core</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```

## 基础配置

``` yml
# 模板路径配置
jxls.template.path: classpath:jxls/
```
