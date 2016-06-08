/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this._orgTree = this.orgTree('#orgTree');
            this._accountList = this.accountList('#accountList');
            this._selectList = this.selectUserList('#selectedList');
            this._unSelectList = this.unSelectUserList('#unselectedList');
            this.initEvent();
        },
        /**
         * 初始化事件
         */
        initEvent: function () {
            var me = this;
            $(".newOrg").click(function () {
                $('#org_win').modal('show');
            });
            $('.updateOrg').click(function () {
                if (!me.selectData) {
                    alert('请选择一个组织！');
                    return;
                }
                Dolphin.ajax({
                    url: '/api/f1636e6852684975b9bc1105f8e95b93@id=' + me.selectData.id,
                    type: Dolphin.requestMethod.GET,
                    onSuccess: function (reData) {
                        Dolphin.form.setValue(reData.value, '.edit-form');
                        $('.selectpicker').selectpicker('val', reData.value.company.split(','));
                        $('#org_win').modal('show');
                    }
                });
            });
            $('.relationAccount').click(function () {
                if (!me.selectData) {
                    alert('请选择一个组织！');
                    return;
                }
                $('#org_relation_win').modal('show');
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
                        url: '/api/ae55fd5637d040249574c12f97e11cc9',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            me._orgTree.reload();
                            $('#org_win').modal('hide');
                        }
                    });

                }
            });
            /**
             * 保存组织人员关系
             */
            $('.relation_submit').click(function () {
                var data = {};
                data.id = me.selectData.id;
                data.accounts = [];
                var selData = me._selectList.data.rows;
                for (var i = 0; i < selData.length; i++) {
                    data.accounts.push(selData[i].id);
                }
                Dolphin.ajax({
                    url: '/api/ecf2c717827c4c2d998ea9fd4d5b779c',
                    type: Dolphin.requestMethod.POST,
                    data: Dolphin.json2string(data),
                    onSuccess: function (reData) {
                        me._accountList.reload();
                        $('#org_relation_win').modal('hide');
                    }
                });
            });
            /**
             * 选择面板中的按钮
             */
            $('[change]').click(function () {
                var thisButton = $(this), allFlag = !!thisButton.attr('all'),
                    sourceList, targetList,
                    checkedData,
                    i;
                if (thisButton.attr("change") == "select") {
                    sourceList = me._unSelectList;
                    targetList = me._selectList;
                } else {
                    sourceList = me._selectList;
                    targetList = me._unSelectList;
                }
                if (allFlag) {
                    checkedData = [].concat(sourceList.data.rows);
                } else {
                    checkedData = sourceList.getChecked();
                }
                for (i = 0; i < checkedData.length; i++) {
                    if (!checkedData[i].inheritFlag) {
                        sourceList.removeRow(checkedData[i].__id__);
                        targetList.addRowWithData(checkedData[i]);
                    }
                }
            });

            $('#org_relation_win').on('show.bs.modal', function (e) {
                me._selectList.load('/api/3569ed456e5545d5afeece71d333677a', {
                    properties: {
                        "organization_obj": me.selectData.id,
                        "pageSize": "-1"
                    }
                });
                me._unSelectList.load('/api/3569ed456e5545d5afeece71d333677a', {properties: {"organization_obj": "-1"}});
            });
        },
        /**
         * 组织树
         * @returns {*|TREE}
         */
        orgTree: function () {
            var me = this;
            return new Dolphin.TREE({
                panel: arguments[0],
                url: '/api/ed040a7849cc400fbf55ec6ec0abf43b@parentId={id}',
                mockPathData: ['id'],
                defaultId: '-1',
                multiple: false,
                onChecked: function (data) {
                    me.selectData = data;
                    me._accountList.load('/api/3569ed456e5545d5afeece71d333677a', {properties: {"organization_obj": data.id}});
                },
                onLoad: function () {
                    if (me._orgTree.data.length > 0)
                        me._orgTree.expend(me._orgTree.data[0]);
                }
            });
        },
        accountList: function (panelId) {
            var me = this;
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
                    title: '状态'
                }, {
                    code: 'company',
                    title: '公司'
                }],
                multiple: false,
                rowIndex: true,
                checkbox: false,
                ajaxType: Dolphin.requestMethod.POST,
                data: {rows: []},
                pagination: true,
                onLoadSuccess: function (data) {
                }
            });
        },
        selectUserList: function (panelId) {
            return new Dolphin.LIST({
                panel: panelId,
                panelType: 'panel-warning',
                title: '已选择列表',
                idField: 'id',
                maxHeight: '400px',
                columns: [{
                    code: 'name',
                    title: '用户名称',
                    width: '120px'
                }, {
                    code: 'code',
                    title: '用户编码',
                    width: '100px'
                }],
                multiple: true,
                rowIndex: true,
                checkbox: true,
                ajaxType: Dolphin.requestMethod.POST,
                data: {rows: []},
                pagination: false
            });
        },
        unSelectUserList: function (panelId) {
            return new Dolphin.LIST({
                panel: panelId,
                title: '未选择列表',
                panelType: 'panel-info',
                maxHeight: '400px',
                idField: 'id',
                columns: [{
                    code: 'name',
                    title: '用户名称',
                    width: '120px'
                }, {
                    code: 'code',
                    title: '用户编码',
                    width: '100px'
                }],
                multiple: true,
                rowIndex: false,
                checkbox: true,
                ajaxType: Dolphin.requestMethod.POST,
                data: {rows: []},
                pagination: true
            });
        }
    };
    org.breezee.page.init();
});