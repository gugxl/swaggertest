# 基于哪个镜像
FROM java:8
# 将本地文件夹挂载到当前容器
VOLUME /tmp
# 拷贝文件到容器，swaggertest-0.0.1-SNAPSHOT.jar这里是maven打包后的名字
ADD swaggertest-0.0.1-SNAPSHOT.jar swaggertest.jar
RUN bash -c 'touch /swaggertest.jar'
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/swaggertest.jar"]

EXPOSE 8080