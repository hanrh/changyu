/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this.initEvent();
            this._userList = this.userList('#userList');
            $('.selectpicker').selectpicker('render');
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
                        url: '/api/39f139515f18427984e8774c59ba727b',
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
        userList: function (panelId) {
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'name',
                    title: '用户名称',
                    width: '120px'
                }, {
                    code: 'code',
                    title: '用户编码',
                    width: '100px'
                }, {
                    code: 'channel',
                    title: '渠道'
                }, {
                    code: 'status',
                    title: '状态',
                    formatter: function (val) {
                        return val ? '正常' : '禁用';
                    }
                }, {
                    code: 'company',
                    title: '公司'
                }, {
                    code: 'sex',
                    title: '性别',
                    width: '75px',
                    formatter: function (val) {
                        return val ? '男' : '女';
                    }
                }, {
                    code: 'mobile',
                    title: '手机'
                }, {
                    code: 'email',
                    title: '电子邮件'
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
                url: '/api/3569ed456e5545d5afeece71d333677a',
                pagination: true,
                onLoadSuccess: function () {
                    org.breezee.buttons.editCallback('25274ec2bcc14367be8e57c1f10a58b1', 'id', function (data) {
                        if (data.value && data.value.company)
                            $('.selectpicker').selectpicker('val', data.value.company.split(','));
                        $('#account_win').modal('show');
                    });
                }
            });
        }
    };
    org.breezee.page.init();
});