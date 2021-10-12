<template>
    <b-button @click="emitClick" class="primaryBtn">{{text}}</b-button>
</template>

<script>
    export default {
        props: {
            text: {
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
    .primaryBtn{
        background-color: var(--primary-btn-color);
        border: none;
        border-radius: 25px;
        min-width: 125px;
    }
    
    .primaryBtn::placeholder {
        /* color: var(--primary-btn-palceholder-color) !important; */
        font-size: 18px;
    }

    .primaryBtn:hover{
        background-color: var(--primary-btn-color-hover);
    }

    .primaryBtn:focus{
        background-color: var(--primary-btn-color-hover);
    }
</style>