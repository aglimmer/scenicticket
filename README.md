# 景点门票后端服务
## 项目简介
- 这是我初学后端`SpringBoot`和前端`React`时独立设计的一个项目
- 项目当前实现的部分用于为营业员提供门票销售、统计、分析，后面待完善的是为游客提供景点门票的查询、购买包括预定的功能
- 后端Springboot集成使用Spring Data JPA，提供了对数据库持久化映射和操作支持，后端包的命名使用用领域驱动模型设计，请求接口遵循restful编程风格
- 前端模块`scenicticket-ui`（已上传到同名仓库）采用当前主流的三大框架之一React来实现，通过组件化开发方式分解复杂功能为可重复使用的组件，提高开发效率
## 学习要点
- 后端主要是操作数据库框架`Spring Data JPA`，`swagger-ui`配置生成文档
- 前端重点是`React`使用`Route`路由，各个路由组件之间状态渲染，学习`React`之前要对`typescript`有一定了解

## 配置内容
*swagger文档接口*
```shell script
http://localhost:8080/scenicticket/swagger-ui/index.html
```
*配置说明*

- 数据库使用版本`mysql-8.0`
- Java环境`jdk-1.8`
- springboot版本`2.3.2.RELEASE`

*mysql-8.0数据库备份脚本*

```shell script
#位于当前项目根目录下
scenicticket.sql
```
*数据库创建语句*
```sql
#确保在执行备份文件前有这个数据库
create database if not exists scenicticket character set 'utf8mb4' collate 'utf8mb4_0900_ai_ci';
#选定这个数据库
use scenicticket;
#然后执行备份脚本
```
