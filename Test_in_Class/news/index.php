<?php
/**
*@ Author:Shao
*@ Date: 2017-01-24
*@ Despriction: 前台页面展示文件
*/
    header("Content-type:text/html;charset=utf-8");//定义头文件
    date_default_timezone_set('Asia/ShangHai');//设置时区
    require_once ('config.php');//导入配置文件
    require_once ('framework/shao.php');//导入框架
    SHAO::run($config);
    error_reporting(E_ALL ^ E_NOTICE);
?>
