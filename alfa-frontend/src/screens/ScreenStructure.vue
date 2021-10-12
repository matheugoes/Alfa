<template>
    <div class="screen vh-100">
        <screen-navigation class="top" :title="getPageName" :url="getBackUrl"/>
        <router-view class="page"/>
    </div>
</template>

<script>
    import ScreenNavigation from '../components/ScreenNavigation.vue'
    import {mapGetters} from 'vuex'
        
    export default {
        components: { ScreenNavigation },
        computed: {
            ...mapGetters([
                "getPageName",
                "getBackUrl"
            ])
        }
    }
</script>

<style>
    .top {
        padding-top: 20px!important;
        padding-bottom: 20px!important;
        height: 30px!important;
    }

    .page {
        margin-top: 30px!important;
        height: calc(100vh - 100px)!important;
    }
</style>