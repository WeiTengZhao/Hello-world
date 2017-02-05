<?php
/**
*@ Author:Shao
*@ Date: 2017-01-23
*@ Despriction: 从数据库获取新闻内容的模型
*/
    class newsModel {
        public $_table = 'news';

        function count(){//获取当前新闻总条目的函数
            $sql = 'SELECT COUNT(*) FROM '.$this -> _table;
            return DB::findResult($sql,0,0);
        }

        public function getnewsinfo($id) {//获取一篇新闻
            if(empty($id)) {
                return array();
            }else {
                $id = intval($id);
                $sql = 'SELECT * FROM ' .$this->_table. ' WHERE id=' .$id;
                return DB::findOne($sql);
            }
        }

        public function newssubmit($data) { //新闻提交后的处理函数,接收传递进来的内容
            extract($data);
            if (empty($title) || empty($content)) {//判断标题和内容是否为空
                return 0;
            }

            $title = daddslashes($title);
            $content = daddslashes($content);
            $author = daddslashes($author);
            $from = daddslashes($from);

            //此处可以添加图片路径到数据库
            $reg_tag = '/<img.*?\"([^\"]*(jpg|bmp|jpeg|gif)).*?>/';//获取src的正则表达式子
            $ret = preg_match_all($reg_tag, $content, $match_result,PREG_PATTERN_ORDER);//使用正则表达式获取<img>标签中的图片地址
            $image_url = implode("\n",$match_result[1]);//将一维数组转化成字符串 分隔符为/n
            $data = array(
                        'title' => $title,
                        'content'  => $content,
                        'author' => $author,
                        'from' => $from,
                        'dateline' => time(),
                        'image' => $image_url
                    );
            if($_POST['id'] != '') { //若id存在则进行修改操作
                DB::update($this->_table,$data,$_POST['id']);
                return 2;
            }else {//id不存在，进行添加操作
                DB::insert($this->_table,$data);
                return 1;
            }
        }

        function find_orderby_dateline() {//显示列表的具体业务逻辑
            $sql = 'SELECT * FROM '.$this->_table. ' ORDER BY dateline DESC';//mysql语句,取数据，按照dateline倒序排列
            return DB::findALL($sql);//取出全部
        }

        function del_by_id($id) {//删除操作
            return DB::del($this->_table,'id='.$id);
        }

        function get_news_list() {//前台页面获取新闻列表函数
            $data = $this->find_orderby_dateline();
            foreach ($data as $key => $news) {

                /*$reg_tag = '/<img.*?\"([^\"]*(jpg|bmp|jpeg|gif)).*?>/';
                $ret = preg_match_all($reg_tag, $data[$key]['content'], $match_result);*/

                $data[$key] ['content'] = mb_substr(strip_tags($data[$key]['content']),0,200);//去除html标签，并裁剪200字的预览
                $data[$key] ['dateline'] = date('Y-m-d H:i:s',$data[$key]['dateline']);//设置时间显示格式

            }
            return $data;
        }
    }
?>
