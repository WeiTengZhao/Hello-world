<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 优化后的入口文件
*/
    header("Content-type:text/html; charset=utf-8");
    session_start();
    require_once ("config.php");
    require_once ("framework/shao.php");
    SHAO::run($config);
    error_reporting(E_ALL ^ E_NOTICE);
?>
