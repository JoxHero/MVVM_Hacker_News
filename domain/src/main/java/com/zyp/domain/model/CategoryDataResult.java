package com.zyp.domain.model;

import com.zyp.domain.ServiceResult;

import java.util.List;

/**
 * Created by zyp on 2016/6/22.
 */

public class CategoryDataResult extends ServiceResult{


    /**
     * error : false
     * results : [{"_id":"5769f7f3421aa914aa400c01","createdAt":"2016-06-22T10:29:07.839Z","desc":"可读取pdf文件的view","publishedAt":"2016-06-22T11:57:27.848Z","source":"chrome","type":"Android","url":"https://github.com/barteksc/AndroidPdfViewer","used":true,"who":"dreamxuwj"},{"_id":"5769f37d421aa914aa400bfe","createdAt":"2016-06-22T10:10:05.954Z","desc":"给用户提供一个好看的 Rating 打分效果","publishedAt":"2016-06-22T11:57:27.848Z","source":"chrome","type":"Android","url":"https://github.com/eugeneek/SmileBar","used":true,"who":"代码家"},{"_id":"5769f347421aa91496a32dc1","createdAt":"2016-06-22T10:09:11.768Z","desc":"超实用的 Android 图片压缩工具。","publishedAt":"2016-06-22T11:57:27.848Z","source":"chrome","type":"Android","url":"https://github.com/zetbaitsu/Compressor","used":true,"who":"代码家"},{"_id":"5767bd52421aa9560005955c","createdAt":"2016-06-20T17:54:26.368Z","desc":"Watchlist","publishedAt":"2016-06-21T12:00:17.657Z","source":"chrome","type":"Android","url":"https://github.com/Ronak-LM/Watchlist","used":true,"who":"花开堪折枝"},{"_id":"5767931d421aa94f3da6d715","createdAt":"2016-06-20T14:54:21.921Z","desc":"在布局里添加自定义字体","publishedAt":"2016-06-21T12:00:17.657Z","source":"chrome","type":"Android","url":"https://github.com/daniribalbert/CustomFontLib","used":true,"who":"蒋朋"},{"_id":"57676ae8421aa94ea080dc7c","createdAt":"2016-06-20T12:02:48.947Z","desc":"渐变色背景组件","publishedAt":"2016-06-20T12:31:26.789Z","source":"chrome","type":"Android","url":"https://github.com/csdodd/GradientLayout","used":true,"who":"代码家"},{"_id":"5767473a421aa947f4cbcdfb","createdAt":"2016-06-20T09:30:34.639Z","desc":"自己动手编译最新Android源码(超详细)","publishedAt":"2016-06-20T12:31:26.789Z","source":"web","type":"Android","url":"http://toutiao.io/shares/477268/url","used":true,"who":"Dong dong Liu"},{"_id":"57671c60421aa967dde7c162","createdAt":"2016-06-20T06:27:44.603Z","desc":"炒鸡炫酷效果的ExpandingPager","publishedAt":"2016-06-20T12:31:26.789Z","source":"web","type":"Android","url":"https://github.com/qs-lll/ExpandingPager","used":true,"who":null},{"_id":"5766a00d421aa967dde7c160","createdAt":"2016-06-19T21:37:17.271Z","desc":"CircleCheckBox\n","publishedAt":"2016-06-20T12:31:26.789Z","source":"chrome","type":"Android","url":"https://github.com/arlindiDev/CircleCheckBox","used":true,"who":"花开堪折枝"},{"_id":"57669296421aa967da4dde9f","createdAt":"2016-06-19T20:39:50.363Z","desc":"materialdesignicons.com 图标封装","publishedAt":"2016-06-20T12:31:26.789Z","source":"chrome","type":"Android","url":"https://github.com/MrBIMC/MaterialDesignIcons","used":true,"who":"蒋朋"}]
     */

    private boolean error;
    /**
     * _id : 5769f7f3421aa914aa400c01
     * createdAt : 2016-06-22T10:29:07.839Z
     * desc : 可读取pdf文件的view
     * publishedAt : 2016-06-22T11:57:27.848Z
     * source : chrome
     * type : Android
     * url : https://github.com/barteksc/AndroidPdfViewer
     * used : true
     * who : dreamxuwj
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
