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
            this._prtOpenList = this.prtOpenList('#prtOpenList');
            this.initEvent();
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $('.content-refresh').click(function () {
                me._prtOpenList.reload();
            });
        },
        /**
         * 产品信息列表分页
         * @param panelId
         * @returns {*|LIST}
         */
        prtOpenList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'productId',
                    title: '物料编码'
                }, {
                    code: 'shortText',
                    title: '物料描述',
                    textAlign: 'left',
                    width: '400px',
                    formatter: function (val) {
                        return '<div style="max-width: 400px;overflow: hidden;text-overflow:ellipsis;white-space:nowrap;">' + val + '</div>'
                    }
                }, {
                    code: 'company',
                    title: '公司'
                }, {
                    code: 'province',
                    title: '省份'
                }, {
                    code: 'channel',
                    title: '渠道'
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
                url: '/api/4ae7537cc09740dc89bd7a781238df90',
                pagination: true,
                onClick: function (data, thisRow, event) {
                },
                onLoadSuccess: function () {

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