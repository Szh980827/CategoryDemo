package com.zhihao.category;

import java.io.Serializable;
import java.util.List;

/**
 * author：wangzihang
 * date： 2017/8/4 11:13
 * desctiption：
 * e-mail：wangzihang@xiaohongchun.com
 */

public class CategoryBean implements Serializable {


    /**
     * code : 0
     * data :
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String type;
        private String moreIcon;
        private String moduleStyle;
        private String moduleTitle;
        private String moreLinkType;
        private String moreTextDisplay;
        private String moreUniversalNavigator;
        private List<DataListBean> dataList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMoreIcon() {
            return moreIcon;
        }

        public void setMoreIcon(String moreIcon) {
            this.moreIcon = moreIcon;
        }

        public String getModuleStyle() {
            return moduleStyle;
        }

        public void setModuleStyle(String moduleStyle) {
            this.moduleStyle = moduleStyle;
        }

        public String getModuleTitle() {
            return moduleTitle;
        }

        public void setModuleTitle(String moduleTitle) {
            this.moduleTitle = moduleTitle;
        }

        public String getMoreLinkType() {
            return moreLinkType;
        }

        public void setMoreLinkType(String moreLinkType) {
            this.moreLinkType = moreLinkType;
        }

        public String getMoreTextDisplay() {
            return moreTextDisplay;
        }

        public void setMoreTextDisplay(String moreTextDisplay) {
            this.moreTextDisplay = moreTextDisplay;
        }

        public String getMoreUniversalNavigator() {
            return moreUniversalNavigator;
        }

        public void setMoreUniversalNavigator(String moreUniversalNavigator) {
            this.moreUniversalNavigator = moreUniversalNavigator;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {

            private String id;
            private String type;
            private String title;
            private String imgURL;
            private String yuan;
            private String xian;
            private String linkType;
            private String linkParam;
            private String universalNavigator;

            public DataListBean() {
                super();
            }

            public DataListBean(String type) {
                this.type = type;
            }

            public String getYuan() {
                return yuan;
            }

            public void setYuan(String yuan) {
                this.yuan = yuan;
            }

            public String getXian() {
                return xian;
            }

            public void setXian(String xian) {
                this.xian = xian;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgURL() {
                return imgURL;
            }

            public void setImgURL(String imgURL) {
                this.imgURL = imgURL;
            }

            public String getLinkType() {
                return linkType;
            }

            public void setLinkType(String linkType) {
                this.linkType = linkType;
            }

            public String getLinkParam() {
                return linkParam;
            }

            public void setLinkParam(String linkParam) {
                this.linkParam = linkParam;
            }

            public String getUniversalNavigator() {
                return universalNavigator;
            }

            public void setUniversalNavigator(String universalNavigator) {
                this.universalNavigator = universalNavigator;
            }
        }
    }
}
