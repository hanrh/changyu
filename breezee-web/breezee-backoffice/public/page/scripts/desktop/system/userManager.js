/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this.initEvent();
            this._userList = this.userList('#userList');
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $(".newAccount").click(function () {
                $('#account_win').modal('show');
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
                        url: '/api/4c7b346d00854494aa6b97dd47f965eb',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            me._userList.reload();
                            $('#account_win').modal('hide');
                        }
                    });

                }
            });
            $('.content-refresh').click(function () {
                me._userList.reload();
            });
        },
        /**
         * 用户列表
         * @param panelId
         * @returns {*|LIST}
         */
        userList: function (panelId) {
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'name',
                    title: '用户名称',
                    width: '140px'
                }, {
                    code: 'code',
                    title: '用户编码',
                    width: '140px'
                }, {
                    code: 'status',
                    title: '状态',
                    width: '120px',
                    formatter: function (val) {
                        return val ? '正常' : '禁用';
                    }
                }, {
                    code: 'sex',
                    title: '性别',
                    width: '75px',
                    formatter: function (val) {
                        return val ? '男' : '女';
                    }
                }, {
                    code: 'mobile',
                    title: '手机',
                    width: '140px'
                }, {
                    code: 'email',
                    title: '电子邮件'
                }, {
                    code: 'customerId',
                    title: '客户编码'
                }, {
                    code: 'id',
                    title: '&nbsp;',
                    width: '180px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.edit({
                                id: row.id
                            })
                            + '<a href="javascript:;" data-id="' + val + '" ' +
                            'class="btn btn-outline btn-circle btn-sm dark delBtn">' +
                            '<i class="fa fa-' + (row.status > 0 ? 'lock' : 'unlock') + '"></i>' + (row.status > 0 ? '锁定' : '解锁') + '</a>';
                    }
                }],
                multiple: true,
                rowIndex: true,
                checkbox: true,
                ajaxType: Dolphin.requestMethod.POST,
                url: '/api/ce3f73c0482a4c98a06429a2e64b5f63',
                pagination: true,
                onLoadSuccess: function () {
                    org.breezee.buttons.editCallback('56eaa61cc42d46f8a49a8cf5aba22d2a', 'id', function (data) {
                        $('#account_win').modal('show');
                    });
                }
            });
        }
    };
    org.breezee.page.init();
});