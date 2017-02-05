<?php
/**
*@ Author:Shao
*@ Date: 2017-01-21
*@ Despriction: DB引擎工厂类，用于创建DB对象
*/

    class DB {
        public static $db;//保存数据库操作类产生的实例化对象

        /*
         * 初始化数据库对象函数
         * @param: string:$dbtype:数据库类型,MySql、SqlServe、Oracle
         * @param: string:$config:数据库相关配置,地址、库名、账密等
         * */
        public static function init($dbtype,$config) {
            self::$db = new $dbtype;//实例化新的对象，存放在$db中
            self::$db -> connect($config);//根据配置，链接数据库
        }

        public static function query($sql) {
            return self::$db -> query($sql);
        }

        public static function findALL($sql) {
            $query =  self::$db -> query($sql);
            return self::$db -> findAll($query);
        }

        public static function findOne($sql) {
            $query = self::$db -> query($sql);
            return self::$db -> findOne($query);
        }

        public static function findResult($sql,$row = 0,$filed = 0) {
            $query = self::$db -> query($sql);
            return self::$db -> findResult($query,$row,$filed);
        }

        public static function insert($table,$arr) {
            return self::$db -> insert($table,$arr);
        }

        public static function update($table,$arr,$where) {
            return self::$db -> update($table,$arr,$where);
        }

        public static function del($table,$where) {
            return self::$db -> del($table,$where);
        }
    }
    error_reporting(E_ALL ^ E_NOTICE);
?>
