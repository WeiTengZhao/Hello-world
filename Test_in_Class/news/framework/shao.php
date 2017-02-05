<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 框架的启动引擎
*/

    $currentdir = dirname(__FILE__);//获取当前框架的目录地址
    include_once ($currentdir.'/include.list.php');//引入列表清单
    foreach ($paths as $path) {//遍历数组引入多个文件
        include_once ($currentdir.'/'.$path);
    }

    class SHAO {
        public static $controller;
        public static $method;
        public static $config;

        private static function init_db() {//实例化DB操作类
            DB::init('mysql',self::$config['dbconfig']);
        }

        private static function init_view() {//初始化视图引擎
            VIEW::init('Smarty',self::$config['viewconfig']);
        }

        private static function init_controllor() {//初始化控制器类
            self::$controller = isset($_GET['controller']) ? daddslashes($_GET['controller']) : 'index';
        }

        private static function init_method() {//初始化方法
            self::$method = isset($_GET['method']) ? daddslashes($_GET['method']) : 'index';
        }

        public static function run($config) {//启动方法
            self::$config = $config;
            self::init_controllor();
            self::init_db();
            self::init_method();
            self::init_view();
            C(self::$controller,self::$method);//实例化控制器
        }
    }
?>
