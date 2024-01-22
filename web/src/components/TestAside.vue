<template>
    <el-menu style="height: 100vh;"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             default-active="/Home"
             :collapse= "isCollapse"
             >
        <el-menu-item index="/Home">
            <i class="el-icon-s-home"></i>
            <!-- 这个slot会当菜单栏移入之后，鼠标放在上面还能看到这个菜单栏的名字 -->
            <span slot="title">首页</span>
        </el-menu-item>
        <el-menu-item index="/One">
            <i class="el-icon-s-flag"></i>
            <span slot="title">导航一</span>
        </el-menu-item>
        <el-menu-item index="Two">
            <i class="el-icon-s-opportunity"></i>
            <span slot="title">导航二</span>
        </el-menu-item>
    </el-menu>
</template>

<script>
export default {
    name: "TestAside",

    // 在 Vue.js 中，props 是用于从父组件向子组件传递数据的一种机制。通过在子组件的声明中定义 props，父组件可以向子组件传递数据，从而实现组件之间的通信。
    // 在 Vue 组件中，可以通过**在子组件**的 props 选项中定义一个对象，该对象包含了要接收的属性及其类型
    props: {
        isCollapse: Boolean // isCollapse 就变成了**子组件**的一个属性，通过这个属性可以在子组件中使用父组件传递过来的数据。
    }
}
</script>

<style scoped>

</style>