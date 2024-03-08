
create table t_user(
 id int(10) not null auto_increment comment '编号',
 username varchar(40) default null comment '名字',
 age int(10) default 0 comment '年龄',
 primary key (id)
)engine=innodb charset=utf8 comment='人员信息表'

