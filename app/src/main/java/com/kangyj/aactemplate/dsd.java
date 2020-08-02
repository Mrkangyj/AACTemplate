package com.kangyj.aactemplate;

import java.util.List;

/**
 * author Mr.kang
 * e-mail:kangyoujie@aliyun.com
 * github:https://github.com/Mrkangyj
 * date  09
 * desc
 */
class dsd {

    /**
     * code : 1
     * msg : 数据返回成功
     * data : {"page":2,"totalCount":9590,"totalPage":959,"limit":10,"list":[{"content":"儿子:\u201c爸爸，为什么王叔叔那么喜欢吃辣\u201d爸爸:\u201c你怎么知道王叔叔喜欢吃辣？\u201d儿子:\u201c别人都叫我妈妈为辣妈，我经常看到王叔叔抱着我妈妈又亲又啃\u201d爸爸:\u201c尼玛\u201d","updateTime":"2018-11-03 09:45:28"},{"content":"儿子:\u201c爸爸，为什么王叔叔那么喜欢吃辣\u201d爸爸:\u201c你怎么知道王叔叔喜欢吃辣？\u201d儿子:\u201c别人都叫我妈妈为辣妈，我经常看到王叔叔抱着我妈妈又亲又啃\u201d爸爸:\u201c尼玛\u201d","updateTime":"2018-11-03 09:45:28"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * page : 2
         * totalCount : 9590
         * totalPage : 959
         * limit : 10
         * list : [{"content":"儿子:\u201c爸爸，为什么王叔叔那么喜欢吃辣\u201d爸爸:\u201c你怎么知道王叔叔喜欢吃辣？\u201d儿子:\u201c别人都叫我妈妈为辣妈，我经常看到王叔叔抱着我妈妈又亲又啃\u201d爸爸:\u201c尼玛\u201d","updateTime":"2018-11-03 09:45:28"},{"content":"儿子:\u201c爸爸，为什么王叔叔那么喜欢吃辣\u201d爸爸:\u201c你怎么知道王叔叔喜欢吃辣？\u201d儿子:\u201c别人都叫我妈妈为辣妈，我经常看到王叔叔抱着我妈妈又亲又啃\u201d爸爸:\u201c尼玛\u201d","updateTime":"2018-11-03 09:45:28"}]
         */

        private int page;
        private int totalCount;
        private int totalPage;
        private int limit;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * content : 儿子:“爸爸，为什么王叔叔那么喜欢吃辣”爸爸:“你怎么知道王叔叔喜欢吃辣？”儿子:“别人都叫我妈妈为辣妈，我经常看到王叔叔抱着我妈妈又亲又啃”爸爸:“尼玛”
             * updateTime : 2018-11-03 09:45:28
             */

            private String content;
            private String updateTime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
