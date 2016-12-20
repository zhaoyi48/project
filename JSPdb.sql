DROP TABLE IF EXISTS `T_USERS`;
CREATE TABLE `T_USERS` (
  `T_USERID` numeric(10) NOT NULL,
  `T_NICKNAME` varchar(20) DEFAULT NULL,
  `T_NAME` varchar(50) DEFAULT NULL,
  `T_IDNO` numeric(18) DEFAULT NULL,
  `T_HATDTEL` varchar(20) default NUll,
  `T_TEL` numeric(18) default null,
  `T_ADDRESS` varchar(50) default null,
  `T_MAIL` varchar(50) default null,
  `T_SIGN` numeric(1) default null,
  `T_PAYTRUST` varchar(20) default null,
  `T_COMPANY`   varchar(50) default null,
  `T_COMPANYADD`  varchar(50) default null,
  `T_SELLCONT`  varchar(50) default null,
  `T_SELLTRUST`  varchar(20) default null,
  `T_MANAGER`  varchar(50) default null,
  `T_MANAGERID`  varchar(18) default null,
  `T_USERPASS` varchar(10) not null,
  `T_SIGNDATE` date default null,
  `T_ACCESS` numeric not null,
  PRIMARY KEY (`T_USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `T_PRODUCTTYPE`;
CREATE TABLE `T_PRODUCTTYPE` (
  `T_PRODUCTTYPEID` varchar(2)not NULL,
  `T_PRODUCTNAME` varchar(50) not NULL,
  
  PRIMARY KEY (`T_PRODUCTTYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `T_PRODUCT`;
CREATE TABLE `T_PRODUCT` (
  
  `T_PRODUCTID` varchar(20)   not NULL,
  `T_PRODUCTNAME` varchar(50) not NULL,
  `T_PRICE` numeric(12,2) default null,
  `T_NUM`  numeric(10) default null,
  `T_PRODUCTTYPEID` varchar(2) not NULL,
  `T_PRODUCTDATE` date not NULL, 
  `T_SELLUSERID`  numeric(10) default null,
  `T_COMMENT`  varchar(10) default null,
  `T_POSTAGE` numeric(10,2) default null,
  
  PRIMARY KEY (`T_PRODUCTID`),
  foreign key (`T_PRODUCTTYPEID`) references T_PRODUCTTYPE(`T_PRODUCTTYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `T_TALK`;
CREATE TABLE `T_TALK` (
  `T_TALKTIME` date not NULL,   
  `T_SENDER` numeric(10) not null,
  `T_ACCEPTER` numeric(10) not null,
  `T_TALKCONTENT` varchar(1000) not NULL,
  
  PRIMARY KEY (`T_TALKTIME`),
  foreign key (`T_SENDER`) references T_USERS(`T_USERID`),
  foreign key (`T_ACCEPTER`) references T_USERS(`T_USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `T_WANTBUY`;
CREATE TABLE `T_WANTBUY` (
  `T_PRODUCTID` varchar(20) not NULL,   
  `T_BUYNUM` numeric(10) not null,
  `T_BUYDATE` date not null,
  `T_COMPUTECOST` numeric(10,2) not NULL,
  `T_ADDCOST` numeric(10) not null,
  `T_SUBCOST` numeric(10) not null,
  `T_REALCOST` numeric(20) not null,
  `T_PRICE` numeric(10,2) not null,
  `T_SELLUSERID` numeric(10) not null,
  `T_BUYUSERID` numeric(10) not null,
  `T_WANTPROID` varchar(25) not null,
  PRIMARY KEY (`T_PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `T_REALBUY`;
CREATE TABLE `T_REALBUY` (
  `T_PRODUCTID` varchar(20) not NULL,   
  `T_BUYNUM` numeric(10) not null,
  `T_BUYDATE` date not null,
  `T_SELLUSERID` numeric(10) not null,
  `T_COMPUTECOST` numeric(10,2) not NULL,
  `T_ADDCOST` numeric(10) not null,
  `T_SUBCOST` numeric(10) not null,
  `T_REALCOST` numeric(20) not null,
  `T_BUYUSERID` numeric(10) not null,
  `T_BUYPROID` varchar(25) not null,
  PRIMARY KEY (`T_PRODUCTID`),
  foreign key (`T_PRODUCTID`) references T_PRODUCT(`T_PRODUCTID`),
  foreign key (`T_SELLUSERID`) references T_USERS(`T_USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `T_REALSELL`;
CREATE TABLE `T_REALSELL` (
  `T_PRODUCTID` varchar(20) not NULL,   
  `T_BUYNUM` numeric(10) not null,
  `T_BUYDATE` date not null,
  `T_BUYUSERID` numeric(10) not null,
  `T_COMPUTECOST` numeric(10,2) not NULL,
  `T_ADDCOST` numeric(10) not null,
  `T_SUBCOST` numeric(10) not null,
  `T_REALCOST` numeric(20) not null,
  `T_SELLUSERID` numeric(10) not null,
  `T_SELLPROID` varchar(25) not null,
  PRIMARY KEY (`T_PRODUCTID`),
  foreign key (`T_PRODUCTID`) references T_PRODUCT(`T_PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

