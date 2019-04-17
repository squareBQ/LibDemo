# Maven本地仓库及依赖上传（Mac）

#### 1. 安装
 1. 下载[`Nexus Repository OSS`](https://www.sonatype.com/)
 2. 解压缩包到本地目录，如`/Users/***/nexus-3.16.1-02-mac/`下
 3. 打开`/安装目录/nexus-version/etc/`下`nexus-default.properties`文件，可查看服务地址+端口号。
 3. 从终端进入到nexus的bin目录下，使用`nexus start`命令运行服务即可（相关状态命令可在`/安装目录/nexus-version/bin/nexus`文件中查看）

#### 2. Nexus后台配置
 1. 使用默认帐密登录配置后台`admin/admin123`
 2. `configuration-Repository-Repositories`新增仓库，{Type:hosted, Format:maven2, Status:online}
 3. `Browse server contents-Browse`可以看到新建的仓库

#### 3. AS配置
 1. 新建module工程，选择为android library
 2. module的`build.gradle`文件中，引入maven插件`apply plugin: 'maven'`
 3. module的`build.gradle`文件中，添加上传依赖的配置
 4. 项目的`build.gradle`文件中添加本地maven仓库
 5. 可在terminal终端使用`./gradlew uploadArchives`构建上传依赖
 6. 构建+上传成功，即可在nexus后台看到上传成功的aar包
 
 
 > tips:
 
  * 如开启后，浏览器中输入`nexus-default.properties`文件中对应的地址+端口号无法进入设置页面，可能是端口被占用，请更换端口号；
  * 解压缩需要使用命令`tar -xvf`解压，否则会出现`Could not resolve mvn:org.apache.felix/org.apache.felix.framework`的异常(由于手动解压，文件名发生了变化)
  * 依赖上传的配置信息如下：

  ```gradle
  uploadArchives {
        repositories.mavenDeployer {
            repository(url: "http://localhost:8082/repository/com.zahi.lib/") {
                authentication(userName: "zahi", password: "Mima1234")
            }
            pom.groupId = "com.zahi.lib"
            pom.artifactId = "zahilib"
            pom.version = "1.0.0"
        }
    }
  ```
  
   * 项目`build.gradle`添加本地maven地址如下：

   ```gradle
   allprojects {
    repositories {
        google()
        jcenter()
        maven() {
            url 'http://localhost:8082/repository/com.zahi.lib/'
        }
    }
   ```