<template>
  <el-card>
  <el-form  :model="form" label-width="80px">
    <el-row>
      <el-col span="4">
        <el-form-item label="基金代码"  >
        <el-input  v-model="form.name"></el-input>
        </el-form-item>
      </el-col>
      <el-col span="2"><el-form-item></el-form-item></el-col>
        <el-col span="4" >
        <el-form-item label="基金名称">
          <el-input  v-model="form.name" ></el-input>
        </el-form-item>
        </el-col>
      <el-col span="2"><el-form-item></el-form-item></el-col>
      <el-col span="4">
        <el-form-item label="基金类型"  >
         <el-select style="width:100%">
           <el-option>请选择</el-option>
           <el-option>平安</el-option>
         </el-select>
        </el-form-item>
      </el-col>
      <el-col span="2"><el-form-item></el-form-item></el-col>
      <el-col span="4">
        <el-form-item label="登记机构"  >
          <el-select style="width:100%">
            <el-option>请选择</el-option>
            <el-option>平安</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col span="2"><el-form-item></el-form-item></el-col>
    </el-row>
    <el-row>
      <el-col span="4">
        <el-form-item label="托管行">
          <el-select style="width:100%">
            <el-option>请选择</el-option>
            <el-option>平安</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col span="2"><el-form-item></el-form-item></el-col>
      <el-col span="4">
        <el-form-item label="审核状态">
          <el-select style="width:100%">
            <el-option>请选择</el-option>
            <el-option>平安</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col span="6">
        <el-form-item>
        <el-button type="primary" icon="el-icon-search" >查询</el-button>
        <el-button type="primary" icon="el-icon-refresh">重置</el-button>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>

    <el-table  border >
      <template v-slot="form">
        <div class="btns">
           <el-button type="primary" icon="el-icon-refresh">重置</el-button>
        </div>
      </template>
      <el-table-column prop="name" label="姓名s" align="center">
      </el-table-column>
      <el-table-column prop="age" label="年龄" align="center"></el-table-column>
      <el-table-column prop="sex" label="性别" align="center"></el-table-column>
      <el-table-column prop="major" label="专业" align="center"></el-table-column>
      <el-table-column prop="depart" label="院系" align="center"></el-table-column>
      <el-table-column prop="term" label="学期" align="center"></el-table-column>
      <el-table-column prop="year" label="年级" align="center"></el-table-column>
      <el-table-column prop="role" label="角色" align="center"></el-table-column>
    </el-table>
  </el-card>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!')
    }

  }
}
</script>
