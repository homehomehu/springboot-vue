<template>
    <div style="display: flex;">
        <!-- display: flex 是设置容器为 flex 容器 -->
        <div style="flex: 1;  cursor: pointer">
        <!-- @后面的是事件，所以这里监听的是“点击该元素”这一事件-->
            <i :class="icon" style="font-size:34px; line-height: 61px"
               @click="collapse"></i>
        </div>
        <div style="flex: 1; text-align: center; font-size: 34px; line-height: 61px">
            <span>WelcomeToHomeHome</span>
        </div>
        <div style="flex: 1; text-align: right; line-height: 61px">
            <el-dropdown>
                <span>王小虎</span>
                <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
                    <!--                这里加上 .native 之后表示触发的是父组件的事件，否则会触发组件内部的事件-->
                    <el-dropdown-item @click.native="logOut">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
export default {
    name: "TestHeader",
    props: {
        icon: String
    },
    methods:{
        toUser(){
            console.log("to_user")
        },
        logOut(){
            console.log("log_out")
        },
        collapse(){
            this.$emit("doCollapse")
        }  // 自定义了一个 “doCollapse”事件，通过触发 "doCollapse" 事件，父组件可以监听到这个事件
    }
}
</script>

<style scoped>

</style>