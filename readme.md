说明：
1、 这是一个使用Gradle 构建Struts2 + Springframework + hibernate JAVA Web 项目的简单DEMO，
2、 Gradle 是一个非常强大的构建系统，
    在新的Android 工程构建系统中起着非常重要的作用，同样它也可以用于开发Java Web项目。
    建议使用Intellij IDEA 进行开发。
3、关于工程结构：
    一般你的工程结构需要是：
     src/main/java           -- java 代码
     src/main/resources      -- 配置文件
     src/main/webapp         -- WebRoot
     build.gradle            -- gradle 构建脚本
     settings.gradle         -- gradle 项目设置，在其中你可以配置目录下哪些文件夹是一个module
    关于工程结构的配置请参照DEMO中build.gradle的war{}部分，
    详情请查看gradle 的war 插件页面：<a href="http://www.gradle.org/docs/current/userguide/war_plugin.html">http://www.gradle.org/docs/current/userguide/war_plugin.html</a>
详细请查看 http://www.gradle.org/ 上关于war 插件的介绍。