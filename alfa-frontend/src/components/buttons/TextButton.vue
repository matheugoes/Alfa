<template>
    <a @click="emitClick" href="#" class="textBtn">{{textButton}}</a>
</template>

<script>
    export default {
        props: {
            textButton: {
                type: String
            }
        },
        methods: {
            emitClick(){
                this.$emit("click");
            }
        }
    }
</script>

<style scoped>
    .textBtn{
        font-size: 16px;
        font-weight: 500;
        color: #4F4F4F;
        background: none;
        border: none;
        text-decoration: none;
    }

    .textBtn:hover{
        font-weight: 600;
        color: #3b3b3b;
        cursor: pointer;
    }
</style>