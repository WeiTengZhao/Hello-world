<?php
/**
*@ Author:Shao
*@ Date: 2017-01-18
*@ Despriction: 封装的mysql数据库处理类
*/
    class mysql {
        function err($error)
        {//报错函数
            die("对不起，数据库连接出错，错误原因为：<br>" . $error);
        }

        /*
         * @param $config为配置数组array($dbhost,$dbuser,$dbpsw,$dbname,$dbcharest)
         * @ return bool连接成不成功
         * */
        function connect($config) {//数据库连接函数处理数据库连接
            extract($config);
            if (!$conn = mysql_connect($dbhost,$dbuser,$dbpsw)) {//连接数据库
                $this->err(mysql_error());
            }
            if (!mysql_select_db($dbname)) { //选择数据库
                $this->err(mysql_error());
            }
            if (!mysql_query("set names ".$dbcharset)) { //设置字符集
                $this->err(mysql_error());
            }
        }

        /*
         * 对执行SQL语句进行封装↓
         * @param string $sql
         * @return bool 返回执行成功，资源或执行失败
         * */
        function query($sql) {
            if (!($query = mysql_query($sql))) { //使用mysql_query函数执行sql语句
                $this->err($sql . "<br>" . mysql_error());//输出错误信息
            } else {
                return $query;
            }
        }

        /*
         * 列表封装↓
         *
         * @param source $query:SQL语句通过mysql_query执行出来的结果资源
         * @return array():返回列表数组
         * */
        function findAll($query) {
            while ($rs = mysql_fetch_array($query, MYSQL_ASSOC)) {//使用mysql_fetch_array函数把资源转化成数组，一次一条
                $list[] = $rs;//将转化出来的数组存放在列表中
            }
            return isset($list) ? $list : '';
        }

        /*
         * 取单条
         *
         * @param source $query:SQL语句通过mysql_query执行出来的结果资源
         * @return array();返回单条数组
         * */
        function findOne($query) {
            $rs = mysql_fetch_array($query, MYSQL_ASSOC);
            return $rs;
        }

        /*
         * 指定行指定字段的值
         *
         * @param: source $query:SQL语句通过mysql_query执行出来的结果资源
         * @param: $row:指定的行
         * @param: $field:指定的字段
         * @return array():返回指定数组
         * */

        function findResult($query, $row, $field) {
            $rs = mysql_result($query, $row, $field);
            return $rs;
        }

        /*
         * 添加函数
         * @param: string $table:表名
         * @param: array $arr:添加数组(包含字段和值的一组数组)
         * */
        function insert($table, $arr) {
            foreach ($arr as $key => $value) {//foreach循环数组，分别取出添加的字段和内容
                $keyArr[] = '`' . $key . '`';//把arr数组中的键名保存到keyArr数组中
                $valueArr[] = '\'' .$value . '\'';//把arr数组中的值保存到valueArr数组中,加`因为SQL的insert添加字符串要用`隔开
            }
            $keys = implode(",", $keyArr);//把数组整合成字符串,以 ， 为分隔符
            $values = implode(",", $valueArr);
            $sql = "INSERT INTO " . $table . " (" . $keys . ") VALUES (" . $values . ")";//书写SQL语句,INSERT INTO 表名 (多个字段) VALUES (多个值)
            $this->query($sql);//调用前面写的query()方法运行sql语句
            return mysql_insert_id;//返回插入的主键值
        }

        /*
         *
         * 修改函数
         * @param: string $table:表名
         * @param: $arr:修改数组(包含字段和值的一组数组)
         * @param: string $where:条件
         * */
        function update($table, $arr, $where) {
            foreach ($arr as $key => $value) {
//                $value = mysql_real_escape_string($value);//转义话传入数据
                $keyAndvalueArr[] = "`" . $key . "`='" . $value . "'";
            }
            $keyAndvalueArrs = implode(",", $keyAndvalueArr);//将数组整合成一个长的字符串
            $sql = "UPDATE " . $table . " SET " . $keyAndvalueArrs . " WHERE id=" . $where;//书写SQL语句,UPDATE 表名 SET  'key = value' WHERE 条件
            $this->query($sql);
        }

        /*
         *
         * 删除函数
         * @param: string:$table:表名
         * @param: string:$where:条件
         * */
        function del($table, $where) {
            $sql = "DELETE FROM " . $table . " WHERE " . $where;//书写删除SQL语句，DELETE FROM 表名 WHERE 条件
            $this->query($sql);
        }
    }
    error_reporting(7);
?>
