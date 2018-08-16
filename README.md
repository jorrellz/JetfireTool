
-------------------------------------------------------------------------------
## 简介

JetfireTool是整合Java基础工具类的集合，可快速实现体力活的代码。

-------------------------------------------------------------------------------

## 包含组件
对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类，同时提供以下组件：

- jetfiretool-aop              JDK动态代理封装，提供非IOC下的切面支持
- jetfiretool-bloomFilter      布隆过滤，提供一些Hash算法的布隆过滤
- jetfiretool-cache            缓存
- jetfiretool-core             核心，包括Bean操作、日期、各种Util等
- jetfiretool-cron             定时任务模块，提供类Crontab表达式的定时任务
- jetfiretool-crypto           加密解密模块
- jetfiretool-db               JDBC封装后的数据操作，基于ActiveRecord思想
- jetfiretool-dfa              基于DFA模型的多关键字查找
- jetfiretool-extra            扩展模块，对第三方封装（模板引擎、邮件、Servlet、二维码等）
- jetfiretool-http             基于HttpUrlConnection的Http客户端封装
- jetfiretool-log              自动识别日志实现的日志门面
- jetfiretool-script           脚本执行封装，例如Javascript
- jetfiretool-setting          功能更强大的Setting配置文件和Properties封装
- jetfiretool-system           系统参数调用封装（JVM信息等）
- jetfiretool-json             JSON实现
- jetfiretool-captcha          图片验证码实现


-------------------------------------------------------------------------------

## 使用

### Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
    <groupId>com.github.jorrellz</groupId>
    <artifactId>jetfiretool-all</artifactId>
    <version>1.0.0</version>
</dependency>
```

