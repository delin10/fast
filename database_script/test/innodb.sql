---可以查看配置文件加载顺序
---在linux一般在/etc/my.cnf
---在windows中可能为.ini或者.conf
---MySQL以读取到的最后一个配置文件为准

MYSQL --HELP

---数据库文件存放路径参数
show variables like 'datadir';

---查看mysql支持的引擎信息
show engins;

---测试各引擎的不同
create table mytest engine=myisam
as select * from salaries;

alter table mytest engine=innodb;

alter table mytest engine=archive;

---导入数据库脚本
---delin为数据库名称
mysql -u root -p delin < employees.sql

---查看innodb版本
show variables like 'innodb_version'\G

---查看innodb_read_io_threads和innodb_write_io_threads
show variables like 'innodb_%io_threads'\G

---包含缓冲池、插入缓冲、自适应hash索引、事务、信号量、后台线程-master_thread信息
show engine innodb status\G;

---查看purge线程数量
show variables like 'innodb_purge_threads'\G

---查看缓冲池大小
show variables like 'innodb_buffer_pool_size'\G

---查看缓冲池实例数量
show variables like 'innodb_buffer_pool_instances'\G

---ERROR 1238 (HY000): Variable 'innodb_buffer_pool_instances' is a read only variable
---需要在配置文件中修改
set innodb_buffer_pool_instances=2

---查看LRU的midpoint位置
show variables like 'innodb_old_blocks_pct'\G


---可以查看配置文件加载顺序
---在linux一般在/etc/my.cnf
---在windows中可能为.ini或者.conf
---MySQL以读取到的最后一个配置文件为准

MYSQL --HELP

---数据库文件存放路径参数
show variables like 'datadir';

---查看mysql支持的引擎信息
show engins;

---测试各引擎的不同
create table mytest engine=myisam
as select * from salaries;

alter table mytest engine=innodb;

alter table mytest engine=archive;

---导入数据库脚本
---delin为数据库名称
mysql -u root -p delin < employees.sql

---查看innodb版本
show variables like 'innodb_version'\G

---查看innodb_read_io_threads和innodb_write_io_threads
show variables like 'innodb_%io_threads'\G

---包含缓冲池、插入缓冲、自适应hash索引、事务、信号量、后台线程-master_thread信息
show engine innodb status\G;

---查看purge线程数量
show variables like 'innodb_purge_threads'\G

---查看缓冲池大小
show variables like 'innodb_buffer_pool_size'\G

---查看缓冲池实例数量
show variables like 'innodb_buffer_pool_instances'\G

---ERROR 1238 (HY000): Variable 'innodb_buffer_pool_instances' is a read only variable
---需要在配置文件中修改
set innodb_buffer_pool_instances=2

---查看LRU的midpoint位置
show variables like 'innodb_old_blocks_pct'\G

---该参数表示页读取到mid位置多久才会被移到队头
show variables like 'innodb_old_blocks_time'\G

set global innodb_old_blocks_time=0

---查看缓冲池运行状态
select pool_id,hit_rate,pages_made_young,pages_not_made_young
from information_schema.innodb_buffer_pool_stats\G



