select * from gsales
select * from goods
select * from salesman

--展示所有商品列表所用多表联立的sql解释：
------------------------------------------------------
select gname,gprice,gnum, allSum                        --所求新表的项目

from goods, (select gid as salesid,sum(snum) as allSum  --整个大括号里面代表一张表
            from gsales                                   --将gid相同的相加求和
            where trunc(sdate) = trunc(sysdate)            --时间从系统获取，条件是与表中sdate时间相同
            group by gid)
where gid = salesid                                      --goods表与大括号里的这张表，取gid与salessid的交集
------------------------------------------------------

--知识充电：
select trunc(sysdate) from dual;
select trunc(sysdate) + 1 from dual;
select sysdate from dual;       --从系统获取时间

select sid,to_char(sdate,'yyyy/mm/dd') from gsales --转换时间输出格式，注意：字段的格式不能被转换