/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this.initEvent();
            this._dataList = this.dataList('#dataList');
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $(".newData").click(function () {
                $('#data_win').modal('show');
            });
            /**
             * 保存按钮
             */
            $(".btn_submit").click(function () {
                var ef = $(".edit-form");
                if (Dolphin.form.validate(ef)) {
                    var data = Dolphin.form.getValue(ef, '"');
                    if (data.company)
                        data.company = data.company.join(',');
                    Dolphin.ajax({
                        url: '/api/8c436d88d249485d83be59284de17ceb',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            me._dataList.reload();
                            $('#data_win').modal('hide');
                        }
                    });

                }
            });
        },
        dataList: function (panelId) {
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                queryParams: {accountCode: $('[name=accountCode]').val()},
                idField: 'id',
                columns: [{
                    code: 'code',
                    title: '客户编码',
                    width: '120px'
                }, {
                    code: 'name',
                    title: '客户名称',
                    width: '100px'
                }, {
                    code: 'type',
                    title: '客户类型'
                }, {
                    code: 'delegateType',
                    title: '代理范围'
                }, {
                    code: 'id',
                    title: '&nbsp;',
                    width: '180px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.edit({
                                id: row.id
                            })
                            + org.breezee.buttons.del({
                                id: row.id
                            });
                    }
                }],
                multiple: true,
                rowIndex: true,
                checkbox: true,
                ajaxType: Dolphin.requestMethod.GET,
                url: '/api/8c436d88d249485d83be59284de17ceb',
                pagination: true,
                onLoadSuccess: function () {

                }
            });
        }
    };
    org.breezee.page.init();
});