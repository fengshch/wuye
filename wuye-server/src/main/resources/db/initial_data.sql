INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('南石集团','公司','集团公司',null,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('广东分公司','公司','区域公司',1,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('湖北分公司','公司','区域公司',1,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('广州公司','公司','城市公司',2,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('深圳公司','公司','城市公司',2,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('武汉公司','公司','城市公司',3,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('佛山公司','公司','城市公司',2,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('东莞公司','公司','城市公司',2,0);

INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('白云人家管理处','管理处','管理处',4,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('梧桐仙庄管理处','管理处','管理处',5,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('东湖唱晚管理处','管理处','管理处',6,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('西樵小居管理处','管理处','管理处',7,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('松山春晓管理处','管理处','管理处',8,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('财务部','部门','部门',1,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('市场部','部门','部门',1,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('销售部','部门','部门',1,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('财务部','部门','部门',2,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('市场部','部门','部门',2,0);
INSERT INTO zzjg(name,jglb,description,parent_id,version) VALUES('销售部','部门','部门',2,0);

INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('全国','区域','区域',null,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('广东省','区域','区域',1,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('湖北省','区域','区域',1,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('广州市','区域','区域',2,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('深圳市','区域','区域',2,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('武汉市','区域','区域',3,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('佛山市','区域','区域',2,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('东莞市','区域','区域',2,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('白云人家','项目','小区',4,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('梧桐仙庄','项目','小区',5,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('东湖唱晚','项目','小区',6,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('西樵小居','项目','小区',7,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('松山春晓','项目','小区',8,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('东区','分区','分区',9,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('西区','分区','分区',9,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('南区','分区','分区',10,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('北区','分区','分区',10,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('别墅区','分区','分区',11,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('高层','分区','分区',12,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('A栋','楼栋','楼栋',16,0);
INSERT INTO dyqy(name,qylb,description,parent_id,version) VALUES('B栋','楼栋','楼栋',16,0);

INSERT INTO wyzy(no,name,zylb,jzmj,sfmj,description,dyqy_id,version) VALUES('A0201','201','房间',120,100,'201 房',20,0);
INSERT INTO wyzy(no,name,zylb,jzmj,sfmj,description,dyqy_id,version) VALUES('A0202','202','房间',120,100,'202 房',20,0);
INSERT INTO wyzy(no,name,zylb,jzmj,sfmj,description,dyqy_id,version) VALUES('A0203','203','房间',120,100,'203 房',20,0);
INSERT INTO wyzy(no,name,zylb,jzmj,sfmj,description,dyqy_id,version) VALUES('A0204','204','房间',120,100,'204 房',20,0);

INSERT INTO person(name,xb,version) VALUES ('张三','男',0);
INSERT INTO person(name,xb,version) VALUES ('李四','女',0);
INSERT INTO person(name,xb,version) VALUES ('王五','男',0);
INSERT INTO person(name,xb,version) VALUES ('赵六','女',0);

INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('001','gr',1,NULL );
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('002','gr',2,NULL );
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('003','gr',3,NULL );
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('004','gr',4,NULL );

INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('005','jg',NULL,1);
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('006','jg',NULL,2);
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('007','jg',NULL,3);
INSERT INTO customer(no,khlb,gr_id,jg_id) VALUES('008','jg',NULL,4);

INSERT INTO fkgx(zy_id,kh_id,sfsf) VALUES(1,1,TRUE );
INSERT INTO fkgx(zy_id,kh_id,sfsf) VALUES(2,4,TRUE );
INSERT INTO fkgx(zy_id,kh_id,sfsf) VALUES(3,2,TRUE );

INSERT INTO sfxm(name) VALUES ('物业管理费');
INSERT INTO sfxm(name) VALUES ('水费');
INSERT INTO sfxm(name) VALUES ('电费');
INSERT INTO sfxm(name) VALUES ('路灯分摊');

INSERT INTO sfbz(name,formula,sfxm_id) VALUES('住宅管理费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(2.0);foo.sum();',1);
INSERT INTO sfbz(name,formula,sfxm_id) VALUES('公寓管理费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(3.0);foo.sum();',1);
INSERT INTO sfbz(name,formula,sfxm_id) VALUES('住宅水费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(5.0);foo.sum();',2);
INSERT INTO sfbz(name,formula,sfxm_id) VALUES('公寓水费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(7.0);foo.sum();',2);
INSERT INTO sfbz(name,formula,sfxm_id) VALUES('住宅电费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(9.0);foo.sum();',3);
INSERT INTO sfbz(name,formula,sfxm_id) VALUES('公寓电费','var Foo = Java.type(''cn.southstone.wuye.server.cal.Foo'');var foo = new Foo();foo.setA(5.0);foo.setB(11.0);foo.sum();',3);

INSERT INTO bzxy(fkgx_id,sfbz_id) VALUES (1,1);
INSERT INTO bzxy(fkgx_id,sfbz_id) VALUES (1,3);
INSERT INTO bzxy(fkgx_id,sfbz_id) VALUES (2,2);
INSERT INTO bzxy(fkgx_id,sfbz_id) VALUES (2,4);