<template>
    <b-row class="screen-navigation h-5" align-h="start">
        <b-col cols="2">
            <img class="navigation-icon" @click="goBack" src="../assets/icon-left.png"/>
        </b-col>
        <b-col cols="8">
            <p class="navigation-title">{{title}}</p>
        </b-col>  
    </b-row>
</template>

<script>
    export default {
        props: {
            title: {
                type: String,
            },
            url: {
                type: String,
            }
        },
        methods: {
            goBack() {
                this.$router.push(this.url);
            }
        }
    }
</script>

<style>
    .navigation-icon {
        width: 13px;
        height: 21px;
        cursor: pointer;
    }

    .navigation-title {
        font-size: 20px;
        height: 21px;
        color: #888888;
    }
</style>