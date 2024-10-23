<template>
  <div class="submit-reimbursement">
    <h2>提交报销申请</h2>
    <el-form :model="form" :rules="rules" ref="formRef" label-width="120px">
      <el-form-item label="申请人姓名" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="部门" prop="department">
        <el-input v-model="form.department"></el-input>
      </el-form-item>
      <el-form-item label="报销金额" prop="amount">
        <el-input-number v-model="form.amount" :min="0" :precision="2"></el-input-number>
      </el-form-item>
      <el-form-item label="报销事由" prop="reason">
        <el-input type="textarea" v-model="form.reason"></el-input>
      </el-form-item>
      <el-form-item label="消费日期" prop="date">
        <el-date-picker v-model="form.date" type="date" placeholder="选择日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="附件上传">
        <el-upload
          action="#"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-remove="beforeRemove"
          multiple
          :limit="5"
          :on-exceed="handleExceed"
          :file-list="fileList"
          :auto-upload="false"
          :on-change="handleFileChange"
        >
          <el-button type="primary">点击上传</el-button>
          <template #tip>
            <div class="el-upload__tip">
              支持上传jpg/png/pdf文件,且不超过5MB
            </div>
          </template>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { sendmsg } from "@/api/system/post"
//import { sendmsg as sendmsgbaoxiao } from "@/api/system/baoxiao"

const formRef = ref(null)

const form = reactive({
  name: '',
  department: '',
  amount: 0,
  reason: '',
  date: '',
})

const rules = {
  // name: [{ required: true, message: '请输入申请人姓名', trigger: 'blur' }],
  // department: [{ required: true, message: '请输入部门', trigger: 'blur' }],
  // amount: [{ required: true, message: '请输入报销金额', trigger: 'blur' }],
  // reason: [{ required: true, message: '请输入报销事由', trigger: 'blur' }],
  // date: [{ type: 'date', required: true, message: '请选择消费日期', trigger: 'change' }],
}

const fileList = ref([])

const handleRemove = (file, fileList) => {
  console.log(file, fileList)
}

const handlePreview = (file) => {
  console.log(file)
}

const handleExceed = (files, fileList) => {
  ElMessage.warning(`当前限制选择 5 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
}

const beforeRemove = (file, fileList) => {
  return ElMessageBox.confirm(`确定移除 ${file.name}？`)
}

const handleFileChange = (file, fileList) => {
  if (file.size > 5 * 1024 * 1024) {
    ElMessage.error('文件大小不能超过5MB')
    const index = fileList.indexOf(file)
    fileList.splice(index, 1)
  }
}

const submitForm = async () => {
  if (!formRef.value) return
  await formRef.value.validate((valid, fields) => {
    if (valid) {
      console.log(form)
      sendmsg(form).then(res=>{
        console.log(res)
        console.log('回复收到')
      })
      // 这里添加提交表单的逻辑
      
      ElMessage.success('表单提交成功')
    } else {
      console.log('表单验证失败', fields)
    }
  })
}

const resetForm = () => {
  if (!formRef.value) return
  formRef.value.resetFields()
  fileList.value = []
}
</script>

<style scoped>
.submit-reimbursement {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}
</style>
