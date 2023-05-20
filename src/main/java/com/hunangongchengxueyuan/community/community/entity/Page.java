package com.hunangongchengxueyuan.community.community.entity;

/**
 *
 * 封装页面相关信息
 *
 * */
public class Page {

    //当前页码
    private int current = 1;
    //显示上限
    private int limit = 10;
    //数据总载(用于计数页面总数)
    private int rows;
    //查询路径
    private  String path;

    public int getRows(int discussPostRows) {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath(String s) {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getCurrent() {

        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }
    /*
    * 获取当前页起始行
    * @return
    * */
    public int getOffset(){
        //current * limit - limit;
        return  (current-1)*limit;
    }

    /*
    * 获取总页数
    * */
    public int getTotal(){
        //rows / limit[+1]
        if(rows % limit == 0){
            return  rows / limit;
        }else{
            return  rows / limit +1;
        }
    }

    //获取起始页码
    public int getFrom(){
        int from = current-2;
        return  from<1 ? 1 : from;
    }

   //获取结束页码
    public int getTo(){
        int to = current+2;
        int total = getTotal();
        return  to > total ? total : to;
    }
}
