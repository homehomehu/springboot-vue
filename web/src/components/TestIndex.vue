<template>
    <el-container style="height: 100%; border: 1px solid #eee">
        <!--左边那个侧栏部分-->
        <el-aside style="background-color: rgb(238, 241, 246); height: 100vh" :width="asideWidth">
        <!-- :isCollapse 将父组件中的 isCollapse 数据绑定到子组件 <TestAside> 的 isCollapse 属性上-->
        <!-- 可以看看子组件的的 props 那里，表明子组件会从父组件接收 isCollapse 属性 -->
            <TestAside :isCollapse="isCollapse"></TestAside>
        </el-aside>

        <!-- 右边那个body和header部分 -->
        <el-container style="height: 100%">
            <el-header style="height: 100%; border-bottom: rgba(169,169,169,0.29) 1px solid">
                <!-- 在这里监听到了 TestHeader 里面所触发的 doCollapse 事件 -->
                <TestHeader @doCollapse="doCollapse" :icon="icon"></TestHeader>
            </el-header>
            <el-main style="height: 100%">
                <TestMain></TestMain>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
import TestAside from "@/components/TestAside.vue";
import TestHeader from "@/components/TestHeader.vue";
import TestMain from "@/components/TestMain.vue";

export default {
    name: "TestIndex",
    components: {TestMain, TestHeader, TestAside},
    data() {
        return {
            isCollapse: false,
            asideWidth: '200px',
            icon: 'el-icon-s-fold'
        }
    },
    methods: {
        doCollapse(){
            console.log(111111)

            this.isCollapse = !this.isCollapse
            if(!this.isCollapse) { // 展开时
                this.asideWidth = '200px'
            }else {
                this.asideWidth = '64px'
                this.icon = 'el-icon-s-unfold'
            }
        }
    }
}
</script>

<style scoped>  /* scoped 这个属性表示该样式仅作用于当前组件的元素，而不会影响到其他组件的样式*/
.el-header {
    /*.el-header是类选择器*/
    /*background-color: #B3C0D1;*/
    color: #333;
}

.el-aside {
    color: #333;
}

.el-main {
    padding: 0;
}
</style>