<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 视图引擎工厂类,用于创建VIEW对象
*/
    class VIEW {
        public static $view;//保存视图引擎类产生的实例化对象

        /*
         * 视图引擎初始化方法
         *@param: string $viewtype:视图引擎类型
         *@param: string $config:视图引擎配置
         * */
        public static function init($viewtype,$config) {//视图引擎初始化方法
            self::$view = new $viewtype;

            foreach ($config as $key => $value) { //载入视图引擎初始化配置
                self::$view -> $key = $value;
            }
        }

        public static function assign($data) {
            foreach ($data as $key => $value) {
                self::$view -> assign($key,$value);
            }
        }

        public static function display($template) {
            self::$view -> display($template);
        }
    }
?>
