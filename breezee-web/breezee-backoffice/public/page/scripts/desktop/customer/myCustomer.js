/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {

    org.breezee.page = {
        /**
         * 初始化页面
         */
        init: function () {
            this.destroy();
            this._customerList = this.customerList('#customerList');
            this.initEvent();
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $('.content-refresh').click(function () {
                me._customerList.reload();
            });
        },
        /**
         * 客户信息列表分页
         * @param panelId
         * @returns {*|LIST}
         */
        customerList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'code',
                    title: '客户编码',
                    width: '120px'
                }, {
                    code: 'type',
                    title: '客户类型',
                    width: '120px'
                }, {
                    code: 'name',
                    title: '客户名称',
                    width: '300px',
                    formatter: function (val) {
                        return '<div style="max-width: 300px;overflow: hidden;text-overflow:ellipsis;white-space:nowrap;">' + val + '</div>'
                    }
                }, {
                    code: 'rank',
                    title: '客户级别',
                    width: '75px'
                }, {
                    code: 'address',
                    title: '地址',
                    formatter: function (val) {
                        return '<div style="max-width: 400px;overflow: hidden;text-overflow:ellipsis;white-space:nowrap;">' + val + '</div>'
                    }
                }, {
                    code: '',
                    title: '&nbsp;',
                    width: '90px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.view({
                            id: row.id
                        });
                    }
                }],
                multiple: false,
                ajaxType: Dolphin.requestMethod.POST,
                url: '/api/41d7222ba7f246ceb33daaa4e5c97a0e',
                pagination: true,
                onClick: function (data, thisRow, event) {
                },
                onLoadSuccess: function () {
                    org.breezee.buttons.viewCallback('ac843b67de424221a24e9962e7281b33', 'id', function (data) {

                    });
                }
            });
        },
        /**
         * 一些页面DOM对象和事件的销毁
         */
        destroy: function () {
        }
    };
    org.breezee.page.init();
});