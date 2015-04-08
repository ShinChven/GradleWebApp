#使用Gradle 构建JavaWebApp
Gradle是很强大的构建工具，不过如果你在天朝，你可能需要一个强大的网络环境。
本项目不具备太大实战意义，只是探索性地使用Gradle 构建Java Web项目，本人自己也只是使用它当学生和测试的模板。
本项目还在不间断施工中，请多多包涵。
如果在「食用」过程中发现Gradle build起来真TM恶心，建议赶紧回头使用Maven，Maven 在天朝使用确实更加顺畅。
##Gradle的基本结构
一般使用Gradle 来构建一个项目，首先会有一个project文件夹，然后在project文件夹中会有一个或者多个module。project表示一个工作空间，而其中的module则是具体的应用，也可以是应用所依赖的library。
###settings.gradle
在此文件中使用include ':folder' 语句配置某个文件夹为module文件夹，只有在这里配置了，开发工具才会增目标文件夹中运行build.gradle文件构建module。
###build.gradle
Gradle项目中使用build.gradle 文件对项目进行构建：
<p>1、根文件夹中的build.gradle 文件一般用于配置一些整个工程下的通用配置，比如repository之类的。
<p>2、module 中的build.gradle 配置module 的构建。
##SSH module
这是一个Gradle 构建的Struts2 Hiberante4 Springframeworks4 应用，详细配置请查看其中的build.gradle 文件。该module基本已经填完坑，可以拉下来直接运行。<p>
Good luck!
##SpringWebMVC
请参考这个仓库：<a href="https://github.com/ShinChven/SpringApp">https://github.com/ShinChven/SpringApp</a>
##构建War 项目
当你在module 的build.gradle中添加了war 插件（apply plugin: 'war'）时，IDE会识别该module 为Java Web项目，
你可以使用一些配置来定义War包的结构，比如：<p>
```groovy
configurations {
    moreLibs // 配置该module 在构建时，既加载dependencies中的依赖，还加载「散装」的jar包
}

war {
    from '/src/main/webapp' // 指定WebRoot 路径
    webInf { from '/src/main/webapp/WEB-INF/' } // 指定 WEB-INF 文件夹路径.
    classpath fileTree('lib') // 指定 WEB-INF/lib 文件夹路径.
    classpath configurations.moreLibs // build 「散装」的jar包
    webXml = file('/src/main/webapp/WEB-INF/web.xml') // WEB-INF/web.xml 文件路径
}
```
<p>
在配置好war 以后，Gradle build 时会自动生成这样的项目结构：<p>
&nbsp;   一般你的工程结构需要是：<p>
  &nbsp;&nbsp;   src/main/java           -- java 代码<p>
  &nbsp;&nbsp;   src/main/resources      -- 配置文件<p>
  &nbsp;&nbsp;   src/main/webapp         -- WebRoot<p>
  &nbsp;&nbsp;   build.gradle            -- gradle 构建脚本<p>
  &nbsp;&nbsp;   settings.gradle         -- gradle 项目设置，在其中你可以配置目录下哪些文件夹是一个module<p>
  &nbsp;&nbsp;   关于工程结构的配置请参照DEMO中build.gradle的war{}部分，<p>
  &nbsp;&nbsp;   详情请查看gradle 的war 插件页面： http://www.gradle.org/docs/current/userguide/war_plugin.html<p>




