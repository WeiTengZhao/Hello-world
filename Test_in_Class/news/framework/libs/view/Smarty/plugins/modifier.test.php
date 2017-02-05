<?php
/**
*@ Author:Shao
*@ Date: 2017-01-17
*@ Despriction: 尝试变形数据控制器插件, 实现时间的格式化显示
*/
    function smarty_modifier_test($utime,$format){
        return date($format,$utime);
    }
?>
