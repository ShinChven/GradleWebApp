说明：<p>
1、 这是一个使用Gradle 构建Struts2 + Springframework + hibernate JAVA Web 项目的简单DEMO，<p>
2、 Gradle 是一个非常强大的构建系统，<p>
  &nbsp;&nbsp;  在新的Android 工程构建系统中起着非常重要的作用，同样它也可以用于开发Java Web项目。<p>
3、 在计算机中配置Gradle：<p>
    &nbsp;&nbsp;下载gradle： http://www.gradle.org/downloads。<p>
    &nbsp;&nbsp;配置系统环境变量 GRADLE_HOME 到下载到的gradle包解压出来的文件夹。<p>
4、 建议使用Intellij IDEA 开发，File - Open... 打开build.gradle 即可。<p>
5、 关于工程结构：<p>
  &nbsp;   一般你的工程结构需要是：<p>
  &nbsp;&nbsp;   src/main/java           -- java 代码<p>
  &nbsp;&nbsp;   src/main/resources      -- 配置文件<p>
  &nbsp;&nbsp;   src/main/webapp         -- WebRoot<p>
  &nbsp;&nbsp;   build.gradle            -- gradle 构建脚本<p>
  &nbsp;&nbsp;   settings.gradle         -- gradle 项目设置，在其中你可以配置目录下哪些文件夹是一个module<p>
  &nbsp;&nbsp;   关于工程结构的配置请参照DEMO中build.gradle的war{}部分，<p>
  &nbsp;&nbsp;   详情请查看gradle 的war 插件页面： http://www.gradle.org/docs/current/userguide/war_plugin.html<p>