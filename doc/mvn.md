##版本高级的maven 自动编译
### 执行main方法
	#执行 com.java.Main.class  main方法
	mvn exec:java -Dexec.mainClass="com.java.Main" -Dexec.args="arg0 arg1 arg2"
	mvn exec:java -Dexec.mainClass="thinkInjava.c10.Dirlist" -Dexec.args="arg0 arg1 arg2"
### sublime 运行
		ctrl+B
		#注意把package注释掉 
### 执行测试用例
	#Test.class中的@Test方法
	mvn test -Dtest=Test
###  mvn 命令
	mvn compile  编译主程序源代码，不会编译test目录的源代码。第一次运行时，会下载相关的依赖包，可能会比较费时间。
    mvn test-compile  编译测试代码，compile之会后生成target文件夹，主程序编译在classes下面，测试程序放在test-classes下。
    mvn test 运行应用程序中的单元测试
    mvn site 生成项目相关信息的网站
    mvn clean 清除目标目录中的生成结果
    mvn package 依据项目生成jar文件，打包之前会进行编译，测试。
    mvn install 在本地Repository中安装jar.
    mvn eclipse:eclipse
    生成Eclipse项目文件及包引用定义，注意，需确保定义classpath variables:M2_REPO,指向本地maven类库目录。
    创建maven项目命令
    mvn archetype:generate  列出所有可用的模板供选择并创建
    mvn dependency:analyze  使用maven Dependency插件进行优化
    mvn dependency:resolve  已解决依赖的列表
    mvn dependency:tree   项目的整个依赖树
    mvn install -X 查看完整的依赖踪迹，包含那些因为冲突或者其它原因而被拒绝引入的构件（慎用，输出信息巨大）
    mvn scm:checkin -Dmessage="Message" 提交
    mvn scm:checkout 检出
    mvn scm:update 更新
    mvn help:effective-pom 查看项目的有效pom
    mvn help:effective-pom > mypom.xml 可以把项目的有效pom放入mypom.xml里面去。以供查看
    mvn help:active-profiles 列出活动的profile
    mvn test -Dtest=MyTest  只能src.test.java下的MyTest类进行测试
    mvn test -Dtest=MyTest -DfailIfNoTests=false 如果测试类里没有测试方法不报错
    mvn package -Dmavne.test.skip=true 打包之前不执行单元测试
    生成项目
    mvn archetype:create -DgroupId=com.myproject.app -DartifactId=myproject -DpackageName=com.myproject.mavenbook
    用archetype插件快速创建一个组名为com.myproject.app artifactId为myproject 项目包目录结构为com/myproject/mavenbook的java项目
    mvn archetype:create -DgroupId=com.myproject.app -DartifactId=myproject -DpackageName=com.myproject.mavenbook -DarchetypeArtifactId=maven-archetype-webapp
    用archetype插件快速创建一个组名为com.myproject.app artifactId为myproject 项目包目录结构为com/myproject/mavenbook的web-app项目
