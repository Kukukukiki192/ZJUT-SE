教材.NoSQL数据库原理及应用.pdf[👉](https://pan.baidu.com/s/1_R9StVa4tUPS5H3McI6wsA?pwd=1111)

# NoSQL命令

### 键值DB-Redis命令

字符串 String
```sql
SET key1 "redis"
GET key1
GETRANGE key1 0 5
```
列表 List：字符串构成的有序集合
```sql
LPUSH key1 'C++' 'database'
RPUSH key1 orange
LRANGE key1 0 2
```
集合 Set：String类型元素的无序集合
```sql
SADD key1 redis mysql
SMEMBERS key1
SREM key1 redis
```
有序集 Sorted Set：String类型元素 关联double类型数 从小到大排序构成的集合
```sql
Zadd key1 1 redis 2 mysql
Zrange key1 0 5
```
哈希映射 Hash：带有键值型特征的数据结构
```sql
HSET key1 name "Zhang"
HGET key1 name
HMSET key1 name “redis tutorial” description “redis basic commands for caching” likes 20 visitors 23000
HGETALL key1
```
位数组：二进制整数构成的数组

键命令
```sql
Keys *
DEL key1
Del  key1
EXISTS key1
MOVE key1 db1
RENAME key1 newkey
TYPE key1
```
DB命令
```sql
SELECT index
FLUSHALL
FLUSHDB
```
### 文档DB-MongoDB命令

```sql
数据库
show dbs
db
use db1
db.dropDatabase()
集合
db.createCollection(name, options)
db.createCollection("mycollect")
db.createCollection(“orders" , {size:1024,capped:true,max:100}) //指定size 1024KB，大小固定，满了就会删除旧文档，最多存放100个文档
show collections
db.collection1.drop()
文档
db.collection1.insert(document)//插入一个文档
db.collection1.insertOne({"a": 3})
db.collection1.insertMany([{"b": 3}, {'c': 4}])
db.collection1.find({query}, {projection}) 
     from	              where   select
db.collection1.find().pretty()
	              .sort({key:1/-1}) 升序/降序
	              .skip()	2
	              .limit()	3
```

### 列族DB-Cassandra命令

键空间
```sql

创建
CREATE KEYSPACE KeySpaceName
WITH replication = {
'class': ‘Strategy name’, //定数据副本位置策略
//1 SimpleStrategy 2 NetworkTopologyStrategy 3 OldNetworkTopologyStrategy
'replication_factor' : ‘No.Of replicas’//副本数量
}
AND durable_writes = ‘Boolean value’; //写数据时是否写入commit log

CREATE KEYSPACE teach 
with replication = 
{ ‘class’ : ‘SimpleStrategy’, ‘replication_factor’: 1 } 
and durable_writes = false;

修改
ALTER KEYSPACE KeySpaceName
WITH replication = {'class': ‘Strategy name’, 'rep
lication_factor' : ‘No.Of replicas’};
删除
DROP KEYSPACE “KeySpace name”;
查看(all
DESCRIBE keyspaces;//查看所有的键空间
切换
USE keyspaces;
```
列族(表
```sql
--创建
CREATE (TABLE | COLUMNFAMILY) <表名> ( 
<列名称> <数据类型> primary key， 
<列名称> <数据类型> [static]
<列名称> <数据类型> ，……
)

CREATE TABLE users (
username text, 
id timeuuid, 
email text STATIC, 
encrypted_password blob STATIC, 
body text, 
PRIMARY KEY (username, id)
);
查看
DESCRIBE tables;

修改
ALTER (TABLE | COLUMNFAMILY) <tablename> 
<instruction>
增加一列
ALTER TABLE table name ADD new column datatype;
删除一列
ALTER TABLE emp DROP emp_email;

删除表
DROP TABLE <tablename>

创建索引
CREATE INDEX <identifier> ON <tablename>(name)
在emp1表上的name属性上创建索引
CREATE INDEX name ON emp1 (emp_name);
删除索引
drop index name;


插入
INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone, emp_sal) 
VALUES(1,'ram', 'Hyderabad', 9848022338, 50000);
更新
UPDATE emp 
SET emp_city='Delhi', emp_sal=50000
WHERE emp_id=2;

查询(只支持主键列、索引列的查询
 分区主键 =
 聚类主键 = > < >= <= 依次使用
 索引列 =
 否则要增加allow filtering短语表强制查询
select * from table where key1=? and key2=? and key3<? and key3>=?

删除
 删除emp_id=3的emp_sal列
DELETE emp_sal FROM emp WHERE emp_id=3;
 删除emp_id=3的一个整个行
DELETE FROM emp WHERE emp_id=3;

集合
List
Set
Map
```
作业：
```sql
use student_course;

create table zkx_students (
sno text primary key,
sname text,
ssex text,
sage int, 
major map<text, int> , //Cno,Grade
dname text
);

create table zkx_courses(
cno text primary key,
cname text,
pre_cno text,
credits int
);

insert into zkx_students(sno, sname, sage, ssex, major, dname) 
values ('S01', 'Wang Jianping', 21, 'Male', {'C01':92,'C03':84}, 'Automatic');

insert into zkx_students (sno, sname, sage, ssex, major, dname) 
values ('S02', 'Liu Hua', 19, 'Female', {'C01':90,'C02':94,'C03':82}, 'Automatic');

insert into zkx_students (sno, sname, sage, ssex, major, dname) 
values ('S03', 'Fan Linjun', 18, 'Female', {'C01':72, 'C02':90}, 'Computer');

insert into zkx_students (sno, sname, sage, ssex, major, dname) 
values ('S04', 'Li Wei', 19, 'Male', {'C03':75}, 'Mathematic');

insert into zkx_students (sno, sname, sage, ssex,  dname) 
values ('S05', 'Huang He', 18, 'Male', 'Mathematic');

insert into zkx_students (sno, sname, sage, ssex,  dname) 
values ('S06', 'Chang Jiang', 20, 'Male', 'Mathematic');

insert into zkx_courses (cno, cname, pre_cno, credits) 
values ('C01', 'English', Null, 4);

insert into zkx_courses (cno, cname, pre_cno, credits) 
values ('C02', 'Data structure', 'C01', 2);

insert into zkx_courses (cno, cname, pre_cno, credits) 
values ('C03', 'Data Base', 'C02', 2);


create index sname_index on zkx_students (sname);
create index major_index on zkx_students (major);
drop index name;

select sno,sname, major from zkx_students where sname='Wang Jianping';
select * from zkx_students where sage>20 allow filtering;
```