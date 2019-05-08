# sqldoc
springboot builder: databaser infomation to word
## 自动生成mysql文档工具

#### 先决条件说明

已安装JAVA8并配置好环境变量

#### 1.编辑application.properties文件并保存

参数说明：

```txt
#数据库URL
spring.datasource.url=jdbc:mysql://10.10.136.58:3306/jd_platform_chen?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
#数据库用户名
spring.datasource.username=root
#数据库密码
spring.datasource.password=root
#数据库驱动（不用修改）
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#JPA设置（不用修改）
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
#程序运行时控制台是否打印sql
spring.jpa.show-sql=false
#指定要生成的word文件名和路径
word.path=C:/Users/yaosai/Desktop/credit_cp.doc
#指定要生成文档的数据库
database.name=credit_cp
```

#### 2.在当前文件夹databaseToword下打开cmd，运行如下指令

```cmd
java -jar sqldoc.jar
```

即可在指定的路径下生成数据库说明文档
