<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="报销人编号" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入报销人编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报销人姓名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入报销人姓名"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报销人部门" prop="deptName">
        <el-input
          v-model="queryParams.deptName"
          placeholder="请输入报销人部门"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报销金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入报销金额"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报销事由" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入报销事由"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报销申请日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择报销申请日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['baoxiao:biaodan:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['baoxiao:biaodan:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['baoxiao:biaodan:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['baoxiao:biaodan:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="biaodanList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="报销人编号" align="center" prop="userId" />
      <el-table-column label="报销人姓名" align="center" prop="userName" />
      <el-table-column label="报销人部门" align="center" prop="deptName" />
      <el-table-column label="报销金额" align="center" prop="amount" />
      <el-table-column label="报销事由" align="center" prop="reason" />
      <el-table-column label="报销申请日期" align="center" prop="date" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="附件" align="center" prop="file" width="100">
        <template #default="scope">
          <image-preview :src="scope.row.file" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['baoxiao:biaodan:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['baoxiao:biaodan:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改baoxiao对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="biaodanRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报销人编号" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入报销人编号" />
        </el-form-item>
        <el-form-item label="报销人姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入报销人姓名" />
        </el-form-item>
        <el-form-item label="报销人部门" prop="deptName">
          <el-input v-model="form.deptName" placeholder="请输入报销人部门" />
        </el-form-item>
        <el-form-item label="报销金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入报销金额" />
        </el-form-item>
        <el-form-item label="报销事由" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入报销事由" />
        </el-form-item>
        <el-form-item label="报销申请日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择报销申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="附件" prop="file">
          <image-upload v-model="form.file"/>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Biaodan">
import { listBiaodan, getBiaodan, delBiaodan, addBiaodan, updateBiaodan } from "@/api/baoxiao/biaodan";

const { proxy } = getCurrentInstance();

const biaodanList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    userId: null,
    userName: null,
    deptName: null,
    amount: null,
    reason: null,
    date: null,
  },
  rules: {
    userId: [
      { required: true, message: "报销人编号不能为空", trigger: "blur" }
    ],
    userName: [
      { required: true, message: "报销人姓名不能为空", trigger: "blur" }
    ],
    deptName: [
      { required: true, message: "报销人部门不能为空", trigger: "blur" }
    ],
    amount: [
      { required: true, message: "报销金额不能为空", trigger: "blur" }
    ],
    reason: [
      { required: true, message: "报销事由不能为空", trigger: "blur" }
    ],
    date: [
      { required: true, message: "报销申请日期不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询baoxiao列表 */
function getList() {
  loading.value = true;
  listBiaodan(queryParams.value).then(response => {
    biaodanList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    biaodanId: null,
    userId: null,
    userName: null,
    deptName: null,
    amount: null,
    reason: null,
    date: null,
    file: null
  };
  proxy.resetForm("biaodanRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.biaodanId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加baoxiao";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _biaodanId = row.biaodanId || ids.value
  getBiaodan(_biaodanId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改baoxiao";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["biaodanRef"].validate(valid => {
    if (valid) {
      if (form.value.biaodanId != null) {
        updateBiaodan(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addBiaodan(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _biaodanIds = row.biaodanId || ids.value;
  proxy.$modal.confirm('是否确认删除baoxiao编号为"' + _biaodanIds + '"的数据项？').then(function() {
    return delBiaodan(_biaodanIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('baoxiao/biaodan/export', {
    ...queryParams.value
  }, `biaodan_${new Date().getTime()}.xlsx`)
}

getList();
</script>
