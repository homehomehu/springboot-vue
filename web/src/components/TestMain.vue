<template>
    <el-table :data="tableData">
        <el-table-column prop="date" label="日期" width="140">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="address" label="地址">
        </el-table-column>
    </el-table>
</template>

<script>
export default {
    name: "TestMain",
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            tableData: Array(10).fill(item)
        }
    },
    methods:{
        loadGet() {
            this.$axios.get(this.$httpUrl + '/user/list').then(res=>res.data).then(res=>{
                console.log(res)
            }) //在这个链式调用中，.then(res => res.status) 表示在获取到响应后，从响应对象中提取出状态码（status）
               // $httpUrl 在 main.js 里面全局配置了
        },
        loadPost() {
            this.$axios.post(this.$httpUrl + '/user/listP',{}).then(res=>res.data).then(res=>{
                console.log(res)
            })
        }
    },
    beforeMount() {
        // 相当于原来刷新浏览器的时候会发送请求，现在就是页面渲染、挂载的时候就会发送请求
        // this.loadGet();
        this.loadPost();
    }
}
</script>

<style scoped>

</style>